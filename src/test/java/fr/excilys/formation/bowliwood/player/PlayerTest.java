package fr.excilys.formation.bowliwood.player;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import bowling.entities.Game;
import player.Player;

public class PlayerTest {
	
	@Test
    public void testPlayer(){
    	
    	Player player = new Player("Jacques", new Game());
    	
    	assertTrue(player.getName().equals("Jacques"));
    	
    }
    
    @Test
    public void testPlayerEnterFrame() {
    	
    	Game game = new Game();
    	Player player = new Player("Michel",game);
    	
    	player.addFrame(9, 1);
    	
    	assertTrue(game.getFrames().get(0)[0].getBall1()==9);

    }

}
