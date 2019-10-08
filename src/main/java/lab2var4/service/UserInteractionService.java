package lab2var4.service;

import lab2var4.exeptions.ErrorInputExceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

class UserInteractionService {

    private static final String PATH = ".\\src\\main\\resources\\Text";
    private Scanner scanner = new Scanner(System.in);


    void showMessage(String message) {
        System.out.printf("\n**************************************************\n%s" +
                "\n**************************************************\n", message);
    }

    void outputResult(String message) {
        System.out.println(message);
    }

    int getUserInput(String message, int max) {
        System.out.printf("\n%s\n", message);
        int i;
        while (true) {
            i = Integer.parseInt(scanner.next());
            try {
                validateInput(i, max);
                break;
            } catch (ErrorInputExceptions e) {
                showMessage(e.getMessage());
            }
        }
        return i;
    }

    private void validateInput(int input, int max) {
        if (input <= 0 || input > max)
            throw new ErrorInputExceptions();
    }


    String readUsingFiles(int input) {
        try {
            return new String(Files.readAllBytes(Paths.get(PATH + input)));
        } catch (IOException e) {
            e.getMessage();
        }
        return "";
    }

}
