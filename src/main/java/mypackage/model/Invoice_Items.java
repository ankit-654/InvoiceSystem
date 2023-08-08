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
@Table(name="invoice_items")
public class Invoice_Items {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int invoice_item_id;
	
	
	@ManyToOne(fetch=FetchType.LAZY,optional = false)
	@JoinColumn(name="invoice_id", nullable = false)
	public Invoice_Details invoice_details;
	
	@ManyToOne(fetch=FetchType.LAZY,optional = false)
	@JoinColumn(name="item_id", nullable = false)
	public Items item;
	private int quantity;
	public Invoice_Items() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Invoice_Items(int invoice_item_id, Invoice_Details invoice_details, Items item, int quantity) {
		super();
		this.invoice_item_id = invoice_item_id;
		this.invoice_details = invoice_details;
		this.item = item;
		this.quantity = quantity;
	}
	public int getInvoice_item_id() {
		return invoice_item_id;
	}
	public void setInvoice_item_id(int invoice_item_id) {
		this.invoice_item_id = invoice_item_id;
	}
	public Invoice_Details getInvoice_details() {
		return invoice_details;
	}
	public void setInvoice_details(Invoice_Details invoice_details) {
		this.invoice_details = invoice_details;
	}
	public Items getItem() {
		return item;
	}
	public void setItem(Items item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	}
