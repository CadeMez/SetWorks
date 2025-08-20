package a4;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

/**
 * Utility methods for completing Assignment 4.
 */
public class A4 {

	/**
	 * Reads a file located in the project directory named {@code files} assuming an
	 * eclipse programming environment.
	 * 
	 * <p>
	 * Students not using eclipse should see the assignment for details on how to
	 * modify this method so that it works on their computer.
	 * 
	 * @param file the name of the file to read
	 * @return a list containing each line of the file
	 */
	public static List<String> readFile(String file) {
		Path path = FileSystems.getDefault().getPath("files", file);
		
		/*
		 * For students not using eclipse, replace the previous line with the following
		 * two lines (see assignment for details):
		 
		String strPath = "C:/Users/burton/Documents/2025W/CISC124/workspace/A4/files/";
		Path path = Paths.get(strPath + file);

	  	 */
		
		
		List<String> lines = new ArrayList<>();
		try {
			lines = Files.readAllLines(path);
		} catch (IOException ex) {
			System.err.println("Failed to read files/" + file);
			System.exit(1);
		}
		return lines;
	}

	/**
	 * Returns a reference to a new {@code StringSet} object created by adding each
	 * string from a list to the set.
	 * 
	 * @param t a list of strings
	 * @return a reference to a new {@code StringSet} object created by adding each
	 *         string from a list to the set
	 */
	public static StringSet fromList(List<String> t) {
		StringSet set = new StringSet();
		for (String s : t) {
			set.add(s);
		}
		return set;
	}

	public static void main(String[] args) {
		List<String> list = readFile("ontario.txt");
		System.out.println("Success!");
		
		long start = System.nanoTime();
		//StringSet set = fromList(list);
		TreeSet<String> set = new TreeSet<>(list);
		long stop = System.nanoTime();
		System.out.println((0.0 + start - stop) / 1e9);
	}
}
