package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SeriesGUI extends JFrame {
    Series series;

    public SeriesGUI() {
        super("Series");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(dimension.width / 2 - 400, dimension.height / 2 - 100, 800, 200);
        setLayout(new FlowLayout());
        JTextField textField1 = new JTextField("First element", 8);
        add(textField1);
        JTextField textField2 = new JTextField("Coefficient", 6);
        add(textField2);
        JTextField textField3 = new JTextField("Amount", 5);
        add(textField3);
        JTextField fileNameField = new JTextField("File name", 6);
        add(fileNameField);
        fileNameField.setEditable(false);
        JRadioButton radioButton1 = new JRadioButton("Linear");
        add(radioButton1);
        JRadioButton radioButton2 = new JRadioButton("Exponential");
        add(radioButton2);
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(radioButton1);
        radioGroup.add(radioButton2);
        radioButton1.setSelected(true);
        JButton button1 = new JButton("Show series");
        add(button1);
        JButton button2 = new JButton("Save to file");
        add(button2);
        button2.setEnabled(false);
        JTextField seriesField = new JTextField(58);
        seriesField.setEditable(false);
        add(seriesField);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value1 = textField1.getText();
                String value2 = textField2.getText();
                String value3 = textField3.getText();
                double initialValue;
                double coefficientValue;
                int amountValue;
                try {
                    initialValue = Double.parseDouble(value1);
                    coefficientValue = Double.parseDouble(value2);
                    amountValue = Integer.parseInt(value3);
                    if (amountValue <= 0) throw new ArithmeticException();
                } catch (NumberFormatException | ArithmeticException exception) {
                    JOptionPane.showMessageDialog(SeriesGUI.this,
                            "Incorrect input", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (radioButton1.isSelected()) {
                    series = new Linear(amountValue, initialValue, coefficientValue);
                } else {
                    series = new Exponential(amountValue, initialValue, coefficientValue);
                }
                seriesField.setText(series.toString());
                button2.setEnabled(true);
                fileNameField.setEditable(true);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    series.saveToFile(fileNameField.getText());
                } catch (IOException exception) {
                    JOptionPane.showMessageDialog(SeriesGUI.this,
                            "File name is incorrect or contains any of the following characters:" +
                                    "\\ / : * ? \" < > | ", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
            }
        });
    }
}
