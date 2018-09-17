package me.jupdyke01.stardewguides;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import me.jupdyke01.stardewguides.buttons.Button;
import me.jupdyke01.stardewguides.buttons.ButtonManager;
import me.jupdyke01.stardewguides.graphics.Window;
import me.jupdyke01.stardewguides.mouse.Mouse;
import me.jupdyke01.stardewguides.pages.Info;
import me.jupdyke01.stardewguides.utils.ImageUtils;

public class Main extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	private boolean running = false;
	private Thread thread;
	private GameState gameState;
	private static final int width = 1200;
	private static final int height = 900;
	ImageUtils iu;
	ButtonManager bm;
	Info info;

	private HashMap<String, BufferedImage> images = new HashMap<>();

	public Main() {
		addMouseListener(new Mouse(this));
		addMouseMotionListener(new Mouse(this));

		iu = new ImageUtils();
		loadImages();
		bm = new ButtonManager();
		loadButtons();
		info = new Info(this);
	}

	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
		gameState = GameState.MAIN_MENU;
	}

	public void loadImages() {
		images.put("logo", iu.getImage("/Art/Logo.png"));
		images.put("background", iu.getImage("/Art/Background.png"));
		images.put("twitter", iu.getImage("/Buttons/Twitter/Twitter.png"));
		images.put("info", iu.getImage("/Buttons/InfoButton/Info.png"));
		images.put("infohover", iu.getImage("/Buttons/InfoButton/InfoHover.png"));
		images.put("communitycenter", iu.getImage("/Buttons/CommunityCenter/CommunityCenter.png"));
		images.put("communitycenterhover", iu.getImage("/Buttons/CommunityCenter/CommunityCenterHover.png"));
		images.put("back", iu.getImage("/Buttons/Back/Back.png"));
		images.put("backhover", iu.getImage("/Buttons/Back/BackHover.png"));
	}

	public void loadButtons() {
		bm.addButton(new Button("twitter", GameState.INFO, images.get("twitter"), images.get("twitter"), (width - 16) - (images.get("twitter").getWidth()), (height - images.get("twitter").getHeight()) - 16,this));
		bm.addButton(new Button("info", GameState.MAIN_MENU, images.get("info"), images.get("infohover"), (width) - (16 + images.get("info").getWidth()), height - (height - 16),this));
		bm.addButton(new Button("communitycenter", GameState.MAIN_MENU, images.get("communitycenter"), images.get("communitycenterhover"), (width / 2) - (images.get("communitycenter").getWidth() / 2), 262,this));
		bm.addButton(new Button("infoback", GameState.INFO, images.get("back"), images.get("backhover"), 16 , (height - images.get("back").getHeight()) - 16,this));
	}

	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 128.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				delta--;
				render();
				frames++;
			}

			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		/////////////////////////////////
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		g.drawImage(images.get("background"), 0, 0, this);
		
		if (gameState.equals(GameState.MAIN_MENU)) {
			g.drawImage(images.get("logo"), (width / 2) - (images.get("logo").getWidth() / 2), 64, this);

			for (Button button : bm.getButtons()) {
				if (button.getGameState().equals(getGameState()))
					button.render(g);
			}

		} else if (gameState.equals(GameState.INFO)) {
			for (Button button : bm.getButtons()) {
				if (button.getGameState().equals(getGameState()))
					button.render(g);
			}
			info.render(g);
			
		}
		/////////////////////////////////
		g.dispose();
		bs.show();

	}


	public static void main(String[] args) {
		new Window(width, height, "Stardew Valley Guides", new Main());
	}

	public ButtonManager getButtonManager() {
		return bm;
	}

	public HashMap<String, BufferedImage> getImages() {
		return images;
	}

	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}



}
