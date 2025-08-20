package a4;

public class Kingston {

	public static void main(String... args) {
		StringSet set = A4.fromList(A4.readFile("kingston.txt"));
		// Postal Codes in Kingston
		System.out.println("There are " + set.size() + " postal codes in Kingston");

		// Postal Codes Near Queen's University
		StringSet nQueensSet = A4.fromList(A4.readFile("nearQ.txt"));
		System.out.println("There are " + nQueensSet.size() + " postal codes near Queen's University");

		// K7L Postal Codes
		StringSet k7lSet = set.prefixSet("K7L");
		System.out.println("There are " + k7lSet.size() + " postal codes starting with K7L");

		// Equal Sets
		if (nQueensSet.equals(k7lSet)){
			System.out.println("The two previous sets are equal");
		} else {
			System.out.println("The two previous sets are not equal");
		}
		
		// Eastern Half of Kingston
		StringSet eastKingstonSet = set.prefixSet("K7K").union(set.prefixSet("K7L"));
		System.out.println("There are " + eastKingstonSet.size() + " postal codes in the eastern half of Kingston");

		// Western Half of Kingston
		StringSet westKingstonSet = set.difference(eastKingstonSet);
		System.out.println("There are " + westKingstonSet.size() + " postal codes in the western half of Kingston");

		// Concession Street
		StringSet southernKingstonSet = A4.fromList(A4.readFile("southern_kingston.txt"));
		StringSet k7kSouthernSet = set.prefixSet("K7K").intersection(southernKingstonSet);
		System.out.println("There are " + k7kSouthernSet.size() + " postal codes with K7K below the Concession Street");
	}
}
