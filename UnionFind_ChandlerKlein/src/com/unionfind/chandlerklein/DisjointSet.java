/*
 * Name:    Chandler Klein
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

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the sets of friends at the wedding.
 * The parent of each value can be found and sets can be combined.
 */
public class DisjointSet 
{
	// The map representing the parent of each value
	private Map<Integer, Integer> parent = new HashMap<>();
	
	// Stores the depth of the trees - prevent unbalanced trees
	private Map<Integer, Integer> rank = new HashMap<>();
	
	/**
	 * Makes number of sets equal to number of friends.
	 * Initializes the parent and rank maps for each friend.
	 * @param numFriends The number of friends at the wedding.
	 */
	public void makeSet(int numFriends)
	{
		for (int i = 1; i <= numFriends; i++)
		{
			parent.put(i, i);
			rank.put(i, 0);
		}
	}
	
	/**
	 * Finds the root of the set the friend is in.
	 * @param friend The friend whose root is being found.
	 * @return The root of the friend.
	 */
	public int find(int friend)
	{
		if (parent.get(friend) != friend)
		{
			parent.put(friend, find(parent.get(friend)));
		}
		return parent.get(friend);
	}
	
	/**
	 * Combines two sets of friends if they aren't already combined.
	 * Ensures the trees do not become unbalanced by comparing the rank of the roots.
	 * @param friendA The friend having a union with friendB.
	 * @param friendB The friend having a union with friendA.
	 * @return True if a union is performed (sets combined), false if not.
	 */
	public boolean union(int friendA, int friendB)
	{
		// Get the roots of both friends
		int parentA = find(friendA);
		int parentB = find(friendB);
		
		// If the roots are both in the same set (sitting at the same table)
		// don't do anything
		if (parentA == parentB) return false;
		
		// If the rank of one root is greater than the other, 
		// put the smaller tree under the larger one to avoid
		// balancing issues
		// If the ranks are equal, make the parent of A B
		// and update the rank of B
		if (rank.get(parentA) > rank.get(parentB))
		{
			parent.put(parentB, parentA);
			return true;
		}
		else if (rank.get(parentA) < rank.get(parentB))
		{
			parent.put(parentA, parentB);
			return true;
		}
		else
		{
			parent.put(parentA, parentB);
			rank.put(parentB, rank.get(parentB) + 1);
			return true;
		}
	}
}