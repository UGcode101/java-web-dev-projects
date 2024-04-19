package org.Launchcode;

import java.util.ArrayList;

public class CheckboxQuestion extends Question {
    private ArrayList<Integer> correctAnswerIndices;

    public CheckboxQuestion(String prompt, ArrayList<String> options, ArrayList<Integer> correctAnswerIndices) {
        super(prompt, options);
        this.correctAnswerIndices = correctAnswerIndices;
    }

    @Override
    public boolean checkAnswer(Object answer) {
        ArrayList<Integer> givenAnswers = (ArrayList<Integer>) answer;
        return givenAnswers.containsAll(correctAnswerIndices) && correctAnswerIndices.containsAll(givenAnswers);
    }
}