package com.oocode;

import java.util.Arrays;
import java.util.Comparator;

public class Answerer {
    public String answerFor(String question) {
        if (question.equals("What is your name?")) return "dfiner";

        if (question.startsWith("Which of the following numbers is the largest:")) {
            return largest(question.split("\\?")[0]);
        }

        if (question.contains("plus")) {
            return plus(question);
        }
        return "??";

    }


    private String largest(String q){
        return (String) Arrays.stream(q.split(":")[1].split(",")).map(String::trim).sorted(Comparator.comparingInt(i -> -Integer.parseInt(i))).toArray()[0];
    }

    private String plus(String q) {
        return "";
    }
}
