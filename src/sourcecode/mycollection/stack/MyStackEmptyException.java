package sourcecode.mycollection.stack;

public class MyStackEmptyException extends Exception {

    String message;

    public MyStackEmptyException() {
        this.message = "Stack is already Empty, so cannot perform Pop operation";
        ;
    }

    public String getMessage() {
        return this.message;
    }
}
