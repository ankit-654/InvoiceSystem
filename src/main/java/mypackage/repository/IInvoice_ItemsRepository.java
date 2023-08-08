package mypackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.Invoice_Items;

public interface IInvoice_ItemsRepository extends JpaRepository<Invoice_Items, Integer> {

}
