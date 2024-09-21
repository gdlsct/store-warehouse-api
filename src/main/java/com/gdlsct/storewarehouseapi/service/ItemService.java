package com.gdlsct.storewarehouseapi.service;

import com.gdlsct.storewarehouseapi.model.Item;
import com.gdlsct.storewarehouseapi.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import store_warehouse_api.server.model.GetItemResponse;
import store_warehouse_api.server.model.SaveItemRequest;
import store_warehouse_api.server.model.SaveItemResponse;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public SaveItemResponse save(SaveItemRequest request) {
        Item newCake = Item.builder()
                .id(UUID.randomUUID())
                .name(request.getName())
                .price(request.getPrice())
                .count(request.getCount())
                .build();

        Item savedItem = itemRepository.save(newCake);

        return SaveItemResponse.builder()
                .id(savedItem.getId())
                .build();
    }

    public GetItemResponse get(UUID id) {
        Item foundItem = itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Товар не найден"));

        return GetItemResponse.builder()
                .id(foundItem.getId())
                .name(foundItem.getName())
                .price(foundItem.getPrice())
                .count(foundItem.getCount())
                .build();
    }
}
