package frequency;

import file_operations.FileHandling;
import java.util.HashMap;

public class FrequencyCalc {

    HashMap<Character, Integer> hashMap;
    public FrequencyCalc(){
        hashMap = new HashMap<>();
    }

    public void buildFrequencyFromFile(String fileNameIn){
        FileHandling fileHandling = new FileHandling();
        String line = fileHandling.readFileLine(fileNameIn);
        buildFrequency(line);
    }

    private void buildFrequency(String lineIn){
        for (char c : lineIn.toCharArray()){
            hashMap.put(c, hashMap.getOrDefault(c,0) + 1);
        }
    }

    public int getFrequency(char key){
        return hashMap.getOrDefault(key, 0);
    }

    public HashMap<Character, Integer> getFrequencyMap(){
        return hashMap;
    }
}
