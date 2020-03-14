import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class MaxHeapTest {
    // homework
    @Test
    public void testMaxHeapLogN(){
        int testSize = 8;
        MaxHeap heap = new MaxHeap(testSize);
        Integer[] actual = {1,20,11,13,12,2,42,23};
        Integer[] expected = {42,23,20,13,12,2,11,1};

        heap.MaxHeapLogN(actual);
        assertArrayEquals(heap.data, expected);
    }

    @Test
    public void testMaxHeapN(){
        int testSize = 8;
        MaxHeap heap = new MaxHeap(testSize);
        Integer[] actual = {1,20,11,13,12,2,42,23};
        Integer[] expected = {42,23,11,20,12,2,1,13};

        heap.MaxHeapN(actual);
        assertArrayEquals(heap.data,expected);
    }

    @Test
    public void testAdd(){
        int testSize = 10;
        MaxHeap heap = new MaxHeap(testSize);
        Integer[] input = {12,43,54,13,42,54,6,21,3,22,5};
        for (Integer integer : input) {
            heap.add(integer);
        }
        assertEquals(10,heap.size);
    }

    @Test
    public void testGet(){
        int testSize = 5;
        MaxHeap heap = new MaxHeap(testSize);
        Integer[] input = {12,43,54,13,42};
        for (Integer integer : input) {
            heap.add(integer);
        }
        assertEquals((Integer)54,heap.get());
    }

    @Test
    public void testPop(){
        int testSize = 7;
        MaxHeap heap = new MaxHeap(testSize);
        Integer[] input = {12,43,54,13,42,34,3};
        //List<Integer> popped = new ArrayList<>();
        for (Integer integer : input) {
            heap.add(integer);
        }
        heap.pop();
        //popped.add(heap.pop());
        assertEquals((Integer)43,heap.get());
        assertEquals(6,heap.size);
        while(heap.size!=0){
            heap.pop();
            //popped.add(heap.pop());
        }
        //System.out.println(popped.toString());
        assertNull(heap.get());
        assertEquals(0,heap.size);
    }

    //leave the performance test in here just in case but I also uploaded individually to a separate repo
    private long testMaxHeapLogNBuild(Integer[] data, int length) {
        MaxHeap heap = new MaxHeap(length);

        long startTime = System.nanoTime();

        heap.MaxHeapLogN(data);

        long endTime = System.nanoTime();

        while(heap.size!=0){
            heap.pop();
        }

        return TimeUnit.MICROSECONDS.convert(endTime-startTime, TimeUnit.NANOSECONDS);
    }

    private long testMaxHeapNBuild(Integer[] data, int length) {
        MaxHeap heap = new MaxHeap(length);

        long startTime = System.nanoTime();

        heap.MaxHeapN(data);

        long endTime = System.nanoTime();

        while(heap.size!=0){
            heap.pop();
        }

        return TimeUnit.MICROSECONDS.convert(endTime-startTime, TimeUnit.NANOSECONDS);
    }

    @Test
    public void timePQBuild() {
        int start = 100000;
        int end = start * 100;
        for (int i=start; i<=end; i +=200000) {
            Integer[] data = new Integer[i];
            for (int j = 0; j< i; j++) {
                data[j] = j;
            }


            long tlogN = testMaxHeapLogNBuild(data, i);

            long tN = testMaxHeapNBuild(data, i);



            System.out.printf("%d %d %d\n", i, tN, tlogN);
        }
    }


}