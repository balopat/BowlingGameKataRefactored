package com.balopat.katas;

public class Game {
	private Frame[] frames = new Frame[10];
	private int currentFrame = 0;

	public Game() {
		for (int i = 0; i < frames.length; i++) {
			frames[i] = new Frame();
		}
	}

	public int score() {
		int score = 0;
		for (Frame frame : frames) {
			score += frame.score();
		}
		return score;
	}

	public void roll(int pins) {
		stepFrame();
		rollOnOpenFrames(pins);
	}

	private void stepFrame() {
		if (frames[currentFrame].isAllRollsUsed() && !lastFrame()) {
			currentFrame++;
		}
	}

	private boolean lastFrame() {
		return currentFrame == frames.length-1;
	}

	private void rollOnOpenFrames(int pins) {
		for (int frameIndex = 0; frameIndex <= currentFrame; frameIndex++) {
			if (!frames[frameIndex].isClosed())
				frames[frameIndex].roll(pins);
		}
	}
}
