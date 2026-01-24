package array;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input.txt"));
        int size = sc.nextInt();
        int[] arr = new int[size];

        for(int i =0; i<size; i++){
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        boolean yesOrNo = findTwoSum3(arr, target);
        System.out.println(yesOrNo);
        }

    //  O(N^2)
    static boolean findTwoSum(int[] array, int target){
        int size = array.length;
        for(int j = 0; j<size-1; j++){
            int find = target-array[j];
            for(int k = j+1; k<size; k++){
                if(find == array[k]){
                    return true;
                }
            }
        }
        return false;
    }

    //O(N)
    static boolean findTwoSum2(int[] array, int target){
        HashMap<Integer, Integer> hashMap = new HashMap<>(5);
        for (int i : array) {
            int find = target - i;
            hashMap.put(i, find);
        }
        for (int key : hashMap.keySet()){
            int value = hashMap.get(key);
            if(hashMap.containsKey(value) && hashMap.get(value) == key){
                return true;
            }
        }
        return false;
    }

    //0(N log N)
    static boolean findTwoSum3(int[] array, int target){
        int size = array.length;
        Arrays.sort(array);  // N log N
        int i = 0;
        int j = size-1;
        int left  = array[i];
        int right = array[j];

        while(i<j){
            int sum = left+right;
            if(target == sum){
                return true;
            }
            else if(sum<target){
                left = array[++i];
            }
            else{
                right = array[--j];
            }
        }
        return false;
    }
}
