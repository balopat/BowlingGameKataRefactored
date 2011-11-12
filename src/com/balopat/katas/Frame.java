package com.balopat.katas;

public class Frame {
	Rolls rolls = new Rolls();
	
	public boolean isAllRollsUsed() {
		return twoRollsLessThen10() || isStrike() || isSpare();
	}

	public void roll(int pins) {
		if (isClosed()) {
			throw new IllegalStateException();
		}
		rolls.roll(pins);
	}
	
	public int score() {
		int score = 0;
		if (isStrike()) {
			score += 10 + strikeBonus();
		} else if (isSpare()) {
			score += 10 + spareBonus();
		} else {
			score += rolls.at(0) + rolls.at(1);
		}
		return score;
	}
	
	boolean isStrike() {
		return rolls.at(0) == 10;
	}

	boolean isSpare() {
		return rolls.at(0) + rolls.at(1) == 10;
	}

	int strikeBonus() {
		return rolls.at(1) + rolls.at(2);
	}

	int spareBonus() {
		return rolls.at(2);
	}
	
	public boolean isClosed() {
		if (rolls.isEmpty()) {
			return false;
		}
		return isStrikeWithBonuses() || isSpareWithBonuses() || twoRollsLessThen10();
	}

	private boolean isStrikeWithBonuses() {
		return (isStrike() && rolls.count() == 3);
	}

	private boolean twoRollsLessThen10() {
		return rolls.at(0) + rolls.at(1) < 10 && rolls.count() == 2;
	}

	private boolean isSpareWithBonuses() {
		return isSpare() && rolls.count() == 3;
	}
	
}
