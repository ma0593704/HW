package hwork6;

public class App {
    public static void main(String[] args) {
        Mouse mouse1 = new Mouse(3);
        Mouse mouse2 = new Mouse(5);
        Mouse mouse3 = new Mouse(1);
        Cat cat1 = new Cat("Борис", 2, 5, 3);
        cat1.addMouse(mouse1);
        cat1.addMouse(mouse2);
        cat1.addMouse(mouse3);
        Cat cat2 = new Cat("Петя", 4, 15, 3);
        cat2.addMouse(mouse1);
        cat2.addMouse(mouse2);
        cat2.addMouse(mouse3);
        System.out.println(cat1);
        System.out.println(cat2);
    }


}
