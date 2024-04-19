package org.Launchcode;

import java.util.ArrayList;

public class MultipleChoiceQuestion extends Question {
    private final int correctAnswerIndex;

    public MultipleChoiceQuestion(String prompt, ArrayList<String> options, int correctAnswerIndex) {
        super(prompt, options);
        this.correctAnswerIndex = correctAnswerIndex;
    }

    @Override
    public boolean checkAnswer(Object answer) {
        return ((Integer) answer == correctAnswerIndex);
    }
}
