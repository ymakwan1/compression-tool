import frequency.FrequencyCalc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class FrequencyTest {
    @Test
    public void testBuildFrequencyFromFile(){
        String fileName = "test.txt";
        FrequencyCalc frequencyCalc = new FrequencyCalc();
        frequencyCalc.buildFrequencyFromFile(fileName);
        Assertions.assertEquals(223000, frequencyCalc.getFrequency('t'));
        Assertions.assertEquals(333, frequencyCalc.getFrequency('X'));
    }
}
