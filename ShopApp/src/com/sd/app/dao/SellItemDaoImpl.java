package com.sd.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.app.model.Item;


@Repository("sellItemDao")
public class SellItemDaoImpl implements SellItemDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addItem(Item item) {
		sessionFactory.getCurrentSession().saveOrUpdate(item);
	}

	@SuppressWarnings("unchecked")
	public List<Item> listItems() {
		return (List<Item>) sessionFactory.getCurrentSession().createCriteria(Item.class).list();
	}

	public Item getItem(int id) {
		return (Item) sessionFactory.getCurrentSession().get(Item.class, id);
	}

	public void deleteItem(Item Items) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Item WHERE id = "+Items.getId()).executeUpdate();
	}


}
