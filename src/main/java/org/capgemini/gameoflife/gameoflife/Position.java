package org.capgemini.gameoflife.gameoflife;

public class Position {
	private int x;
	private int y;
	
	Position (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public boolean isNeighbour(Position p) {
		if (Math.abs(x - p.getX()) <= 1 && Math.abs(y - p.getY()) <= 1)
			return !this.equals(p);
		return false;
	}
}
