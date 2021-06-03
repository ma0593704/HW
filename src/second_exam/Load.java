package second_exam;

public class Load implements Command {
    private Menu theMenu;


    public Load(Menu theMenu) {
        this.theMenu = theMenu;
    }

    @Override
    public void execute() {
        theMenu.Load();
    }
}
