package org.Launchcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Question> questions = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void runQuiz() {
        for (Question question : questions) {
            question.display();
            System.out.print("Your answer: ");
            String input = scanner.nextLine();
            Object answer = parseAnswer(question, input);
            if (question.checkAnswer(answer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong!");
            }
        }
    }

    private Object parseAnswer(Question question, String input) {
        if (question instanceof TrueFalseQuestion) {
            return input.trim().equalsIgnoreCase("true");
        } else if (question instanceof MultipleChoiceQuestion || question instanceof CheckboxQuestion) {
            if (question instanceof MultipleChoiceQuestion) {
                return Integer.parseInt(input.trim()) - 1; // Assuming user input is 1-indexed
            } else {
                String[] parts = input.trim().split("\\s*,\\s*");
                ArrayList<Integer> userAnswers = new ArrayList<>();
                for (String part : parts) {
                    userAnswers.add(Integer.parseInt(part) - 1); // Assuming user input is 1-indexed
                }
                return userAnswers;
            }
        }
        return null;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}