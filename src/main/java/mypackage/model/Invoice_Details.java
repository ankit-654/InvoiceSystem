package mypackage.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="invoice_details")

public class Invoice_Details {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoice_id;
	private String invoice_date;
	private Float total_amount;
	
	
	@ManyToOne(fetch=FetchType.LAZY,optional = false)
	@JoinColumn(name="customer_id", nullable = false)
	public Customers customers;
	
	@OneToMany(mappedBy ="invoice_details", fetch=FetchType.LAZY, cascade=CascadeType.ALL )
	@JsonIgnoreProperties("invoice_details")
	public Set<Invoice_Items> invoiceitem;
	
	@OneToMany(mappedBy ="invoice_details", fetch=FetchType.LAZY, cascade=CascadeType.ALL )
	@JsonIgnoreProperties("invoice_details")
	public Set<Invoice_payments> invoicepayment;

	public Invoice_Details() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Invoice_Details(int invoice_id, String invoice_date, Float total_amount, Customers customers,
			Set<Invoice_Items> invoiceitem, Set<Invoice_payments> invoicepayment) {
		super();
		this.invoice_id = invoice_id;
		this.invoice_date = invoice_date;
		this.total_amount = total_amount;
		this.customers = customers;
		this.invoiceitem = invoiceitem;
		this.invoicepayment = invoicepayment;
	}

	public int getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}

	public String getInvoice_date() {
		return invoice_date;
	}

	public void setInvoice_date(String invoice_date) {
		this.invoice_date = invoice_date;
	}

	public Float getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(Float total_amount) {
		this.total_amount = total_amount;
	}

	public Customers getCustomers() {
		return customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	public Set<Invoice_Items> getInvoiceitem() {
		return invoiceitem;
	}

	public void setInvoiceitem(Set<Invoice_Items> invoiceitem) {
		this.invoiceitem = invoiceitem;
	}

	public Set<Invoice_payments> getInvoicepayment() {
		return invoicepayment;
	}

	public void setInvoicepayment(Set<Invoice_payments> invoicepayment) {
		this.invoicepayment = invoicepayment;
	}


	
	

}
