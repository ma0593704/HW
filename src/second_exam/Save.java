package second_exam;

public class Save implements Command {
    private Menu theMenu;

    public Save(Menu theMenu) {
        this.theMenu = theMenu;
    }

    @Override
    public void execute() {
        theMenu.Save();
    }
}
