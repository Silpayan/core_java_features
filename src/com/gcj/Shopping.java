package com.gcj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Shopping {
	public static void main(String arg[]) {
		try{
			FileReader fr = new FileReader("input\\shopping");
			FileWriter fw = new FileWriter("output\\shopping");
			
			BufferedReader br = new BufferedReader(fr);
			BufferedWriter bw = new BufferedWriter(fw);
			
			String s = br.readLine();
			int N = Integer.parseInt(s);
			int lineNo = 1;
			while(((s = br.readLine()) != null) && lineNo <= N ) {
			
				System.out.print("Case #"+lineNo+": ");
				bw.append("Case #"+lineNo+": ");
				
				int Credit = Integer.parseInt(s);
				//System.out.print("Credit is "+Credit+" ");
				s = br.readLine();
				int noOfItem = Integer.parseInt(s);
				//System.out.print("Total "+noOfItem+" Items are : ");
				s = br.readLine();
				String prices[] = s.split(" ");
				
				boolean found = false;
				for(int item = 0; item < prices.length; item++){
					
					for(int count = item+1; count< prices.length; count++){
						int p1 = Integer.parseInt(prices[item]);
						int p2 = Integer.parseInt(prices[count]);
						if(Credit == (p1+p2)){
							
							System.out.println((item+1)+" "+(count+1));
							bw.append((count+1)+" "+(item+1));
							
							found = true;
							break;
						}
						if(found)
							break;
					}
				if(found)
					break;
				}
				lineNo++;
				System.out.println();
				bw.newLine();
			}
			bw.flush();
			bw.close();
			fr.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
