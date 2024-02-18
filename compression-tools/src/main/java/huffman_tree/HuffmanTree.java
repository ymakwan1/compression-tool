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

}
