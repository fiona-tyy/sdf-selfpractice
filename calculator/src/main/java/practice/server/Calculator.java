package practice.server;

import java.util.LinkedList;
import java.util.List;

public class Calculator {

    public List<Integer> getNumberList(String input){
        List<Integer> numberList = new LinkedList<>();
        String[] splitInput = input.split(" ");
        for(int i = 1; i < splitInput.length; i++){
            numberList.add(Integer.parseInt(splitInput[i]));
        }

        return numberList;
    }

    public Integer add(List<Integer> numberList){
        int sum = 0;
        for(int num : numberList){
            sum += num;
        }
        return sum;
    }

    public Integer subtract(List<Integer> numberList){
        int result = numberList.get(0);
        for(int i = 1; i < numberList.size(); i++){
            result -= numberList.get(i);
        }
        return result;
    }

    public Integer multiply(List<Integer> numberList){
        int result = 1;
        for(int num : numberList){
            result *= num;
        }
        return result;
    }
    
}
