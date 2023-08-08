package mypackage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mypackage.model.Invoice_payments;
import mypackage.services.Invoice_paymentServicess;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*" ,methods = {RequestMethod.GET,RequestMethod.POST})
public class Invoice_Payment_Controller {
@Autowired
Invoice_paymentServicess invoicepayment_service;

@GetMapping("invoicepayment")
public List<Invoice_payments>GetInvoicePayments() {
	return invoicepayment_service.GetAllInvoice_payment();
}
}
