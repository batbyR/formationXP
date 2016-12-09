package fr.excilys.formation.bowliwood;

import org.junit.Test;

import bowling.entities.Frame;
import bowling.entities.Game;

import static org.junit.Assert.fail;

public class ContinuousIntegrationTest {

    @Test
    /**
     * Failing test. Should be changed for CI.
     */
    public void testFailure() {
	// fail();
    }

    public void testCurrentPlayer() {
	String currentPlayer = "1";

	Game game = new Game();
	game.setCurrentPlayer(currentPlayer);

	Frame frame = new Frame(5, 4);
	game.addFrame(frame);
	if ((game.getCurrentPlayer()).equals("2")) {
	    fail();
	}

	frame = new Frame(10, 0);
	game.addFrame(frame);
	if ((game.getCurrentPlayer()).equals("1")) {
	    fail();
	}

    }
}
