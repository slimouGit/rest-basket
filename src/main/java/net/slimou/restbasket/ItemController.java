package net.slimou.restbasket;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    private ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

}
