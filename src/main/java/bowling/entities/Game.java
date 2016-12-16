package bowling.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import player.Player;

public class Game {

    public enum FrameStatus {NORMAL, SPARE, STRIKE};

    private int currentPlayer;
    private List<Frame[]> frames;
    private List<Player> players;
    private int currentFrameNumber;
    
    public Game() {
	this.setCurrentPlayer(0);
	
	this.frames = new ArrayList<>();	
	
	this.players = new ArrayList<Player>();
	
	this.currentFrameNumber = 0;
    }

    public final int getCurrentPlayer() {
	return currentPlayer;
    }
    
    public List<Frame[]> getFrames(){
    	return this.frames;
    }
    
    public List<Player> getPlayers() {
    	return this.players;
    }

    public final void setCurrentPlayer(int currentPlayer) {
	this.currentPlayer = currentPlayer;
    }

    public final void addFrame(Frame frame) {
	this.frames.get(currentPlayer)[currentFrameNumber] = frame;
	if (this.currentPlayer==(this.frames.size()-1)) {
	    currentPlayer = 0;
	    currentFrameNumber++;
	} else {
	    currentPlayer++;
	}
	System.out.println("currentPlayer: " + currentPlayer);
	System.out.println("currentFrameNumber: " + currentFrameNumber);
    }
    
    public final void addPlayer(Player player) {
    	
    	if(currentFrameNumber==0) {
    		this.players.add(player);
    		this.frames.add(new Frame[11]);
    	}
    }
    
    public final void removePlayer(Player player) {
    	
    	int index = players.indexOf(player);
    	this.frames.remove(index);
    	this.players.remove(index);
    }
    
    public final void displayScore() {
    	
    	for(Player p : players) {
    		
    		System.out.print(p.getName());
    		Frame[] playerFrames = frames.get(players.indexOf(p));
    		
    		for(int i = 0 ; i < 11 ; i++ ) {
    			Frame f = playerFrames[i];
    		    if (f != null) {
    		    	System.out.print("||" + f.getBall1() + "|" + f.getBall2());    		    	
    		    }    		    
    		}
    		System.out.print("||");
    		System.out.println(getPlayerScore(p));    	
    	}
    }
        
    public final int getPlayerScore(Player player) {
		int score = 0;
		Frame[] playerFrames = frames.get(players.indexOf(player));
		FrameStatus previousFrameStatus = FrameStatus.NORMAL;
		
		for(int i = 0 ; i < 11 ; i++ ) {
		    Frame f = playerFrames[i];
		    if (f != null) {
			switch (previousFrameStatus) {
				case STRIKE:
				    score += 2 * (f.getBall1() + f.getBall2());
				    break;
			
				case SPARE:
				    score += 2 * f.getBall1() + f.getBall2();
				    break;
			
				default :	
				    score += f.getBall1() + f.getBall2();
			}
			if (f.getBall1() == 10)
			    previousFrameStatus = FrameStatus.STRIKE;
			else if (f.getBall1() + f.getBall2() == 10)
			    previousFrameStatus = FrameStatus.SPARE;
			else
			    previousFrameStatus = FrameStatus.NORMAL;
	
		    }
	}
	
	return score;	
	
    }
    
    public void nextScore(Scanner sc) {
    	int ball1, ball2;
    	int answer;
    	do {
    		answer = 0;
	    	System.out.println("Quel est le score du premier lancer ?");
	    	ball1 = sc.nextInt();
	    	sc.nextLine();
	    	System.out.println("Quel est le score du second lancer ?");
	    	ball2 = sc.nextInt();
	    	sc.nextLine();
	    	System.out.println("Êtes-vous sûr ? 1: oui 0:non");
	    	answer = sc.nextInt();
	    	sc.nextLine();
    	
    	}while((ball1 + ball2) >10 || answer!=1);
    	
    	this.addFrame(new Frame(ball1,ball2));
    	System.out.println("Frame ajoutée !");
    	
    }
    
    public void displaySupportMessage(Player looser){
    	System.out.println(looser+", you suck !");
    }
    
    
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	Game game = new Game();
    	    	
    	int morePlayer = 0;
    	
    	do {
    		System.out.println("Quel est le nom du joueur ?");
    		String name = sc.nextLine();
    		new Player(name, game);
    		System.out.println("Ajouter un autre joueur ? 0:non 1:oui");
    		morePlayer = sc.nextInt();
    		sc.nextLine();
    		
    	}while(morePlayer==1);
    	
    	int leaveGame = 0;
    	while(game.currentFrameNumber<=10){    		
    		game.nextScore(sc);
    		game.displayScore();
    		System.out.println("Voulez-vous continuer à jouer ? 0:non 1:oui");
    		leaveGame = sc.nextInt();
    		sc.nextLine();
    		if(leaveGame==1){
    			game.players.get(game.currentPlayer).leaveGame();
    		}
    	}
    	
    	sc.close();    	
    	
    }

}
