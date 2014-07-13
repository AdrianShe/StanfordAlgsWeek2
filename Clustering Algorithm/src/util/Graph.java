package util;

/* 
 * @author: Adrian She
 * @since: 07/12/2014
 * 
 * Representation of a graph G:(V,E) as an adjacency list;
 */

public interface Graph {
	
	// Initialize a node in a graph
	public void addVertex(int i);
	
	// Add an edge to the node in the graph
	public void addEdge(int s, int d, int w);

}
