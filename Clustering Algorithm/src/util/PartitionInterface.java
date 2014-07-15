package util;

import java.util.Set;

public interface PartitionInterface<T> {
	
	/* 
	 * @author: Adrian She
	 * @since: 07/15/2014
	 * 
	 * A representation of a particular partition in a Union-Find type
	 */		
		// Adds an item to the partition
		public void addItem(T item);
		
		// Adds all the items to the particular partition;
		public void addAllItems(Set<T> items);
		
		// Removes all items in the partition
		public void removeAllItems();
		
		// Returns true if item is in partition
		public boolean inPartition(T item);
		
		// Returns the leader pointer of this particular partition
		public T getLeader();
			
		// Returns the size of a this particular partition
		public int getSize();
		
		public Set<T> getItems();

		boolean equals(Partition<T> obj);
		
}
