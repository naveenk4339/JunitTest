package com.example.demo;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;

public class PrimeFactorsTest {

    @Test
    public void factor_of_1() {
        PrimeFactor factor = new PrimeFactor();

        assertThat(factor.getFactorOf(1), Is.is(Arrays.asList()));
    }

    @Test
    public void factor_of_2() {
        PrimeFactor factor = new PrimeFactor();

        assertThat(factor.getFactorOf(2), Is.is(Arrays.asList(2)));
    }

    @Test
    public void factor_of_3() {
        PrimeFactor factor = new PrimeFactor();

        assertThat(factor.getFactorOf(3), Is.is(Arrays.asList(3)));
    }

    @Test
    public void factor_of_4() {
        PrimeFactor factor = new PrimeFactor();

        assertThat(factor.getFactorOf(4), Is.is(Arrays.asList(2, 2)));
    }

    @Test
    public void factor_of_6() {
        PrimeFactor factor = new PrimeFactor();

        assertThat(factor.getFactorOf(6), Is.is(Arrays.asList(2, 3)));
    }


   @Test
    public void factor_of_8() {
        PrimeFactor factor = new PrimeFactor();

        assertThat(factor.getFactorOf(8), Is.is(Arrays.asList(2,2,2)));
    }

    @Test
    public void factor_of_9() {
        PrimeFactor factor = new PrimeFactor();

        assertThat(factor.getFactorOf(9), Is.is(Arrays.asList(3,3)));
    }
    @Test
    public void factor_of_12() {
        PrimeFactor factor = new PrimeFactor();

        assertThat(factor.getFactorOf(12), Is.is(Arrays.asList(2,2,3)));
    }

    @Test
    public void factor_of_15() {
        PrimeFactor factor = new PrimeFactor();

        assertThat(factor.getFactorOf(15), Is.is(Arrays.asList(3,5)));
    }
   @Test
    public void factor_of_X() {
        PrimeFactor factor = new PrimeFactor();

        assertThat(factor.getFactorOf(2*3*5*7*7),
                Is.is(Arrays.asList(2,3,5,7,7)));
    }

}
