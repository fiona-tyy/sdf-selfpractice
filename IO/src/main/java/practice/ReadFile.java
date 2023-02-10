package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;


public class ReadFile 
{
    public static void main( String[] args ) throws IOException
    {
        // arg passed in can be absolute or relative path
        // test by passing random.txt as arg
        Path path = Paths.get(args[0]);
        File f = path.toFile();

        System.out.printf("File name: %s\n",f.getName());
        System.out.printf("Is directory? %b\n", f.isDirectory());
        System.out.printf("Is directory? %b\n", f.isFile());

        // FileReader must be used when we are reading text files, pdfs or word documents.
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        String line;
        List<String> content = new LinkedList<>();
        int count = 1;
        
        //
        while((line=br.readLine()) != null){
            System.out.printf("Line %d: %s\n", count,line);
            // Adds each line to a list of String
            content.add(line);
            count++;
        }
        br.close();

        // use .get(index) to retrieve element(i.e. each line) from list
        System.out.println(">>>\n"+content.get(0));
    }
}
