package mypackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.Items;

public interface IItemsRepository extends JpaRepository<Items, Integer> {

}

