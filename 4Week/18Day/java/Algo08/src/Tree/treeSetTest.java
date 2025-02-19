package Tree;

import java.util.TreeSet;

public class treeSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Integer> tree = new TreeSet<>();
		
		tree.add(5);
		tree.add(3);
		tree.add(8);
		tree.add(1);
		tree.add(7);
		tree.add(25);
		tree.add(34);
		tree.add(2);
		tree.add(11);
		tree.add(17);
		
		/**
		 * 
		 */
		System.out.println(tree);
		
		if(tree.contains(5)) {
			System.out.println("5는 존재");
		}else {
			System.out.println("5는 존재하지 않음");
		}
		
		System.out.println("최소값 : " + tree.first());
		System.out.println("최대값 : " + tree.last());
		
		tree.remove(3);
		System.out.println(tree);
		
		TreeSet<Integer> tree2 = (TreeSet<Integer>) tree.subSet(5, true, 8, true);
		System.out.println(tree2);
	}

}
