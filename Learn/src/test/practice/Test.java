package test.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// You are given an array A of size N, and you are also given a sum. You need to find if two numbers in A exists that have sum equal to the given sum.
// 10
// 1 2 3 3 4 5 6 7 8 9 10
// 14

class Test{
public void findNumber(int[] arr, int k){
    Arrays.sort(arr);
    int len = arr.length;
    int s = 0;
    int e = len-1;
    while(s<e){
        int cs = arr[s] + arr[e];
        if(cs == k){
            System.out.println(arr[s]+"..."+arr[e]);
        }
        if(cs<k){
            s++;
        }
        else{
            e--;
        }
    }
}

public void findNumbers(int[] arr, int k){
    Map<Integer, Integer> m = new HashMap<>();
    for(int i =0; i<arr.length; i++){
        if(m.containsKey(k-arr[i])){
            System.out.println(arr[i]+"..."+m.get(k-arr[i]));
        }
        m.put(arr[i], 1);
    }
}

// 10
// 1 2 3 4 5 6 7 8 9 10
// 18
// 5 6 7

void findThreeNumbers(int[] arr, int k){
    for(int i =0; i<arr.length; i++){
        findNumbers(arr, k-arr[i], i);
    }
}

public void findNumbers(int[] arr, int k, int n){
    Arrays.sort(arr);
    int len = arr.length;
    int s = n+1;
    int e = len-1;
    while(s<e){
        int cs = arr[s] + arr[e];
        if(cs == k){
            System.out.println(arr[n] + "..." +arr[s]+"..."+arr[e]);
        }
        if(cs<k){
            s++;
        }
        else{
            e--;
        }
    }
}


// Given a binary array arr of size N and an integer M. Find the maximum number of consecutive 1's produced by flipping at most M 0's.

// N = 11
            // 0  1  2  3  4  5  6  7  8
// arr[] = {1, 0,1, 0, 1, 1, 0, 1, 0, 1, 1, 1}

// {0,0,0,1}, 1

// {1,1,0}, 1
// M = 2
// Output:
// 8
// Explanation:
// Maximum subarray is of size 8
// which can be made subarray of all 1 after
// flipping two zeros to 1.

public int maxlength(int[] arr, int m){
    int maxCount = Integer.MIN_VALUE;
    int zeroCount = 0;
    int zp = 0; 
    for(int i = 0; i<arr.length; i++){
        if(arr[i]==0){
            zeroCount++;
        }
        if(zeroCount>m){
            while(arr[zp]!=0){
                zp++;
            }
            zeroCount--;
            maxCount = Math.max(maxCount, i-zp);
            zp++;
        }
        else{
            maxCount = Math.max(maxCount, i-zp+1);
        }      
    }
    return maxCount;
}
}