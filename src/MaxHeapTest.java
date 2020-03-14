

import org.junit.Test;

import java.util.Arrays;

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
        Integer[] expected = {42,23,20,13,12,2,11,1};

        heap.MaxHeapN(actual);
        assertArrayEquals(heap.data,expected);
    }


}