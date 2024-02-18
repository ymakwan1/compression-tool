package file_operations;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHandling {
    public  FileHandling(){

    }

    public boolean validateFile(String fileNameIn){
        File file = new File(fileNameIn);
        return file.exists();
    }
    public String readFileLine(String fileNameIn){
        String line;
        try {
            line = Files.readString(Paths.get(fileNameIn));
            line = line.replaceAll("\\s", "");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return line;
    }
}
