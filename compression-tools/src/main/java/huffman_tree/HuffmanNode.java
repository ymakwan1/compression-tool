package huffman_tree;

import java.io.Serializable;

public class HuffmanNode implements Serializable {

    int charFrequency;
    HuffmanNode leftChild;
    HuffmanNode rightChild;
    char character;

    public HuffmanNode(char characterIn, int charFrequencyIn){
        character = characterIn;
        charFrequency = charFrequencyIn;
        leftChild = null;
        rightChild = null;
    }

    public HuffmanNode(char characterIn, int charFrequencyIn, HuffmanNode leftChildIn, HuffmanNode rightChildIn){
        character = characterIn;
        charFrequency = charFrequencyIn;
        leftChild = leftChildIn;
        rightChild = rightChildIn;
    }

    public int getCharFrequency() {
        return charFrequency;
    }

    public char getCharacter() {
        return character;
    }
}