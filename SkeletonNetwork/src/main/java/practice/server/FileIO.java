package practice.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class FileIO {
    
    public List<String> readFromFile(String fullFilePath) throws IOException{
        List<String> content = new LinkedList<>();

        Path p = Paths.get(fullFilePath);
        File f = p.toFile();
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        String line;

        while((line = br.readLine()) != null){
            content.add(line);
        }

        br.close();
        
        return content;
    }

    public void writeToFile(List<String> content, String fileName) throws IOException{
        String fullFilePath = System.getProperty("user.dir") + File.separator + fileName;
        FileWriter fw = new FileWriter(fullFilePath);

        for(String s : content){
            fw.write(s);
        }
        
        fw.flush();
        fw.close();
    }


}
