/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.lang.reflect.Array;

/**
 *
 * @author vanvo
 */
public class PriorityQueue<T extends Comparable<T>> {
    private T[] pqArray;
    private int currSize, capacity=0;
    private int index=0;

    private Class<T> cl;



    public PriorityQueue(int capacity,Class <T> c){
        this.capacity=capacity;
        this.cl=c;
        this.currSize=0;
        pqArray= (T[]) Array.newInstance(cl,capacity);


    }

    public void clear(){
        currSize=0;
        pqArray=(T[])Array.newInstance(this.cl,capacity);
        index=0;

    }

    public boolean isEmpty(){
        if (currSize==0)
            return true;
        return false;
    }

    public boolean isFull(){
        if (currSize==capacity)
            return true;
        return false;
    }

    public int size() {
        return currSize;
    }



    public void enqueue(T data){
        if (isFull()){
            System.out.println("Cant add any further");
            return;
        }
        pqArray[index]=data;
        index++;
        currSize++;
        System.out.println("Added object "+ data);


    }
    //remove max
    public T dequeue(){
        if (isEmpty()){
            System.out.println("Cant remove any further");
            return null;
        }
        int maxIndex=0;

        for (int i=0;i<currSize;i++){
            if (pqArray[i].compareTo(pqArray[maxIndex])>0)
                maxIndex=i;
        }
        T maxElement=pqArray[maxIndex];
        pqArray[maxIndex]=pqArray[index-1];
        index--;
        currSize--;
        return maxElement;

    }




}
