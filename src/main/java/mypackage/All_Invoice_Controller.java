package mypackage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mypackage.model.All_Invoice;
import mypackage.model.Invoice_Details;
import mypackage.repository.IInvoice_DetailsRepository;
import mypackage.services.Invoice_DetailsServicess;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",methods = {RequestMethod.GET,RequestMethod.POST})
public class All_Invoice_Controller {

	
	@Autowired Invoice_DetailsServicess invoice_details_servicerepo;
	@GetMapping("/all_invoices")
	public List<All_Invoice>getInoives(){
		return invoice_details_servicerepo.getAllInvoices();
	}
}
