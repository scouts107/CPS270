package edu.cmich.cps270;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a set of elements numbered from 0 to 63.  Standard set operations
 * are supported such as adding and removing elements, union, intersection and
 * complement.  
 * 
 * @author [burge1qd, kart1is, tadyc1ja] 
 *
 */
public class Set {	
	
	public static final int MAX_SET_ELEMENT_VALUE = 63;
	private long set;
	
	/**
	 * Initializes an empty set
	 */
	public Set() {
		set = 0;
	}
	
	/**
	 * Initializes an empty set and fills with specified elements
	 * @param elements A list of elements to be added to the set
	 * @throws SetElementValueOutOfRange
	 */
	public Set(List<Integer> elements) throws SetElementValueOutOfRange{
		set = 0;
		for(int i = 0; i < elements.size(); i++) {
			set.addElement(elements.get(i));
		}
	}
	
	/**
	 * Checks if a specific element is in the set
	 * @param x element to be checked
	 * @return if the element is in the set
	 */
	public boolean isInSet(int x) {
		long mask = 1;
		mask << x;
		if (set & mask != 0)
			return true;
		else
			return false
	}
	/**
	 * Emptys a set by returning all bits to 0
	 */
	public void empty() {
		set = 0;
		
	}
	
	/**
	 * Adds an element to the set.  
	 * @param x The identifier of the element to add.  Must be in the range of 0 to 63.
	 * @throws SetElementValueOutOfRange
	 */
	public void addElement(int x) throws SetElementValueOutOfRange {
		long mask = 1;
		if (x > MAX_SET_ELEMENT_VALUE)
			throw SetElementValueOutOfRange;
		else {
			mask << x;
			set = (set | mask);
		}
	}
	
	/**
	 * Removes an element from the set.  
	 * @param x The identifier of the element to remove.  Must be in the range of 0 to 63.
	 * @throws SetElementValueOutOfRange
	 */
	public void removeElement(int x) throws SetElementValueOutOfRange {
		long mask = 1;
		if (x > MAX_SET_ELEMENT_VALUE)
			throw SetElementValueOutOfRange;
		else {
			mask << x;
			set = (set & ~mask);
		}
	}
	
	public Set intersection(Set s) {
		set = (s & set); //finding what is in set s and the set
		
		return null;
	}
	/**
	 * Returns the union of a set  
	 * @param s The set to combine with
	 * @return A union of the two sets
	 */
	public Set union(Set s) {
		s = (s | set);
		return s;
	}
	
	public List<Integer> toList() {

		return null;
	}
	
	/**
	 * Checks if a set is empty.
	 * @return if the set is empty
	 */
	public boolean isEmpty() {
		if(set = 0)
			return true;
		else
			return false;
	}
	
	/**
	 * Checks how many elements are in a set
	 * @return the number of elements in the set
	 */
	public int size() {
		int size = 0;
		String s = Long.toBinaryString(set);
		
		for (int i = 63; i != 1; i--) {
			if (s.charAt(i) == '1')
				size++;
		}
		
		return size;
		
		
	}
	
	/**
	 * Sets set to the complimentary set
	 */
	public void complement() {
		set  = 	~set;
	}
 }
