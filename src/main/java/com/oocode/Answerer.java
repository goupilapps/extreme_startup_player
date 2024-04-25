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
            return plus(question.split("\\?")[0]);
        }

        if (question.contains("multiplied by")) {
            return multiplied(question.split("\\?")[0]);
        }
        return "??";

    }


    private String largest(String q){
        return (String) Arrays.stream(q.split(":")[1].split(",")).map(String::trim).sorted(Comparator.comparingInt(i -> -Integer.parseInt(i))).toArray()[0];
    }

    private String plus(String q) {
        return Arrays.stream(q.substring(8, q.length()).split(" plus ")).map(Integer::parseInt).reduce(0, (integer, integer2) -> integer+integer2).toString();
    }

    private String multiplied(String q) {
        return Arrays.stream(q.substring(8, q.length()).split(" multiplied by ")).map(Integer::parseInt).reduce(1, (integer, integer2) -> integer*integer2).toString();
    }
}
