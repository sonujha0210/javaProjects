package com.sjprogramming.quizapp;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Quiz q = new Quiz();
        q.logic();
    }
}

class Quiz {
    Scanner sc = new Scanner(System.in);
    int correctAnsCount = 0;
    int wrongAnsCount = 0;

    public void logic() {
        Questions q1 = new Questions("Which statement is true about Java?",
                "A. Java is a sequence-dependent programming language",
                "B. Java is a code dependent programming language",
                "C. Java is a platform-dependent programming language",
                "D. Java is a platform-independent programming language");

        Questions q2 = new Questions("What is the extension of java code files?",
                "A. .txt",
                "B. .pdf",
                "C. .sql",
                "D. .java");

        Questions q3 = new Questions("Who invented Java Programming?",
                "A. Guido van Rossum",
                "B. James Gosling",
                "C. Dennis Ritchie",
                "D. Bjarne Stroustrup");

        Questions q4 = new Questions("Which one of the following is not a Java feature?",
                "A. Object-oriented",
                "B. Use of pointers",
                "C. Portable",
                "D. Dynamic and Extensible");

        Questions q5 = new Questions("Which of these cannot be used for a variable name in Java?",
                "A. identifier & keyword",
                "B. identifier",
                "C. Keyword",
                "D. none of the mentioned");

        // Using LinkedHashMap to maintain insertion order
        Map<Questions, Character> hmap = new LinkedHashMap<>();
        hmap.put(q1, 'D');
        hmap.put(q2, 'D');
        hmap.put(q3, 'B');
        hmap.put(q4, 'B');
        hmap.put(q5, 'C');

        for (Map.Entry<Questions, Character> entry : hmap.entrySet()) {
            Questions question = entry.getKey();

            System.out.println(question.getQuestion());
            System.out.println(question.getOption1());
            System.out.println(question.getOption2());
            System.out.println(question.getOption3());
            System.out.println(question.getOption4());

            System.out.print("Enter Your Answer: ");
            // Convert user input to uppercase for case-insensitive comparison
            Character userAns = Character.toUpperCase(sc.next().charAt(0));
            Character correctAnswer = Character.toUpperCase(entry.getValue());

            if (userAns.equals(correctAnswer)) {
                System.out.println("Correct\n");
                correctAnsCount++;
            } else {
                System.out.println("Wrong\n");
                wrongAnsCount++;
            }
        }

        System.out.println("--------Result---------");
        System.out.println("Total Questions: " + hmap.size());
        System.out.println("Correct Answered Questions: " + correctAnsCount);
        System.out.println("Wrong Answered Questions: " + wrongAnsCount);
        int percentage = (100 * correctAnsCount) / hmap.size();
        System.out.println("Percentage: " + percentage + "%");

        if (percentage > 95) {
            System.out.println("Performance: Very Good");
        } else if (percentage < 35) {
            System.out.println("Performance: Very Low");
        } else {
            System.out.println("Performance: Medium");
        }
    }
}
