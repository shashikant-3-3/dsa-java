package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberWithMoreThanHalfFrequency {

    // O(n) time as well as O(n) space complexity
    int numberWithMoreThanHalfFrequency(int[] arr){
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i<arr.length-1; i++){
            if(!hm.containsKey(arr[i])){
                hm.put(arr[i], 1);
            }
            else{
                hm.put(arr[i], hm.get(arr[i])+1);
            }
        }

        return hm.values().stream().max(Integer::compareTo).orElse(0) > arr.length/2 ? hm.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(0) : 0;
    }

    //space O(1) time (nlogN) due to sorting
    int numberWithMoreThanHalfFrequency2(int [] arr){
        Arrays.sort(arr);
        return arr[arr.length/2 + 1];
    }

    // Best approach Moore's voting algorithm
    // space O(1) time O(N)
    int numberWithMoreThanHalfFrequency3(int [] arr){
        int count = 0;
        int currentElement = 0;
        for(int i = 0; i < arr.length-1; i++){
            if(count == 0){
                currentElement = arr[i];
            }
            if(arr[i] == currentElement){
                count++;
            }
            else {
                count--;
            }
        }
        return currentElement;
    }
}

