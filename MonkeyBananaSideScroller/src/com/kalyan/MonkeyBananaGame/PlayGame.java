package com.kalyan.MonkeyBananaGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PlayGame extends JPanel implements KeyListener, ActionListener {

	private static final long serialVersionUID = 1L;

	private Monkey monkey;
	private Banana banana;

	private static JFrame gameFrame;
	private static JPanel gamePanel;
	private static JLabel timeStatus, bananaStatus, timeShow;

	private Timer timer = new Timer(1000, this);

	private GrassField br = new GrassField();
	private BufferedImage grassImage = br.getGrassImage();

	private PlayGameController controller;

	public PlayGame(PlayGameController controller) {
		gameFrame = new JFrame("Monkey-Banana Game");
		bananaStatus = new JLabel("10 Bananas Left");
		timeStatus = new JLabel("Time Left: 60");
		timeShow = new JLabel("Start: 0");

		this.controller = controller;

		gamePanel = new JPanel();
		gamePanel.add(timeStatus);
		gamePanel.add(bananaStatus);
		gamePanel.add(timeShow);
		gamePanel.setBounds(0, 0, 500, 50);
		gamePanel.setBackground(Color.WHITE);
		
		timer.start();
		monkey = new Monkey();
		banana = new Banana();
		updateBanana();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);

		gameFrame.add(this);
		gameFrame.setBackground(Color.WHITE);
		gameFrame.setResizable(false);
		gameFrame.add(gamePanel, BorderLayout.NORTH);
		gameFrame.pack();
		gameFrame.setSize(Constants.FIELD_WIDTH, Constants.FIELD_HEIGHT);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setVisible(true);
	}

	private void updateBanana() {
		banana.generateBanana();
	}

	private void updateMonkey() {
		monkey.generateMonkey();
	}

	private void paintBackground(Graphics g) {
		for (int i = -20; i < 580;) {
			i = i + 20;
			for (int j = 0; j < 540;) {
				g.drawImage(grassImage, i, j, Constants.IMAGE, Constants.IMAGE, this);
				j = j + 20;
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintBackground(g);
//        if(checkCount == 0){
//            paintBackground(g);
//        }
//        checkCount++;
		if (Constants.TOTAL_TIME > 0 && Constants.REMAINING > 0) {
			paintBanana(g);
			BufferedImage staticMonkeyImage = monkey.getMonkeyImage();
			g.drawImage(staticMonkeyImage, monkey.getMonkeyXPosition(), monkey.getMonkeyYPosition(), Constants.IMAGE, Constants.IMAGE, this);
		}
	}

	private void paintBanana(Graphics g) {
		BufferedImage staticBananaImage = banana.getBananaImage();
		g.drawImage(staticBananaImage, banana.getBananaXPosition(), banana.getBananaYPosition(), Constants.IMAGE, Constants.IMAGE, this);
	}

	@Override
	public void keyPressed(KeyEvent e) {

		int code = e.getKeyCode();

		if (code == KeyEvent.VK_LEFT) {
			if (monkey.getMonkeyXPosition() < 20) {
				monkey.setMonkeyXPosition(20);
			}
			monkey.keyLeft(monkey);
		}

		if (code == KeyEvent.VK_RIGHT) {
			if (monkey.getMonkeyXPosition() > 540) {
				monkey.setMonkeyXPosition(540);
			}
			monkey.keyRight(monkey);
		}

		if (code == KeyEvent.VK_UP) {

			if (monkey.getMonkeyYPosition() < 20) {
				monkey.setMonkeyYPosition(20);
			}
			monkey.keyUp(monkey);
		}

		if (code == KeyEvent.VK_DOWN) {
			if (monkey.getMonkeyYPosition() > 500) {
				monkey.setMonkeyYPosition(500);
			}
			monkey.keyDown(monkey);
		}

		boolean collided = this.controller.checkPositionOfBananaAndMonkey();

		if (collided && Constants.REMAINING >= 0) {
			bananaStatus.setText(" Bananas Left: " + Constants.REMAINING);
			updateBanana();
			updateMonkey();
			Constants.ROUND_TIME = 8;
		}

		if (Constants.REMAINING == 0)
			this.controller.gameEnd();
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		monkey.keyReleased(monkey);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (Constants.ROUND_TIME > 0) {
			Constants.ROUND_TIME--;
			timeShow.setText(" Current Round Time: " + Constants.ROUND_TIME);
		}
		if (Constants.ROUND_TIME < 0) {
			updateBanana();
			updateMonkey();
		} else if (Constants.ROUND_TIME == 0) {
			updateBanana();
			updateMonkey();
			Constants.ROUND_TIME = 8;
			repaint();
		}
		if (Constants.TOTAL_TIME > 0) {
			Constants.TOTAL_TIME--;
			timeStatus.setText(" Hurry: " + Constants.TOTAL_TIME);
		} else {
			this.controller.gameEnd();
		}
	}
	
	public Monkey getMonkey() {
		return monkey;
	}

	public Banana getBanana() {
		return banana;
	}
	
	public Timer getTimer() {
		return timer;
	}
	
	public JPanel getGamePanel() {
		return gamePanel;
	}

}
