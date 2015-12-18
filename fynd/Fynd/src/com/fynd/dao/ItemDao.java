package com.fynd.dao;
import com.util.HibernateUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fynd.entities.Item;
import com.fynd.entities.SizeQuantity;
public class ItemDao {
	
	SessionFactory sf = HibernateUtil.getSessionFactory();
    Session session = sf.openSession();
    
	public List<Item> getAllItems(){
		Criteria cr = session.createCriteria(Item.class);
		return cr.list();
   }
	
}
