package implementation;

import java.util.List;

import util.UnionFind;

/* 
 * @author: Adrian She
 * @since: 07/12/2014
 * 
 * Algorithm to run clusterings when distances between two nodes
 * u and v are implicitly known as Hamming distances between
 * the Huffman code representation of these two nodes
 */


public class ClusterHamming {
	
	// Cluster according to differing bits.
	
	private UnionFind<List<Integer>> unionfind;
	private int minimumSpacing; // current minimum distance between nodes
	private static Integer numclusters; // Desired number of clusters
	private int curclusters; // Current number of clusters
	
	public ClusterHamming(List<List<Integer>> bits) {
		unionfind = new UnionFind<List<Integer>>(bits);
		numclusters = unionfind.getSize();
	}
	
	// Cluster until k-clusters appear
	public void runClustering(int k) {
		
		// Check closeness based on differing bits.
		// WHAT IS THIS MADNESS?
		
	}

}
