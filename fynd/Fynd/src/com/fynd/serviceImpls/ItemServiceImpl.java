package com.fynd.serviceImpls;

import com.util.HibernateUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fynd.dao.ItemDao;
import com.fynd.dto.ItemDto;
import com.fynd.entities.Item;
import com.fynd.entities.SizeQuantity;
import com.fynd.services.ItemService;
import com.util.ConversionUtil;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

//@Path("/ItemsService")
public class ItemServiceImpl implements ItemService{
	
	/*@GET
    @Path("/items")
    @Produces(MediaType.APPLICATION_JSON)*/
	public List<ItemDto> getItems(){
		populateItem();
		ItemDao dao= new ItemDao();
		return ConversionUtil.converToItemDto(dao.getAllItems());
	}
	
	private void populateItem() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
		List<Item> items=new ArrayList<Item>();
		int sizes[] = {28,29,30,31,32,33,34,36,38,40};
		File file=new File("C:\\Users\\gauri\\Downloads\\dummy.csv");
		try {
			FileReader fr=new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line=br.readLine();
			Item item;
			while((line=br.readLine())!= null){
				String[] details = line.split(",");
				List<SizeQuantity> quantities=new ArrayList<SizeQuantity>();
				item = new Item(details[0],details[1],Float.parseFloat(details[13]));
				SizeQuantity quantity;
				for(int i=0; i<10; i++){
					quantity= new SizeQuantity(sizes[i], ParseInt(details[2+i]),item);
					quantities.add(quantity);
					quantity=null;
				}
				item.setSize_quantity(quantities);
				session.merge(item);
				items.add(item);
				item=null;
			}
			Criteria cr = session.createCriteria(Item.class);
			List<Item> results = cr.list();

			session.getTransaction().commit();
	        session.close();
			System.out.println("Items:"+items);
			System.out.println("Res:"+results);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	private static int ParseInt(String strNumber) {
	   if (strNumber != null && strNumber.length() > 0) {
	       try {
	          return Integer.parseInt(strNumber);
	       } catch(Exception e) {
	          return 0;   // or some value to mark this field is wrong. or make a function validates field first ...
	       }
	   }
	   else return 0;
	}
}
