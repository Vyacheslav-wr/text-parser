package service;

import by.salei.parser.model.Composite;
import by.salei.parser.service.CompositeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompositeServiceTest {

    @Test
    public void parseTest(){
        Composite composite = new Composite();
        CompositeService compositeService = new CompositeService(composite,"src/main/resources/Text.txt");
        Composite composite2 = compositeService.parse();
        System.out.println(composite2.getComponents().toString());
        compositeService.writeToFile(composite2);
        Assertions.assertEquals(1,composite2.getComponents().size());
    }
}
