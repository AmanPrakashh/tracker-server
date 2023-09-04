package com.example.trackerserver.controller;

public class MergeSort {

    public static void main(String[] args) {
        int [] arr = {2, 4, 7, 9, 1, 32 , 6};
        mergeSort(arr);
    }

    private static void mergeSort(int[] arr) {

        int mid= arr.length/2;
        int [] firstHalf= new int[mid];
        int [] secondHalf= new int[arr.length-mid];
        for(int i=0; i<mid; i++)
        {
            firstHalf[i]=arr[i];
        }

        for(int i = mid; i< arr.length; i++)
        {
            secondHalf[i]= arr[i];
        }


        mergeSort(firstHalf);
        mergeSort(secondHalf);

        merging(firstHalf, secondHalf, arr);



    }

    private static int [] merging(int[] firstHalf, int[] secondHalf, int[] arr) {
        int first=0, second=0, og=0;
        int merged[]= new int[arr.length];
        while(first<firstHalf.length&& second<secondHalf.length)
        {
            if(firstHalf[first]<secondHalf[second])
            {
                merged[og]= firstHalf[first];
                first++;
            }
            else {
                merged[og]= secondHalf[second];
                second++;
            }
            og++;
        }

        if(firstHalf.length>first)
        {
            merged[og]= firstHalf[first];
        }
        if(secondHalf.length>second)
        {
            merged[og]= secondHalf[second];
        }
        return merged;
    }


}
