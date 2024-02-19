package project_manager;

import compression.Compression;
import compression.Decompression;
import file_operations.FileHandling;
import frequency.FrequencyCalc;
import huffman_tree.HuffmanNode;
import huffman_tree.HuffmanTree;

import java.io.IOException;
import java.util.HashMap;

public class ProjectManager {
    String fileName;
    public ProjectManager(String fileNameIn){
        fileName = fileNameIn;
    }

    public void runProject() throws IOException {
        FileHandling fileHandling = new FileHandling();
        FrequencyCalc frequencyCalc = new FrequencyCalc();

        if (fileHandling.validateFile(fileName)){
            frequencyCalc.buildFrequencyFromFile(fileName);

            HashMap<Character, Integer> hashMap = frequencyCalc.getFrequencyMap();

            HuffmanTree huffmanTree = new HuffmanTree();
            HuffmanNode r = huffmanTree.buildHuffManTree(hashMap);
            HashMap<Character, String> map = huffmanTree.buildPrefixCodeTable();

            Compression compression = new Compression(map, r);
            compression.compressAndWrite(fileName, "test1-compress.txt");

            Decompression decompression = new Decompression();
            HuffmanNode n = decompression.readHeaderAsBytes("test1-compress.txt");

        } else {
            System.out.println("File does not exist.");
        }
    }
}
