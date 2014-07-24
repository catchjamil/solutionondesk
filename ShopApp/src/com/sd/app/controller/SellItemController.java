package com.sd.app.controller;

import java.io.File;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
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

	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value = { "/sellItem"}, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		System.out.println("Sell page..");	
		ModelAndView model = new ModelAndView();
		model.addObject("items",  prepareListofBean(itemService.listItems()));
		model.setViewName("sellItem");
		return model;

	}
	
	@RequestMapping(value = { "/sellSaveItem"}, method = RequestMethod.POST)
	public ModelAndView sellSaveItem(HttpServletRequest request) {
		System.out.println("Sell save page..");	
		Enumeration<String> attributeNames = request.getParameterNames();
		ArrayList<Item> items = new ArrayList<Item>();
		
		while(attributeNames.hasMoreElements()){
			String nextElement = attributeNames.nextElement();
			String[] parameterValues = request.getParameterValues(nextElement);
			Item item = null;
			for(int i=0; i<parameterValues.length;i++){
				if(items.size() != parameterValues.length){
					item = new Item();
				}else{
					item = items.get(i);
				}
				if("items".equalsIgnoreCase(nextElement)){
					item.setId(Integer.parseInt(parameterValues[i]));
				}else if("height".equalsIgnoreCase(nextElement)){
					item.setHeight(parameterValues[i]);
				}else if("width".equalsIgnoreCase(nextElement)){
					item.setWidth(parameterValues[i]);
				}else if("thikness".equalsIgnoreCase(nextElement)){
					item.setThikness(parameterValues[i]);
				}else if("quantity".equalsIgnoreCase(nextElement)){
					item.setQuantity(parameterValues[i]);
				}else if("price".equalsIgnoreCase(nextElement)){
					try{
						item.setPrice(Double.parseDouble(parameterValues[i]));
					}catch(NumberFormatException n){
						n.printStackTrace();
					}
					
					
				}else if("subTotal".equalsIgnoreCase(nextElement)){
					try{
						item.setSubTotal(Double.parseDouble(parameterValues[i]));
					}catch(NumberFormatException n){
						n.printStackTrace();
					}
					
					
				}
			}
			items.add(item);
			
		}
		
		ItemMaster itemMaster = new ItemMaster();
		itemMaster.setCustomerName(request.getParameter("custName"));
		itemMaster.setContactNo(request.getParameter("contactNo"));
		itemMaster.setItemAction(ItemAction.SELL.toString());
		itemMaster.setItems(items);
		
		ModelAndView model = new ModelAndView();
		String quationSlipPath = quatationDetails(itemMaster,request);
		String[] split = quationSlipPath.split("/");
		itemMaster.setQuationSlipPath(quationSlipPath);
		itemService.saveSellItems(itemMaster);
		List<ItemMaster> listSellItems = itemService.listSellItems();
		model.addObject("listSellItems",listSellItems);
		model.addObject("fileName",split[split.length-1]);
		model.setViewName("sellItemList");
		
		
		
		return model;

	}
	private List<ItemBean> prepareListofBean(List<Item> items){
		List<ItemBean> beans = null;
		if(items != null && !items.isEmpty()){
			beans = new ArrayList<ItemBean>();
			ItemBean bean = null;
			for(Item item : items){
				bean = new ItemBean();
				
				bean.setId(item.getId());
				bean.setName(item.getName());
				bean.setHeight(item.getHeight());
				bean.setWidth(item.getWidth());
				bean.setThikness(item.getThikness());
				bean.setBuyFrom(item.getBuyFrom());
				bean.setQuantity(item.getQuantity());
				bean.setPrice(item.getPrice() != null?item.getPrice()+"":"0.0");
				bean.setDescription(item.getDescription());

				beans.add(bean);
			}
		}
		return beans;
	}

	private String quatationDetails(ItemMaster itemMaster,HttpServletRequest request){
		String contextPath = request.getRealPath("reports");
		String path = contextPath;
try{
	
		File createReports = new File(contextPath);
		if(!createReports.exists())
			createReports.mkdirs();
		System.out.println("File is created At: "+createReports.getAbsolutePath());
		//InputStream inputStream = new FileInputStream("reports/Quatation.jrxml");
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("reports/Quatation.jrxml");
		
		ArrayList<ItemMaster> itemMasters = new ArrayList<ItemMaster>();
		itemMasters.add(itemMaster);
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(itemMasters);
		Map parameters = new HashMap();
	
		JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
		 path = createReports.getAbsolutePath()+"/Quatation_"+System.currentTimeMillis()+".pdf";
		JasperExportManager.exportReportToPdfFile(jasperPrint,	path);
}catch(Exception e){
	e.printStackTrace();
}
	return path;
		
	}
	


}