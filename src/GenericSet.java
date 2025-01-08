
/*
* AUTHOR: Abdulrahman Al Rajhi
* FILE: GenericSet.java
* ASSIGNMENT: Programming Assignment 1 - GenericSet
* COURSE: CSC 335; Fall 2023
* PURPOSE: This is a Generic Set class, which represents a generic 
* set data structure. It implements some of the Java's set methods.
* 
* USAGE: 
* ArrayList Object 
*/
import java.util.ArrayList;

public class GenericSet<T> {
	private ArrayList<T> set = new ArrayList<>();

	/**
	 * Add an element to the set.
	 * 
	 */
	public boolean add(T element) {
		return !set.contains(element) ? set.add(element) : false;
	}

	/**
	 * Returns the number of elements in the queue.
	 */
	public int size() {
		return set.size();
	}

	/**
	 * Returns true if the element exists in the set
	 */
	public boolean contains(T element) {
		return set.contains(element);
	}

	/**
	 * Returns a generic set of the union of two sets
	 */
	public GenericSet<T> unionOfSets(GenericSet<T> someSet) {
		GenericSet<T> unionSet = new GenericSet<>();
		unionSet.set.addAll(this.set);
		unionSet.set.addAll(someSet.set);
		return unionSet;
	}

	/**
	 * Returns a generic set of the intersection of two sets
	 */
	public GenericSet<T> intersectionOfSets(GenericSet<T> someSet) {
		GenericSet<T> intersectionSet = new GenericSet<>();
		intersectionSet.set.addAll(this.set);
		intersectionSet.set.retainAll(someSet.set);
		return intersectionSet;
	}

	/**
	 * Returns a string representation of the object
	 */
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("[");
		for (int i = 0; i < set.size(); i++) {
			if (i > 0) {
				string.append(", ");
			}
			string.append(set.get(i));
		}
		string.append("]");
		return string.toString();
	}
}
