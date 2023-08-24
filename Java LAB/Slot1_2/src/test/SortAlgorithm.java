/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Arrays;

/**
 *
 * @author Nhật Huy
 */
public class SortAlgorithm extends Algorithm {
    private int tempList[];
    
    public SortAlgorithm() {
    }

    public SortAlgorithm(int numberRange) {
        super(numberRange);
        this.tempList = new int[super.getList().length];
        System.arraycopy(super.getList(), 0, this.tempList, 0, this.tempList.length);
    }

    public void displayResult() {
        System.out.println("Unsorted array: " + Arrays.toString(super.getList()));
        System.out.println("Sorted array: " + Arrays.toString(this.tempList));
    }

    public void bubbleSortExecute() {
        for (int i = 0; i < this.tempList.length - 1; i++) {
            for (int j = 0; j < this.tempList.length - i - 1; j++) {
                if (this.tempList[j] > this.tempList[j + 1]) {
                    swap(this.tempList, j, j + 1);
                }
            }
        }
    }

    public void quickSortExecute() {
        quickSort(0, this.tempList.length - 1);
    }
    public void quickSort(int firstIndex, int lastIndex) {
        if (firstIndex < lastIndex) {
            int partition = partition(firstIndex, lastIndex);
            quickSort(firstIndex, partition - 1);
            quickSort(partition, lastIndex);
        }
    }
    int partition(int firstIndex, int lastIndex) {
        int pivot = this.tempList[(firstIndex + lastIndex) / 2];
        while (firstIndex <= lastIndex) {
            while (this.tempList[firstIndex] < pivot) {
                firstIndex++;
            }
            while (this.tempList[lastIndex] > pivot) {
                lastIndex--;
            }
            if (firstIndex <= lastIndex) {
                swap(this.tempList, firstIndex, lastIndex);
                firstIndex++;
                lastIndex--;
            }
        }
        return firstIndex;
    }
}
