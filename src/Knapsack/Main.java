package Knapsack;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner myObj = new Scanner(System.in);
        String input_n;
        String input_c;
        String input_rng;
        System.out.print("Number of items: ");
        input_n = myObj.nextLine();
        System.out.print("Capacity: ");
        input_c = myObj.nextLine();
        System.out.print("RNG seed: ");
        input_rng = myObj.nextLine();

        //check if user inputs numbers
        if ((!IsNumber(input_n)) || (!IsNumber(input_c)) || (!IsNumber(input_rng)))
        {
            System.out.println("One of your input is not a number");
            System.exit(0);
        }

        int amountOfItems = Integer.parseInt(input_n);
        int capacity_is = Integer.parseInt(input_c);
        int rngSeed = Integer.parseInt(input_rng);

        ItemGenerator generator = new ItemGenerator(amountOfItems, rngSeed);

        System.out.println("");
        generator.showItems();
        System.out.println("");

        int[] values = generator.getValues();
        int[] weights = generator.getWeights();

        Algorithm algo = new Algorithm();
        algo.KnapSack(capacity_is, weights, values, amountOfItems).printUsesItemsStats();
        System.out.println("\nSolution:        " + algo.KnapSack(capacity_is, weights,values, amountOfItems).getResult());
        System.out.println("Solution weight: " + algo.KnapSack(capacity_is, weights, values, amountOfItems).getResultWeight());
    }


    public static boolean IsNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}