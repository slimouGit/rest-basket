package net.slimou.restbasket;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class ItemController {

    private ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/items")
    List<Item> all() {
        return this.itemRepository.findAll();
    }

    @GetMapping("/item/{id}")
    Item get(@PathVariable Integer id) {
        return this.itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }

    @GetMapping("/delete/{id}")
    void delete(@PathVariable Integer id) {
        this.itemRepository.deleteById(id);
    }

    @GetMapping("/new/{name}/{price}")
    void put(@PathVariable String name, @PathVariable Double price) {
        Item item = new Item();
        item.setName(name);
        item.setPrice(price);
        this.itemRepository.save(item);
    }

    @GetMapping("/update/{id}/{name}/{price}")
    void update(@PathVariable Integer id, @PathVariable String name, @PathVariable Double price) {
        Item item = this.itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
        item.setName(name);
        item.setPrice(price);
        this.itemRepository.save(item);
    }

}
