package implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import util.Edge;
import util.Graph;
import util.Partition;
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

	public ClusterExplicitDistance(int runTo, Graph g) {
				graph = g;
				List<Integer> loi = new ArrayList<Integer>();
				for (int i = 1; i <= g.getNumVerticies(); i++) {
					loi.add(i);
				}
				clusters = new UnionFind<Integer>(loi);
				curclusters = clusters.getSize();
				numclusters = runTo;
	}
	
	public void runClustering() {
		// while curclusters > numclusters
		// find p,q in different clusters in which it is the closet pair of separating points
		// (find the minimal edge weight)
		// join p and q
		List<Edge> edges = graph.sortEdges(graph.getEdges());
		for (Edge e: edges) {
			Partition<Integer> p1 = clusters.findItem(e.getSource());
			Partition<Integer> p2 = clusters.findItem(e.getDestination());
			if (p1 != p2 && p1 != null && p2 != null) {
				e.print();
				clusters.join(p1.getLeader(), p2.getLeader());
				System.out.println("Joining " + p1.getLeader() + " and " + p2.getLeader());
				curclusters--;
				System.out.println("There are now " + curclusters + " clusters");
			}
			if (curclusters == numclusters) {
				break;
			}
		}
	}
	
	
	public int findMaxSpacing() {
		int length = Integer.MIN_VALUE;
		Map<Integer, Partition<Integer>> items = clusters.getMap();
		Set<Integer> keys = items.keySet();
		return length;

	}
	
	public void print() {
		clusters.printUnionFind();
	}

}
