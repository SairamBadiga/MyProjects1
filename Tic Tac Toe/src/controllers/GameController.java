package controllers;

import exceptions.InvalidBotCountException;
import exceptions.InvalidPlayersCountException;
import models.Board;
import models.Game;
import models.Player;
import stratergies.WinningStatergy;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    public Game gameStart(int Dimension, List<Player> players, List<WinningStatergy> statergies) throws InvalidBotCountException, InvalidPlayersCountException {
        Game game = Game.getBuilder()
                .setDimensions(Dimension)
                .setPlayers(players)
                .setStatergies(statergies)
                .build();
        return game;

    }
    public void printBoard(Board board) {
        board.getBoard();

    }
    public void makeMove(){

    }
}
