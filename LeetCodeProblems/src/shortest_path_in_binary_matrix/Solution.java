package shortest_path_in_binary_matrix;
public class Solution {

	public int shortestPathBinaryMatrix(int[][] grid) {
		int length = grid[0].length;
		System.out.println("length : " + length);
		int shortestPath = findShortestPath(grid, -1, -1, 0, 0, length);
		System.out.println("shortestPath : " + shortestPath);
		return shortestPath;
	}

	private int findShortestPath(int[][] grid, int px, int py, int x, int y, int length) {
		if (x == length - 1 && y == length - 1) {
			System.out.println("Reached end point");
			return 1;
		}
		System.out.println("(New x, New y) : (" + x + " , " + y + ")");
		int shortestPath = 10000;
		int[] gradients = { -1, 0, 1 };
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (isLocationCorrect(grid, px, py, x, y, length, x + gradients[i], y + gradients[j])) {
					grid[x][y] = 2;
					int routeLength = findShortestPath(grid, x, y, x + gradients[i], y + gradients[j], length);
					shortestPath = shortestPath < routeLength ? shortestPath : routeLength;
//                    System.out.println("New shortest path : " + shortestPath);
//                    System.out.println("route length : " + routeLength);
				}
			}
		}
		return shortestPath + 1;
	}

	private boolean isLocationCorrect(int[][] grid, int px, int py, int x, int y, int length, int nx, int ny) {
//		System.out.print("(Parent x, Parent y) : (" + px + " , " + py + "), ");
//		System.out.print("(x, y) : (" + x + " , " + y + "), ");
//		System.out.println("(New x, New y) : (" + nx + " , " + ny + ")");
		if (nx == px && ny == py) {
//			System.out.println("Cond 1");
			return false;
		} else if (nx == x && ny == y) {
//			System.out.println("Cond 2");
			return false;
		} else if (nx < 0 || nx >= length) {
//			System.out.println("Cond 3");
			return false;
		} else if (ny < 0 || ny >= length) {
//			System.out.println("Cond 4");
			return false;
		} else if (grid[x][y] == 2 || grid[nx][ny] == 1 || grid[nx][ny] == 2) {
//        	System.out.println("Cond 5");
			return false;
		} else {
//        	System.out.println("Cond true. grid[nx][ny] : " + grid[nx][ny]);
			return true;
		}
	}
}
