package array;

import java.util.*;

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

    List<Integer> majorityElements(int [] arr){
        List<Integer> result = new ArrayList<>();
        int maxIterations = arr.length/3;
        int element1 = 0 , element2 = 0;
        int count1 = 0, count2 = Integer.MIN_VALUE;

        for(int a : arr){
            if(count1 == 0 && element2 != a){
                count1 ++;
                element1 = a;
            }
            else if(count2 == 0 && element1 != a){
                count2++;
                element2 = a;
            }
            else if(element2 == a){
                count2++;
            } else if (element1 == a) {
                count1++;
            }else {
                count1--;
                count2--;
            }
        }
        int cnt1 = 0, cnt2 = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == element1){
                cnt1++;
            }
            if(arr[i] == element2){
                cnt2++;
            }
        }
        addElementsToResult(cnt1, element1, arr, result, maxIterations);
        addElementsToResult(cnt2, element2, arr, result, maxIterations);
        return result;
    }

    void addElementsToResult(int count, int element, int [] arr, List<Integer> result, int maxIterations){
        if(count > maxIterations){
            result.add(element);
        }
    }
}

