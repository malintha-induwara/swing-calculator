import javax.swing.*;
import java.awt.*;

class Calculator extends JFrame {
    private JButton[] btns;
    private  final String[] btnNames = {"7", "8", "9", "-", "4", "5", "6", "/", "1", "2", "3", "+", "0", ".", "=", "*"};
    private JTextField txt;
    private JPanel displayPanel;
    private JPanel btnPanel;
    private String [] store;



    Calculator() {
        setSize(400, 300);
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        displayPanel = new JPanel();
        btnPanel = new JPanel(new GridLayout(4, 4, 5,5));

        txt = new JTextField(20);
        txt.setPreferredSize(new Dimension(250,50));

        displayPanel.add(txt);

        btns = new JButton[16];

        for (int i = 0; i < btns.length; i++) {
            btns[i] = new JButton(btnNames[i]);
            btns[i].setFont(new Font("Serif",Font.BOLD,20));
            btnPanel.add(btns[i]);
        }
        add(displayPanel, BorderLayout.PAGE_START);
        add(btnPanel, BorderLayout.CENTER);

        //Button Declaration

        btns[0].addActionListener((event)->{
            txt.setText(txt.getText()+"7");
        });

        btns[1].addActionListener((event)->{
            txt.setText(txt.getText()+"8");
        });

        btns[2].addActionListener((event)->{
            txt.setText(txt.getText()+"9");
        });

        btns[3].addActionListener((event)->{
            txt.setText(txt.getText()+"-");
        });

        btns[4].addActionListener((event)->{
            txt.setText(txt.getText()+"4");
        });

        btns[5].addActionListener((event)->{
            txt.setText(txt.getText()+"5");
        });

        btns[6].addActionListener((event)->{
            txt.setText(txt.getText()+"6");
        });

        btns[7].addActionListener((event)->{
            txt.setText(txt.getText()+"/");
        });

        btns[8].addActionListener((event)->{
            txt.setText(txt.getText()+"1");
        });

        btns[9].addActionListener((event)->{
            txt.setText(txt.getText()+"2");
        });

        btns[10].addActionListener((event)->{
            txt.setText(txt.getText()+"3");
        });

        btns[11].addActionListener((event)->{
            txt.setText(txt.getText()+"+");
        });

        btns[12].addActionListener((event)->{
            txt.setText(txt.getText()+"0");
        });

        btns[13].addActionListener((event)->{
            txt.setText(txt.getText()+".");
        });

        btns[14].addActionListener((event)->{
            double result=evaluateExpression(txt.getText());
            txt.setText(String.valueOf(result));
        });

        btns[15].addActionListener((event)->{
            txt.setText(txt.getText()+"*");
        });

    }

    public static double evaluateExpression(String expression) {
        String[] operators = {"+", "-", "*", "/"};

        for (int i = 0; i < operators.length; i++) {
            String operator = operators[i];
            if (expression.contains(operator)) {
                String[] operands = expression.split("\\" + operator);
                double result = 0;


                double num1 = Double.parseDouble(operands[0]);
                double num2 = Double.parseDouble(operands[1]);

                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                }

                return result;
            }
        }
        return 0;
    }



}

class Main {
    public static void main(String args[]){
        Calculator c1 = new Calculator();
        c1.setVisible(true);
    }
}
