package find_median_from_data_stream;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        BasicFunctions.print(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        BasicFunctions.print(medianFinder.findMedian()); // return 2.0
    }
}
