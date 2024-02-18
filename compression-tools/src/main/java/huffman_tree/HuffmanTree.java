package huffman_tree;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Comparator;

public class HuffmanTree {

    HuffmanNode root;
    public HuffmanTree(){

    }

    public void buildHuffManTree(HashMap<Character, Integer> hashMap){
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>(
                Comparator.comparingInt(HuffmanNode::getCharFrequency)
        );

        for (Map.Entry<Character, Integer> map : hashMap.entrySet()){
            priorityQueue.add(new HuffmanNode(map.getKey(), map.getValue()));
        }

        while (priorityQueue.size() > 1) {
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();

            HuffmanNode mergedNode = new HuffmanNode('\0', left.charFrequency + right.charFrequency, left, right);
            priorityQueue.add(mergedNode);
        }

        root = priorityQueue.poll();
    }

    public void buildPrefixCodeTable(){
        HashMap<Character, String> prefixCodeTable = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        buildPrefixCodeTableHelper(root, stringBuilder, prefixCodeTable);

        for (Map.Entry<Character, String> map : prefixCodeTable.entrySet()){
            System.out.println("Character : " +  map.getKey() + " String : " + map.getValue());
        }
    }

    private void buildPrefixCodeTableHelper(HuffmanNode rootIn, StringBuilder stringBuilderIn, HashMap<Character, String> prefixCodeTableIn) {
        if (rootIn == null){
            return;
        }

        if (rootIn.leftChild == null && rootIn.rightChild == null) {
            prefixCodeTableIn.put(rootIn.character, stringBuilderIn.toString());
        }

        stringBuilderIn.append('0');
        buildPrefixCodeTableHelper(rootIn.leftChild, stringBuilderIn, prefixCodeTableIn);
        stringBuilderIn.deleteCharAt(stringBuilderIn.length() - 1);

        stringBuilderIn.append('1');
        buildPrefixCodeTableHelper(rootIn.rightChild, stringBuilderIn, prefixCodeTableIn);
        stringBuilderIn.deleteCharAt(stringBuilderIn.length() - 1);
    }
}
