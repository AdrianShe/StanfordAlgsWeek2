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
	static Graph g;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File f = new File("clustering1.txt");
			readFile(f);
			ClusterExplicitDistance toCluster = new ClusterExplicitDistance(4,g);
			toCluster.runClustering();
			System.out.println("Maximum cluster spacing is: " + toCluster.findMaxSpacing());
			toCluster.print();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void readFile(File fin) throws IOException {
		FileInputStream fis = new FileInputStream(fin);
	 
		//Construct BufferedReader from InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	 
		String line = null;
		int counter = 0;

		while ((line = br.readLine()) != null) {
			String[] result = line.split(" ");
		 // Parse the line here
			if (counter == 0) {
				g = new Graph(Integer.parseInt(result[0]));
				counter++;
			}
			else {
				int source = Integer.parseInt(result[0]);
				int destination = Integer.parseInt(result[1]);
				int weight = Integer.parseInt(result[2]);
				g.addEdge(source, destination, weight);
				counter++;
			}
		}
	 
		br.close();
	}

}
