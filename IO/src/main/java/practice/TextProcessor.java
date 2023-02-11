package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextProcessor {

    public List<String> getWordsFromFile(File file) throws FileNotFoundException, IOException{

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        
        List<String> wordList = new ArrayList<>();
        
        // use br.lines() to give a stream of lines, and then further split to words
        wordList = br.lines()
        .map(l -> l.replaceAll("[^a-zA-Z0-9\\s]", ""))
        .flatMap(l -> Stream.of(l.split("\\s+")))
        .map(String :: trim)
        .map(String :: toLowerCase)
        .collect(Collectors.toList());
        
        br.close();

        return wordList;
    }

    public Map<String, Integer> getWordCount (List<String> wordList){
        // Use treemap as it is naturally sorted
        Map<String, Integer> wordCountMap = new TreeMap<>();
        for(String w : wordList){
    
            if(!wordCountMap.containsKey(w)){
                wordCountMap.put(w, 1);
            } else {
                wordCountMap.put(w, (Integer)wordCountMap.get(w)+1);
            }
        }
        return wordCountMap;
    }
    
    public String getHighestWord (Map<String,Integer> wordCountMap){
        String highestCountWord = "";
        int highestCount = 0;
        for(Map.Entry<String,Integer> entry : wordCountMap.entrySet()){
            if (entry.getValue() > highestCount){
                highestCount = entry.getValue();
                highestCountWord = entry.getKey();
            }
        }
        return highestCountWord;
    }

    public void writeToFile(Map<String,Integer> wordCountMap, String dirName, String fileName) throws IOException{
        FileWriter fw = new FileWriter(System.getProperty("user.dir")+ File.separator + dirName + File.separator + fileName);

        // Iterating through map
        for(Map.Entry<String,Integer> entry : wordCountMap.entrySet()){
            fw.write(entry.getKey() + ": " + entry.getValue() + "\n");
        }
        fw.flush();
        fw.close();
    }
    
}
