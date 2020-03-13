/*
 * Name:    Chandler Klein
 *
 * INPUT:
 * This program reads inputs from a file. The file starts with a line of two
 * integers N and M (1<=N, M<=1000). N indicates the number of friends;
 * the friends are marked from 1 to N. Then M lines follow.
 * Each line consists of two integers A and B (A != B),
 * that means friend A and friend B know each other.
 *
 * OUTPUT:
 * How many tables they need at least.
 * 
 * REFERENCE:
 * https://en.wikipedia.org/wiki/Disjoint-set_data_structure#Pseudocode
 * https://www.techiedelight.com/disjoint-set-data-structure-union-find-algorithm/
 * 
 * CONFIGURATION:
 * Eclipse version 4.14.0
 * Java SE Development Kit 13
 */

package com.unionfind.chandlerklein;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		System.out.print("Enter the name of the input file: ");
		
		try
		{
			// Get the file name from the user and create a reader for it
			Scanner scanner = new Scanner(System.in);
			String fileName = scanner.nextLine();
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			
			// Get the number of friends at the wedding and the 
			// number of lines in the file
			String fields[] = br.readLine().split(" ");
			int numFriends = Integer.parseInt(fields[0]);
			int numLines = Integer.parseInt(fields[1]);
			
			// Initialize sets for the number of friends
			// specified in the input file
			DisjointSet ds = new DisjointSet();
			ds.makeSet(numFriends);
			
			// Keep track of successful unions to
			// later calculate number of sets (tables)
			int successfulUnions = 0;
			
			// For each line, perform a union operation on the
			// two friends. If the union is successful and
			// sets have been combined, increment the counter
			for (int i = 0; i < numLines; i++)
			{
				fields = br.readLine().split(" ");
				int friendA = Integer.parseInt(fields[0]);
				int friendB = Integer.parseInt(fields[1]);
				if ((ds.union(friendA, friendB)) == true) successfulUnions++ ;
			}
			
			// The final result - if a union is successful, we decrease
			// the number of original sets (number of tables we would need at first)
			int numTables = numFriends - successfulUnions;
			
			System.out.printf("\n>> Tables needed: %d\n", numTables);
			
			scanner.close();
			br.close();
		}
		catch (IOException e)
		{
			System.out.println("\n>> File not found! Please try again.\n");
			main(args);
		}
		catch (NullPointerException | ArrayIndexOutOfBoundsException e)
		{
			System.out.println("\n>> Incorrect file parameters or format! Please try again.\n" +
							   "Example file: \n5 3\r\n1 2\r\n2 3\r\n4 5");
			main(args);
		}
	}
}