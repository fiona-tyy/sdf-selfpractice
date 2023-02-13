package practice;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileManager {

    // CREATING A NEW FILE

    public boolean createFile(String fullDirPath, String fileName) throws IOException{

        File newFile = new File(fullDirPath + File.separator + fileName);

        // .createNewFile to create new file
        Boolean fileCreated = newFile.createNewFile();

        // returns true if file created, returns falst if file already exists
        if(fileCreated){
            System.out.println("New file created: " + fileName);
        } else {
            System.out.println("File " + fileName + " already exists");
        }

        return fileCreated; 
    }

    // CREATING A NEW DIRECTORY

    public boolean createDir(String directoryName) {
        
        File newDir = new File(directoryName);
        
        // .mkdir() to create new file
        Boolean dirCreated = newDir.mkdir();

        // returns true if file created, returns falst if file already exists
        if(dirCreated){
            System.out.println("New directory created: " + directoryName);
        } else {
            System.out.println("Directory " + directoryName + " already exists");
        }

        return dirCreated;
    }

    // LISTING FILES IN A DIRECTORY

    public Set<String> listFilesInDirectory(String dir){
        return Stream.of(new File(dir).listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());
    }
    
}
