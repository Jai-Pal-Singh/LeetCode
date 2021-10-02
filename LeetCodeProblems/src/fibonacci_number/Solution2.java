package fibonacci_number;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    List<Integer> fib;

    public int fib(int n) {
        fib = new ArrayList<>(n + 1);

        for (int i = 0; i <= n; i++) {
            fib.add(i, 0);
        }

        System.out.println("n : " + n + " ; fib size : " + fib.size());
        return getFibonacciNumber(n);
    }

    public int getFibonacciNumber(int n) {
        if (n < 2)
            return n;
        if (fib.get(n) != 0)
            return fib.get(n);
        int res = getFibonacciNumber(n - 1) + getFibonacciNumber(n - 2);
        System.out.println("n : " + n);
        fib.add(n, res);
        return res;
    }
}
