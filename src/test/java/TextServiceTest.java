import by.salei.parser.model.Composite;
import by.salei.parser.service.TextService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TextServiceTest {

    @Test
    public void parseTest(){
        Composite composite = new Composite();
        TextService textService = new TextService(composite,"src/main/resources/Text.txt");
        Composite composite2 = textService.parse();
        System.out.println(composite2.getComponents().toString());
        textService.writeToFile(composite2);
        Assertions.assertEquals(1,composite2.getComponents().size());
    }
}
