package org.Launchcode;

import java.util.ArrayList;

public class MultipleChoiceQuestion extends Question {
    private final int correctAnswerIndex;  // Index of the correct answer in the options list

    public MultipleChoiceQuestion(String prompt, ArrayList<String> options, int correctAnswerIndex) {
        super(prompt, options);  // Initialize the superclass (Question) fields
        this.correctAnswerIndex = correctAnswerIndex;  // Set the index of the correct answer
    }

    @Override
    public boolean checkAnswer(Object answer) {
        if (!(answer instanceof Integer)) {
            return false;  // Ensures the answer is of the correct type (Integer)
        }
        return (Integer) answer == correctAnswerIndex;  // Check if the answer matches the correct index
    }
}