package lab2var4.exeptions;

public class ErrorInputExceptions extends RuntimeException {
    public ErrorInputExceptions() {
        super("THE ANSWER IS NOT CORRECT!\nBe more careful when typing!\n");
    }
}
