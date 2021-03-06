package com.javaCodeChallenge.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BinaryTreeTest {

	static Node nodeTemp = new Node(3);
	
	public static void main(String[] args) {

		List<Integer> inputData = new ArrayList<>();
		int numbersLimit = 50;
		System.out.println("Adding randon 10 numbers between 1 - 1000 : ");
		Random rand = new Random();
		
		int i = 9;
		int findValue = 0;
		int containsValue = 0;
		while(i > 0) {
			int value = rand.nextInt(numbersLimit);
			inputData.add(value);
			System.out.println(value);
			if(i == 5) {
				findValue = value;
			}
			if(i == 3) {
				containsValue = value;
			}
			i--;
			
		}

		int randonExistsValue = containsValue + rand.nextInt(numbersLimit - 20);
		
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("---------------------------------BinaryTree------------------------------------------------");
		BinaryTree tree2 = new BinaryTree();
		inputData.add(10);
		for(Integer value: inputData) {
			tree2.insert(value.intValue());
		}
		
		System.out.println("Binary Tree2 InOrder print *** ");
		tree2.printInOrder();
		
		Node nodeFromTree2 = tree2.find(findValue, 1);
		System.out.println("Find a Node with value " + findValue + " : " + nodeFromTree2.getData());
		System.out.println("Contains a Node with value " + containsValue + " : " + tree2.contains(containsValue));
		System.out.println("Contains a Node with value " + randonExistsValue + " : " + tree2.contains(randonExistsValue));
		
		System.out.println("----------------------------------");
		//System.out.println("Is Tree1 equals to Tree2  ? " + tree2.compareTree(orderedNodes));
		
		System.out.println("Is Tree2 Binary format  ? " + tree2.isBinarySearchTree());
		
		BinaryTree tree3 = new BinaryTree();
		 
		for(int k = 0; k< inputData.size(); k++) {
			tree3.insert(inputData.get(k));
			if(k == 7) {
				break;
			}
		}
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("-----------------Swap Nodes at Kth Level---------------------------------------------------");
		System.out.println("              -> Before Swap");
		tree3.print();

		tree3.swapNodesFromLevel(2);
		System.out.println("              -> After Swap-----------------");
		tree3.print();
		System.out.println("              -> Print inorder after swapping : ");
		System.out.print("              -> ");tree3.collectInOrder().forEach(k -> {System.out.print(k + ", ");});System.out.println("");
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("-----------------Print Nodes at Nth Level when N<=height-----------------------------------");
		tree3.printNodesAtLevel(2);
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("-----------------Convert BST to GST--------------------------------------------------------");
		BinaryTree tree4 = new BinaryTree();
		 
		for(int k = 0; k< inputData.size(); k++) {
			tree4.insert(inputData.get(k));
			if(k == 7) {
				break;
			}
		}
		System.out.println("              -> with new instance-------");
		BinaryTree newGstTree = tree4.bstToGst1();
		newGstTree.print();
		System.out.println("              -> with OUT new instance-------");
		tree4.bstToGst();
		tree4.print();
		
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("-----------------Balanced Binary tree from sorted Arrays-----------------------------------");		
		List<Integer> inputData2 = new ArrayList<>(inputData);
		Collections.sort(inputData2);
		BalancedBinaryTreeFromSortedArray balancedTree1 = new BalancedBinaryTreeFromSortedArray();
		balancedTree1.sortedArray(inputData2.stream()
									.mapToInt((Integer k) -> k.intValue())
									.toArray()
								);
		balancedTree1.print();
		System.out.println("              -> balancedTree1 is Balanced Tree : " + balancedTree1.isBalancedBinaryTree());
		
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("-----------------Convert Existing Binary tree to balanced binary tree O(n)-----------------");
		BinaryTree tree5 = new BinaryTree();
		 
		for(int k = 0; k< inputData.size(); k++) {
			tree5.insert(inputData.get(k));
		}
		
		System.out.println("              -> Before balancing a Tree -----");
		tree5.print();
		System.out.println("              -> After balancing a Tree -----");
		tree5.balanceBinaryTree();
		tree5.print();
		tree5.printPreOrder();
		System.out.println("tree5 is Balanced Tree : " + tree5.isBalancedBinaryTree());
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("-----------------Convert Existing Binary tree to balanced binary tree log(n)---------------");
		
		//int[] avlInput = {4,3,1,7,5,2,6};
		int[] avlInput = inputData.stream()
				.mapToInt((Integer k) -> k.intValue())
				.toArray();
		AVLTree avlTree = new AVLTree(1);
		avlTree.insertValues(avlInput);
		avlTree.print();
		
		updateNode(nodeTemp, 5);
		System.out.println("Updated Temp Node: " + nodeTemp.getLeft().getData());
		
	}
	
	public static void insertData(BinaryNode rootNode, int value) {
		rootNode.insert(value);
	}
	
	public static void updateNode(Node node, int value) {
		node.setLeft(new Node(value));
	}
}
