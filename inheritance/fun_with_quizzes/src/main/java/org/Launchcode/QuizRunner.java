package org.Launchcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class QuizRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Quiz quiz = new Quiz();

        quiz.addQuestion(new MultipleChoiceQuestion(
                "What is the capital of France?",
                new ArrayList<>(Arrays.asList("London", "Berlin", "Paris", "Madrid")),
                2 // Correct index for Paris
        ));

        quiz.addQuestion(new CheckboxQuestion(
                "Select programming languages (enter indices separated by commas, e.g., 1, 3):",
                new ArrayList<>(Arrays.asList("Java", "English", "Python", "Spanish")),
                new ArrayList<>(Arrays.asList(0, 2)) // Java and Python
        ));

        quiz.addQuestion(new TrueFalseQuestion(
                "The Earth is flat. (true/false)",
                false
        ));

        runQuiz(scanner, quiz);
        scanner.close();
    }

    private static void runQuiz(Scanner scanner, Quiz quiz) {
        for (Question question : quiz.getQuestions()) {
            question.display();
            try {
                System.out.print("Your answer: ");
                boolean isCorrect = processAnswer(scanner, question);
                System.out.println(isCorrect ? "Correct!" : "Wrong!");
            } catch (Exception e) {
                System.out.println("Invalid input: " + e.getMessage());
                System.out.println("Please try again.");
            }
            System.out.println();
        }
    }

    private static boolean processAnswer(Scanner scanner, Question question) {
        if (question instanceof TrueFalseQuestion) {
            boolean userAnswer = scanner.nextLine().trim().equalsIgnoreCase("true");
            return question.checkAnswer(userAnswer);
        } else if (question instanceof MultipleChoiceQuestion) {
            int userAnswer = Integer.parseInt(scanner.nextLine().trim()) - 1;
            return question.checkAnswer(userAnswer);
        } else if (question instanceof CheckboxQuestion) {
            String[] parts = scanner.nextLine().trim().split("\\s*,\\s*");
            List<Integer> userAnswers = new ArrayList<>();
            for (String part : parts) {
                userAnswers.add(Integer.parseInt(part.trim()) - 1);
            }
            return question.checkAnswer(userAnswers);
        }
        return false;
    }
}
