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
        if(inputArray.length == 0){
            return;
        }
        for (Integer datum : inputArray) {
            add(datum);
        }
    }

    // build a heap based on data
    // to be implemented in O(n)
    public void MaxHeapN(Integer[] inputArray) {
        // homework

        for(int i = (int)Math.floor( inputArray.length - 1 ); i >= 0; i--){
            heapifyDown(inputArray, i);
        }

    }

    private void maxHeapify(Integer[] inputArray, int n){
        int largest = n;
        int right = rightChild(n);
        int left = leftChild(n);
        if(left < inputArray.length && inputArray[left] > inputArray[largest]){
            largest = left;
        }
        if(right < inputArray.length && inputArray[right] > inputArray[largest]){
            largest = right;
        }
        if(largest != n){
            swap(n,largest);
            maxHeapify(inputArray, largest);
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
        if(n != 1 && data[n] > data[parent(n)]){
            swap(n,parent(n));
            heapifyUp(parent(n));
        }
    }

    private void heapifyDown(Integer[] arr, int n){
        int smallest = n;
        int l = leftChild(n);
        int r = rightChild(n);
        if(l <= n && data[l] < data[smallest]){
            smallest = l;
        }
        if(r <= n && data[r] < data[smallest]){
            smallest = r;
        }
        if(smallest != n){
            swap(smallest,n);
            heapifyDown(data, smallest);
        }
    }


    // add an item to the heap
    public boolean add(Integer item) {
        // homework
        if(size == data.length){
            return false;
        }
        data[size++] = item;
        heapifyUp(size-1);
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
        int key = data[0];
        data[0] = data[size-1];
        size--;
        heapifyDown(data, 0);
        return key;
    }

    public void print()
    {
        System.out.println("Heap =");
        for (int i = 0; i<data.length; i++ ) {
            System.out.print(data[i]+" ");
        }
    }

    //for test
    public static void main(String[] args) {
        int testSize = 8;

        Integer[] data = new Integer[testSize];
        MaxHeap heap = new MaxHeap(testSize);

        MaxHeap newHeap = new MaxHeap(testSize);
        Integer[] data2 = new Integer[testSize];

        for(int i = 0; i< data.length;i++){
            int rm = (int) (Math.random()*((20-1)+1))+1;
            //int rm = (rand.nextInt(1000)%10);
            data[i] = rm;
        }

        for(int i = 0; i< data2.length;i++){
            int rm2 = (int) (Math.random()*((20-1)+1))+1;
            data2[i] = rm2;
        }

        //System.out.println(Arrays.toString(data));
        heap.MaxHeapLogN(data);
        System.out.println("result for MaxLogN:");
        heap.print();
        int get = heap.get();
        System.out.println("\n\nget(): "+get+"\n");
        heap.pop();
        System.out.println("after pop():");
        heap.print();
        System.out.println();
        System.out.println("\n result of MaxN:");
        newHeap.MaxHeapN(data2);
        newHeap.print();
    }
}
