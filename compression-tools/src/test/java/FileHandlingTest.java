import file_operations.FileHandling;
import org.junit.jupiter.api.Test;

public class FileHandlingTest {
    @Test
    public void testValidFile(){
        String fileName = "test.txt";
        FileHandling fileHandling = new FileHandling();
        fileHandling.validateFile(fileName);
    }
}
