package mypackage.model;

import java.util.Set;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="customers")
public class Customers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int customer_id;
private String customer_name;
private String city;
private String email_address;
private String mobile_number;


@OneToMany(mappedBy="customers",cascade = CascadeType.ALL)
@JsonIgnoreProperties("customers")
public Set<Invoice_Details> invoice_details;


public Customers() {
	super();
	// TODO Auto-generated constructor stub
}


public Customers(int customer_id, String customer_name, String city, String email_address, String mobile_number,
		Set<Invoice_Details> invoice_details) {
	super();
	this.customer_id = customer_id;
	this.customer_name = customer_name;
	this.city = city;
	this.email_address = email_address;
	this.mobile_number = mobile_number;
	this.invoice_details = invoice_details;
}


public Customers(int customer_id2, int customer_id3, String city2, String email_address2, String mobile_number2,
		Object object) {
	// TODO Auto-generated constructor stub
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


public String getCity() {
	return city;
}


public void setCity(String city) {
	this.city = city;
}


public String getEmail_address() {
	return email_address;
}


public void setEmail_address(String email_address) {
	this.email_address = email_address;
}


public String getMobile_number() {
	return mobile_number;
}


public void setMobile_number(String mobile_number) {
	this.mobile_number = mobile_number;
}


public Set<Invoice_Details> getInvoice_details() {
	return invoice_details;
}


public void setInvoice_details(Set<Invoice_Details> invoice_details) {
	this.invoice_details = invoice_details;
}




}
