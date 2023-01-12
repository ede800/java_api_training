package fr.lernejo.navy_battle;

public class Ship {
    private int size;
    private int hits;
    private boolean isVertical;
    private int x;
    private int y;
    private String type;

    public Ship(int size,String type) {
        this.size = size;
        this.hits = 0;
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public int getHits() {
        return hits;
    }

    public String getType() {
        return type;
    }

    public void setCoordinates(int x, int y, boolean isVertical) {
        this.x = x;
        this.y = y;
        this.isVertical = isVertical;
    }

    public boolean attack() {
        hits++;
        if (hits == size) {
            return true;
        }
        return false;
    }
    
    public boolean isAtCoordinates(int x, int y) {
        if (isVertical) {
            return this.x <= x && x < this.x + size && this.y == y;
        }
        return this.x == x && this.y <= y && y < this.y + size;
    }
}

