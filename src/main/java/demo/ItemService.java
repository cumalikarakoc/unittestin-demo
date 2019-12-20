package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    private List<Item> items;
    @Autowired
    private ItemRepository itemRepository;

    public ItemService() {
        items = new ArrayList<>();
//        items.add(new Item(1, "milk"));
//        items.add(new Item(2, "bread"));
//        items.add(new Item(3, "cheese"));
    }

    public List<Item> all() {
        return itemRepository.findAll();
    }

    public Item addOne(String name){
        return itemRepository.save(new Item(name));
    }

    public Item findOne(int id) {
        return items.stream()
                .filter(f -> f.getId() == id)
                .findAny()
                .orElse(null);
    }
}
