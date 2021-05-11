package Knapsack;

import javax.swing.*;

public class Holder
{
    //Result item statistics
    private int[] usedValues;
    private int[] usedWeights;
    private int resultWeight;
    private int resultValue;

    public Holder(int[] values, int[] weights)
    {
        usedValues = values;
        usedWeights = weights;
        resultValue = 0;
        resultWeight = 0;

        int amount = usedWeights.length;

        for(int i=0; i<amount; i++)
        {
            resultWeight += weights[i];
            resultValue += values[i];
        }
    }

    public int[] getUsedWeights()
    {
        return usedWeights;
    }

    public int[] getUsedValues()
    {
        return usedValues;
    }

    public int getResult()
    {
        return resultValue;
    }

    public int getResultWeight()
    {
        return resultWeight;
    }

    //Print used items;
    public void printUsesItemsStats()
    {
        for (int i = 0; i < usedValues.length; i++)
        {
            System.out.println("Used item stats:"  + " weight: " + usedWeights[i] + " value: " + usedValues[i]);
        }
    }

    public String printUsesItemsStats_String()
    {
        String insertedItems = "";
        for (int i = 0; i < usedValues.length; i++)
        {
            insertedItems = insertedItems + "Used item stats:"  + " weight: " + usedWeights[i] + " value: " + usedValues[i] + "\n";
        }
        return insertedItems;
    }

    public String[] printUsesItemsStats_StringList()
    {
        String[] insertedItems = new String[usedValues.length];
        for (int i = 0; i < usedValues.length; i++)
        {
            insertedItems[i] = "Used item stats:"  + " weight: " + Integer.toString(usedWeights[i]) + " value: " + Integer.toString(usedValues[i]);
        }
        return insertedItems;
    }
}


