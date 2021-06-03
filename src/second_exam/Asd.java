package second_exam;

public class Asd {
    private Command startCommand;
    private Command loadCommand;
    private Command saveCommand;
    private Command exitCommand;

    public Asd(Command startCommand, Command loadCommand, Command saveCommand, Command exitCommand) {
        this.startCommand = startCommand;
        this.loadCommand = loadCommand;
        this.saveCommand = saveCommand;
        this.exitCommand = exitCommand;
    }

    public void start() {
        startCommand.execute();
    }

    public void load() {
        loadCommand.execute();
    }

    public void save() {
        saveCommand.execute();
    }

    public void exit() {
        exitCommand.execute();
    }
}
