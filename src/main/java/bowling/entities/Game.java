package bowling.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.lang.reflect.Array;

public class Game {

    public enum FrameStatus {NORMAL, SPARE, STRIKE};

    private String currentPlayer;
    private List<Frame[]> frames;
    private int currentFrameNumber;
    
    public Game() {
	this.setCurrentPlayer("1");
	this.frames = new ArrayList<>();
	this.frames.add(new Frame[10]);
	this.frames.add(new Frame[10]);
	this.currentFrameNumber = 0;
    }

    public final String getCurrentPlayer() {
	return currentPlayer;
    }

    public final void setCurrentPlayer(String currentPlayer) {
	this.currentPlayer = currentPlayer;
    }

    public final void addFrame(Frame frame) {
	this.frames.get((Integer.parseInt(currentPlayer)-1))[currentFrameNumber] = frame;
	if (this.currentPlayer.equals("2")) {
	    currentPlayer = "1";
	    currentFrameNumber++;
	} else {
	    currentPlayer = "2";
	}
    }
    
    // TODO : last frame special case
    public final int getPlayerScore(String player) {
	int score = 0;
	Frame[] playerFrames = frames.get(player.equals("1") ? 0 : 1);
	FrameStatus previousFrameStatus = FrameStatus.NORMAL;
	
	for(int i = 0 ; i < 10 ; i++ ) {
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

}
