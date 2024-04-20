package org.Launchcode;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Question {
    protected String prompt;
    protected ArrayList<String> options;

    // Constructor for initializing with prompt and options
    public Question(String prompt, ArrayList<String> options) {
        if (prompt == null || options == null || options.isEmpty()) {
            throw new IllegalArgumentException("Prompt and options must not be null or empty.");
        }
        this.prompt = prompt;
        this.options = options;
    }

    // Display method to show the question and options
    public void display() {
        System.out.println(prompt);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    // Abstract method to be implemented by subclasses to check if the given answer is correct
    public abstract boolean checkAnswer(Object answer);

    // Overriding equals to compare questions based on prompt and options
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Question question = (Question) obj;
        return Objects.equals(prompt, question.prompt) &&
                Objects.equals(options, question.options);
    }

    // Overriding hashCode in accordance with equals
    @Override
    public int hashCode() {
        return Objects.hash(prompt, options);
    }
}