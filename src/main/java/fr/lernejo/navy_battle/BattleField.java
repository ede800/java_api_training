package fr.lernejo.navy_battle;

import java.util.ArrayList;
import java.util.List;

public class BattleField {
    private final int fieldSize = 10;
    private Cell[][] grid = new Cell[fieldSize][fieldSize];
    private List<Ship> ships = new ArrayList<>();

    public BattleField() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                grid[i][j] = new Cell(i, j);
            }
        }
    }

    public boolean placeShip(Ship ship, int row, int col, boolean isVertical) {
        if (isOutOfBounds(row, col, ship.getSize(), isVertical) || isOverlapping(row, col, ship.getSize(), isVertical)) {
            return false;
        }
        if (isVertical) {
            for (int i = row; i < row + ship.getSize(); i++) {
                grid[i][col].setOccupied(true);
            }
        } else {
            for (int j = col; j < col + ship.getSize(); j++) {
                grid[row][j].setOccupied(true);
            }
        }
        ship.setCoordinates(row, col, isVertical);
        ships.add(ship);
        return true;
    }

    public boolean attackCell(int row, int col) {
        if (isOutOfBounds(row, col)) {
            return false;
        }
        Cell cell = grid[row][col];
        if (!cell.isOccupied()) {
            cell.setHit(true);
            return false;
        }
        Ship ship = getShipAt(row, col);
        if (ship.attack()) {
            System.out.println("You have sank a " + ship.getType() + "!");
        }
        cell.setHit(true);
        return true;
    }

    private boolean isOutOfBounds(int row, int col) {
        return row < 0 || row >= fieldSize || col < 0 || col >= fieldSize;
    }

    private boolean isOutOfBounds(int row, int col, int size, boolean isVertical) {
        if (isVertical) {
            return row + size > fieldSize;
        }
        return col + size > fieldSize;
    }

    private boolean isOverlapping(int row, int col, int size, boolean isVertical) {
        if (isVertical) {
            for (int i = row; i < row + size; i++) {
                if (grid[i][col].isOccupied()) {
                    return true;
                }
            }
        } else {
            for (int j = col; j < col + size; j++) {
                if (grid[row][j].isOccupied()) {
                    return true;
                }
            }
        }
        return false

