package me.jupdyke01.stardewguides.mouse;

import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import me.jupdyke01.stardewguides.GameState;
import me.jupdyke01.stardewguides.Main;
import me.jupdyke01.stardewguides.buttons.Button;

public class Mouse extends MouseAdapter {

	private Main main;

	public Mouse(Main main) {
		this.main = main;
	}

	public void mouseMoved(MouseEvent e) {
		for (Button button : main.getButtonManager().getButtons()) {
			if (main.getGameState().equals(button.getGameState()))
				if (button.onButton(e.getX(), e.getY()))
					button.setHovered(true);
				else
					button.setHovered(false);
		}
	}

	public void mousePressed(MouseEvent e) {
		for (Button button : main.getButtonManager().getButtons())
			if (main.getGameState().equals(button.getGameState()))
				if (button.onButton(e.getX(), e.getY()))
					if (button.getId().equals("info")) {
						main.setGameState(GameState.INFO);
					} else if (button.getId().equals("twitter")) {
						try {
							Desktop.getDesktop().browse(new URI("https://twitter.com/jupdyke01/"));
						} catch (IOException | URISyntaxException e1) {
							e1.printStackTrace();
						}
					} else if (button.getId().equals("infoback")) {
						main.setGameState(GameState.MAIN_MENU);
					}
	}

}
