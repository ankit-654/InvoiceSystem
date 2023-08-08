package mypackage.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypackage.model.Invoice_Items;
import mypackage.repository.IInvoice_ItemsRepository;


@Service

public class Invoice_itemsServicess {
	@Autowired
	IInvoice_ItemsRepository Invoice_itemsrepo;
	
	public List<Invoice_Items>GetAllInvoice_items(){
		List <Invoice_Items> lst =new ArrayList<Invoice_Items>();
		for(Invoice_Items i:Invoice_itemsrepo.findAll())
		{
			Invoice_Items im=new Invoice_Items(i.getInvoice_item_id(),null,null, i.getQuantity());
			lst.add(im);
		}
		
		return lst;
	}
	public Invoice_Items GetInvoice_itemsByInvoice_items_id(int Invoice_items_id)
	{
		Invoice_Items st=Invoice_itemsrepo.findById(Invoice_items_id).get();
		return st;
	}
	
	public Invoice_Items AddInvoice_items(Invoice_Items st) {
		return Invoice_itemsrepo.save(st);
	}
	public Invoice_Items Update(Invoice_Items st) {
		return Invoice_itemsrepo.save(st);
	}
	
	public Invoice_Items DeleteInvoice_items(int Invoice_items_id)
	{
		Invoice_Items st=Invoice_itemsrepo.findById(Invoice_items_id).get();
		Invoice_itemsrepo.delete(st);
		return st;
		
		
	}
	


}
