package com.example.demo;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FizzBuzzTest {

    @Test
    public void when_zero() {

        assertThat(FizzBuzz.get(0),is("0"));
    }

    @Test
    public void when_three() {

        assertThat(FizzBuzz.get(3),is("FIZZ"));
    }


    @Test
    public void when_5() {

        assertThat(FizzBuzz.get(5),is("BUZZ"));
    }

    @Test
    public void when_6() {

        assertThat(FizzBuzz.get(6),is("FIZZ"));
    }
    @Test
    public void when_10() {

        assertThat(FizzBuzz.get(10),is("BUZZ"));
    }
}
