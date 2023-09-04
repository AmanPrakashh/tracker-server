package com.example.trackerserver.controller;

import java.util.ArrayList;
import java.util.List;

public class TestInterview {

    public static void main(String[] args) {
    int[] arr = {12 , 5, 7, 8, 9, 16};

        mergeSort(arr);

        for(int num: arr)
        {
            System.out.println(num+"  ");
        }


    }

    static  void mergeSort(int[] arr)
    {
        //base cond
        if(arr==null|| arr.length<=1){
            return ;
        }

        int mid= arr.length/2;
        int[] left= new int [mid];
        int[] right= new int [arr.length-mid];


        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length-mid);
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);

        for(int nums : arr)
        {
            System.out.println(nums);
        }
    }

    static void merge(int[] arr, int[] left, int[] right)
    {
        int leftIndex=0, rightIndex=0, mergeIndex=0;

        while(leftIndex<left.length && rightIndex<right.length )
        {
            if(left[leftIndex]<right[rightIndex])
            {
                arr[mergeIndex++]= left[leftIndex++];
            }
            else
            {
                arr[mergeIndex++]=right[rightIndex++];
            }
        }
        while(leftIndex<left.length)
        {
            arr[mergeIndex++]= left[leftIndex++];
        }
        while(rightIndex<right.length)
        {
            arr[mergeIndex++]= right[leftIndex++];
        }
    }
}
