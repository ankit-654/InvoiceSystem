package mypackage.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypackage.model.*;
import mypackage.repository.*;
@Service
public class CustomerServicess {
	@Autowired
	ICustomersRepository custrepo;
	
	public List<Customers>GetAllCustomers(){
		List<Customers> lst=new ArrayList<Customers>();
		for(Customers c: custrepo.findAll())
		{
			Customers cm=new Customers(c.getCustomer_id(), c.getCustomer_name(), c.getCity(), c.getEmail_address(), c.getMobile_number(), null);
			lst.add(cm);
		}
		
		
		return lst;
	}
	public Customers GetCustomerByCustomer_id(int Customer_id)
	{
		Customers st=custrepo.findById(Customer_id).get();
		return st;
	}
	
	public Customers AddCustomer(Customers st) {
		return custrepo.save(st);
	}
	public Customers  Update(Customers st) {
		return custrepo.save(st);
	}
	
	public Customers DeleteCustomer(int id)
	{
		Customers st=custrepo.findById(id).get();
		custrepo.delete(st);
		return st;
		
		
	}
	
}
