package org.Launchcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Question> questions;
    private Scanner scanner;

    public Quiz() {
        this.questions = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    // Method to retrieve the list of questions
    public List<Question> getQuestions() {
        return this.questions;  // returns a reference to the list of questions
    }

    public void runQuiz() {
        int score = 0;
        for (Question question : questions) {
            question.display();
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();
            if (question.checkAnswer(userAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect.");
            }
        }
        System.out.println("You scored " + score + " out of " + questions.size());
        scanner.close();
    }
}
