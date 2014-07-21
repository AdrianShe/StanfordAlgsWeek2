/**
 * 
 */
package util;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Adrian She
 * @since: 07/15/2014
 */
public class Partition<T> implements PartitionInterface<T> {
	
	private T leader;
	private Set<T> items;
	
	public Partition(T t) {
		leader = t;
		items = new LinkedHashSet<T>();
		items.add(t);
	}

	@Override
	public void addItem(T item) {
		// TODO Auto-generated method stub
		items.add(item);
	}
	
	@Override
	public void addAllItems(Set<T> setOfItems) {
		items.addAll(setOfItems);
	}
	
	@Override
	public void removeAllItems() {
		leader = null;
		items.clear();
	}
	

	@Override
	public boolean inPartition(T item) {
		// TODO Auto-generated method stub
		return items.contains(item);
	}

	@Override
	public T getLeader() {
		// TODO Auto-generated method stub
		return leader;
	}
	
	public void setLeader(T t) {
		leader = t;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return items.size();
	}
	
	@Override
	public Set<T> getItems() {
		// TODO Auto-generated method stub
		return items;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((leader == null) ? 0 : leader.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		else {
			return this.equals((Partition<T>) obj);
		}
	}
	
	@Override
	public boolean equals(Partition<T> obj) {
		if (this.getLeader().equals(obj.getLeader())) {
			return true;
		}
		return false;
	}

	


}
