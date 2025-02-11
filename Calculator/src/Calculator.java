import javax.swing.*; // Importing Swing library for GUI components
import java.awt.*; // Importing AWT library for layout managers and more GUI components
import java.awt.event.*; // Importing AWT library for event handling

public class Calculator implements ActionListener { // Calculator class implementing ActionListener interface

    JFrame frame; // Main frame for the calculator
    JTextField textfield; // Text field to display input and results
    JButton[] numberButtons = new JButton[10]; // Array to store number buttons
    JButton[] functionButtons = new JButton[9]; // Array to store function buttons
    JButton addButton, subButton, mulButton, divButton; // Buttons for arithmetic operations
    JButton decButton, equButton, delButton, clrButton, negButton; // Buttons for decimal, equal, delete, clear, and negative functions
    JPanel panel; // Panel to organize buttons

    Font myFont = new Font("Ink Free", Font.BOLD, 30); // Font for buttons and text field

    double num1 = 0, num2 = 0, result = 0; // Variables to store operands and result
    char operator; // Variable to store the operator

    Calculator() { // Constructor for the Calculator class

        frame = new JFrame("Calculator"); // Initializing frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Setting default close operation
        frame.setSize(420, 550); // Setting size of the frame
        frame.setLayout(null); // Setting layout to null for absolute positioning

        textfield = new JTextField(); // Initializing text field
        textfield.setBounds(50, 25, 300, 50); // Setting bounds for text field
        textfield.setFont(myFont); // Setting font for text field
        textfield.setEditable(false); // Making text field non-editable

        // Initializing function buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");

        // Adding function buttons to the array
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        // Setting properties for function buttons
        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this); // Adding action listener
            functionButtons[i].setFont(myFont); // Setting font
            functionButtons[i].setFocusable(false); // Disabling focus
        }

        // Setting properties for number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i)); // Initializing number buttons
            numberButtons[i].addActionListener(this); // Adding action listener
            numberButtons[i].setFont(myFont); // Setting font
            numberButtons[i].setFocusable(false); // Disabling focus
        }

        // Setting bounds for special buttons
        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        // Initializing panel and setting its properties
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300); // Setting bounds for panel
        panel.setLayout(new GridLayout(4, 4, 10, 10)); // Setting layout for panel

        // Adding buttons to panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        // Adding components to frame
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true); // Making frame visible
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator(); // Creating instance of Calculator
    }

    @Override
    public void actionPerformed(ActionEvent e) { // Handling button click events

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i))); // Appending number to text field
            }
        }
        if (e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat(".")); // Appending decimal point to text field
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText()); // Storing first operand
            operator = '+'; // Setting operator
            textfield.setText(""); // Clearing text field
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textfield.getText()); // Storing first operand
            operator = '-'; // Setting operator
            textfield.setText(""); // Clearing text field
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textfield.getText()); // Storing first operand
            operator = '*'; // Setting operator
            textfield.setText(""); // Clearing text field
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText()); // Storing first operand
            operator = '/'; // Setting operator
            textfield.setText(""); // Clearing text field
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textfield.getText()); // Storing second operand

            switch (operator) { // Performing operation based on operator
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textfield.setText(String.valueOf(result)); // Displaying result
            num1 = result; // Storing result for further calculations
        }
        if (e.getSource() == clrButton) {
            textfield.setText(""); // Clearing text field
        }
        if (e.getSource() == delButton) {
            String string = textfield.getText(); // Getting current text
            textfield.setText(""); // Clearing text field
            for (int i = 0; i < string.length() - 1; i++) {
                textfield.setText(textfield.getText() + string.charAt(i)); // Removing last character
            }
        }
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textfield.getText()); // Getting current value
            temp *= -1; // Negating the value
            textfield.setText(String.valueOf(temp)); // Displaying negated value
        }
    }
}
