package net.slimou.restbasket;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ItemPopulate implements CommandLineRunner {

    private ItemRepository itemRepository;

    public ItemPopulate(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Item item = new Item();
        item.setName("Banane");
        item.setPrice(1.42);
        this.itemRepository.save(item);
    }
}
