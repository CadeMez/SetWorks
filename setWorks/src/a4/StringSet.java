package a4;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Naive list-based implementation of a set of strings.
 *
 */
public class StringSet {

	// USE THIS FIELD TO STORE THE ELEMENTS OF THE SET.
	// DO NOT CHANGE THE NAME OF THE FIELD.
	// DO NOT MAKE THE FIELD PRIVATE.
	List<String> list;

	
	// SOME ALREADY IMPLEMENTED METHODS 

	/**
	 * Returns the number of elements in this set.
	 * 
	 * @return the number of elements in this set
	 */
	public int size() {
		return this.list.size();
	}

	/**
	 * Returns {@code true} if this set contains an element equal to {@code s},
	 * returns {@code false} otherwise.
	 * 
	 * @param s a string to search for in this set
	 * @return {@code true} if the set contains an element equal to {@code s},
	 *         {@code false} otherwise
	 */
	public boolean contains(String s) {
		return this.list.contains(s);
	}

	/**
	 * Removes from this set the element equal to {@code s} if such an element
	 * exists. If the set does not contain {@code s} then no changes are made to the
	 * set. 
	 * 
	 * @param s a string to remove from this set
	 * @return {@code true} if a string was removed from this set, {@code false}
	 *         otherwise
	 */
	public boolean remove(String s) {
		return this.list.remove(s);
	}

	/**
	 * Returns a string representation of this set. The string representation
	 * is similar to the string returned by {@code java.util.List.toString}.
	 * 
	 * @return a string representation of this set
	 */
	@Override
	public String toString() {
		return this.list.toString();
	}

	
	// ADD THE REQUIRED CONSTRUCTORS AND METHODS AFTER THIS POINT
	
	// String Set Constructor
	public StringSet(String... string){
		ArrayList<String> temp = new ArrayList<>();
		for (String val : string){
			if (!list.contains(val)){
				temp.add(val);
			}
		} 
		this.list = temp;
	}
	

	// String Set Constructor
	public StringSet(StringSet other){
		this.list = new ArrayList<>(other.list);
	}


	// Add Method
	public boolean add(String s){
		if (!this.list.contains(s)){
			this.list.add(s);
			return true;
		} 
		return false;
	}


	// Union Method
	public StringSet union(StringSet other){
		StringSet temp = new StringSet(this);
		for (String val : other.list){
			if (!temp.contains(val)){
				temp.add(val);
			}
		}
		return temp;
	}



	// Intersection Method
	public StringSet intersection(StringSet other){
		StringSet temp = new StringSet();
		for (String val : this.list) {
			if (other.list.contains(val)){
				temp.add(val);
			}
		} 
		return temp;
	}


	// Difference Method
	public StringSet difference(StringSet other){
		StringSet temp = new StringSet();
		for (String val : this.list){
			if (!other.list.contains(val)){
				temp.list.add(val);
			}
		}
		return temp;
	}

	
	// Prefix Set Method
	public StringSet prefixSet(String prefix){
		StringSet temp = new StringSet();
		for (String val : this.list){
			if (val.startsWith(prefix)) {
				temp.add(val);
			}
		} 
		return temp;
	}

	// Equals Method
	@Override
	public boolean equals(Object obj){
		if (this == obj) return true;
		if (obj == null || !(obj instanceof StringSet)) return false;
		StringSet temp = (StringSet) obj;
		return this.list.containsAll(temp.list) && temp.list.containsAll(this.list);
	}

	// HashCode Method
	@Override
	public int hashCode() {
		int hash = 0;
		
		for(int i = 0; i < this.list.size(); i++) {
			hash += this.list.get(i).hashCode();
		}
		return hash;
	}

}

