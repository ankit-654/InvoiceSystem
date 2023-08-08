package mypackage.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="invoice_payments")
public class Invoice_payments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int payment_id;
	@ManyToOne(fetch=FetchType.LAZY,optional = false)
	@JoinColumn(name="invoice_id", nullable = false)
	public Invoice_Details invoice_details;
	
	
	private String payment_date;
	private Float payment_amount;
	private String payment_mode;
	private String description;
	public Invoice_payments() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Invoice_payments(int payment_id, Invoice_Details invoice_details, String payment_date, Float payment_amount,
			String payment_mode, String description) {
		super();
		this.payment_id = payment_id;
		this.invoice_details = invoice_details;
		this.payment_date = payment_date;
		this.payment_amount = payment_amount;
		this.payment_mode = payment_mode;
		this.description = description;
	}
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public Invoice_Details getInvoice_details() {
		return invoice_details;
	}
	public void setInvoice_details(Invoice_Details invoice_details) {
		this.invoice_details = invoice_details;
	}
	public String getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}
	public Float getPayment_amount() {
		return payment_amount;
	}
	public void setPayment_amount(Float payment_amount) {
		this.payment_amount = payment_amount;
	}
	public String getPayment_mode() {
		return payment_mode;
	}
	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
