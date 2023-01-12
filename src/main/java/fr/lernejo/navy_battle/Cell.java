package fr.lernejo.navy_battle;

public class Cell {
    private final int x;
    private final int y;
    private boolean isOccupied;
    private boolean isHit;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.isOccupied = false;
        this.isHit = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }
}

