package com.gdlsct.storewarehouseapi.api;

import com.gdlsct.storewarehouseapi.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;
import store_warehouse_api.server.api.ItemApiController;
import store_warehouse_api.server.model.GetItemResponse;
import store_warehouse_api.server.model.SaveItemRequest;
import store_warehouse_api.server.model.SaveItemResponse;

import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

@Controller
public class ItemController extends ItemApiController {

    private final ItemService itemService;

    public ItemController(NativeWebRequest request,
                          ItemService itemService) {
        super(request);
        this.itemService = itemService;
    }


    @Override
    public ResponseEntity<SaveItemResponse> saveItem(SaveItemRequest request) {
        return ok(itemService.save(request));
    }

    @Override
    public ResponseEntity<GetItemResponse> getItem(UUID id) {
        return ok(itemService.get(id));
    }
}
