package com.oocode;

import java.util.Arrays;
import java.util.Comparator;

public class Answerer {
    public String answerFor(String question) {
        if (question.equals("What is your name?")) return "dfiner";

        if (question.startsWith("Which of the following numbers is the largest:")) {
            return largest(question);
        }
        return "??";

    }

    private String largest(String q){
        return Arrays.stream(q.split(":")[1].split(",")).map(String::trim).max(Comparator.comparingInt(value -> -Integer.parseInt(value))).get();
    }
}
