package atmin_v5;

import atmin_v3.Command;
import java.util.List;

public class SleepModeCommand implements Command {
    private final List<Command> commands;

    public SleepModeCommand(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        System.out.println("[SleepMode]");
        System.out.println("""
                SleepMode: Tắt đèn
                SleepMode: Điều hòa set 28°C
                SleepMode: Quạt tốc độ thấp""");
        for (Command c : commands) {
            c.execute();
        }
    }

    @Override
    public void undo() {
        for (Command c : commands) {
            c.undo();
        }
    }
}
