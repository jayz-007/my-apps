package com.techlabs.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Action implements ActionListener {
	
	private PlayerNameFrame frame;

	public Action(PlayerNameFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new FrameClientApp(frame);
		frame.setVisible(false);
		
	}

}
