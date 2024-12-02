package main;

import menu.MainMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        Scanner sc = new Scanner(System.in);
        while(true){
            menu.displayMenu();
            System.out.println("Write your option: ");
            String command = sc.nextLine();
            menu.executeCommand(command);
        }
    }
}