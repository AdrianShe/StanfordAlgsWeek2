package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import util.Partition;
import util.UnionFind;

public class TestUnionFind {
	
	UnionFind<Integer> unionfind;
	List<Integer> toAdd;
	static int MAXITEMS = 50;
	
	@Before
	public void constructUnionFind() {
		toAdd = new ArrayList<Integer>();
		for (int i = 1; i <= MAXITEMS; i++) {
			toAdd.add(i);
		}
		unionfind = new UnionFind<Integer>(toAdd);
	}
	
	@Test
	public void testSize() {
		assertEquals(MAXITEMS, unionfind.getSize());
		Partition<Integer> partition = new Partition<Integer>(MAXITEMS / 2);
		assertEquals(1, unionfind.getSize(partition));
	}
	
	@Test
	public void testFindItem() {
		assertEquals(new Partition<Integer>(1), unionfind.findItem(1));
		assertEquals(new Partition<Integer>(MAXITEMS / 2), unionfind.findItem(MAXITEMS / 2));
		assertEquals(new Partition<Integer>(MAXITEMS), unionfind.findItem(MAXITEMS));
		assertNull(unionfind.findItem(1001));
	}
	 
	@Test
	public void testJoinEqualSizes() {
		for (int i = 1; i <= MAXITEMS; i+=2) {
			unionfind.join(i, i+1);
		}
		assertEquals(MAXITEMS / 2, unionfind.getSize());
		assertEquals(2, unionfind.getSize(new Partition<Integer>(MAXITEMS / 2)));
		assertEquals(0, unionfind.getSize(new Partition<Integer>(MAXITEMS / 2 - 1)));
		assertEquals(new Partition<Integer>(3), unionfind.findItem(4));

		
		for (int i = 1; i <= MAXITEMS; i+=4) {
			unionfind.join(i, i+2);
		}
		assertEquals(new Partition<Integer>(1), unionfind.findItem(4));

		assertEquals(MAXITEMS / 4 + 1, unionfind.getSize());
		assertEquals(4, unionfind.getSize(new Partition<Integer>(1)));
	}
	
	@Test
	public void testJoinP1Greater() {
		
		// Initialize a partition of size MAXITEMS/2
		for (int i = 1; i <= MAXITEMS/2; i++) {
			unionfind.join(1,i);
		}
		assertEquals(MAXITEMS / 2 + 1, unionfind.getSize());
		assertEquals(MAXITEMS / 2, unionfind.getSize(new Partition<Integer>(1)));
		
		// Initialize a partition of size MAXITEMS/2 - 1
		for (int i = MAXITEMS / 2 + 1; i <= MAXITEMS - 1; i++) {
			unionfind.join(MAXITEMS / 2 + 1,i);
		}
		
		assertEquals(3, unionfind.getSize());
		assertEquals(MAXITEMS / 2 - 1, unionfind.getSize(new Partition<Integer>(MAXITEMS / 2 + 1)));
		assertEquals(0, unionfind.getSize(new Partition<Integer>(MAXITEMS / 2 + 2)));
		assertEquals(new Partition<Integer>(MAXITEMS / 2 + 1), unionfind.findItem(MAXITEMS / 2 + 2));
		
		// Join the two partitions
		
		unionfind.join(1, MAXITEMS / 2 + 1);
		
		assertEquals(2, unionfind.getSize());
		assertEquals(MAXITEMS - 1, unionfind.getSize(new Partition<Integer>(1)));
		assertEquals(0, unionfind.getSize(new Partition<Integer>(MAXITEMS / 2 + 2)));
		assertEquals(new Partition<Integer>(1), unionfind.findItem(MAXITEMS / 2 + 2));
		
	}
	
	@Test
	public void testJoinP1Smaller() {
		// Initialize a partition of size MAXITEMS/2 - 1
		for (int i = 1; i <= MAXITEMS/2 - 1; i++) {
			unionfind.join(1,i);
		}
		assertEquals(MAXITEMS / 2 + 2, unionfind.getSize());
		assertEquals(MAXITEMS / 2 - 1, unionfind.getSize(new Partition<Integer>(1)));
		
		// Initialize a partition of size MAXITEMS/2
		for (int i = MAXITEMS / 2; i < MAXITEMS; i++) {
			unionfind.join(MAXITEMS / 2,i);
		}
		
		assertEquals(3, unionfind.getSize());
		assertEquals(MAXITEMS / 2, unionfind.getSize(new Partition<Integer>(MAXITEMS / 2)));
		assertEquals(0, unionfind.getSize(new Partition<Integer>(MAXITEMS / 2 + 2)));
		assertEquals(new Partition<Integer>(MAXITEMS / 2), unionfind.findItem(MAXITEMS / 2 + 2));
		
		// Join the two partitions
		
		unionfind.join(1, MAXITEMS / 2);
		
		assertEquals(2, unionfind.getSize());
		assertEquals(MAXITEMS - 1, unionfind.getSize(new Partition<Integer>(MAXITEMS / 2)));
		assertEquals(0, unionfind.getSize(new Partition<Integer>(MAXITEMS / 2 + 2)));
		assertEquals(new Partition<Integer>(MAXITEMS / 2), unionfind.findItem(MAXITEMS / 2 + 2));
		
	}
		

}
