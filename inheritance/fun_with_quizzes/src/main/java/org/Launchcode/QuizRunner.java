package org.Launchcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class QuizRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Quiz quiz = new Quiz();

        // Correctly creating and adding a multiple-choice question
        quiz.addQuestion(new MultipleChoiceQuestion(
                "What is the capital of France?",
                new ArrayList<>(Arrays.asList("London", "Berlin", "Paris", "Madrid")),
                2 // Index starts at 0; thus, Paris is at index 2
        ));

        quiz.addQuestion(new CheckboxQuestion(
                "Select programming languages:",
                new ArrayList<>(Arrays.asList("Java", "English", "Python", "Spanish")),
                new ArrayList<>(Arrays.asList(0, 2)) // Correct indices for Java and Python
        ));

        quiz.addQuestion(new TrueFalseQuestion(
                "The Earth is flat.",
                false
        ));

        // Iterating over questions and processing answers
        for (Question question : quiz.getQuestions()) {
            question.display();  // Corrected from question.equals() to display the question
            System.out.print("Your answer: ");
            if (question instanceof TrueFalseQuestion) {
                boolean userAnswer = scanner.nextLine().trim().equalsIgnoreCase("true");
                System.out.println(question.checkAnswer(userAnswer) ? "Correct!" : "Wrong!");
            } else if (question instanceof MultipleChoiceQuestion) {
                int userAnswer = Integer.parseInt(scanner.nextLine().trim()) - 1; // Assuming user enters 1-based index
                System.out.println(question.checkAnswer(userAnswer) ? "Correct!" : "Wrong!");
            } else if (question instanceof CheckboxQuestion) {
                String[] parts = scanner.nextLine().trim().split("\\s*,\\s*");
                ArrayList<Integer> userAnswers = new ArrayList<>();
                for (String part : parts) {
                    userAnswers.add(Integer.parseInt(part) - 1); // Assuming user enters 1-based index
                }
                System.out.println(question.checkAnswer(userAnswers) ? "Correct!" : "Wrong!");
            }
            System.out.println(); // Adds a blank line for better readability between questions
        }

        scanner.close(); // Close the scanner to free resources
    }
}