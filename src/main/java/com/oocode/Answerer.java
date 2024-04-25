package com.oocode;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Answerer {
    public String answerFor(String question) {
        try {
            if (question.equals("What is your name?")) return "dfiner";

            if (question.startsWith("Which of the following numbers is the largest:")) {
                return largest(question.split("\\?")[0]);
            }

            if (question.contains("plus")) {
                return reverseplus(question.split("\\?")[0]);
            }

            if (question.contains("plus")) {
                return plus(question.split("\\?")[0]);
            }

            if (question.contains("minus")) {
                return minus(question.split("\\?")[0]);
            }

            if (question.contains("multiplied by") && !question.contains("plus")) {
                return multiplied(question.split("\\?")[0]);
            }

            if (question.startsWith("Which of the following numbers is both a square and a cube: ")) {
                return squarecube(question.split("\\?")[0]);
            }

            if (question.startsWith("Which of the following numbers are primes: ")) {
                return prime(question.split("\\?")[0]);
            }

            if (question.contains(" to the power of ")) {
                return power(question.split("\\?")[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "??";
        }



        return "??";

    }


    private String largest(String q){
        return (String) Arrays.stream(q.split(":")[1].split(",")).map(String::trim).sorted(Comparator.comparingInt(i -> -Integer.parseInt(i))).toArray()[0];
    }

    private String plus(String q) {
        return Arrays.stream(q.substring(8, q.length()).split(" plus ")).map(Integer::parseInt).reduce(0, (integer, integer2) -> integer+integer2).toString();
    }

    private String minus(String q) {
        return Arrays.stream(q.substring(8, q.length()).split(" minus ")).map(Integer::parseInt).reduce(0, (integer, integer2) -> -integer2-integer).toString();
    }


    private String multiplied(String q) {
        return Arrays.stream(q.substring(8, q.length()).split(" multiplied by ")).map(Integer::parseInt).reduce(1, (integer, integer2) -> integer*integer2).toString();
    }

    private String squarecube(String q) {
        return ((Arrays.stream(q.split(":")[1].split(",")).map(String::trim).filter(integer -> roo(Double.parseDouble(integer))).toArray()[0])).toString();
    }

    private Boolean roo(Double one) {
        return (Math.sqrt(one) - Math.round(Math.sqrt(one)) == 0) && (Math.cbrt(one) - Math.round(Math.cbrt(one)) == 0);
    }

    private String prime(String q) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293};
        var l = Arrays.stream(primes).boxed().toList();

        var v = Collectors.joining(", ");

        return Arrays.stream(q.split(":")[1].split(",")).map(String::trim).map(Integer::parseInt).filter(l::contains).map(integer -> String.valueOf(integer)).collect(v);
    }

    private String power(String q) {

        List<String> values = Arrays.stream(q.substring(8, q.length()).split(" to the power of ")).toList();
        BigInteger value = new BigInteger(values.get(0));
        return value.pow(Integer.parseInt(values.get(1))).toString();
    }

    private String reverseplus(String q) {
        var v = q.substring(8, q.length()).replace(" plus ", " + ").replace(" multiplied by ", " * ").split(" ");
        //var t = new ReversePolishNotation().calc(v);

        for (int i = 1; i < v.length-1; i=i+2) {
            String tmp = v[i];
            v[i] = v[i+1];
            v[i+1] = tmp;
        }
        return String.valueOf(evalRPN(v));
    }







    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<Integer>();
        int a=0,b=0;
        for(String s: tokens){

            if(s.equals("+")){
                a=st.pop();
                b=st.pop();
                st.push(a+b);
            }
            else if(s.equals("-")){
                a=st.pop();
                b=st.pop();
                st.push(b-a);
            }
            else if(s.equals("*")){
                a=st.pop();
                b=st.pop();
                st.push(a*b);
            }
            else if(s.equals("/")){
                a=st.pop();
                b=st.pop();
                st.push(b/a);
            }
            else {
                st.push(Integer.parseInt(s));
            }

        }
        return st.pop();
    }




    public int stacky(String[] tokens)
    {

        // Initialize the stack and the variable
        Stack<String> stack = new Stack<String>();
        int x, y;
        String result = "";
        int get = 0;
        String choice;
        int value = 0;
        String p = "";

        // Iterating to the each character
        // in the array of the string
        for (int i = 0; i < tokens.length; i++) {

            // If the character is not the special character
            // ('+', '-' ,'*' , '/')
            // then push the character to the stack
            if (tokens[i] != "+" && tokens[i] != "-"
                    && tokens[i] != "*" && tokens[i] != "/") {
                stack.push(tokens[i]);
                continue;
            }
            else {
                // else if the character is the special
                // character then use the switch method to
                // perform the action
                choice = tokens[i];
            }

            // Switch-Case
            switch (choice) {
                case "+":

                    // Performing the "+" operation by popping
                    // put the first two character
                    // and then again store back to the stack

                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = x + y;
                    result = p + value;
                    stack.push(result);
                    break;

                case "-":

                    // Performing the "-" operation by popping
                    // put the first two character
                    // and then again store back to the stack
                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = y - x;
                    result = p + value;
                    stack.push(result);
                    break;

                case "*":

                    // Performing the "*" operation
                    // by popping put the first two character
                    // and then again store back to the stack

                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = x * y;
                    result = p + value;
                    stack.push(result);
                    break;

                case "/":

                    // Performing the "/" operation by popping
                    // put the first two character
                    // and then again store back to the stack

                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = y / x;
                    result = p + value;
                    stack.push(result);
                    break;

                default:
                    continue;
            }
        }

        // Method to convert the String to integer
        return Integer.parseInt(stack.pop());
    }
}
