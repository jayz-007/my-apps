package com.techlabs.model;

import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ExitFrame implements ActionListener {
	private JFrame frake = new JFrame();
	private FrameClientApp frame;
	private PlayerNameFrame frame2;
	JButton yes = new JButton("YES");
	JButton no = new JButton("NO");

	public ExitFrame(FrameClientApp frame, PlayerNameFrame frame2) {
		this.frame = frame;
		this.frame2 = frame2;
	}

	public void action() {
		if (frame.getGame().getStatus().equals(ResultType.WIN)) {

			frake.setLayout(new FlowLayout());
			Label winner = new Label("Winner is " + frame.getGame().getNextPlayer().getPlayerName());
			frake.add(winner);
			frake.setVisible(true);
			frake.setSize(300, 300);
			contiueGame(frake);

		}
		if(frame.getGame().getStatus().equals(ResultType.DRAW)) {
			frake.setLayout(new FlowLayout());
			Label draw = new Label("Game is Draw " );
			frake.add(draw);
			frake.setVisible(true);
			frake.setSize(300, 300);
			contiueGame(frake);

			
		}

	}

	public void contiueGame(JFrame frame) {
		Label LABEL = new Label("Do u want to continue ?");

		frame.add(LABEL);
		yes.addActionListener(this);
		no.addActionListener(this);
		frame.add(yes);
		frame.add(no);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == yes) {
			frake.setVisible(false);
			frame.setVisible(false);
			new FrameClientApp(frame2);
		}
		if (e.getSource() == no) {
			frake.setVisible(false);
			frame.setVisible(false);

		}

	}

}
