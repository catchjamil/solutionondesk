package com.sd.app.controller;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sd.app.bean.ItemBean;
import com.sd.app.constraint.ItemAction;
import com.sd.app.model.Item;
import com.sd.app.model.ItemMaster;
import com.sd.app.service.ItemService;

@Controller
public class SellItemController {

	String fileSeprator = java.io.File.separator;
	@Autowired
	private ItemService itemService;
	private String billNumber;
	private int sequenceNo;
	@RequestMapping(value = { "/sellItem" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		System.out.println("Sell page..");
		ModelAndView model = new ModelAndView();
		List<ItemMaster> listSellItems = itemService.listBuyItems();
		 Iterator<ItemMaster> iterator2 = listSellItems.iterator();
		while(iterator2.hasNext()){
			ItemMaster itemMaster = iterator2.next();
			List<Item> items = itemMaster.getItems();
			boolean status = false;
			Iterator<Item> iterator = items.iterator();
			while(iterator.hasNext()){
				try{
					
					Item item = iterator.next();
					
					int q = item.getQuantity() != null? Integer.parseInt(item.getQuantity()):0;
					int sq = item.getSoldQuantity() != null? Integer.parseInt(item.getSoldQuantity()) : 0;
				if(q <= sq){
					status=true;
					break;
				}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
			if(status){
				iterator2.remove();
			}
		}
		Collections.reverse(listSellItems);
		model.addObject("itemMasters", listSellItems);
		model.setViewName("sellItem");
		return model;

	}

	@RequestMapping(value = { "/sellItemList" }, method = RequestMethod.GET)
	public ModelAndView sellItemList() {
		System.out.println("Sell page..");
		ModelAndView model = new ModelAndView();
		List<ItemMaster> listSellItems = itemService.listSellItems();
		sequenceNo = listSellItems.size();
		Collections.reverse(listSellItems);
		model.addObject("listSellItems", listSellItems);
		//model.addObject("fileName", split[split.length - 1]);
		model.setViewName("sellItemList");

		
		return model;

	}

	String[] fieldNames = { "items", "size", "quantity", "price" };

	@RequestMapping(value = { "/sellSaveItem" }, method = RequestMethod.POST)
	public ModelAndView sellSaveItem(HttpServletRequest request) {
		System.out.println("Sell save page..");
		Enumeration<String> attributeNames = request.getParameterNames();
		ArrayList<Item> items = new ArrayList<Item>();
		while (attributeNames.hasMoreElements()) {
			String nextElement = attributeNames.nextElement();
			boolean status = false;
			for (String fieldName : fieldNames) {
				if (fieldName.equalsIgnoreCase(nextElement)) {
					status = true;
					break;
				}
			}
			if (status) {
				String[] parameterValues = request.getParameterValues(nextElement);
				Item item = null;
				for (int i = 0; i < parameterValues.length; i++) {
					if (items.size() != parameterValues.length) {
						item = new Item();
						items.add(item);
					} else {
						item = items.get(i);
					}
					if ("items".equalsIgnoreCase(nextElement)) {
						item.setId(Integer.parseInt(parameterValues[i]));
						Item childItem = itemService.getChildItem(Integer.parseInt(parameterValues[i]));
						item.setName(childItem.getName()); 
					} else if ("size".equalsIgnoreCase(nextElement)) {
						item.setSize(parameterValues[i]);
					} else if ("quantity".equalsIgnoreCase(nextElement)) {
						item.setQuantity(parameterValues[i]);
					
					}else if ("price".equalsIgnoreCase(nextElement)) {
						try {
							item.setPrice(Double.parseDouble(parameterValues[i]));
						} catch (NumberFormatException n) {
							n.printStackTrace();
						}
					}
				}
			}
		}

		ItemMaster itemMaster = new ItemMaster();
		itemMaster.setCustomerName(request.getParameter("custName"));
		itemMaster.setContactNo(request.getParameter("contactNo"));
		itemMaster.setAddress(request.getParameter("address"));

		itemMaster.setItemAction(ItemAction.SELL.toString());
		itemMaster.setItems(items);

		ModelAndView model = new ModelAndView();
		billNumber = createBillNumber(sequenceNo);
		String quationSlipPath = quatationDetails(itemMaster, request);
		quationSlipPath = quationSlipPath.contains("\\")? quationSlipPath.replace("\\", "/") : quationSlipPath;
		String[] split = quationSlipPath.split("/");
		String  relativePath ="/"+split[split.length-2]+"/"+split[split.length-1];
		itemMaster.setQuationSlipPath(relativePath);

		itemService.saveSellItem(itemMaster);
		List<ItemMaster> listSellItems = itemService.listSellItems();
		Collections.reverse(listSellItems);
		model.addObject("listSellItems", listSellItems);
		//model.addObject("fileName", split[split.length - 1]);
		model.setViewName("sellItemList");

		return model;

	}

	private List<ItemBean> prepareListofBean(List<Item> items) {
		List<ItemBean> beans = null;
		if (items != null && !items.isEmpty()) {
			beans = new ArrayList<ItemBean>();
			ItemBean bean = null;
			for (Item item : items) {
				bean = new ItemBean();

				bean.setId(item.getId());
				bean.setName(item.getName());
				bean.setSize(item.getSize());
				bean.setQuantity(item.getQuantity());
				bean.setPrice(item.getPrice() != null ? item.getPrice() + "" : "0.0");
				bean.setDescription(item.getDescription());

				beans.add(bean);
			}
		}
		return beans;
	}

	private String quatationDetails(ItemMaster itemMaster, HttpServletRequest request) {
		String contextPath = request.getRealPath("reports");
		String path = contextPath;
		try {

			File createReports = new File(contextPath);
			if (!createReports.exists())
				createReports.mkdirs();
			System.out.println("File is created At: " + createReports.getAbsolutePath());
			// InputStream inputStream = new
			// FileInputStream("reports/Quatation.jrxml");
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("reports"+java.io.File.separator+"Quatation.jrxml");

			ArrayList<ItemMaster> itemMasters = new ArrayList<ItemMaster>();
			itemMasters.add(itemMaster);
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(itemMasters);
			Map parameters = new HashMap();
			parameters.put("billNumber", billNumber);

			JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
			path = createReports.getAbsolutePath() + java.io.File.separator+"Quatation_" + System.currentTimeMillis() + ".pdf";
			JasperExportManager.exportReportToPdfFile(jasperPrint, path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;

	}
	
	private String createBillNumber(int sequenceNumber){
		
		int day, month, year;
	      int second, minute, hour;
	      GregorianCalendar date = new GregorianCalendar();
	 
	      day = date.get(Calendar.DAY_OF_MONTH);
	      month = date.get(Calendar.MONTH);
	      year = date.get(Calendar.YEAR);
	 
	      second = date.get(Calendar.SECOND);
	      minute = date.get(Calendar.MINUTE);
	      hour = date.get(Calendar.HOUR);
	 
	      System.out.println("Current date is  "+day+"/"+(month+1)+"/"+year);
	      System.out.println("Current time is  "+hour+" : "+minute+" : "+second);
	      return "FG-"+day+(month+1)+year+hour+minute+second+"-"+sequenceNumber;
	}
	
	

}