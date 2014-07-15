package implementation;

import util.Graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
 * @author: Adrian She
 * @since: 07/12/2014
 * 
 * Main method to run clustering algorithm on provided text files
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static void readFile(File fin) throws IOException {
		FileInputStream fis = new FileInputStream(fin);
	 
		//Construct BufferedReader from InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	 
		String line = null;
	
		while ((line = br.readLine()) != null) {
			String[] result = line.split(" ");
		 // Parse the line here
		}
	 
		br.close();
	}

}
