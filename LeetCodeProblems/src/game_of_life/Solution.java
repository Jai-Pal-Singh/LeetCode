package game_of_life;

/**
 * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.

 

Example 1:


Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
Example 2:


Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 25
board[i][j] is 0 or 1.
 

Follow up:

Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches upon the border of the array (i.e., live cells reach the border). How would you address these problems?
 */

 /**
  * Solution

  To solve it in place, we use 2 bits to store 2 states:

[2nd bit, 1st bit] = [next state, current state]

- 00  dead (next) <- dead (current)
- 01  dead (next) <- live (current)  
- 10  live (next) <- dead (current)  
- 11  live (next) <- live (current) 
In the beginning, every cell is either 00 or 01.
Notice that 1st state is independent of 2nd state.
Imagine all cells are instantly changing from the 1st to the 2nd state, at the same time.
Let's count # of neighbors from 1st state and set 2nd state bit.
Since every 2nd state is by default dead, no need to consider transition 01 -> 00.
In the end, delete every cell's 1st state by doing >> 1.
For each cell's 1st bit, check the 8 pixels around itself, and set the cell's 2nd bit.

Transition 01 -> 11: when board == 1 and lives >= 2 && lives <= 3.
Transition 00 -> 10: when board == 0 and lives == 3.
To get the current state, simply do

board[i][j] & 1
To get the next state, simply do

board[i][j] >> 1
  */
public class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                int liveCount = getLiveCount(board, m, n, i, j);
                if(board[i][j] == 1 && liveCount >= 2 && liveCount <=3){
                    board[i][j] = 3;
                }
                else if(board[i][j] == 0 && liveCount == 3){
                    board[i][j]  = 2;
                }
            }
        }
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                board[i][j] >>= 1;
            }
        }
    }
    
    private int getLiveCount(int[][] board, int m, int n, int i, int j){
        int[] x = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] y = new int[]{-1, 0, 1, -1, 1, -1, 0, 1}; 
        int liveCount = 0;
        for(int k = 0; k<8; k++){
            if((i+x[k]) >=0 && (i+x[k]) < m && (j+y[k]) >=0 && (j+y[k]) < n ){
                liveCount += board[i+x[k]][j+y[k]] & 1; 
            }
        }
        return liveCount;
    }
}
