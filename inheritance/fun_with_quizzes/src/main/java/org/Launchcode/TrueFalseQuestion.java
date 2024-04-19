package org.Launchcode;

import java.util.ArrayList;

public class TrueFalseQuestion extends Question {
    private boolean correctAnswer;

    public TrueFalseQuestion(String prompt, boolean correctAnswer) {
        super(prompt, new ArrayList<String>() {{
            add("True");
            add("False");
        }});
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean checkAnswer(Object answer) {
        return (Boolean) answer == correctAnswer;
    }
}