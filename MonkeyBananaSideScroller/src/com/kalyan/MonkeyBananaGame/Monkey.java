package com.kalyan.MonkeyBananaGame;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;

public class Monkey {

	private int monkeyXPosition;
	private int monkeyYPosition;
	private BufferedImage monkeyImage;
	private MonkeyState monkeyState;

	public Monkey() {
		monkeyState = new IdleState();
		generateMonkey();
    }

	public void setMonkeyState(MonkeyState newMonkeyState) {
		monkeyState = newMonkeyState;
	}

	public BufferedImage getMonkeyImage() {
		URL monkeyResource = getClass().getResource("/media/monkey.png");
		try {
			monkeyImage = ImageIO.read(monkeyResource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return monkeyImage;
	}

	public Monkey generateMonkey() {
		Random random = new Random();
		monkeyXPosition = random.nextInt(19) * Constants.BOX_SIZE;
		monkeyYPosition = random.nextInt(19) * Constants.BOX_SIZE;
		if (monkeyXPosition >= Constants.FIELD_WIDTH || monkeyYPosition >= Constants.FIELD_HEIGHT) {
			generateMonkey();
		}
        if (monkeyXPosition <0 || monkeyYPosition< 0){
        	generateMonkey();
        }

		return this;
	}

	public MonkeyState keyUp(Monkey monkey) {
		return monkeyState.keyUp(this);
	}

	public MonkeyState keyDown(Monkey monkey) {
		return monkeyState.keyDown(this);
	}

	public MonkeyState keyLeft(Monkey monkey) {
		return monkeyState.keyLeft(this);
	}

	public MonkeyState keyRight(Monkey monkey) {
		return monkeyState.keyRight(this);
	}

	public MonkeyState keyReleased(Monkey monkey) {
		return monkeyState.keyReleased(this);
	}

	public int getMonkeyXPosition() {
		return monkeyXPosition;
	}

	public int getMonkeyYPosition() {
		return monkeyYPosition;
	}

	public void setMonkeyXPosition(int x) {
		this.monkeyXPosition = x;
	}

	public void setMonkeyYPosition(int y) {
		this.monkeyYPosition = y;
	}
}
