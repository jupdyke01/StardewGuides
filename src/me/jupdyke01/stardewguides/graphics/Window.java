package me.jupdyke01.stardewguides.graphics;

import java.awt.Dimension;

import javax.swing.JFrame;

import me.jupdyke01.stardewguides.Main;

public class Window {

	public Window(int width, int height, String title, Main main) {
		Dimension d = new Dimension(width - 10, height - 10);
		main.setPreferredSize(d);
		main.setMinimumSize(d);
		main.setMaximumSize(d);
		
		JFrame frame = new JFrame("Stardew Guides");
		frame.add(main);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		main.start();
	}
	
}
