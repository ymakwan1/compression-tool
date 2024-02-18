package project_manager;

import file_operations.FileHandling;
import frequency.FrequencyCalc;

public class ProjectManager {
    String fileName;
    public ProjectManager(String fileNameIn){
        fileName = fileNameIn;
    }

    public void runProject(){
        FileHandling fileHandling = new FileHandling();
        FrequencyCalc frequencyCalc = new FrequencyCalc();
        if (fileHandling.validateFile(fileName)){
            frequencyCalc.buildFrequencyFromFile(fileName);
        } else {
            System.out.println("File does not exist.");
        }
    }
}
