package project_manager;

import file_operations.FileHandling;
import frequency.FrequencyCalc;
import huffman_tree.HuffmanTree;

import java.util.HashMap;

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
            HashMap<Character, Integer> hashMap = frequencyCalc.getFrequencyMap();
            HuffmanTree huffmanTree = new HuffmanTree();
            huffmanTree.buildHuffManTree(hashMap);
        } else {
            System.out.println("File does not exist.");
        }
    }
}
