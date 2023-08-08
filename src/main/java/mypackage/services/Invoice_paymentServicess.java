package mypackage.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypackage.model.Invoice_payments;
import mypackage.repository.IInvoice_paymentsRepository;

@Service

public class Invoice_paymentServicess {
	@Autowired
	IInvoice_paymentsRepository Invoice_paymentrepo;
	
	public List<Invoice_payments>GetAllInvoice_payment(){
		List<Invoice_payments>lst=new ArrayList<Invoice_payments>();
		for(Invoice_payments p: Invoice_paymentrepo.findAll())
		{
			Invoice_payments pm=new Invoice_payments(p.getPayment_id(), null, p.getPayment_date(), p.getPayment_amount(), p.getPayment_mode(), p.getDescription());
			lst.add(pm);

		}
		return lst;
	}
	public Invoice_payments GetInvoice_paymentByInvoice_payment_id(int Invoice_payment_id)
	{
		Invoice_payments st=Invoice_paymentrepo.findById(Invoice_payment_id).get();
		return st;
	}
	
	public Invoice_payments AddInvoice_payment(Invoice_payments st) {
	Invoice_payments ip=new Invoice_payments(0, st.getInvoice_details(), st.getPayment_date(), st.getPayment_amount(), st.getPayment_mode(), st.getDescription());
		return Invoice_paymentrepo.save(ip);
	}
	public Invoice_payments Update(Invoice_payments st) {
		return Invoice_paymentrepo.save(st);
	}
	
	public Invoice_payments DeleteInvoice_payments(int Invoice_payment_id)
	{
		Invoice_payments st=Invoice_paymentrepo.findById(Invoice_payment_id).get();
		Invoice_paymentrepo.delete(st);
		return st;

}}
