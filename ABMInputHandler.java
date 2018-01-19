import java.util.Scanner;

public class ABMInputHandler {

    private Scanner io;
    private ABMInput input;

    public ABMInputHandler () {
        this.io = new Scanner(System.in);
        this.input = new ABMInput();
    }

    public ABMInput fetch () {
        this.input.fetchInput(this.io);
        return this.input;
    }
}
