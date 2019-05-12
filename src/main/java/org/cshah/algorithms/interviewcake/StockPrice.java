package org.cshah.algorithms.interviewcake;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class StockPrice {

    public static int getMaxProfit(int[] stockPrices) {

        if (stockPrices.length < 2) {
            throw new IllegalArgumentException("Getting a profit requires at least 2 prices");
        }

        // we'll greedily update minPrice and maxProfit, so we initialize
        // them to the first price and the first possible profit
        int minPrice = stockPrices[0];
        int maxProfit = stockPrices[1] - stockPrices[0];

        // start at the second (index 1) time
        // we can't sell at the first time, since we must buy first,
        // and we can't buy and sell at the same time!
        // if we started at index 0, we'd try to buy *and* sell at time 0.
        // this would give a profit of 0, which is a problem if our
        // maxProfit is supposed to be *negative*--we'd return 0.
        for (int i = 1; i < stockPrices.length; i++) {
            int currentPrice = stockPrices[i];

            // see what our profit would be if we bought at the
            // min price and sold at the current price
            int potentialProfit = currentPrice - minPrice;

            // update maxProfit if we can do better
            maxProfit = Math.max(maxProfit, potentialProfit);

            // update minPrice so it's always
            // the lowest price we've seen so far
            minPrice = Math.min(minPrice, currentPrice);
        }
        return maxProfit;
    }
    // tests
    /*

    https://www.interviewcake.com/question/java/stock-price

    Complexity
O(n)O(n) time and O(1)O(1) space. ↴ We only loop through the array once.

What We Learned
This one's a good example of the greedy ↴ approach in action. Greedy approaches are great because they're fast (usually just
 one pass through the input). But they don't work for every problem.

How do you know if a problem will lend itself to a greedy approach? Best bet is to try it out and see if it works. Trying
out a greedy approach should be one of the first ways you try to break down a new question.

To try it on a new problem, start by asking yourself:

"Suppose we could come up with the answer in one pass through the input, by simply updating the 'best answer so far'
as we went. What additional values would we need to keep updated as we looked at each item in our input, in order to be able
to update the 'best answer so far' in constant time?"
     */

    @Test
    public void priceGoesUpThenDownTest() {
        final int actual = getMaxProfit(new int[] {1, 5, 3, 2});
        final int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void priceGoesDownThenUpTest() {
        final int actual = getMaxProfit(new int[] {7, 2, 8, 9});
        final int expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    public void priceGoesUpAllDayTest() {
        final int actual = getMaxProfit(new int[] {1, 6, 7, 9});
        final int expected = 8;
        assertEquals(expected, actual);
    }

    @Test
    public void priceGoesDownAllDayTest() {
        final int actual = getMaxProfit(new int[] {9, 7, 4, 1});
        final int expected = -2;
        assertEquals(expected, actual);
    }

    @Test
    public void priceStaysTheSameAllDayTest() {
        final int actual = getMaxProfit(new int[] {1, 1, 1, 1});
        final int expected = 0;
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void exceptionWithOnePriceTest() {
        getMaxProfit(new int[] {5});
    }

    @Test(expected = Exception.class)
    public void exceptionWithEmptyPricesTest() {
        getMaxProfit(new int[] {});
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(StockPrice.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}