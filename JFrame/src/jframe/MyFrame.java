/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements ActionListener {

    public static void main(String[] args) {
        MyFrame myframe = new MyFrame();
        myframe.setSize(400, 300);
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myframe.setLocationRelativeTo(null);
        myframe.setLayout(new FlowLayout(FlowLayout.LEFT)); // Align components to the left

        // Create Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.addActionListener(e -> JOptionPane.showMessageDialog(myframe, "Save functionality not implemented."));
        
        JMenuItem printItem = new JMenuItem("Print");
        printItem.addActionListener(e -> JOptionPane.showMessageDialog(myframe, "Print functionality not implemented."));
        
        JMenuItem clearItem = new JMenuItem("Clear");
        clearItem.addActionListener(e -> {
            // Clear the text fields and text area
            JTextField textField = (JTextField) myframe.getContentPane().getComponent(2);
            JTextField textField1 = (JTextField) myframe.getContentPane().getComponent(4);
            JTextField textField2 = (JTextField) myframe.getContentPane().getComponent(6);
            JTextArea textArea = (JTextArea) ((JScrollPane) myframe.getContentPane().getComponent(13)).getViewport().getView();

            textField.setText("");
            textField1.setText("");
            textField2.setText("");
            textArea.setText(""); // Clear the text area
        });

        toolsMenu.add(saveItem);
        toolsMenu.add(printItem);
        toolsMenu.add(clearItem);
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        myframe.setJMenuBar(menuBar);

        JLabel label4 = new JLabel("This is my heading");
        Font textFont = new Font("Arial", Font.BOLD, 16);
        label4.setFont(textFont);

        JLabel label1 = new JLabel("Enter your first name");
        JLabel label2 = new JLabel("Enter Surname");
        JLabel label3 = new JLabel("Enter your Student Number");

        JTextField textField = new JTextField(15);
        JTextField textField1 = new JTextField(15);
        JTextField textField2 = new JTextField(15);

        myframe.add(label4);
        myframe.add(label1);
        myframe.add(textField);
        myframe.add(label2);
        myframe.add(textField1);
        myframe.add(label3);
        myframe.add(textField2);

        JLabel labelUnitLocation = new JLabel("Unit Location");
        String[] locationArray = {"IIEMSA", "IIE VEGA", "IIE VC"};
        JComboBox<String> majorChoice = new JComboBox<>(locationArray);
        majorChoice.setPreferredSize(new Dimension(textField.getPreferredSize()));

        myframe.add(labelUnitLocation);
        myframe.add(majorChoice);

        JCheckBox checkBoxHaws = new JCheckBox("HAWS");
        JCheckBox checkBoxBcad = new JCheckBox("BCAD");
        JCheckBox checkBoxBcis = new JCheckBox("BCIS");
        JCheckBox checkBoxHonms = new JCheckBox("HONMS");

        myframe.add(checkBoxHaws);
        myframe.add(checkBoxBcad);
        myframe.add(checkBoxBcis);
        myframe.add(checkBoxHonms);

        JButton submitButton = new JButton("Submit");
        JButton clearButton = new JButton("Clear");
        myframe.add(submitButton);
        myframe.add(clearButton);

        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        myframe.add(scrollPane);

        submitButton.addActionListener(e -> {
            String selectedLocation = (String) majorChoice.getSelectedItem();
            String studentInfo = "**** New Student ****\n" +
                    "First Name: " + textField.getText() + "\n" +
                    "Surname: " + textField1.getText() + "\n" +
                    "Student Number: " + textField2.getText() + "\n" +
                    "Unit Location: " + selectedLocation + "\n\n";

            textArea.append(studentInfo);

            // Append message based on the information provided
            if (textField.getText().isEmpty() || textField1.getText().isEmpty() || textField2.getText().isEmpty()) {
                textArea.append("Please fill in all fields!\n");
            } else {
                textArea.append("Student information submitted successfully!\n");
            }
        });

        clearButton.addActionListener(e -> {
            textField.setText("");
            textField1.setText("");
            textField2.setText("");
            checkBoxHaws.setSelected(false);
            checkBoxBcad.setSelected(false);
            checkBoxBcis.setSelected(false);
            checkBoxHonms.setSelected(false);
            textArea.setText(""); // Clear the text area
        });

        myframe.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // This method can be removed or used if needed for other actions
    }
}
