package Knapsack;

public class ItemGenerator
{
    private int[] weights;
    private int[] values;
    private int amountOfItems;

    public ItemGenerator(int amount, int userInputSeed)
    {
        var rand = new RandomNumberGenerator(userInputSeed);
        amountOfItems = amount;
        values = new int[amount];
        weights = new int[amount];

        for (int i = 0; i < amount; i++)
        {
            weights[i] = rand.nextInt(1, 29);
        }
        for (int i = 0; i < amount; i++)
        {
            values[i] = rand.nextInt(1, 29);
        }
    }

    public void showItems()
    {
        for (int i = 0; i < amountOfItems; i++)
        {
            System.out.println("Item" + (i + 1) + " weight: " + weights[i] + " value: " + values[i]);
        }
    }

    public int[] getWeights()
    {
        return weights;
    }

    public int[] getValues()
    {
        return values;
    }
}
