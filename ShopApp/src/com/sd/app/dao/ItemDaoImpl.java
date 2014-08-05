package com.sd.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.app.constraint.ItemAction;
import com.sd.app.constraint.Status;
import com.sd.app.model.Item;
import com.sd.app.model.ItemMaster;


@Repository("itemDao")
public class ItemDaoImpl implements ItemDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	public List<ItemMaster> listBuyItems() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		List<ItemMaster> itemMasters= (List<ItemMaster>) currentSession.createQuery("FROM ItemMaster WHERE itemAction='"+ItemAction.BUY+"' AND status!='"+Status.DELETE+"'").list();
		return itemMasters;
	}

	public ItemMaster getItem(int id) {
		return (ItemMaster) sessionFactory.getCurrentSession().get(ItemMaster.class, id);
	}

	public void deleteItem(int id) {
		
		 ItemMaster item = getItem(id);
		 item.setStatus(Status.DELETE.toString());
		 sessionFactory.getCurrentSession().flush();
	}
	
	@SuppressWarnings("unchecked")
	public List<ItemMaster> listSellItems() {
		Session currentSession = sessionFactory.getCurrentSession();
		return (List<ItemMaster>) currentSession.createQuery("FROM ItemMaster WHERE itemAction='"+ItemAction.SELL+"' and status!='"+Status.DELETE+"'").list();
		
	}

	@Override
	public void saveItem(ItemMaster itemMaster) {
		// TODO Auto-generated method stub
		itemMaster.setStatus(Status.ADD.toString());
		sessionFactory.getCurrentSession().save(itemMaster);
		
	}

	@Override
	public void saveSellItem(ItemMaster itemMaster) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		List<Item> items = itemMaster.getItems();
		for(Item item : items){
			Item itemDb = (Item)currentSession.get(Item.class, item.getId());
			try{
				int q = item.getQuantity() != null? Integer.parseInt(item.getQuantity()):0;
				int sq = itemDb.getSoldQuantity() != null? Integer.parseInt(itemDb.getSoldQuantity()) : 0;
				itemDb.setSoldQuantity((q+sq)+"");
			}catch(Exception e){
				e.printStackTrace();
			}
			
			currentSession.flush();
			item.setId(null);
		}
		itemMaster.setStatus(Status.ADD.toString());
		sessionFactory.getCurrentSession().save(itemMaster);
		
	}

	@Override
	public List<ItemMaster> listOfAvailableItems() {
		// TODO Auto-generated method stub
		return null;
	}
	

	



}
