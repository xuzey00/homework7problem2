import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

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
            data[i]=i;
        }
        System.out.println(Arrays.toString(data));
        //System.out.println(heap.MaxHeapLogN(data)); to check the result
        heap.MaxHeapLogN(data);
    }
}
