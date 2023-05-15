package com.gcj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.sound.midi.Sequence;

public class Robot {
	public static void main(String arg[]) {
		try{
			FileReader fr = new FileReader("input\\robot");
			FileWriter fw = new FileWriter("output\\robot");
			
			BufferedReader br = new BufferedReader(fr);
			BufferedWriter bw = new BufferedWriter(fw);
			
			int O[] = new int[100];
			int B[] = new int[100], buttonTOPress;
			
			String s = br.readLine();
			int N = Integer.parseInt(s);
			System.out.println("Total Cases"+N);
			int caseNo = 1;
			while(((s = br.readLine()) != null) && caseNo <= N ) {
			
				System.out.print("Case #"+caseNo+": ");
				bw.append("Case #"+caseNo+": ");
								
				String words[] = s.split(" ");
				buttonTOPress = Integer.parseInt(words[0]);
				
				int oCount = 0, bCount = 0;
				
				String sequence[] = new String[100];  
					
				for(int wordNo = 1; wordNo < words.length; ){
					//System.out.print(" "+words[wordNo]);
					sequence[oCount+bCount] = words[wordNo];
					//System.out.print(" "+sequence[oCount+bCount]);
					if(words[wordNo].contains("O")) {
						O[oCount++]=Integer.parseInt(words[wordNo+1]);
						//System.out.print(words[wordNo]+ words[wordNo+1]+" ");
					} else	
						if(words[wordNo].contains("B")) {
							B[bCount++]=Integer.parseInt(words[wordNo+1]);
							//System.out.print(words[wordNo]+ words[wordNo+1]+" ");
					}
					wordNo = wordNo+2;
				}
				
				int time = 0;
				int positionO = 1;
				int positionB = 1;
						
				for(int pressCount = 0, o = 0, b = 0; pressCount < buttonTOPress; time++){
					
					//System.out.print("o="+o+" "+oCount+" b="+b+" "+bCount+" press="+pressCount+ " buttonToPress="+buttonTOPress);//pressCount++;
					//System.out.print(" "+sequence[pressCount]+" "+pressCount+" ");
					
					if(o < oCount){ //if end of O array then no button left
						if(positionO == O[o] ){ //only O press button no move
							if(sequence[pressCount].equals("O")){
								System.out.print(" Processing "+sequence[pressCount]);
								o++;pressCount++;	
							}
							
						}else 
							if(positionO < O[o]){ //O moves fwd
								
								positionO++;
							} else 
								if(positionO > O[o]){ // O moves back
								//if(caseNo ==5)System.out.print(" O moves back "+positionO+O[o]);
								positionO--;
							}
					}
					
					if(b < bCount ){// //if end of B array then no button left for B
										
						if(positionB == B[b] ){ //only B press button no move	
							if(sequence[pressCount].contains("B")){
								System.out.print(" Processing "+sequence[pressCount]);						
								b++;pressCount++;
							}
							
							
						}else 
							if(positionB < B[b]){ //O moves fwd
								
								positionB++;
							} else 
								if(positionB > B[b]){ // O moves back
								//if(caseNo == 5)System.out.print(" B moves back "+positionB+"Next Switch"+O[o]);
								positionB--;
							}
					}
				}
				
				System.out.print(time);
				bw.write(String.valueOf(time));
				
				caseNo++;
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
