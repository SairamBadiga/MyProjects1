import controllers.GameController;
import exceptions.InvalidBotCountException;
import exceptions.InvalidPlayersCountException;
import models.Game;
import models.GameState;
import models.Player;
import models.Symbol;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InvalidBotCountException, InvalidPlayersCountException {
        GameController gameController = new GameController();
        Game game = gameController.gameStart(3, new ArrayList<>(), new ArrayList<>());
        while(game.getGameState() == GameState.IN_PROGRESS){
            gameController.printBoard(game.getBoard());
            gameController.makeMove();
        }
    }
}