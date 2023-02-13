package practice.server;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileManager {

    // use this to create a file within a subfolder
    public boolean createFile(String fullDirPath, String fileName) throws IOException{
        String fullFileName = fullDirPath + File.separator + fileName;
        File newFile = new File(fullFileName);
        Boolean fileCreated = newFile.createNewFile();

        if(fileCreated){
            System.out.println("New file created " + fileName);
        } else {
            System.out.println("File already exists: " + fileName);
        }

        return fileCreated;
    }

    // use this to create a file within root directory
    public boolean createFile( String fileName) throws IOException{
        String fullFileName = System.getProperty("user.dir") + File.separator + fileName;
        File newFile = new File(fullFileName);
        Boolean fileCreated = newFile.createNewFile();

        if(fileCreated){
            System.out.println("New file created " + fileName);
        } else {
            System.out.println("File already exists: " + fileName);
        }

        return fileCreated;
    }

    // use this to create a directory
    public boolean createDirectory(String directoryName){
        String fullDirPath = System.getProperty("user.dir") + File.separator + directoryName;
        File newDir = new File(fullDirPath);
        boolean dirCreated = newDir.mkdir();

        if(dirCreated){
            System.out.println("New file created " + directoryName);
        } else {
            System.out.println("File already exists: " + directoryName);
        }

        return dirCreated;
    }
    
    public Set<String> listFilesinDirectory (String fullDirectoryPath){
        return Stream.of(new File(fullDirectoryPath).listFiles())
                    .filter(file -> !file.isDirectory())
                    .map(File::getName)
                    .collect(Collectors.toSet());
    }

}
