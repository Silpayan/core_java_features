package com.gcj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Mobile {
	public static void main(String arg[]) {
		try{
			FileReader fr = new FileReader("input\\mobilelarge");
			FileWriter fw = new FileWriter("output\\mobilelarge");
			
			Map<String, String>  keys = addKeys();
			
			BufferedReader br = new BufferedReader(fr);
			BufferedWriter bw = new BufferedWriter(fw);
			
			String s = br.readLine();
			int N = Integer.parseInt(s);
			int lineNo = 1;
			
			/*Iterator i = keys.entrySet().iterator();
			
			while(i.hasNext()){
				System.out.println(i.next());
			}*/
			
			while(((s = br.readLine()) != null) && lineNo <= N ) {
			
				System.out.print("Case #"+lineNo+": ");
				bw.append("Case #"+lineNo+": ");
									
				for(int charNo = 0; charNo < s.length(); charNo++){
					System.out.print(keys.get(s.substring(charNo, charNo+1)));
					bw.append(keys.get(s.substring(charNo, charNo+1)));
					if(charNo!=s.length()-1 && (keys.get(s.substring(charNo,charNo+1))).substring(0,1).equals((keys.get(s.substring(charNo+1,charNo+2))).substring(0,1))){
						System.out.print(" ");
						bw.append(" ");
					}
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

	private static Map<String, String> addKeys() {
		Map<String, String> keys = new HashMap<String, String>();
		keys.put(" ", "0");
		keys.put("a", "2");
		keys.put("b", "22");
		keys.put("c", "222");
		
		keys.put("d", "3");
		keys.put("e", "33");
		keys.put("f", "333");
		
		keys.put("g", "4");
		keys.put("h", "44");
		keys.put("i", "444");
		
		keys.put("j", "5");
		keys.put("k", "55");
		keys.put("l", "555");
		
		keys.put("m", "6");
		keys.put("n", "66");
		keys.put("o", "666");
		
		keys.put("p", "7");
		keys.put("q", "77");
		keys.put("r", "777");
		keys.put("s", "7777");
		
		keys.put("t", "8");
		keys.put("u", "88");
		keys.put("v", "888");
		
		keys.put("w", "9");
		keys.put("x", "99");
		keys.put("y", "999");
		keys.put("z", "9999");
		
		return keys;
	}

}
