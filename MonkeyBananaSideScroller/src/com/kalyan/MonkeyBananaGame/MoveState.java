package com.kalyan.MonkeyBananaGame;

public class MoveState extends MonkeyState {

	public MonkeyState keyUp(Monkey monkey) {
		monkey.setMonkeyYPosition(monkey.getMonkeyYPosition() - Constants.BOX_SIZE);
		monkey.setMonkeyState(this);
		return this;
	}

	public MonkeyState keyDown(Monkey monkey) {
		monkey.setMonkeyYPosition(monkey.getMonkeyYPosition() + Constants.BOX_SIZE);
		monkey.setMonkeyState(this);
		return this;
	}

	public MonkeyState keyLeft(Monkey monkey) {
		monkey.setMonkeyXPosition(monkey.getMonkeyXPosition() - Constants.BOX_SIZE);
		monkey.setMonkeyState(this);
		return this;
	}

	public MonkeyState keyRight(Monkey monkey) {
		monkey.setMonkeyXPosition(monkey.getMonkeyXPosition() + Constants.BOX_SIZE);
		monkey.setMonkeyState(this);
		return this;
	}

	public MonkeyState keyReleased(Monkey monkey) {
		monkey.setMonkeyState(new IdleState());
		return new IdleState();
	}
}
