package com.gdlsct.storewarehouseapi.repository;

import com.gdlsct.storewarehouseapi.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemRepository extends CrudRepository<Item, UUID> {


}
