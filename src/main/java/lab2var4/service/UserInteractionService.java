package lab2var4.service;

import lab2var4.exeptions.ErrorInputExceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class UserInteractionService {

    private Scanner scanner = new Scanner(System.in);


    public void showMessage(String message) {
        System.out.printf("\n**************************************************\n%s" +
                "\n**************************************************\n", message);
    }

    public void outputResult(String message) {
        System.out.println(message);
    }

    public int getUserInput(String message, int max) {
        System.out.printf("\n%s\n", message);
        int i;
        while (true) {
            i = Integer.parseInt(scanner.next());
            try {
                validateInput(i, max);
                break;
            } catch (RuntimeException e) {
                showMessage(e.getMessage());
            }
        }
        return i;
    }

    private void validateInput(int input, int max) {
        if (input <= 0 || input > max)
            throw new ErrorInputExceptions();
    }


    public String readUsingFiles(int input) throws IOException {
        return new String(Files.readAllBytes(Paths.get(".\\src\\main\\resources\\Text" + input)));
    }

}
