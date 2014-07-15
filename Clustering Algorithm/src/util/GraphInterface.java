package util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
 * @author: Adrian She
 * @since: 07/12/2014
 * 
 * Representation of a undirected graph G:(V,E) as an adjacency list;
 */

public interface GraphInterface {
	
	// Initialize a node in a graph
	public void addVertex(int i);
	
	// Add an edge to the node in the graph
	public void addEdge(int s, int d, int w);
	
	// Getters
	public Integer getNumVerticies();
	
	public ArrayList<LinkedList<Edge>> getGraph();
	
	public List<Edge> getEdges();

}
