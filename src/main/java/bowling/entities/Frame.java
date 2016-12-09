package bowling.entities;

public class Frame {

    private int ball1;
    private int ball2;

    public Frame(int ball1, int ball2) {
	this.setBall1(ball1);
	this.setBall2(ball2);
    }

    public final int getBall1() {
	return ball1;
    }

    public final void setBall1(int ball1) {
	this.ball1 = ball1;
    }

    public final int getBall2() {
	return ball2;
    }

    public final void setBall2(int ball2) {
	this.ball2 = ball2;
    }

}
