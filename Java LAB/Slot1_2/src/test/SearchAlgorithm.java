/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Nhật Huy
 */
public class SearchAlgorithm extends Algorithm {
    private final int numberToFind;

    public SearchAlgorithm(int numberRange, int n) {
        super(numberRange);
        this.numberToFind = n;
    }
    
    public void displayResult(ArrayList<Integer> result) {
        System.out.println("Array: " + Arrays.toString(super.getList()));
        if (result.isEmpty()) {
            System.out.println("The array does not contain an element with a value of " + this.numberToFind + "!");
        } 
        else if (result.size() == 1) {
            System.out.println("The array contains element(s) with a value of " + this.numberToFind + ".");
        }
        else {
            System.out.println("The array contains element(s) with a value of " + this.numberToFind + ", in the following indexes: " + result.toString());
        }
    }
    
    public ArrayList<Integer> linearSearchExecute() {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < super.getList().length; i++) {
            if (list[i] == this.numberToFind) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<Integer> binarySearchExecute() {
        ArrayList<Integer> result = new ArrayList<>();
        
        int tempList[] = new int[super.getList().length];
        System.arraycopy(this.list, 0, tempList, 0, tempList.length);
        
        for (int i = 0; i < tempList.length - 1; i++) {
            for (int j = i + 1; j < tempList.length; j++) {
                if (tempList[i] > tempList[j])
                    swap(tempList, i, j);
            }
        }
        
        if (binarySearch(tempList, 0, (tempList.length - 1), this.numberToFind) != -1) {
            result.add(this.numberToFind);
        }
        
        return result;
    }
    int binarySearch(int tempList[], int l, int r, int x)
    {
        if (r>=l)
        {
            int mid = l + (r - l)/2;
            
            if (tempList[mid] == x)
               return mid;
            if (tempList[mid] > x)
               return binarySearch(tempList, l, mid-1, x);
            return binarySearch(tempList, mid+1, r, x);
        }
        return -1;
    }
}
