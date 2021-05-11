package Knapsack;

import javax.swing.*;

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

    public String showItems_String()
    {
        String itemList = "";
        for (int i = 0; i < amountOfItems; i++)
        {
            itemList = itemList +"Item" + (i + 1) + " weight: " + weights[i] + " value: " + values[i] + "\n";
        }
        return itemList;
    }

    public String[] showItems_StringList()
    {
        String[] itemList = new String[amountOfItems];
        for (int i = 0; i < amountOfItems; i++)
        {
            itemList[i] = "Item" + (i + 1) + " weight: " + weights[i] + " value: " + values[i];
        }
        return itemList;
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
