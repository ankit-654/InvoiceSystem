package mypackage.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypackage.model.Items;
import mypackage.repository.IItemsRepository;
@Service

public class ItemsServicess {
	@Autowired
	IItemsRepository Itemrepo;
	
	public List<Items>GetAllItems(){
		
		
		List<Items>lst=new ArrayList<Items>();
		for(Items t:Itemrepo.findAll())
		{
			Items it=new Items(t.getitem_id(),t.getitem_name(), t.getpurchase_rate(),t.getselling_rate(),t.gettax(),t.getstock_quantity(), null);
			lst.add(it);
		}
		return lst;
	}
	
	public Items GetItemsByItems_id(int id) 
	{
		Items st=Itemrepo.findById(id).get();
		Items i=new Items(st.getitem_id(), st.getitem_name(), st.getpurchase_rate(), st.getselling_rate(), st.gettax(), st.getstock_quantity(), null);
		return i;
	}
//	
	public Items AddItems(Items st) {
		return Itemrepo.save(st);
	}
	public Items Update(Items st) {
		return Itemrepo.save(st);
	}
	
	public Items DeleteItem(int Item_id)
	{
		Items st=Itemrepo.findById(Item_id).get();
		Itemrepo.delete(st);
		return st;
		
		
	}


}
