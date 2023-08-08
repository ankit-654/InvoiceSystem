package mypackage.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.Customers;
public interface ICustomersRepository extends JpaRepository<Customers, Integer> {

}
