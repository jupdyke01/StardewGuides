package me.jupdyke01.stardewguides.pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import me.jupdyke01.stardewguides.Main;

public class Info {

	private Main main;
	
	public Info(Main main) {
		this.main = main;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.setFont(new Font("SansSerif", Font.PLAIN, 60));
		g.drawString("Author: Jupdyke01", main.getWidth() / 2 - 245,  main.getHeight() - (main.getHeight() - 64));
		g.setFont(new Font("SansSerif", Font.PLAIN, 20));
		g.drawString("I decided to make this guides program because I was sick of having 10 wiki pages open.", 240, main.getHeight() - (main.getHeight() - 200));
	}
	
}
