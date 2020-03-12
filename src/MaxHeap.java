import java.util.Arrays;
import java.util.HashMap;
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

    public int parent(int pos){
        return pos/2;
    }

    public void swap(int f, int s){
        int temp = data[f];
        data[f] = data[s];
        data[s] = temp;
    }

    public void heapifyUp(int n){
        if(n != 1 && data[n] < data[parent(n)]){
            swap(n, parent(n));
            heapifyUp(parent(n));
        }
    }

    // add an item to the heap
    public boolean add(Integer item) {
        // homework
        if(size != data.length){
            for(int i = 0; i<data.length;i++){
                if(data[i] == null){
                    data[i] = item;
                    size++;
                    return true;
                }
            }
        }
        System.out.println("max capacity reached");
        return false;
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

    public static void main(String[] args) {
        int testSize = 5;
        Integer[] data = new Integer[testSize];
        MaxHeap heap = new MaxHeap(testSize);
        for(int i = 0; i<data.length;i++){
            int rm = (int) (Math.random()*((10-1)+1))+1;
            data[i]= rm;
        }
        System.out.println(Arrays.toString(data));
        //System.out.println(heap.MaxHeapLogN(data)); to check the result
        heap.MaxHeapLogN(data);
    }
}
