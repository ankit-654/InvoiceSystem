package mypackage.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypackage.model.All_Invoice;
import mypackage.model.Customers;
import mypackage.model.Invoice_Details;
import mypackage.model.Invoice_Items;
import mypackage.model.Invoice_payments;
import mypackage.repository.*;
import net.bytebuddy.asm.Advice.Return;

@Service

public class Invoice_DetailsServicess {
	@Autowired
	IInvoice_DetailsRepository Invoice_Detailsrepo;
	@Autowired IInvoice_paymentsRepository payment_services;
	@Autowired
	IInvoice_ItemsRepository invoice_itemrepo;;

	public List<Invoice_Details>GetAllInvoice_Details(){

		List<Invoice_Details>lst=new ArrayList<Invoice_Details>();
		for(Invoice_Details id:Invoice_Detailsrepo.findAll()) {
		Invoice_Details i=new Invoice_Details(id.getInvoice_id(), id.getInvoice_date(), id.getTotal_amount(), null, null, null);
	    lst.add(i);
	    }
      return lst;	
}
	
	/// All Invoices
	public List<All_Invoice>getAllInvoices(){
		List<All_Invoice>lst=new ArrayList<All_Invoice>();
		List<Invoice_Details>invoices=Invoice_Detailsrepo.findAll();
		for(Invoice_Details d:invoices) {
			float total_amount=0;
			float paid_amount=0;
			float remaining_amount=0;
			String status="";
			List<Invoice_payments>payment=payment_services.findAll();
			for(Invoice_payments p:payment) {
				if(d.getInvoice_id()==p.getInvoice_details().getInvoice_id()) {
					paid_amount+=p.getPayment_amount();
				}
			}
			total_amount=d.getTotal_amount();
			remaining_amount=total_amount-paid_amount;
			if(paid_amount==0) {
				status="Unpaid";
			}
			else if(paid_amount>0 && paid_amount<total_amount) {
				status="Partial Paid";
			}
			else {
				status="Paid";
			}
			
			All_Invoice a=new All_Invoice(d.getInvoice_id(), d.getCustomers().getCustomer_id(), d.getCustomers().getCustomer_name(), d.getInvoice_date(), total_amount, paid_amount, remaining_amount, status);
			lst.add(a);
		}
		return lst;
		}
	
	/// AllInvoice By ID
	
	public All_Invoice getInvoicebyId(int id){
		All_Invoice m=null;
		for(All_Invoice i:getAllInvoices()) {
			if(i.getInvoice_id()==id) {
				m=i;
				break;
			}
		}
		return m;
	}
		
			
	public Invoice_Details GetInvoice_DetailsByInvoice_Details_id(int Invoice_Details_id)
	{
		Invoice_Details st=Invoice_Detailsrepo.findById(Invoice_Details_id).get();
		return st;
	}
	
	public void AddInvoice_Details(Invoice_Details st) {

		Invoice_Details d=new Invoice_Details(0, st.getInvoice_date(), st.getTotal_amount(), st.getCustomers(), null, null);
		Invoice_Details id=	Invoice_Detailsrepo.save(d);
		for(Invoice_Items m :st.getInvoiceitem())
		{
			Invoice_Items im=new Invoice_Items(0, id, m.getItem(), m.getQuantity());
			invoice_itemrepo.save(im);
		}

	}
	public Invoice_Details Update(Invoice_Details st) {
		return Invoice_Detailsrepo.save(st);
	}
	
	public Invoice_Details DeleteInvoice_Details(int Invoice_Details_id)
	{
		Invoice_Details st=Invoice_Detailsrepo.findById(Invoice_Details_id).get();
		Invoice_Detailsrepo.deleteById(Invoice_Details_id);
		return st;
		
	}
	

}
