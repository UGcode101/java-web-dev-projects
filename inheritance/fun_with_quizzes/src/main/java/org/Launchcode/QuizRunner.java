package org.Launchcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class QuizRunner {
    public static <Question> void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Quiz quiz = new Quiz();

        quiz.addQuestion(new MultipleChoiceQuestion(
                "What is the capital of France?",
                new ArrayList<>(Arrays.asList("London", "Berlin", "Paris", "Madrid")),
                3
        ));

        quiz.addQuestion(new CheckboxQuestion(
                "Select programming languages:",
                new ArrayList<>(Arrays.asList("Java", "English", "Python", "Spanish")),
                new ArrayList<>(Arrays.asList(1, 3))
        ));

        quiz.addQuestion(new TrueFalseQuestion(
                "The Earth is flat.",
                false
        ));

        for (org.Launchcode.Question question : quiz.getQuestions()) {
            question.equals();
            System.out.print("Your answer: ");
            if (question instanceof TrueFalseQuestion) {
                boolean userAnswer = scanner.nextLine().trim().equalsIgnoreCase("true");
                System.out.println(question.checkAnswer(userAnswer) ? "Correct!" : "Wrong!");
            } else if (question instanceof MultipleChoiceQuestion) {
                int userAnswer = Integer.parseInt(scanner.nextLine().trim());
                System.out.println(question.checkAnswer(userAnswer) ? "Correct!" : "Wrong!");
            } else if (question instanceof CheckboxQuestion) {
                String[] parts = scanner.nextLine().trim().split("\\s*,\\s*");
                ArrayList<Integer> userAnswers = new ArrayList<>();
                for (String part : parts) {
                    userAnswers.add(Integer.parseInt(part));
                }
                System.out.println(question.checkAnswer(userAnswers) ? "Correct!" : "Wrong!");
            }
            System.out.println();
        }
    }
}