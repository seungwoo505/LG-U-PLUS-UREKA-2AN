package Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 백준_1991_트리순회 {
	
	static Map<Character, Character[]> tree = new HashMap<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		scan.nextLine();
		
		for(int i = 0; i < n; i++) {
			String input = scan.nextLine();
			
			char parent = input.charAt(0);
			char leftChild = input.charAt(2);
			char rightChild = input.charAt(4);
			
			tree.putIfAbsent(parent, new Character[2]);
			if(leftChild != '.') {
				tree.get(parent)[0] = leftChild;
			}
			
			if(rightChild != '.') {
				tree.get(parent)[1] = rightChild;
			}
		}
		
		preOrder('A');
		
		System.out.println();
		
		inOrder('A');
		
		System.out.println();
		
		postOrder('A');
		
	}
	
	static void preOrder(char node) {
		System.out.print(node);
		
		if(tree.containsKey(node)) {
			Character[] children = tree.get(node);
			
			if(children[0] != null) {
				preOrder(children[0]);
			}
			
			if(children[1] != null) {
				preOrder(children[1]);
			}
		}
	}
	
	static void inOrder(char node) {
		
		if(tree.containsKey(node)) {
			Character[] children = tree.get(node);
			
			if(children[0] != null) {
				inOrder(children[0]);
			}
		}
		
		System.out.print(node);
		
		if(tree.containsKey(node)) {
			Character[] children = tree.get(node);
			
			if(children[1] != null) {
				inOrder(children[1]);
			}
		}
	}
	
	static void postOrder(char node) {
		
		if(tree.containsKey(node)) {
			Character[] children = tree.get(node);
			
			if(children[0] != null) {
				postOrder(children[0]);
			}
			
			if(children[1] != null) {
				postOrder(children[1]);
			}
		}
		
		System.out.print(node);
	}
}
