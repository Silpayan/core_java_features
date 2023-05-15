package com.ds;

public class RemoveDuplicate {

	public static void main(String s[]){


		char chArr[]={'g','e','e','k','f','o','r','g','e','e','k'};
        System.out.println(chArr);
        int tail = 1;
        for(int i =0; i< chArr.length; i++)
        {
            int j;
            for(j =0;j< tail; j++) {
                if (chArr[i] == chArr[j])
                    break; // break if we find duplicate.
            }
            // if j reachs tail..we did not break, which implies this char at pos i
            // is not a duplicate. So we need to add it our "unique char list"
            // we add it to the end, that is at pos tail.
            if (j == tail) {
              chArr[tail] = chArr[i]; // add
              tail++; // increment tail...[0,tail) is still "unique char list"
            }
        }
        for(; tail < chArr.length;tail++){
            chArr[tail] = 0;
        }
        System.out.println(chArr);
	}
}
