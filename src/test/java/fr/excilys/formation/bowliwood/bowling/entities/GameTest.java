package fr.excilys.formation.bowliwood.bowling.entities;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.Test;

import bowling.entities.Frame;
import bowling.entities.Game;
import player.Player;

public class GameTest {
	
	@Test
    public void testCurrentPlayer() {		
	
		Game game = new Game();
		Player player1 = new Player("Jack", game);
		Player player2 = new Player("John", game);		
		
		player1.addFrame(5,4);	
		
		assertTrue(game.getCurrentPlayer()==1);
	
		player2.addFrame(5,4);	
		
		assertTrue(game.getCurrentPlayer()==0);	
    
    }
    
    @Test
    public void testScoreCalculation() {
	
	Game game = new Game();
	Player player1 = new Player("Jack", game);
	Player player2 = new Player("John", game);
	
	game.addFrame(new Frame(5,4));
	game.addFrame(new Frame(6,2));
	
	assertTrue(game.getPlayerScore(player1)==9);
	assertTrue(game.getPlayerScore(player2)==8);
	
	game.addFrame(new Frame(10,0));
	game.addFrame(new Frame(6,2));
	game.addFrame(new Frame(5,1));
	game.addFrame(new Frame(6,2));
	
	// test correct strike scoring 
	assertTrue(game.getPlayerScore(player1)==31);
	assertTrue(game.getPlayerScore(player2)==24);
	
	game.addFrame(new Frame(6,4));
	game.addFrame(new Frame(2,2));
	game.addFrame(new Frame(5,1));
	game.addFrame(new Frame(6,2));

	// test correct spare scoring 
	assertTrue(game.getPlayerScore(player1)==52);
	assertTrue(game.getPlayerScore(player2)==36);
	
	
    }
    
    @Test
    public void testDisplayScore() {
    	
    	Game game = new Game();
    	Player player1 = new Player("Jack", game);
    	Player player2 = new Player("John", game);
    	
    	game.addFrame(new Frame(5,4));
    	game.addFrame(new Frame(6,2));    	
    	game.addFrame(new Frame(10,0));
    	game.addFrame(new Frame(6,2));
    	game.addFrame(new Frame(5,1));
    	game.addFrame(new Frame(6,2));
    	
    	game.displayScore();
    	
    }
    
    @Test
    public void testLeaveGame() {
    	Game game = new Game();
    	Player player1 = new Player("Jack", game);
    	Player player2 = new Player("John", game);
    	
    	game.addFrame(new Frame(5,4));
    	game.addFrame(new Frame(6,2));    	
    	game.addFrame(new Frame(10,0));
    	
    	player1.leaveGame();
    	
    	assertTrue(game.getPlayers().size()==1);
    	assertTrue(game.getPlayers().get(0).getName().equals("John"));
    }
    
    @Test
    public void testNextScore(){
    	
    	ByteArrayInputStream in = new ByteArrayInputStream("4\n5\n1".getBytes());
    	System.setIn(in);
    	Scanner sc = new Scanner(System.in);
    	Game game = new Game();
    	Player player1 = new Player("Jack", game);
    	Player player2 = new Player("John", game);
    	game.nextScore(sc);
    	sc.close();
    	
    	assertTrue(game.getFrames().get(0)[0].getBall1()==4);
    	
    }
    
    @Test
    public void testBadNextScore(){
    	
    	ByteArrayInputStream in = new ByteArrayInputStream("11\n6\n1\n4\n5\n1".getBytes());
    	System.setIn(in);
    	Scanner sc = new Scanner(System.in);
    	Game game = new Game();
    	Player player1 = new Player("Jack", game);
    	Player player2 = new Player("John", game);
    	game.nextScore(sc);
    	sc.close();
    	
    	assertTrue(game.getFrames().get(0)[0].getBall1()==4);
    	
    }

}
