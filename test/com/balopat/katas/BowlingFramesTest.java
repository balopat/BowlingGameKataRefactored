package com.balopat.katas;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BowlingFramesTest {

	
	@Test
	public void shouldHaveZeroScoresOnInitialization() throws Exception {
		BowlingFrames frames = new BowlingFrames();
		assertThat(frames.score(), is(0));
	}
	
	@Test
	public void shouldBeInStrikeStateAfterStrike(){
		
	}
}
