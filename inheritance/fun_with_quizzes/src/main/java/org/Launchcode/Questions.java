package org.Launchcode;

import java.util.ArrayList;
import java.util.Objects;

abstract class Question {
    protected String prompt;
    protected ArrayList<String> options;

    public Question(String prompt, ArrayList<String> options) {
        this.prompt = prompt;
        this.options = options;
    }

    public void display() {
        System.out.println(prompt);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    public abstract boolean checkAnswer(Object answer);

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Question question = (Question) obj;
        return Objects.equals(prompt, question.prompt) &&
                Objects.equals(options, question.options);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prompt, options);
    }

    public void equals() {
    }
}