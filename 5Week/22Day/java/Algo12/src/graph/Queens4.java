package graph;

import java.util.LinkedList;
import java.util.List;

public class Queens4 {
	
	static int N = 8;
	
	static List<Position> promise = new LinkedList<>();
	
	static int promiseSetCnt;

	public static void main(String[] args) {
		dfs(0);
		System.out.println(promiseSetCnt);

	}
	
	static void dfs(int curRow) {
		if(curRow == N) {
			promiseSetCnt++;
			return;
		}
		for(int col = 0; col < N; col++) {
			if(isSafe(curRow, col)) { //유망하면
				promise.add(new Position(curRow, col));
				dfs(curRow + 1);
				promise.remove(promise.size() - 1);
			}
		}
	}
	
	static boolean isSafe(int curRow, int col) {
		for(Position queen : promise) {
			if(queen.col == col) {
				return false;
			}
			
			if(Math.abs(queen.row - curRow) == Math.abs(queen.col - col)) {
				return false;
			}
				
		}
		return true;
	}
	
	static class Position{
		int row, col;

		public Position(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "Position [row=" + row + ", col=" + col + "]";
		}
	}

}
