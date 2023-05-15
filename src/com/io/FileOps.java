package com.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileOps {
	public static void main(String []s) throws IOException{
		File file = new File("MyFile.txt");
		FileWriter fw = new FileWriter(file); 	// create a FileWriter
												// that will send its
												// output to a File
		PrintWriter pw = new PrintWriter(fw); 	// create a PrintWriter
												// that will send its
												// output to a Writer
		pw.println("howdy"); // write the data
		pw.println("folks");
		pw.flush();
		pw.close();

		FileReader fr =	new FileReader(file); // create a FileReader to get
											  // data from 'file'
		BufferedReader br =	new BufferedReader(fr); // create a BufferReader to
													// get its data from a Reader
		String data = br.readLine(); // read some data
		br.close();
		System.out.println("File"+ data);
	}

}