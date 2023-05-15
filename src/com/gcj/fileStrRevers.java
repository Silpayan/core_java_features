package com.gcj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class fileStrRevers {
	
	public static void main(String arg[]) {
		try{
			FileReader fr = new FileReader("input\\longstr");
			FileWriter fw = new FileWriter("output\\longstr");
			
			BufferedReader br = new BufferedReader(fr);
			BufferedWriter bw = new BufferedWriter(fw);
			
			String s = br.readLine();
			int N = Integer.parseInt(s);
			int lineNo = 1;
			while(((s = br.readLine()) != null) && lineNo <= N ) {
			System.out.print("Case #"+lineNo+":");
			
			bw.append("Case #"+lineNo+":");
			String words[] = s.split(" ");
			for(int wordNo = 1; wordNo <= words.length; wordNo++){
				System.out.print(" "+words[words.length-wordNo]);
				bw.append(" "+words[words.length-wordNo]);
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
