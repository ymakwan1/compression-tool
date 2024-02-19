package compression;
import file_operations.FileHandling;
import huffman_tree.HuffmanNode;

import java.io.*;
import java.util.HashMap;

public class Compression {

    private final HashMap<Character, String> prefixCodeTable;
    HuffmanNode r;

    public Compression(HashMap<Character, String> prefixCodeTableIn, HuffmanNode rIn) {
        prefixCodeTable = prefixCodeTableIn;
        r = rIn;
    }

    public void compressAndWrite(String inputFilename, String outputFilename) throws IOException {
        writeHeaderAsBytes(outputFilename);
        writeCompressedContent(inputFilename, outputFilename);
    }

    private void writeHeaderAsBytes(String outputFilename) {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(outputFilename))) {
            outputStream.writeObject(r);
            outputStream.writeObject(null);
            System.out.println("Header written successfully to " + outputFilename);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeCompressedContent(String inputFilename, String outputFilename) throws IOException {
        try(BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputFilename)))
        {


            FileHandling fileHandling = new FileHandling();
            String text = fileHandling.readFileLine(inputFilename);
            StringBuilder encodedText = new StringBuilder();

            for (char ch : text.toCharArray()) {
                encodedText.append(prefixCodeTable.get(ch));
            }

            System.out.println("Encoded StringBuilder:" + encodedText.toString());

            int numBytes = (encodedText.length() + 7) / 8;
            System.out.println("numBytes : " + numBytes);

            byte[] bytes = new byte[numBytes];

            for (int i = 0; i < encodedText.length(); i += 8) {
                String byteString = encodedText.substring(i, Math.min(i + 8, encodedText.length()));
                bytes[i / 8] = (byte) Integer.parseInt(byteString, 2);
            }

            outputStream.write(bytes);

            System.out.println("Text encoded and written to " + outputFilename);
        }
        catch (IOException e) {
            System.out.println("Error encoding and writing the text to the file: " + e.getMessage());
        }
    }
}