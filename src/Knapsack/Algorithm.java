package Knapsack;
import java.util.*;


public class Algorithm
{
    public Holder KnapSack(int capacity_is, int[] weights, int[] values, int amountOfItems)
    {
        int[][] K = new int[amountOfItems + 1][capacity_is + 1];

        for (int i = 0; i <= amountOfItems; ++i)
        {
            for (int w = 0; w <= capacity_is; ++w)
            {
                if (i == 0 || w == 0)
                {
                    K[i][w] = 0;
                }
                else if (weights[i - 1] <= w)
                {
                    K[i][w] = Math.max(values[i - 1] + K[i - 1][w - weights[i - 1]],   K[i - 1][w]);
                }
                else
                {
                    K[i][w] = K[i - 1][w];
                }
            }
        }

        int result = K[amountOfItems][capacity_is];
        int resultValueForCalculation = result;

        // Create a List of used items
        List<Integer> usedItems = new ArrayList<Integer>();

        int W = capacity_is;
        for (int i = amountOfItems; i > 0 && resultValueForCalculation > 0; i--)
        {

            // either the result comes from the top
            // (K[i-1][w]) or from (values[i-1] + K[i-1]
            // [w-weights[i-1]]) as in Knapsack table. If
            // it comes from the latter one/ it means
            // the item is included.
            if (resultValueForCalculation == K[i - 1][W])
            continue;
                else
            {
                usedItems.add(i-1);
                // This item is included.
                // Since this weight is included its
                // value is deducted
                resultValueForCalculation = resultValueForCalculation - values[i - 1];
                W = W - weights[i - 1];
            }
        }

        int[] usedValues = new int[usedItems.size()];
        int[] usedWeights = new int[usedItems.size()];
        int usedItemsIterator = 0;

        for (int i :  usedItems)
        {
            usedValues[usedItemsIterator] = values[i];
            usedWeights[usedItemsIterator] = weights[i];
            usedItemsIterator++;
        }

        Holder resultHolder = new Holder(usedValues, usedWeights);

        return resultHolder;
    }
}