package huichan.kr.main;

import java.util.Scanner;

import huichan.kr.main.query.Query;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cursor = "> ";
        Query question = new Query();

        while (true) {
            System.out.print(cursor);
            question.insertQuery(sc.nextLine());

            if (question.getHead().equals("quit")) { 
                System.out.println("bye");
                break;
            }

            question.send();
            cursor = question.useDB == null ? "> " : "[" + question.useDB + "]" + " > ";
        }
    }
}
