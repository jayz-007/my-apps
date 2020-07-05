package com.techlabs.model;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameClientApp extends JFrame implements ActionListener {
	private PlayerNameFrame frame;
	ArrayList<Button> buttons = new ArrayList<Button>();
	JLabel gameStatus = new JLabel();
	JLabel currentPlayer = new JLabel();
	JLabel winnder = new JLabel();
	Game newGame;

	public FrameClientApp(PlayerNameFrame frame) {
		super();
		this.frame = frame;
		this.frame.setVisible(false);
		this.setVisible(true);
		this.setSize(500, 500);
		JPanel p = new JPanel(new GridLayout(4, 3));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p.add(gameStatus);
		gameStatus.setText("Game status is "+ ResultType.PROGRESS.toString());
		p.add(currentPlayer);
		currentPlayer.setText(this.frame.getplayer1()+"'s turn");

		p.add(winnder);
		for (int i = 0; i < 9; i++) {
			buttons.add(new Button(i + ""));
			p.add(buttons.get(i));
			buttons.get(i).addActionListener(this);

		}
		this.newGame = new Game(
				new Player[] { new Player(frame.getplayer1(), Mark.X), new Player(frame.getplayer2(), Mark.O) },
				new ResultAnalyzer(new Board()));

		this.add(p);
		this.setVisible(true);
		p.setBackground(Color.CYAN);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		winnder.setText("");
		for (Button button : buttons) {
			if (button == e.getSource()) {
				try {
					setPlayerColor(button);
					newGame.Play(Integer.parseInt(button.getLabel()));
					button.setLabel(newGame.getCurrentPlayer().getPlayerMark().toString());
					setGameStatus();
					setCurrentPlayer();
					setWinnder();

				} catch (Exception e2) {
					winnder.setText("Place already marked");
				}
			}

		}

	}

	public void setGameStatus() {
		gameStatus.setText("Game status is :" + newGame.getStatus().toString());
	}

	public void setCurrentPlayer() {
		currentPlayer.setText("It is " + newGame.getCurrentPlayer().getPlayerName() + "'s turn");
	}

	public void setWinnder() {
		if (newGame.getStatus().equals(ResultType.WIN)) {
			disableActionListener();
			winnder.setText("Winnder is:" + newGame.getNextPlayer().getPlayerName());
			new ExitFrame(this, frame).action();
		}
		if (newGame.getStatus().equals(ResultType.DRAW)) {
			disableActionListener();
			new ExitFrame(this, frame).action();
			;
		}
	}

	public Game getGame() {
		return newGame;
	}

	public PlayerNameFrame getPlayerNameFrame() {
		return frame;
	}

	public void disableActionListener() {
		currentPlayer.setText("");
		for (int i = 0; i < 9; i++) {
			buttons.get(i).removeActionListener(this);
		}
	}
	
	public void setPlayerColor(Button button) {
		if(newGame.getCurrentPlayer().getPlayerName().equals(frame.getplayer1())) {
			button.setBackground(Color.GREEN);
		}
		if(newGame.getCurrentPlayer().getPlayerName().equals(frame.getplayer2())) {
			button.setBackground(Color.RED);
		}
	}

}
