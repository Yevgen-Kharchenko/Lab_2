package lab2var4;

import lab2var4.service.MainService;

import java.io.IOException;


public class App {

    private final MainService mainService;

    public App() {
        mainService = new MainService();
    }

    private void run() {
        mainService.doSeparation();
    }

    public static void main(String[] args) throws IOException {
        App app = new App();
        app.run();
    }


}
