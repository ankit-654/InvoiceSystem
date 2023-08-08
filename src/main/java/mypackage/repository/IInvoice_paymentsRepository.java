package mypackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.Invoice_payments;

public interface IInvoice_paymentsRepository extends JpaRepository<Invoice_payments, Integer> {

}
