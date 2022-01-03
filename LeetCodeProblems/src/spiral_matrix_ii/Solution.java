package spiral_matrix_ii;
/* 
Given a positive integer n,generate an n x n matrix filled with elements from 1 to n2 in spiral order.

Example 1:

Input:n=3 Output:[[1,2,3],[8,9,4],[7,6,5]]Example 2:

Input:n=1 Output:[[1]]

Constraints:

1<=n<=20
 */



/* 
Solution Overview There are various problems in spiral matrix series with some variations like Spiral Matrix and Spiral Matrix III.

In order to solve such questions,the core idea is to decode the underlying pattern.This can be done by simulating the pattern and finding a generic representation that would work for any given nn.Let'sdiscuss a few approaches.

Approach 1:Traverse Layer by Layer in Spiral Form Intuition

If we try to build a pattern for a given nn,we observe that the pattern repeats after completing one circular traversal around the matrix.Let'scall this one circular traversal as layer.We start traversing from the outer layer and move towards inner layers on every iteration.

img

Algorithm

Let'sdevise an algorithm for the spiral traversal:

We can observe that,for any given nn,the total number of layers is given by:\lfloor\frac{n+1}{2}\rfloor⌊2 n+1 ​⌋This works for both even and odd nn.Example

For n=3 n=3,layers=2l ayers=2

For n=6 n=6,total layers=3l ayers=3

Also,for each layer,we traverse in at most 4 directions:img

In every direction,either row or column remains constant and other parameter changes(increments/decrements).

Direction 1:From top left corner to top right corner.

The row remains constant as\text{layer}layer and column increments from\text{layer}layer to n-\text{layer}-1 n−layer−1

Direction 2:From top right corner to the bottom right corner.

The column remains constant as n-layer-1 n−layer−1 and row increments from\text{layer}+1l ayer+1 to n-\text{layer}n−layer.

Direction 3:From bottom right corner to bottom left corner.

The row remains constant as n-\text{layer}-1 n−layer−1 and column decrements from n-\text{layer}-2 n−layer−2 to\text{layer}layer.

Direction 4:From bottom right corner to top left corner.

The column remains constant as\text{layer}layer and column decrements from n-\text{layer}-2 n−layer−2 to\text{layer}+1l ayer+1.

This process repeats(n+1)/2(n+1)/2 times until all layers are traversed.

img

Complexity Analysis

Time Complexity:\mathcal{O}(n^2)O(n 2).Here,nn is given input and we are iterating over n\cdot nn⋅n matrix in spiral form.Space Complexity:\mathcal{O}(1)O(1)We use constant extra space for storing cntcnt.
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int cnt = 1;
        for (int layer = 0; layer < (n + 1) / 2; layer++) {
            // direction 1 - traverse from left to right
            for (int ptr = layer; ptr < n - layer; ptr++) {
                result[layer][ptr] = cnt++;
            }
            // direction 2 - traverse from top to bottom
            for (int ptr = layer + 1; ptr < n - layer; ptr++) {
                result[ptr][n - layer - 1] = cnt++;
            }
            // direction 3 - traverse from right to left
            for (int ptr = layer + 1; ptr < n - layer; ptr++) {
                result[n - layer - 1][n - ptr - 1] = cnt++;
            }
            // direction 4 - traverse from bottom to top
            for (int ptr = layer + 1; ptr < n - layer - 1; ptr++) {
                result[n - ptr - 1][layer] = cnt++;
            }
        }
        return result;
    }
}
