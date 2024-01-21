package com.example.triviaapptest;

public class TriviaList {

    String question;
    String answer;
    String a_Choice;
    String b_Choice;
    String c_Choice;
    String d_Choice;

    public TriviaList(String question, String answer, String a_Choice, String b_Choice, String c_Choice, String d_Choice) {
        this.question = question;
        this.answer = answer;
        this.a_Choice = a_Choice;
        this.b_Choice = b_Choice;
        this.c_Choice = c_Choice;
        this.d_Choice = d_Choice;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getA_Choice() {
        return a_Choice;
    }

    public String getB_Choice() {
        return b_Choice;
    }

    public String getC_Choice() {
        return c_Choice;
    }

    public String getD_Choice() {
        return d_Choice;
    }

    @Override
    public String toString() {
        return "TriviaList{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", a_Choice='" + a_Choice + '\'' +
                ", b_Choice='" + b_Choice + '\'' +
                ", c_Choice='" + c_Choice + '\'' +
                ", d_Choice='" + d_Choice + '\'' +
                '}';
    }
}

