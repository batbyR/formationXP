package player;

import java.util.Scanner;

import bowling.entities.Frame;
import bowling.entities.Game;

public class Player {

	private String name;
	private String pwd;
	private Game game;
	
	public Player(String name, Game game){
		this.setName(name);
		this.game = game;
		this.game.addPlayer(this);		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addFrame(int ball1, int ball2){		
		this.game.addFrame(new Frame(ball1, ball2));
	}	
	
	public void leaveGame() {
		this.game.removePlayer(this);
		this.game = null;
	}
	
}
