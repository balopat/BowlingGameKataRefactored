package com.balopat.katas;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FrameTest {
	Frame f;

	@Before
	public void createFrame() {
		f = new Frame();
	}

	@Test
	public void emptyFrameShouldNotBeClosed() throws Exception {
		assertThat(f.isClosed(), is(false));
	}

	@Test
	public void shouldReturnStrikeForStrikeRollIndex() {
		f.roll(10);
		assertThat(f.isStrike(), is(true));
	}


	@Test
	public void isStrikeShouldReturnFalseForNonStrikeRollIndex() {
		f.roll(4);
		assertThat(f.isStrike(), is(false));
	}


	@Test
	public void isSpareShouldReturnTrueForSpareRollIndex() {
		f.roll(5);
		f.roll(5);
		assertThat(f.isSpare(), is(true));
	}



	@Test
	public void strikeBonusShouldBe0WhenNothingHasBeenRolledAfterStrike() {
		rollStrike();
		assertThat(f.strikeBonus(), is(0));
	}

	@Test
	public void shouldBeClosedAfterTwoNonSpecials() throws Exception {
		f.roll(0);
		f.roll(2);
		assertThat(f.isClosed(), is(true));
	}

	@Test
	public void shouldNotBeClosedAfterOneNonSpecial() throws Exception {
		f.roll(0);
		assertThat(f.isClosed(), is(false));
	}

	@Test
	public void shouldNotBeClosedAfterStrike() throws Exception {
		f.roll(10);
		assertThat(f.isClosed(), is(false));
	}

	@Test
	public void shouldNotBeClosedAfterStrikeAndTheFirstNonStrikeRoll()
			throws Exception {
		f.roll(10);
		f.roll(3);
		assertThat(f.isClosed(), is(false));
	}

	@Test
	public void shouldNotBeClosedAfterStrikeAndTheFirstStrike() throws Exception {
		f.roll(10);
		f.roll(10);
		assertThat(f.isClosed(), is(false));
	}

	@Test
	public void shouldBeClosedAfterStrikeAndTheBonuses() throws Exception {
		f.roll( 10);
		f.roll( 5);
		f.roll( 2);
		assertThat(f.isClosed(), is(true));
	}

	@Test
	public void shouldBeClosedAfterSpareAndTheFirstBonus() throws Exception {
		f.roll(5);
		f.roll(5);
		f.roll(2);
		assertThat(f.isClosed(), is(true));
	}

	@Test
	public void shouldNotBeClosedAfterSpare() throws Exception {
		f.roll(5);
		f.roll(5);
		assertThat(f.isClosed(), is(false));
	}

	@Test(expected = IllegalStateException.class)
	public void rollShouldFailAfterClosed() throws Exception {
		f.roll(10);
		f.roll(10);
		f.roll(2);
		f.roll(3);
	}

	private void rollStrike() {
		f.roll(10);
	}

}
