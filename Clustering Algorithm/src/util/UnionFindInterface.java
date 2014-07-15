package util;

/* 
/**
 * @author Adrian She
 * @since: 07/15/2014
 *
 * 
 * A specification for the Union Find data type, as described in 
 * Tim Roughgarden's "Implementation Kruskal's Algorithm via Union-Find"
 * video in "Algorithms: Design and Analysis"
 */

public interface UnionFindInterface<T> {
		
		// Finds the partition in which a particular item is contained 
		 
		public Partition<T> findItem(T item);
		
		// Joins two partitions of a union-find, referenced by their leaders, into one by merging
		// the smaller partition into the larger one
		public void join(T leader1, T leader2);
		
		// Gets the number of partitions present (useful for k-clustering problem)
		
		public int getSize();
		
		// Gets the size of a particular partition within the union-find
		
		public int getSize(Partition<T> p);
		
		public Partition<T> findPartition(Partition<T> partition);
		
		public void printUnionFind();



}
