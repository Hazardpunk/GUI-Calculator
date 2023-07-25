package com.mortgageapp;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;


public class Frame_GUI extends JFrame {

    public JTextField s_Principle;
    public JTextField s_Ir;
    public JTextField s_Period;
    public JLabel labelMortgage;

    public Frame_GUI(){

        JButton Button = new JButton("Calculate");
        ImageIcon logo = new ImageIcon("C:\\Java\\Frame\\src\\image.png");

        this.setTitle("Mortgage Calculator");
        this.setSize(420,420);
        this.setIconImage(logo.getImage());
        this.setResizable(false);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,100,10));
        this.getContentPane().setBackground(new Color(0, 181, 224));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JLabel labelPrinciple = new JLabel("Principal Amount");
        s_Principle = new JTextField(10);
        JLabel labelAnnualInterest = new JLabel("Annual Interest Rate");
        s_Ir = new JTextField(10);
        JLabel labelPeriod = new JLabel("Period Plan (Years)");
        s_Period = new JTextField(10);
        labelMortgage = new JLabel("Monthly Mortgage");

        labelPrinciple.setFont(new Font("Arial",Font.BOLD,15));
        labelAnnualInterest.setFont(new Font("Arial",Font.BOLD,15));
        labelPeriod.setFont(new Font("Arial",Font.BOLD,15));
        labelMortgage.setFont(new Font("Arial",Font.BOLD,15));
        Button.addActionListener(e -> calculateMortgage());

        this.add(labelPrinciple);
        this.add(s_Principle);
        this.add(labelAnnualInterest);
        this.add(s_Ir);
        this.add(labelPeriod);
        this.add(s_Period);
        this.add(labelMortgage);
        this.add(Button);





        this.setVisible(true);
    }

    public void calculateMortgage(){

        int principal = Integer.parseInt(s_Principle.getText());    // Converting String input into Integer/Double
        double Ir = Double.parseDouble(s_Ir.getText());
        int period = Integer.parseInt(s_Period.getText());

        double monthly_Interest = (Ir/100.0)/12;           // Calculating Mortgage value
        int payments_Numbers = period*12;
        double factor = Math.pow((1+monthly_Interest),payments_Numbers);
        double mortgage = (principal*monthly_Interest*factor)/(factor-1);

        NumberFormat result = NumberFormat.getCurrencyInstance();
        labelMortgage.setText("Mortgage "+result.format(mortgage));



    }
}





