package com.techlabs.model;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class PlayerNameFrame extends JFrame {
	private JTextArea player1 = new JTextArea();
	private JTextArea player2 = new JTextArea();

	public PlayerNameFrame() {
		JPanel panel = new JPanel();
		panel.setBounds(100,100, 100, 100);
		JLabel label1 = new JLabel("player 1:");
		player1 = new JTextArea("\t");
		JLabel label2 = new JLabel("player 2:");
		player2 = new JTextArea("\t");
		JButton button = new JButton("Done");
		label1.setBounds(100, 30, 400, 30);
		button.addActionListener(new Action(this));
		panel.add(label1);
		panel.add(player1);
		panel.add(label2);
		panel.add(player2);
		panel.add(button);
		add(panel);
		setSize(500, 200);
		setVisible(true);

	}

	public String getplayer1() {
		return player1.getText();
	}

	public String getplayer2() {
		return player2.getText();
	}
}

