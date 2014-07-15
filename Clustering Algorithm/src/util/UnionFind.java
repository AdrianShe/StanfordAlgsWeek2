/**
 * 
 */
package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Adrian She
 * @since: 7/15/2014
 *
 * Naive implementation of a union find data structure
 */
public class UnionFind<T> implements UnionFindInterface<T>, Iterable<Partition<T>>{

	Map<T, Partition<T>> items; 
	List<Partition<T>> partitions;
	int size; // Represents number of partitions, NOT the total number of items
	
	// Construct a union find in which each item is in a separate partition
	public UnionFind(List<T> toAdd) {
		items = new HashMap<T, Partition<T>>();
		partitions = new ArrayList<Partition<T>>();
		for (int i = 0; i < toAdd.size(); i++) {
			T item = toAdd.get(i);
			items.put(item, new Partition<T>(item));
			partitions.add(new Partition<T>(item));
		}
		size = toAdd.size();
	}
	
	@Override
	public Partition<T> findItem(T item) {
		return items.get(item);
	}
	
	@Override
	public Partition<T> findPartition(Partition<T> partition) {
		// TODO Auto-generated method stub
		if (items.containsValue(partition)) {
			for (Partition<T> part: partitions) {
				if (part.equals(partition)) {
					return part;
				}
			}
		}
		return null;
	}

	@Override
	public void join(T leader1, T leader2) {
		// TODO Auto-generated method stub
		Partition<T> p1 = findPartition(new Partition<T>(leader1));
		Partition<T> p2 = findPartition(new Partition<T>(leader2));

		if (p1 == null || p2 == null || p1.equals(p2)) {
			return;
		}
		else {
			int p1size = p1.getSize();
			int p2size = p2.getSize();
			if (p1size >= p2size) {
				Set<T> setOfItems = p2.getItems();
				this.findPartition(p1).addAllItems(setOfItems);
				for (T item: setOfItems) {
					items.put(item, p1);
				}
			partitions.remove(p2);
			p2.removeAllItems();
			size--;
		}
		
		else {
			join(leader2, leader1);
		}
			
		}
	}
	
	

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public int getSize(Partition<T> p) {
		// TODO Auto-generated method stub
		if (items.containsValue(p)) {
			for (Partition<T> part: partitions) {
				if (part.equals(p)) {
					return part.getSize();
				}
			}
		}
		return 0;
	}

	@Override
	public Iterator<Partition<T>> iterator() {
		// TODO Auto-generated method stub
		return partitions.iterator();
	}
	
	public void printUnionFind() {
		System.out.println("I have " + size + " items");
		System.out.println("They include: ");
		int counter = 1;
		for (Partition<T> p: partitions) {
				System.out.println("Partition " + counter + " :");
				Set<T> setOfitems = p.getItems();
				for (T i: setOfitems) {
					System.out.println(i.toString());
				}
				counter++;
		}
			
		System.out.println("My map contains ");
			for (Map.Entry<T, Partition<T>> item: items.entrySet()) {
				System.out.println(item.getKey()  + " Partition " + item.getValue().getLeader());
			}
			
		}
	
		


	}

