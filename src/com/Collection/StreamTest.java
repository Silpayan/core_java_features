package com.Collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args){

        List<Integer> nums = Arrays.asList(9,5,10,34,54,4,5); //test check in after moving local folder

        Stream<Integer> data = nums.stream();

        System.out.println( "nums : ");


        //long count  = data.count();
        //System.out.println(count); //stream has already been operated upon or closed

        //Stream<Integer> sortedData = data.sorted();
        //data.forEach( n -> System.out.println(n)); //stream has already been operated upon or closed
        //sortedData.forEach( n -> System.out.println(n));

        Stream<Integer> mapData = data.map(n -> n*2);

        mapData.forEach( n -> System.out.println(n));

        System.out.println( "numsA : ");


        List<Integer> numsA = Arrays.asList(9,5,10,34,54,4,5);

        numsA.stream()                      //Array to Stream
                .filter( n ->  (n&1) == 1)  //filter odd nums
                .sorted()                   //Sort
                .map( n -> n*2 )            //doubling by map method, it is not Map
                .forEach( n -> System.out.println( n ) );


        int result  = numsA.stream()                      //Array to Stream
                .filter( n ->  (n&1) == 1)  //filter odd nums
                .sorted()                   //Sort
                .map( n -> n*2 )            //doubling by map method, it is not Map
                .reduce(0, (c,e) -> c+e); //add with carry
        System.out.println( "\n numsA Reduce = " + result);

    }
}
