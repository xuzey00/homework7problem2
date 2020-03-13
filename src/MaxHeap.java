import java.util.Arrays;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
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
    public void MaxHeapLogN(Integer[] data) {
        // homework
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Arrays.asList(data));
        maxHeap.addAll(Arrays.asList(data));

    }

    // build a heap based on data
    // to be implemented in O(n)
    public void MaxHeapN(Integer[] data) {
        // homework

    }

    public int rightChild(int pos){
        return (2*pos) + 1;
    }

    public int leftChild(int pos){
        return (2*pos);
    }

    public int parent(int pos){
        return pos/2;
    }

    public void swap(int f, int s){
        int temp = data[f];
        data[f] = data[s];
        data[s] = temp;
    }

    public boolean isLeaf(int pos){
        return pos >= (size / 2) && pos <= size;
    }

    public void heapifyUp(int n){
        if(n != 1 && data[n] < data[parent(n)]){
            swap(n,parent(n));
            heapifyUp(parent(n));
        }
    }

    public void heapifyDown(Integer[] arr, int n){
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
        return null;
    }

    // remove the root item
    public Integer pop() {
        // homework
        return null;
    }

    public void print()
    {
        for (int i = 1; i <= size / 2; i++ )
        {
            System.out.print(" PARENT : " + data[i] + " LEFT CHILD : " + data[2*i]
                    + " RIGHT CHILD :" + data[2 * i  + 1]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int testSize = 5;
        Integer[] data = new Integer[testSize];
        MaxHeap heap = new MaxHeap(testSize);
        for(int i = 0; i<data.length;i++){
            int rm = (int) (Math.random()*((10-1)+1))+1;
            data[i]= rm;
        }
        System.out.println(Arrays.toString(data));
        heap.MaxHeapN(data);
        heap.print();
    }
}
