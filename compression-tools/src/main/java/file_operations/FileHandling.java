package file_operations;

import java.io.File;

public class FileHandling {
    public  FileHandling(){

    }

    public boolean validateFile(String fileNameIn){
        File file = new File(fileNameIn);
        return file.exists();
    }
}
