package com.kalyan.MonkeyBananaGame;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PlayGameController {
	
	private static JLabel timeStatus, bananaStatus, timeShow;
	private static JLabel gameOverText, numberOfBananas, result;
	
	private static JPanel gamePanel;
	
	private Monkey monkey;
	private Banana banana;
	private Timer timer;
	
	private PlayGame game;
	
	public PlayGameController() {
		game = new PlayGame(this);
		monkey = game.getMonkey();
		banana = game.getBanana();
		timer = game.getTimer();
		gamePanel = game.getGamePanel();
	}

	public static void main(String[] args) {
		new PlayGameController();
	}

	public boolean checkPositionOfBananaAndMonkey() {
		if (monkey.getMonkeyXPosition() == banana.getBananaXPosition() && monkey.getMonkeyYPosition() == banana.getBananaYPosition()) {
			Constants.REMAINING--;
			return true;
		}
		return false;
	}

	public void gameEnd() {
		timer.stop();

		timeStatus.setVisible(false);
		timeShow.setVisible(false);
		bananaStatus.setVisible(false);

		gameOverText = new JLabel();
		numberOfBananas = new JLabel();
		result = new JLabel();

		boolean yes = true;

		gameOverText.setText("Game is Over!!!");

		int no = (Constants.TOTAL_BANANAS - Constants.REMAINING);
		if (no > 1) {
			numberOfBananas.setText("Monkey Ate: " + no + " bananas");
		} else {
			numberOfBananas.setText("Monkey Ate: " + no + " banana");
		}

		if (Constants.REMAINING > 0) {
			result.setText("You Lost, Bro !");
		} else {
			result.setText("You are the wiinner !!!");
		}

		gameOverText.setBounds(10, 10, 50, 10);
		numberOfBananas.setBounds(80, 10, 50, 10);
		result.setBounds(10, 30, 50, 10);

		gamePanel.add(gameOverText);
		gamePanel.add(numberOfBananas);
		gamePanel.add(result);

		game.repaint();
	}
}
