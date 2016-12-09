package fr.excilys.formation.bowliwood;

import org.junit.Test;

import bowling.entities.Frame;
import bowling.entities.Game;

import static org.junit.Assert.*;

public class ContinuousIntegrationTest {

    @Test
    /**
     * Failing test. Should be changed for CI.
     */
    public void testFailure() {
	// fail();
    }

    @Test
    public void testCurrentPlayer() {
	String currentPlayer = "1";

	Game game = new Game();
	game.setCurrentPlayer(currentPlayer);

	Frame frame = new Frame(5, 4);
	game.addFrame(frame);
	if (!(game.getCurrentPlayer()).equals("2")) {
	    fail();
	}

	frame = new Frame(10, 0);
	game.addFrame(frame);
	assertTrue(game.getCurrentPlayer().equals("1"));	
    
    }
    
    @Test
    public void testScoreCalculation() {
	
	Game game = new Game();
	
	game.addFrame(new Frame(5,4));
	game.addFrame(new Frame(6,2));
	
	assertTrue(game.getPlayerScore("1")==9);
	assertTrue(game.getPlayerScore("2")==8);
	
	game.addFrame(new Frame(10,0));
	game.addFrame(new Frame(6,2));
	game.addFrame(new Frame(5,1));
	game.addFrame(new Frame(6,2));
	
	// test correct strike scoring 
	assertTrue(game.getPlayerScore("1")==31);
	assertTrue(game.getPlayerScore("2")==24);
	
	game.addFrame(new Frame(6,4));
	game.addFrame(new Frame(2,2));
	game.addFrame(new Frame(5,1));
	game.addFrame(new Frame(6,2));

	// test correct spare scoring 
	assertTrue(game.getPlayerScore("1")==52);
	assertTrue(game.getPlayerScore("2")==36);
	
	
    }
    
    
    
}
