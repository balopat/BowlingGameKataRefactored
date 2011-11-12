package com.balopat.katas;

import java.util.ArrayList;
import java.util.List;

public class Rolls {

	List<Integer> rolls = new ArrayList<Integer>();

	public void roll(int pins) {
		rolls.add(pins);
	}
	public int at(int i) {
		return rolls.size() <= i 
					?0 
					:rolls.get(i);
	}
	public int count() {
		return rolls.size();
	}
	public boolean isEmpty() {
		return rolls.isEmpty();
	}
}
