package com.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.PriorityQueue;

public class StreamConversionMasterclass {

    public static void main(String[] args) {
        System.out.println("=== 1. PRIORITY QUEUE TO PRIMITIVE ARRAYS ===");
        // OUTPUT: === 1. PRIORITY QUEUE TO PRIMITIVE ARRAYS ===
        priorityQueueToPrimitiveArray();
        priorityQueueTo2DArray();

        System.out.println("\n=== 2. INTERMEDIATE MAPPING TO PRIMITIVE STREAMS ===");
        // OUTPUT: \n=== 2. INTERMEDIATE MAPPING TO PRIMITIVE STREAMS ===
        objectStreamToPrimitiveArray();

        System.out.println("\n=== 3. TERMINAL SCALAR & SUMMARY OPERATIONS ===");
        // OUTPUT: \n=== 3. TERMINAL SCALAR & SUMMARY OPERATIONS ===
        scalarAndSummaryOperations();

        System.out.println("\n=== 4. MULTI-DIMENSIONAL FLAT MAPPING ===");
        // OUTPUT: \n=== 4. MULTI-DIMENSIONAL FLAT MAPPING ===
        flatteningWithStreams();
    }

    /**
     * Demonstrates converting PriorityQueue<Integer> to int[].
     * Covers both preserving the queue (via streams) and strict priority ordering (via polling).
     */
    private static void priorityQueueToPrimitiveArray() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(30); pq.add(10); pq.add(20);

        // Approach A: Preserving the Queue using mapToInt() (Internal Heap Order)
        int[] heapOrderArr = pq.stream().mapToInt(Integer::intValue).toArray();
        System.out.println("PQ Stream (Heap Order): " + Arrays.toString(heapOrderArr));
        // OUTPUT: PQ Stream (Heap Order): [10, 30, 20]

        // Approach B: Preserving the Queue + Sorting via Stream
        int[] sortedStreamArr = pq.stream().mapToInt(Integer::intValue).sorted().toArray();
        System.out.println("PQ Stream + .sorted(): " + Arrays.toString(sortedStreamArr));
        // OUTPUT: PQ Stream + .sorted(): [10, 20, 30]

        // Approach C: Destructive Polling (Strict Priority Order)
        int[] strictlySortedArr = new int[pq.size()];
        int i = 0;
        while (!pq.isEmpty()) {
            strictlySortedArr[i++] = pq.poll();
        }
        System.out.println("PQ Polled (Strict Order): " + Arrays.toString(strictlySortedArr));
        // OUTPUT: PQ Polled (Strict Order): [10, 20, 30]
    }

    /**
     * Demonstrates converting PriorityQueue<int[]> to int[][].
     * Highlights the use of custom allocation arrays (int[][]::new) since arrays are Objects.
     */
    private static void priorityQueueTo2DArray() {
        // Max-heap sorting pairs descending by their first index
        PriorityQueue<int[]> pq2D = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        pq2D.add(new int[]{10, 20});
        pq2D.add(new int[]{30, 40});

        // Using toArray(int[][]::new) factory mapping to allocate the outer container
        int[][] result2D = pq2D.stream().toArray(int[][]::new);
        System.out.println("PQ 2D Array Output: " + Arrays.deepToString(result2D));
        // OUTPUT: PQ 2D Array Output: [[30, 40], [10, 20]]
    }

    /**
     * Demonstrates the primary Java 8 entry point mapping methods (mapToInt, mapToLong, mapToDouble)
     * used to unbox standard object streams into primitive streams to bypass boxing overhead.
     */
    private static void objectStreamToPrimitiveArray() {
        List<Integer> integerList = List.of(1, 2, 3);
        List<Long> longList = List.of(100L, 200L, 300L);
        List<Double> doubleList = List.of(1.5, 2.5, 3.5);

        // mapToInt uses Integer::intValue to unbox wrapper objects
        int[] ints = integerList.stream().mapToInt(Integer::intValue).toArray();

        // mapToLong uses Long::longValue to extract primitive longs
        long[] longs = longList.stream().mapToLong(Long::longValue).toArray();

        // mapToDouble uses Double::doubleValue to extract primitive doubles
        double[] doubles = doubleList.stream().mapToDouble(Double::doubleValue).toArray();

        System.out.println("int[] from mapToInt: " + Arrays.toString(ints));
        // OUTPUT: int[] from mapToInt: [1, 2, 3]

        System.out.println("long[] from mapToLong: " + Arrays.toString(longs));
        // OUTPUT: long[] from mapToLong: [100, 200, 300]

        System.out.println("double[] from mapToDouble: " + Arrays.toString(doubles));
        // OUTPUT: double[] from mapToDouble: [1.5, 2.5, 3.5]
    }

    /**
     * Demonstrates terminal math functions (.sum(), .average()) and the single-pass
     * compilation of metrics using .summaryStatistics().
     */
    private static void scalarAndSummaryOperations() {
        List<Integer> scores = List.of(10, 20, 30, 40);

        // Individual Math Terminal Actions
        int totalSum = scores.stream().mapToInt(Integer::intValue).sum();
        OptionalDouble average = scores.stream().mapToInt(Integer::intValue).average();

        System.out.println("Scalar Sum: " + totalSum);
        // OUTPUT: Scalar Sum: 100

        System.out.println("Scalar Average: " + (average.isPresent() ? average.getAsDouble() : 0.0));
        // OUTPUT: Scalar Average: 25.0

        // All-in-one execution using summaryStatistics
        IntSummaryStatistics stats = scores.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();

        System.out.println("--- Summary Statistics Box ---");
        // OUTPUT: --- Summary Statistics Box ---

        System.out.println("Count : " + stats.getCount());
        // OUTPUT: Count : 4

        System.out.println("Sum   : " + stats.getSum());
        // OUTPUT: Sum   : 100

        System.out.println("Min   : " + stats.getMin());
        // OUTPUT: Min   : 10

        System.out.println("Max   : " + stats.getMax());
        // OUTPUT: Max   : 40

        System.out.println("Avg   : " + stats.getAverage());
        // OUTPUT: Avg   : 25.0
    }

    /**
     * Demonstrates flatMapToInt to deconstruct multi-dimensional arrays or collections
     * down into a flat, one-dimensional primitive stream pipeline.
     */
    private static void flatteningWithStreams() {
        List<int[]> nestedArrays = new ArrayList<>();
        nestedArrays.add(new int[]{1, 2});
        nestedArrays.add(new int[]{3, 4, 5});

        // flatMapToInt flattens multiple primitive arrays into a single sequential IntStream
        int[] flattenedResult = nestedArrays.stream()
                .flatMapToInt(Arrays::stream)
                .toArray();

        System.out.println("Flattened 1D Primitive Array: " + Arrays.toString(flattenedResult));
        // OUTPUT: Flattened 1D Primitive Array: [1, 2, 3, 4, 5]
    }
}

