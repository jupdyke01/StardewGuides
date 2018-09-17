package me.jupdyke01.stardewguides.buttons;

import java.util.ArrayList;

public class ButtonManager {

	private ArrayList<Button> buttons = new ArrayList<>();
	
	public Button getButton(String id) {
		for (Button button : buttons)
			if (button.getId().equals(id))
				return button;
		return null;
	}
	
	public void addButton(Button button) {
		buttons.add(button);
	}
	
	public ArrayList<Button> getButtons() {
		return buttons;
	}
}
