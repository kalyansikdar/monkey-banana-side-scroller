package com.kalyan.MonkeyBananaGame;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;

public class Banana {

	private int bananaXPosition;
	private int bananaYPosition;
	private BufferedImage bananaImage;

	public BufferedImage getBananaImage() {
		URL bananaResource = getClass().getResource("/media/banana.png");
		try {
			bananaImage = ImageIO.read(bananaResource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bananaImage;
	}

	public Banana generateBanana() {
		Random random = new Random();
		bananaXPosition = random.nextInt(20) * Constants.BOX_SIZE;
		bananaYPosition = random.nextInt(20) * Constants.BOX_SIZE;
		if (bananaXPosition >= Constants.FIELD_WIDTH || bananaYPosition >= Constants.FIELD_HEIGHT)
			generateBanana();

		if (bananaXPosition <0 || bananaYPosition< 0){
			generateBanana();
		}
		return this;
	}

	public int getBananaXPosition() {
		return bananaXPosition;
	}

	public int getBananaYPosition() {
		return bananaYPosition;
	}

	public void setBananaXPosition(int x) {
		this.bananaXPosition = x;
	}

	public void setBananaYPosition(int y) {
		this.bananaYPosition = y;
	}
}
