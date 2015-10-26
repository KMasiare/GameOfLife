package org.capgemini.gameoflife.gameoflife;

import java.util.ArrayList;
import java.util.List;

public class GameOfLife {
	private List<Cell> cells = new ArrayList<Cell>();
	
	public void countNextStepExperimental() {
		for (Cell c : cells) {
			c.checkIfSurvives();
		}
		setNextState();
	}
	
	private void setNextState() {
		for (Cell c : cells) {
			c.setNextState();
		}
	}
	
	void addNewCell(Cell cell) {
		cells.add(cell);
	}

	public int getNumberOfAliveCells() {
		int noOfAliveCells = 0;
		for (Cell c : cells) {
			if(c.isAlive() == StateOfLife.alive) {
				noOfAliveCells++;
			}
		}
		return noOfAliveCells;
	}
	
	public void updateNeighbours() {
		for (Cell c : cells) {
			c.findNeighbours(cells);
		}
	}
}
