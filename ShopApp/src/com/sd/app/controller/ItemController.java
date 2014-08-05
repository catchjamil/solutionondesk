package com.sd.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sd.app.bean.ItemBean;
import com.sd.app.constraint.ItemAction;
import com.sd.app.model.Item;
import com.sd.app.model.ItemMaster;
import com.sd.app.service.ItemService;


@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value = "/saveItem", method = RequestMethod.POST)
	public ModelAndView saveItem(@ModelAttribute("command") ItemMaster itemMaster, 
			BindingResult result) {
		// Item item = prepareModel(ItemBean);
		// itemService.addItem(item);
		itemMaster.setItemAction(ItemAction.BUY.toString());
		itemService.saveItem(itemMaster);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("items",  itemService.listBuyItems());
		return new ModelAndView("itemsList", model);
	}

	@RequestMapping(value="/items", method = RequestMethod.GET)
	public ModelAndView listItems() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("items",  itemService.listBuyItems());
		return new ModelAndView("itemsList", model);
	}

	@RequestMapping(value = "/addItem", method = RequestMethod.GET)
	public ModelAndView addItem(@ModelAttribute("command")  ItemMaster itemMaster,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		//itemService.saveSellItems(itemMaster);
		//model.put("items",  prepareListofBean(itemService.listItems()));
		return new ModelAndView("addItem", model);
	}
	
	/*@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}*/
	
	@RequestMapping(value = "/deleteItem", method = RequestMethod.GET)
	public ModelAndView deleteItem(@ModelAttribute("command")  ItemMaster itemMaster,
			BindingResult result,HttpServletRequest request) {
		int parseInt = Integer.parseInt(request.getParameter("id"));
		
		itemService.deleteItem(parseInt);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("items",  itemService.listBuyItems());
		return new ModelAndView("itemsList", model);
	}
	
	@RequestMapping(value = "/editItem", method = RequestMethod.GET)
	public ModelAndView editItem(@ModelAttribute("command")  ItemMaster itemMaster,
			BindingResult result, HttpServletRequest request) {
		
		int parseInt = Integer.parseInt(request.getParameter("id"));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("item", itemService.getItem(parseInt));
		///model.put("items",  prepareListofBean(itemService.listItems()));
		return new ModelAndView("addItem", model);
	}
	
	private Item prepareModel(ItemBean itemBean){
		Item item = new Item();
		item.setId(itemBean.getId());
		item.setName(itemBean.getName());
		item.setSize(itemBean.getSize());
		item.setQuantity(itemBean.getQuantity());
		try{
			Double price = new Double(itemBean.getPrice());
			item.setPrice(price != null? price: 0.0);
		}catch(Exception e){
			e.printStackTrace();
		}
		item.setDescription(itemBean.getDescription());
		itemBean.setId(null);
		return item;
	}
	
	private List<ItemBean> prepareListofBean(List<ItemMaster> items){/*
		ItemMaster itemMaster = new ItemMaster();
		List<ItemBean> beans = null;
		if(items != null && !items.isEmpty()){
			beans = new ArrayList<ItemBean>();
			ItemBean bean = null;
			for(Item item : items){
				bean = new ItemBean();
				
				bean.setId(item.getId());
				bean.setName(item.getName());
				bean.setSize(item.getSize());
				bean.setBuyFrom(item.getBuyFrom());
				bean.setQuantity(item.getQuantity());
				
				bean.setPrice(item.getPrice() != null?item.getPrice()+"":"0.0");
				bean.setDescription(item.getDescription());

				beans.add(bean);
			}
		}
		return beans;
	*/
	return null;	
	}
	
	private ItemBean prepareItemBean(Item item){
		ItemBean bean = new ItemBean();

		bean.setId(item.getId());
		bean.setName(item.getName());
		bean.setSize(item.getSize());
		bean.setQuantity(item.getQuantity());
		bean.setPrice(item.getPrice()+"");
		bean.setDescription(item.getDescription());
		
		return bean;
	}
}
