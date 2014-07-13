package implementation;

import util.Graph;
import util.UnionFind;

/* 
 * @author: Adrian She
 * @since: 07/12/2014
 * 
 * Algorithm to run single-link clusterings when distances are explicitly known
 */

public class ClusterExplicitDistance {
	
	private Graph graph;
	private UnionFind<Integer> clusters; // UnionFind to represent clusters
	private static Integer numclusters; // Desired number of clusters
	private int curclusters; // Current number of clusters
	
	public ClusterExplicitDistance() {
		
	}
	
	public void runClustering() {
		// while curclusters > numclusters
		// find p,q in different clusters in which it is the closet pair of separating points
		// (find the minimal edge weight)
		// join p and q
	}
	
	public int findMaxSpacing() {
		return 0;
	}

}
