package models;

import exceptions.InvalidBotCountException;
import exceptions.InvalidMoveException;
import exceptions.InvalidPlayersCountException;
import stratergies.WinningStatergy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameState gameState;
    private Player Winner;
    private int nextPlayerMoveIndex;
    private List<WinningStatergy> statergies;
    private int dimensions;
    private static Scanner scanner = new Scanner(System.in);

    public GameState getGameState() {
        return gameState;
    }


    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public Game(int dimensions, List<Player> players, List<WinningStatergy> statergies) {
        this.dimensions = dimensions;
        this.board = new Board(this.dimensions);
        this.players = players;
        this.moves = new ArrayList<>();
        this.statergies = statergies;
        this.gameState = GameState.IN_PROGRESS;
        this.nextPlayerMoveIndex = 0;
    }
    public boolean validatemove(Move move){
        if(move.cell.getRow()>=dimensions || move.cell.getCol()>=dimensions){
            return false;
        }
        if(move.cell.getRow()<0 || move.cell.getCol()<0){
            return false;
        }
        if(this.board.getBoard()[move.cell.getRow()][move.cell.getCol()].getCellState() == CellState.Filled){
            return false;
        }

        return true;

    }
    public void makeMove() throws InvalidMoveException {
        Player currentPlayer = players.get(nextPlayerMoveIndex);
        System.out.println("Hey it's" + currentPlayer.getName() + "'s turn");

        Move move = currentPlayer.move();
        if(!validatemove(move)){
            throw new InvalidMoveException("It's a invalid move");
        }
        int row = move.cell.getRow();
        int col = move.cell.getCol();
        Cell cell = this.board.getBoard()[row][col];
        cell.setCellState(CellState.Filled);
        cell.setPlayer(currentPlayer);
        Move finalmove = new Move(currentPlayer, cell);
        moves.add(finalmove);
        nextPlayerMoveIndex = (nextPlayerMoveIndex + 1) % players.size();



    }

    public static class Builder{
        private int dimensions;
        private List<Player> players;
        private List<WinningStatergy> statergies;

        public int getDimensions() {
            return dimensions;
        }

        public Builder setDimensions(int dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public List<WinningStatergy> getStatergies() {
            return statergies;
        }

        public Builder setStatergies(List<WinningStatergy> statergies) {
            this.statergies = statergies;
            return this;
        }
        private void  validateBotCount() throws InvalidBotCountException{
            int botCount = 0;
            for(Player p : players){
                if(p.getPlayerType() == PlayerType.BOT){
                    botCount++;
                }
            }
            if(botCount >1){
                throw new InvalidBotCountException("Bot are more than one");
            }
        }
        private void validatePlayerCount() throws InvalidPlayersCountException{
            int playerCount = 0;
            if(players.size() != dimensions){
                throw new InvalidPlayersCountException("Players count is not validated");
            }

        }
        private void validateUniqueSymbolsForEachPlayer(){

        }
        private void validate() throws InvalidPlayersCountException, InvalidBotCountException{
            validateBotCount();
            validatePlayerCount();
            validateUniqueSymbolsForEachPlayer();


        }
        public Game build()throws InvalidPlayersCountException, InvalidBotCountException{
            validate();
            return new Game(dimensions, players, statergies);
    }


    }


}
