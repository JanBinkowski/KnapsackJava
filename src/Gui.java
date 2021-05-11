import Knapsack.Algorithm;
import Knapsack.Holder;
import Knapsack.ItemGenerator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {
    private JTextField tfNoItems;
    private JTextField tfCap;
    private JButton solveButton;
    private JTextField tfRngSeed;
    private JList genList;
    private JList usedList;
    private JPanel mainPanel;

    String input_n, input_rng, input_c;

    public Gui(){
        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input_n = tfNoItems.getText();
                input_c = tfCap.getText();
                input_rng = tfRngSeed.getText();
                //check if user inputs numbers
                if ((!IsNumber(input_n)) || (!IsNumber(input_c)) || (!IsNumber(input_rng)))
                {
                    String[] error = {"One of your input is not a number, \nor brackets are not filled! "};
                    genList.setListData(error);
                }
                else{
                    int amountOfItems = Integer.parseInt(input_n);
                    int capacity_is = Integer.parseInt(input_c);
                    int rngSeed = Integer.parseInt(input_rng);

                    ItemGenerator generator = new ItemGenerator(amountOfItems, rngSeed);

                    genList.setListData(generator.showItems_StringList());

                    int[] values = generator.getValues();
                    int[] weights = generator.getWeights();

                    Algorithm algo = new Algorithm();
                    Holder result = algo.KnapSack(capacity_is, weights, values, amountOfItems);
                    String[] resultData = result.printUsesItemsStats_StringList();
                    String[] finalData = new String[resultData.length+3];
                    finalData[0] = "Solution: " + result.getResult();
                    finalData[1] = "Solution weight: " + result.getResultWeight(); finalData[2] = "\n";
                    System.arraycopy(resultData, 0, finalData, 3, resultData.length);
                    usedList.setListData(finalData);
                }
            }
        });
    }

    public static boolean IsNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new Gui().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
