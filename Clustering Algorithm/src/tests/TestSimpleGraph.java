package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import util.Edge;
import util.Graph;

public class TestSimpleGraph {
	
	Graph g;
	
	@Before 
	public void constructGraph() {
		g = new Graph(5);
		g.addEdge(1,2,4);
		g.addEdge(1,5,2);
		g.addEdge(2,3,6);
	}
	
	@Test
	public void testAddVertex() {
		g.addVertex(6);
		assertEquals(6, (int) g.getNumVerticies());
		g.addEdge(6,1,7);
		assertEquals(4, g.getEdges().size());
	}
	
	@Test 
	public void testAddEdge() {
		List<Edge> edges = g.getEdges();
		assertEquals(3, edges.size());
		g.addEdge(2, 5, 8);
		g.addEdge(3, 5, 6);
		g.addEdge(4, 5, 10);
		g.printGraph();
		edges = g.getEdges();
		assertEquals(6, edges.size());
	}
	
	@Test
	public void testGetEdges() {
		List<Edge> edges = g.getEdges();
		Edge edge1 = new Edge(1,2,4);
		Edge edge2 = new Edge(1,5,2);
		Edge edge3 = new Edge(2,3,6);
		assertEquals(edge1, edges.get(0));
		assertEquals(edge2, edges.get(1));
		assertEquals(edge3, edges.get(2));
	}
	
	@Test
	public void testSortEdges() {
		Edge same = new Edge(3,4,4);
		g.addEdge(3,4,4);
		List<Edge> edges = g.sortEdges(g.getEdges());
		Edge edge1 = new Edge(1,2,4);
		Edge edge2 = new Edge(1,5,2);
		Edge edge3 = new Edge(2,3,6);
		assertEquals(edge2, edges.get(0));
		assertEquals(edge1, edges.get(1));
		assertEquals(same, edges.get(2));
		assertEquals(edge3, edges.get(3));

	}

}
