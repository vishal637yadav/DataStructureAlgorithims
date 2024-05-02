package sourcecode.mycollection.stack;

public class MyStackFullException extends Exception {
    String message;

    public MyStackFullException() {
        this.message = "Stack is already full, so cannot perform Push operation";
    }

    public String getMessage() {
        return this.message;
    }
}
