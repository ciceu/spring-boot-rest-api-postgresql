package com.crina.repository;

import com.crina.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ItemRepository extends JpaRepository<Item, Integer> {
    Item findByName(String name);
}
