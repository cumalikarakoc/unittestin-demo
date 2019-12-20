package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping("/")
    public ResponseEntity index() {

        return ResponseEntity.ok(itemService.all());
    }

    @RequestMapping("/{id}")
    public ResponseEntity show(@PathVariable("id") String id) {

        Item f = itemService.findOne(Integer.parseInt(id));
        if (f == null) return ResponseEntity.status(404).build();
        return ResponseEntity.ok(f);
    }

    @RequestMapping("/env")
    public ResponseEntity env() {
        return ResponseEntity.ok(System.getenv().get("COMPUTERNAME"));
    }
}
