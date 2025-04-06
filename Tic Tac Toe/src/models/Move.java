package models;

public class Move {
    Player player;
    Cell cell;
    public Move(Player player, Cell cell) {
        this.player = player;
        this.cell = cell;
    }
}
