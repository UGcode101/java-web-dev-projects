package org.Launchcode;

import org.Launchcode.Question;
import java.util.ArrayList;
import java.util.List;

public class CheckboxQuestion extends Question {
    private List<Integer> correctAnswerIndices;

    public CheckboxQuestion(String prompt, ArrayList<String> options, ArrayList<Integer> correctAnswerIndices) {
        super(prompt, options);
        validateCorrectAnswerIndices(correctAnswerIndices, options.size());
        this.correctAnswerIndices = new ArrayList<>(correctAnswerIndices);
    }

    private void validateCorrectAnswerIndices(ArrayList<Integer> indices, int optionsSize) {
        for (Integer index : indices) {
            if (index == null || index < 0 || index >= optionsSize) {
                throw new IllegalArgumentException("Each index must be within the valid range of options.");
            }
        }
    }

    @Override
    public boolean checkAnswer(Object answer) {
        if (!(answer instanceof List)) {
            throw new IllegalArgumentException("Answer must be a list of integers.");
        }

        List<?> answerList = (List<?>) answer;
        List<Integer> userAnswers = new ArrayList<>();
        for (Object obj : answerList) {
            if (!(obj instanceof Integer)) {
                throw new IllegalArgumentException("All elements of the answer list must be integers.");
            }
            userAnswers.add((Integer) obj);
        }

        return userAnswers.containsAll(correctAnswerIndices) && correctAnswerIndices.containsAll(userAnswers);
    }
}