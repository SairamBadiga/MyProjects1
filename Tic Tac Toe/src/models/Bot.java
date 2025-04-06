package models;

public class Bot extends Player {
    private DifficultyLevel botDifficultyLevel;
    private BotStatergy botStratergy;

    public Bot(String name, Symbol symbol, DifficultyLevel difficultyLevel, BotStatergy botStratergy) {
        super(name, symbol);
        this.botDifficultyLevel = difficultyLevel;
        this.botStratergy = botStratergy;

    }
}
