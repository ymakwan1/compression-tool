package frequency;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class FrequencyCalc {

    HashMap<Character, Integer> hashMap;
    public FrequencyCalc(){
        hashMap = new HashMap<>();
    }

    public void buildFrequencyFromFile(String fileNameIn){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileNameIn));
            String line;
            while ((line = bufferedReader.readLine()) != null){
               line = line.replaceAll("\\s", "");
               buildFrequency(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void buildFrequency(String lineIn){
        for (char c : lineIn.toCharArray()){
            hashMap.put(c, hashMap.getOrDefault(c,0) + 1);
        }
    }

    public int getFrequency(char key){
        return hashMap.getOrDefault(key, 0);
    }
}
