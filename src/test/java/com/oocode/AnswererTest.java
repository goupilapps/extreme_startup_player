package com.oocode;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AnswererTest {
    @Test
    public void canAnswerMyName() {
        var contents = new Answerer().answerFor("What is your name?");

        assertThat(contents, equalTo("dfiner"));
    }

    @Test
    public void canAnswerMyName1() {
        var contents = new Answerer().answerFor("Which of the following numbers is the largest: 22, 27, 8?");

        assertThat(contents, equalTo("27"));
    }

    @Test
    public void canAnswerMyName2() {
        var contents = new Answerer().answerFor("What is 18 plus 63?");

        assertThat(contents, equalTo("81"));
    }

    @Test
    public void canAnswerMyName5() {
        var contents = new Answerer().answerFor("What is 98 minus 84?");

        assertThat(contents, equalTo("14"));
    }

    @Test
    public void canAnswerMyName3() {
        var contents = new Answerer().answerFor("What is 75 multiplied by 51?");

        assertThat(contents, equalTo("3825"));
    }

    @Test
    public void canAnswerMyName4() {
        var contents = new Answerer().answerFor("Which of the following numbers is both a square and a cube: 4932, 729, 1000, 1681, 240, 1655, 2926?");

        assertThat(contents, equalTo("729"));
    }




}