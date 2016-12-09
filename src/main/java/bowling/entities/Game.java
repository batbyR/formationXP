package bowling.entities;

public class Game {

    private String currentPlayer;

    public Game() {
	this.setCurrentPlayer("1");
    }

    public final String getCurrentPlayer() {
	return currentPlayer;
    }

    public final void setCurrentPlayer(String currentPlayer) {
	this.currentPlayer = currentPlayer;
    }

    public final void addFrame(Frame frame) {
	this.setCurrentPlayer("2");
    }

}
