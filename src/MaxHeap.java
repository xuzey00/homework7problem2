import java.util.*;
import java.lang.Math;

public class MaxHeap implements Heap {
    int size;

    Integer[] data;

    public MaxHeap(int capacity) {
        data = new Integer[capacity];
        size = 0;
    }

    // build a heap based on data
    // to be implemented in O(nlogn)
    public void MaxHeapLogN(Integer[] inputArray) {
        // homework
        //System.out.println("Max heap build O(nlogn)");
        if(inputArray.length == 0){
            return;
        }
        for (Integer datum : inputArray) {
            add(datum);
            //print();
            //System.out.println(Arrays.toString(data));
        }
    }

    // build a heap based on data
    // to be implemented in O(n)
    public void MaxHeapN(Integer[] inputArray) {
        // homework
        //System.out.println("Max heap build O(n)");
        if(inputArray.length == 0){
            return;
        }

        for (int i = 0; i < inputArray.length; i++) {
            data[i] = inputArray[i];
        }

        size = inputArray.length;
        for (int i = size/2; i >= 0; i--)
        {
            heapifyDown(i);
            //System.out.println("data: " +Arrays.toString(data));
        }

    }

    private int rightChild(int pos){
        return (2*pos) + 2;
    }

    private int leftChild(int pos){
        return (2*pos) + 1;
    }

    private int parent(int pos){
        return (pos-1)/2;
    }

    private void swap(int f, int s){
        int temp = data[f];
        data[f] = data[s];
        data[s] = temp;
    }

    private boolean isLeaf(int pos){
        return pos >= (size / 2) && pos <= size;
    }

    private void heapifyUp(int n){

        if(n != 0 && data[n] > data[parent(n)]){
            swap(n,parent(n));
            heapifyUp(parent(n));
        }
    }

    private void heapifyDown(int n){
        int largest = n;
        int left = leftChild(n);
        int right = rightChild(n);

        if ((left < size) && (data[left] > data[largest])) {
            largest = left;
        }
        if ((right < size) && (data[right] > data[largest])) {
            largest = right;
        }

        if(largest != n) {
            swap(largest,n);
            heapifyDown(largest);
        }
    }


    // add an item to the heap
    public boolean add(Integer item) {
        // homework
        if(size == 0){
            data[0] = item;
            size++;
            return true;
        }
        if(size == data.length){
            return false;
        }
        data[size] = item;
        heapifyUp(size++);
        return true;
    }

    // return the max item in the heap
    public Integer get() {
        // homework
        if(size != 0){
            return data[0];
        }
        return null;
    }

    // remove the root item
    public Integer pop() {
        // homework
        if(size == 0){
            return null;
        }
        int temp = data[0];
        data[0] = data[size-1];
        size--;
        heapifyDown(0);
        //System.out.println("popped: "+temp);
        //System.out.println(Arrays.toString(data));
        return temp;
    }

    public void print()
    {
        System.out.println("Heap =");
        if(size == 0) {
            System.out.print("null\n ");
        }
        for(int i = 0; i<size;i++){
            System.out.print(" "+ data[i]);
        }
        System.out.print("\n");
    }

    //for test
   /* public static void main(String[] args) {
        int testSize = 8;

        Integer[] data1 = new Integer[testSize];
        MaxHeap heap = new MaxHeap(testSize);

        MaxHeap newHeap = new MaxHeap(testSize);
        Integer[] data2 = new Integer[testSize];

        for(int i = 0; i< data1.length;i++){
            int rm = (int) (Math.random()*((20-1)+1))+1;
            //int rm = (rand.nextInt(1000)%10);
            //data1[i] = rm;

        }
        data1 = new Integer[]{1, 20, 11, 13, 12, 2, 42, 23};
        data1[0] = 1;
        data1[1] = 20;
        data1[2] = 11;
        data1[3] = 13;
        data1[4] = 12;
        data1[5] = 8;
        data1[6] = 12;
        data1[7] = 2;

        for(int i = 0; i< data2.length;i++){
            //int rm2 = (int) (Math.random()*((20-1)+1))+1;
            //data2[i] = rm2;
        }

       // data2=new Integer[]{1,20,11,13,12,2,42,23};


        //System.out.println("data1: " + Arrays.toString(data1));
        heap.MaxHeapLogN(data1);
        System.out.println("result for MaxLogN:");
        heap.print();

        while (heap.get() != null) {
            System.out.println("pop:" + heap.pop());
            heap.print();
        }

        System.out.println();

        System.out.println("data2: "+ Arrays.toString(data2));

        newHeap.MaxHeapN(data2);
        System.out.println("\nresult of MaxN:");
        newHeap.print();

        while (newHeap.get() != null) {
            System.out.println("pop:" + newHeap.pop());
            newHeap.print();
        }
    }*/
}
