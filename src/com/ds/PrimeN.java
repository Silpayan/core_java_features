package com.ds;

import java.io.*;

class PrimeN {
  public static void main(String[] args) throws Exception{
	  int i,j;
	  int nPrimes;
	  boolean is_prime = false;
	  BufferedReader bf = new BufferedReader(
	  new InputStreamReader(System.in));
	  System.out.println("Enter number:");
	  int num = Integer.parseInt(bf.readLine());
	    
	  int pPrimes[] = new int[num/2];
	  nPrimes = 0;
	  for(i = 2; i<=num; i++)
	  {
	      is_prime = true;
	      for(j=0;j<nPrimes && j<=num/2; j++)
	         if (i%pPrimes[j] == 0)
	         {
	             is_prime = false; break;
	         }
	      if (is_prime)
	      {
	         pPrimes[nPrimes++] = i;
	      }
	  }
	  
	  System.out.println("primes found less than :"+ nPrimes+" "+ num);
	  for (i=0; i< nPrimes; i++)
		  System.out.print("  "+ pPrimes[i]);
  }
}