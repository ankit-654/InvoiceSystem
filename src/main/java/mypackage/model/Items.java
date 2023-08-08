package mypackage.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="items")
public class Items {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
private int item_id;
private String item_name;
private Float purchase_rate;
private Float selling_rate;
private Float tax;
private int stock_quantity;


public Items(int item_id, String item_name, Float purchase_rate, Float selling_rate, Float tax, int stock_quantity,
		Set<Invoice_Items> invoiceitem) {
	super();
	this.item_id = item_id;
	this.item_name = item_name;
	this.purchase_rate = purchase_rate;
	this.selling_rate = selling_rate;
	this.tax = tax;
	this.stock_quantity = stock_quantity;
	this.invoiceitem = invoiceitem;
}


public int getitem_id() {
	return item_id;
}


public void setItem_id(int item_id) {
	this.item_id = item_id;
}


public String getitem_name() {
	return item_name;
}


public void setitem_name(String item_name) {
	this.item_name = item_name;
}


public Float getpurchase_rate() {
	return purchase_rate;
}


public void setpurchase_rate(Float purchase_rate) {
	this.purchase_rate = purchase_rate;
}


public Float getselling_rate() {
	return selling_rate;
}


public void setselling_rate(Float selling_rate) {
	this.selling_rate = selling_rate;
}


public Float gettax() {
	return tax;
}


public void settax(Float tax) {
	this.tax = tax;
}


public int getstock_quantity() {
	return stock_quantity;
}


public void setstock_quantity(int stock_quantity) {
	this.stock_quantity = stock_quantity;
}


public Set<Invoice_Items> getInvoiceitem() {
	return invoiceitem;
}


public void setInvoiceitem(Set<Invoice_Items> invoiceitem) {
	this.invoiceitem = invoiceitem;
}


@OneToMany(mappedBy ="item", fetch=FetchType.LAZY, cascade=CascadeType.ALL )
@JsonIgnoreProperties("item")
public Set<Invoice_Items> invoiceitem;


public Items() {
	super();
	// TODO Auto-generated constructor stub
}



}
