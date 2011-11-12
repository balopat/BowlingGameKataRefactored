package com.balopat.katas;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class RollsTest {
	Rolls r;
	
	@Before
	public void createRolls() {
		r = new Rolls();
	}
	
	@Test
	public void shouldReturn0ForNonExistentRoll() throws Exception {
		assertThat(r.at(0),is(0));
	}
	
	@Test
	public void shouldReturn1WhenIRoll1Once() throws Exception {
		r.roll(1);
		assertThat(r.at(0),is(1));
	}
	
	@Test
	public void shouldBeEmptyWhenCreated() throws Exception {
		assertThat(r.isEmpty(),is(true));
	}
	
	@Test
	public void shouldNotBeEmptyWhenRolled() throws Exception {
		r.roll(1);
		assertThat(r.isEmpty(),is(false));
	}
	
	@Test
	public void countShouldBe0WhenCreated() throws Exception {
		assertThat(r.count(), is(0));
	}
	
	@Test
	public void countShouldBe1WhenRolled() throws Exception {
		r.roll(0);
		assertThat(r.count(), is(1));
	}

}
