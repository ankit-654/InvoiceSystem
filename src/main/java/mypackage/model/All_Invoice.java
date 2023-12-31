package mypackage.model;

public class All_Invoice {
private int invoice_id;
private int customer_id;
private String customer_name;
private String invoice_date;
private float total_amount;
private float paid_amount;
private float remaining_amount;
private String status;
public All_Invoice() {
	super();
	// TODO Auto-generated constructor stub
}
public All_Invoice(int invoice_id, int customer_id, String customer_name, String invoice_date, float total_amount,
		float paid_amount, float remaining_amount, String status) {
	super();
	this.invoice_id = invoice_id;
	this.customer_id = customer_id;
	this.customer_name = customer_name;
	this.invoice_date = invoice_date;
	this.total_amount = total_amount;
	this.paid_amount = paid_amount;
	this.remaining_amount = remaining_amount;
	this.status = status;
}
public int getInvoice_id() {
	return invoice_id;
}
public void setInvoice_id(int invoice_id) {
	this.invoice_id = invoice_id;
}
public int getCustomer_id() {
	return customer_id;
}
public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
}
public String getCustomer_name() {
	return customer_name;
}
public void setCustomer_name(String customer_name) {
	this.customer_name = customer_name;
}
public String getInvoice_date() {
	return invoice_date;
}
public void setInvoice_date(String invoice_date) {
	this.invoice_date = invoice_date;
}
public float getTotal_amount() {
	return total_amount;
}
public void setTotal_amount(float total_amount) {
	this.total_amount = total_amount;
}
public float getPaid_amount() {
	return paid_amount;
}
public void setPaid_amount(float paid_amount) {
	this.paid_amount = paid_amount;
}
public float getRemaining_amount() {
	return remaining_amount;
}
public void setRemaining_amount(float remaining_amount) {
	this.remaining_amount = remaining_amount;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
}
