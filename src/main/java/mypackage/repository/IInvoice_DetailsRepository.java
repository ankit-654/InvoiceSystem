package mypackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.Invoice_Details;

public interface IInvoice_DetailsRepository extends JpaRepository<Invoice_Details, Integer> {

}
