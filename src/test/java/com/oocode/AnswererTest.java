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
}