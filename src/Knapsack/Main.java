package Knapsack;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends Frame implements ActionListener
{
    JTextField numberOfItems_tf, capacity_tf, rngSeed_tf;
    JLabel numberOfItems_l, capacity_l, rngSeed_l, generatedItems_l, outputItems_l;
    JTextArea generatedItems_ta, outputItems_ta;
    JButton solve_b;

    String input_n, input_rng, input_c;

    Main(){
        //textFields
        numberOfItems_tf=new JTextField();
        numberOfItems_tf.setBounds(175,40, 100,25);
        capacity_tf=new JTextField();
        capacity_tf.setBounds(175,70, 100,25);
        rngSeed_tf=new JTextField();
        rngSeed_tf.setBounds(175,100, 100,25);

        //Labels
        numberOfItems_l=new JLabel("Number Of Items:");
        numberOfItems_l.setBounds(50,40, 150,20);
        capacity_l=new JLabel("Knapsack Capacity:");
        capacity_l.setBounds(50,70, 150,20);
        rngSeed_l=new JLabel("RNG Seed:");
        rngSeed_l.setBounds(50,100, 150,20);
        generatedItems_l=new JLabel("Generated Items:");
        generatedItems_l.setBounds(30,150, 150,20);
        outputItems_l=new JLabel("Inserted Items:");
        outputItems_l.setBounds(320,150, 150,20);

        //TextArea
        generatedItems_ta=new JTextArea();
        generatedItems_ta.setBounds(20,180,270,400);
        generatedItems_ta.setEditable(false);
        outputItems_ta=new JTextArea();
        outputItems_ta.setBounds(310,180,270,400);
        outputItems_ta.setEditable(false);

        //Buttons
        solve_b=new JButton("Solve!");
        solve_b.setBounds(388,50,100,70);
        solve_b.addActionListener(this);

        add(solve_b);
        add(generatedItems_ta);
        add(outputItems_ta);
        add(numberOfItems_tf);
        add(capacity_tf);
        add(rngSeed_tf);
        add(numberOfItems_l);
        add(rngSeed_l);
        add(capacity_l);
        add(generatedItems_l);
        add(outputItems_l);

        setSize(600,600);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

            input_n = numberOfItems_tf.getText();
            input_c = capacity_tf.getText();
            input_rng = rngSeed_tf.getText();

            //check if user inputs numbers
            if ((!IsNumber(input_n)) || (!IsNumber(input_c)) || (!IsNumber(input_rng)))
            {
                generatedItems_ta.setText("One of your input is not a number, \nor brackets are not filled! ");
            }
            else{
                int amountOfItems = Integer.parseInt(input_n);
                int capacity_is = Integer.parseInt(input_c);
                int rngSeed = Integer.parseInt(input_rng);

                ItemGenerator generator = new ItemGenerator(amountOfItems, rngSeed);

                generatedItems_ta.setText(generator.showItems_String());

                int[] values = generator.getValues();
                int[] weights = generator.getWeights();

                Algorithm algo = new Algorithm();
                String solution = "";
                solution = "Solution:        " + algo.KnapSack(capacity_is, weights,values, amountOfItems).getResult();
                solution = solution + "\nSolution weight: " + algo.KnapSack(capacity_is, weights, values, amountOfItems).getResultWeight();
                solution = solution + "\n\n" + algo.KnapSack(capacity_is, weights, values, amountOfItems).printUsesItemsStats_String();
                outputItems_ta.setText(solution);
            }

    }

    public static void main(String[] args) {
        new Main();
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