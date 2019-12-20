package demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

public class ItemControllerTest {

    private ItemController itemController;
    private ItemService itemService;

    @BeforeEach
    void setup(){
        itemService = Mockito.mock(ItemService.class);
        itemController =  new ItemController(itemService);

//        itemController.setItemService(itemService);
    }

    @Test
    void testShouldReturn200Status(){
        Mockito.when(itemService.all()).thenReturn(new ArrayList<>());

        Assertions.assertEquals(200, itemController.index().getStatusCodeValue());
    }

    @Test
    void testShouldReturn404IfRequestedItemNotExists(){
        Mockito.when(itemService.findOne(Mockito.anyInt())).thenReturn(null);

        Assertions.assertEquals(404, itemController.show("1").getStatusCodeValue());
    }

    @Test
    void testShouldReturn200IfRequestedItemExists(){
        Mockito.when(itemService.findOne(Mockito.anyInt())).thenReturn(new Item( "jam"));

        Assertions.assertEquals(200, itemController.show("1").getStatusCodeValue());
    }

    @Test
    void testShouldThrowExceptionIfNonIntegerArgumentSupplied(){
        Assertions.assertThrows(Exception.class, () -> {
            itemController.show("four");
        });
    }

}
