package practice;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class TextProcessorTest {

    TextProcessor tp;
    String fileName = "/Users/Fiona/Documents/TFIP/self-practice/IO/dataFolder/rhinos.txt";
    Map<String,Integer> wordCountMap;
    List<String> wordList;

    @Before
    public void setUp() throws FileNotFoundException, IOException{

        Path p = Paths.get(fileName);
        File file = p.toFile();
        tp = new TextProcessor();
        wordList = tp.getWordsFromFile(file);
        wordCountMap = tp.getWordCount(wordList);
    }

    @Test
    public void testGetWordsFromFile() {
        assertTrue(!wordList.isEmpty());
    }

    @Test
    public void testGetWordCount() {
        assertTrue(!wordCountMap.isEmpty());
    }


}
