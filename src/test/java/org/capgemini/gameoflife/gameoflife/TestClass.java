package org.capgemini.gameoflife.gameoflife;

import org.junit.Assert;
import org.junit.Test;

public class TestClass {

	@Test
	public void test() {
		Position p1 = new Position(1, 5);
		Position p2 = new Position(1, 6);

		if (Math.abs(p1.getX() - p2.getX()) <= 1 && Math.abs(p1.getY() - p2.getY()) <= 1) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void dieIfOneNeighbour() {
		Cell cell1 = new Cell(new Position(1, 5), StateOfLife.alive);
		Cell cell2 = new Cell(new Position(2, 5), StateOfLife.alive);
		GameOfLife gol = new GameOfLife();
		gol.addNewCell(cell1);
		gol.addNewCell(cell2);
		gol.updateNeighbours();
		
		gol.countNextStepExperimental();
		System.out.println(gol.getNumberOfAliveCells());
		Assert.assertTrue(gol.getNumberOfAliveCells() == 0);
	}
	
	@Test
	public void aliveIfTwoNeighbours() {
		Cell cell1 = new Cell(new Position(1, 5), StateOfLife.alive);
		Cell cell2 = new Cell(new Position(2, 5), StateOfLife.alive);
		Cell cell3 = new Cell(new Position(1, 6), StateOfLife.alive);
		GameOfLife gol = new GameOfLife();
		gol.addNewCell(cell1);
		gol.addNewCell(cell2);
		gol.addNewCell(cell3);
		gol.updateNeighbours();
		
		gol.countNextStepExperimental();
		Assert.assertTrue(gol.getNumberOfAliveCells() == 3);
	}
	
	@Test 
	public void deadIfFourNeighbours() {
		Cell cell1 = new Cell(new Position(1, 5), StateOfLife.alive);
		Cell cell2 = new Cell(new Position(2, 5), StateOfLife.alive);
		Cell cell3 = new Cell(new Position(1, 6), StateOfLife.alive);
		Cell cell4 = new Cell(new Position(0, 6), StateOfLife.alive);
		Cell cell5 = new Cell(new Position(0, 5), StateOfLife.alive);
		
		GameOfLife gol = new GameOfLife();
		gol.addNewCell(cell1);
		gol.addNewCell(cell2);
		gol.addNewCell(cell3);
		gol.addNewCell(cell4);
		gol.addNewCell(cell5);
		gol.updateNeighbours();
		gol.countNextStepExperimental();
		
		Assert.assertTrue(gol.getNumberOfAliveCells() == 3);
	}
	
	@Test
	public void becomeAliveIfHasThreeNeighbours() {
		Cell cell1 = new Cell(new Position(1, 5), StateOfLife.alive);
		Cell cell2 = new Cell(new Position(2, 5), StateOfLife.alive);
		Cell cell3 = new Cell(new Position(1, 6), StateOfLife.alive);
		Cell cell4 = new Cell(new Position(2, 6), StateOfLife.dead);
		
		GameOfLife gol = new GameOfLife();
		gol.addNewCell(cell1);
		gol.addNewCell(cell2);
		gol.addNewCell(cell3);
		gol.addNewCell(cell4);
		gol.updateNeighbours();
		gol.countNextStepExperimental();
		Assert.assertTrue(gol.getNumberOfAliveCells() == 4);
	}

}
