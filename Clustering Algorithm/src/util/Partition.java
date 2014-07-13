package util;

/* 
 * @author: Adrian She
 * @since: 07/12/2014
 * 
 * A representation of a particular partition in a Union-Find type
 */

public interface Partition<T> {
	
	// Adds an item to the partition
	public void addItem(T item);
	
	// Returns true if item is in partition
	public boolean inPartition(T item);
	
	// Returns the leader pointer of this particular partition
	public T getLeader();
	
	// Sets the leader pointer of an the item in the particular partition
	public void setLeader();
		
	// Returns the size of a this particular partition
	public int getSize();
	

}
