package atmin_v3;

public class RemoteControl {
    private final Command c;

    public RemoteControl(Command c) {
        this.c = c;
    }

    public void press() {
        c.execute();
    }

    public void pressUndo() {
        c.undo();
    }

}
