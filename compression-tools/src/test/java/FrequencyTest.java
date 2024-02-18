import frequency.FrequencyCalc;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class FrequencyTest {
    @Test
    public void testBuildFrequencyFromFile(){
        String fileName = "test.txt";
        FrequencyCalc frequencyCalc = new FrequencyCalc();
        frequencyCalc.buildFrequencyFromFile(fileName);
        assertEquals(223000, frequencyCalc.getFrequency('t'));
        assertEquals(333, frequencyCalc.getFrequency('X'));
    }
}
