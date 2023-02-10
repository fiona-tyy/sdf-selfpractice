package practice;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class WriteFile {

    public static void main(String[] args) throws IOException {

        List<String> sampleText = new LinkedList<>();
        
        for(int i = 0; i < 10; i++){
            sampleText.add(String.format("This is string no.%d",i+1));
        }
        
        String path = args[0];
        FileWriter fw = new FileWriter(path);
        for (String s: sampleText){
            fw.write(s + "\n");
        }

        fw.close();
    }
    
}
