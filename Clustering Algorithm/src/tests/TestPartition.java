package tests;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import util.Partition;

public class TestPartition {
	
	Partition<Integer> partition;
	static int MAXITEMS = 1000;
	
	@Before
	public void constructPartition() {
		partition = new Partition<Integer>(1);
	}
	
	@Test
	public void testAddItems() {
		for (int i = 2; i <= MAXITEMS; i++) {
			partition.addItem(i);
		}
		assertEquals(1000, partition.getSize());
		partition.addItem(1); // make sure no duplicates are being added
		assertEquals(1000, partition.getSize());
		assertTrue(partition.inPartition(1000));
		assertTrue(!partition.inPartition(1001));
	}
	
	@Test
	public void testAddAllItems() {
		Set<Integer> setofItems = new HashSet<Integer>();
		for (int i = 2; i <= MAXITEMS; i++) {
			setofItems.add(i);
		}
		partition.addAllItems(setofItems);
		assertEquals(1000, partition.getSize());
		partition.addItem(1); // make sure no duplicates are being added
		assertEquals(1000, partition.getSize());
		assertTrue(partition.inPartition(1000));
		assertTrue(!partition.inPartition(1001));
	}
	
	@Test 
	public void testRemoveAll() {
		for (int i = 2; i <= MAXITEMS; i++) {
			partition.addItem(i);
		}
		partition.removeAllItems();
		assertNull(partition.getLeader());
		assertEquals(0, partition.getSize());
	}
	
	@Test
	public void testLeader() {
		for (int i = 2; i <= MAXITEMS; i++) {
			partition.addItem(i);
		}
		assertEquals(1, (int) partition.getLeader());
	}
	
	@Test
	public void testEquality() {
		Partition<Integer> partition2 = new Partition<Integer>(1);
		for (int i = 2; i <= MAXITEMS; i++) {
			partition.addItem(i);
		}
		for (int i = MAXITEMS; i >= 2; i--) {
			partition2.addItem(i);
		}
		assertTrue(partition.getSize() == partition2.getSize());
		assertTrue(partition.equals(partition2));
	}
	

	

}
