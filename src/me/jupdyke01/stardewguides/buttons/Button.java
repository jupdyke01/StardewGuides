package me.jupdyke01.stardewguides.buttons;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import me.jupdyke01.stardewguides.GameState;
import me.jupdyke01.stardewguides.Main;

public class Button {

	private String id;
	private GameState gameState;
	private BufferedImage image;
	private BufferedImage after;
	private int x;
	private int y;
	private int width;
	private int height;
	private Main main;
	private boolean hovered = false;
	
	public Button(String id, GameState gameState, BufferedImage image, BufferedImage after, int x, int y, Main main) {
		this.id = id;
		this.gameState = gameState;
		this.image = image;
		this.after = after;
		this.x = x;
		this.y = y;
		this.width = image.getWidth();
		this.height = image.getHeight();
		this.main = main;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public BufferedImage getAfter() {
		return after;
	}

	public void setAfter(BufferedImage after) {
		this.after = after;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public boolean onButton(int posx, int posy) {
		if (posx > x && posx < x + width)
			if (posy > y && posy < y + height)
				return true;
		return false;
	}
	
	public void render(Graphics g) {
		if (hovered)
			g.drawImage(after, x, y, main);
		else
			g.drawImage(image, x, y, main);
	}

	public boolean isHovered() {
		return hovered;
	}

	public void setHovered(boolean hovered) {
		this.hovered = hovered;
	}
	
	
	
}
