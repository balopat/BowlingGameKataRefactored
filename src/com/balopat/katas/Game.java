package com.balopat.katas;

public class Game {

	private Frame[] frames = new Frame[10];
	private int currentFrame = 0;

	
	public int score() {
		int score = 0;
		for (Frame frame : frames) {
			score += frame.score();
		}
		return score;
	}
	
	
	public void roll(int pins) {
		openNewFrameIfNecessary();
		rollOnActiveFrames(pins);
	}
	
	private void openNewFrameIfNecessary() {
		if (frames[currentFrame] == null) {
			frames[currentFrame] = new Frame();
		}
		if (currentFrame < 9 && frames[currentFrame].isAllRollsUsed()) {
			frames[++currentFrame] = new Frame();
		}
	}

	private void rollOnActiveFrames(int pins) {
		for (Frame frame : frames) {
			if (frame != null && !frame.isClosed()) {
				frame.roll(pins);
			}
		}
	}

}
