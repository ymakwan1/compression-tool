package projectmanager;
import utils.FileHandling;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ProjectManager {

    String fileName;
    public ProjectManager(String fileNameIn){
        fileName = fileNameIn;
    }

    public void run() throws IOException {
        FileHandling fileHandling = new FileHandling();
        try{
            fileHandling.validateFile(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e){
            throw new IOException(e);
        }
    }
}
