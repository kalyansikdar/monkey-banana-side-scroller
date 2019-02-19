package com.kalyan.MonkeyBananaGame;

public class IdleState extends MonkeyState {

	public MonkeyState keyUp(Monkey monkey) {
		monkey.setMonkeyYPosition(monkey.getMonkeyYPosition() - Constants.BOX_SIZE);
		monkey.setMonkeyState(new MoveState());
		return new MoveState();
	}

	public MonkeyState keyRight(Monkey monkey) {
		monkey.setMonkeyXPosition(monkey.getMonkeyXPosition() + Constants.BOX_SIZE);
		monkey.setMonkeyState(new MoveState());
		return new MoveState();
	}

	public MonkeyState keyDown(Monkey monkey) {
		monkey.setMonkeyYPosition(monkey.getMonkeyYPosition() + Constants.BOX_SIZE);
		monkey.setMonkeyState(new MoveState());
		return new MoveState();
	}

	public MonkeyState keyLeft(Monkey monkey) {
		monkey.setMonkeyXPosition(monkey.getMonkeyXPosition() - Constants.BOX_SIZE);
		monkey.setMonkeyState(new MoveState());
		return new MoveState();
	}

}
