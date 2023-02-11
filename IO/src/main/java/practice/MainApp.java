package practice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class MainApp {
    
    public static void main(String[] args) throws IOException{

        String currentDirectory = System.getProperty("user.dir");
        // System.out.println(currentDirectory);
        // String directoryName = args[0];
        // String fullDirPath = currentDirectory + File.separator + directoryName;
        // String fileName = args [1];
        
        // FileManager fm = new FileManager();
        // fm.createDir(directoryName);
        // fm.createFile(fullDirPath, fileName);

        Path p = Paths.get(currentDirectory+ File.separator + "dataFolder" + File.separator +"rhinos.txt");
        File file = p.toFile();

        System.out.println(file.exists());

        TextProcessor tp = new TextProcessor();
        List<String> wordList = tp.getWordsFromFile(file);

        Map<String, Integer> wordCountMap = tp.getWordCount(wordList);

        String highestCountWord = tp.getHighestWord(wordCountMap);
        int highestCount = wordCountMap.get(highestCountWord);
        
        System.out.printf("%s has the highest count: %d\n", highestCountWord, highestCount);
        
        tp.writeToFile(wordCountMap, "dataFolder", "wordCount.txt");
    
    }
}
