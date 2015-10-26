package org.capgemini.gameoflife.gameoflife;

import java.util.ArrayList;
import java.util.List;

public class Cell {
	private Position position;
	private StateOfLife currentState; // to ma byc enum
	private StateOfLife nextState = StateOfLife.dead;
	
	List<Cell> neighbours = new ArrayList<Cell>();

	public Cell(Position position, StateOfLife state) {
		this.position = position;
		this.currentState = state;
	}

	public Position getPosition() {
		return this.position;
	}

	private int countAliveNeighbours() {
		int noOfNeighbours = 0;
		for (Cell c : neighbours) {
			if (c.isAlive() == StateOfLife.alive) {
				noOfNeighbours++;
			}
		}
		return noOfNeighbours;
	}

	public StateOfLife isAlive() {
		return currentState;
	}

	public void checkIfSurvives() {
		int noOfNeighbours = countAliveNeighbours();
		if (!(noOfNeighbours > 3 || noOfNeighbours < 2)) {
			nextState = StateOfLife.alive;
		} else {
			nextState = StateOfLife.dead;
		}
	}

	void setNextState() {
		currentState = nextState;
		nextState = StateOfLife.dead;
	}

	public void findNeighbours(List<Cell> cells) {
		for (Cell c : cells) {
			if(position.isNeighbour(c.getPosition())) {
				neighbours.add(c);
			}
		}
	}
}
