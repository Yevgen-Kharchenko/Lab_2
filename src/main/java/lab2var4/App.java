package lab2var4;

import java.io.IOException;

public class App {


    public static void main(String[] args) throws IOException {
        App app = new App();
        app.setParameters(new UserInteractionService());
    }

    private void setParameters(UserInteractionService userInteractionService) throws IOException {
        int input = userInteractionService.getUserInput("Select the file to scan 1/2", 2);
        userInteractionService.showMessage("Your number is " + input);
        String contents = userInteractionService.readUsingFiles(input);
        System.out.println(contents);

    }

}
