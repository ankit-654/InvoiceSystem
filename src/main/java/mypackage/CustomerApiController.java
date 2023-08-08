package mypackage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mypackage.model.All_Invoice;
import mypackage.model.Customers;
import mypackage.model.Invoice_Details;
import mypackage.model.Invoice_Items;
import mypackage.model.Invoice_payments;
import mypackage.model.Items;
import mypackage.services.CustomerServicess;
import mypackage.services.Invoice_DetailsServicess;
import mypackage.services.Invoice_itemsServicess;
import mypackage.services.Invoice_paymentServicess;
import mypackage.services.ItemsServicess;
import net.bytebuddy.asm.Advice.Return;
@CrossOrigin(origins = "*",allowedHeaders = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RestController
public class CustomerApiController {
	@GetMapping("first")
	public String FirstApi() {
		return "welcome";
	}
	
	@Autowired
	CustomerServicess customerServicess ;
	
	@Autowired
	Invoice_DetailsServicess invoice_detailsServicess ;
	
	@Autowired
	Invoice_itemsServicess invoice_itemsServicess ;
	
	@Autowired
	Invoice_paymentServicess invoice_paymentServicess ;
	
	
	@Autowired
	ItemsServicess itemsServicess ;
	
	
	@GetMapping("Customers")
	public List<Customers>GetAllCustomers() {
//		System.out.println();
		return customerServicess.GetAllCustomers();
	}
	
	@GetMapping("Items")
	public List<Items>GetItems() {
		return itemsServicess.GetAllItems();
	}
	
	@PostMapping("Customers")
	public Customers AddCustomer(@RequestBody Customers c) {
		return customerServicess.AddCustomer(c);
	}
	
	@DeleteMapping("customer/{id}")
	public String DeleteCustomer(@PathVariable int id) {
		 customerServicess.DeleteCustomer(id);
		 return "Deleted";
	}
	
	@PutMapping("customer")
	public String UpdateCustomer(@RequestBody Customers c) {
		customerServicess.Update(c);
		return "updated";
	}
	
	@PostMapping("item")
	public Items AddItem(@RequestBody Items it) {
		return itemsServicess.AddItems(it);
	}
	
	@GetMapping("invoice_detail")
	public List<Invoice_Details>GetInvoiceDetails() {
		return invoice_detailsServicess.GetAllInvoice_Details();
	}
	
	@PostMapping("invoicedetail")
	public Invoice_Details AddInvoiceDetail(@RequestBody Invoice_Details id) {
		System.out.println(id.getInvoice_date()+" "+id.getTotal_amount()+" "+id.getCustomers().getCustomer_id());
		 invoice_detailsServicess.AddInvoice_Details(id);
		 return id;
	}
	
	@GetMapping("invoice_detail/{id}")
	public All_Invoice GetByInvoiceId(@PathVariable("id") int id) {
		return invoice_detailsServicess.getInvoicebyId(id);
	}
	
	@GetMapping("invoiceitem")
	public List<Invoice_Items>GetInvoiceItems() {
		return invoice_itemsServicess.GetAllInvoice_items();
	}
	
	
	
	@PostMapping("invoiceitem")
	public Invoice_Items AddInvoiceItem(@RequestBody Invoice_Items inv_item) {
		return invoice_itemsServicess.AddInvoice_items(inv_item);
}
	
//	@GetMapping("invoicepayment")
//	public List<Invoice_payments>GetInvoicePayments() {
//		return invoice_paymentServicess.GetAllInvoice_payment();
//	}
		
	@PostMapping("invoicepayment")
	public Invoice_payments AddInvoicePayment(@RequestBody Invoice_payments inv_payment) {
		return invoice_paymentServicess.AddInvoice_payment(inv_payment);
	}
	
	@GetMapping("item/{id}")
	public Items GetById(@PathVariable int id) {
		return itemsServicess.GetItemsByItems_id(id);
	}
	
	
	
	
}
