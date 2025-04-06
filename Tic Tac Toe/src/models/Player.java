package models;

import java.util.Scanner;

public class Player {
    String name;
    Symbol symbol;
    PlayerType playerType;
    private static Scanner scanner = new Scanner(System.in);
    public Player(String name, Symbol symbol, PlayerType type) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = type;
    }

    public Move move() {
        System.out.println("Give row number");
        int row = scanner.nextInt();
        System.out.println("Give column number");
        int column = scanner.nextInt();
        Move move = new Move(this, new Cell(row, column));
        return move;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
}
