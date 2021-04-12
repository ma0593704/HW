package hwork8;

public class HoumeA extends Animals {
    private String name;
    private int health;
    private boolean flag;
    private String quantityR;

    public HoumeA(String name, int ves, int speed, int health, boolean flag, String quantityR) {
        super(ves, speed);
        this.name = name;
        this.health = health;
        this.flag = flag;
        this.quantityR = quantityR;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void plusHealth() {
        if (!isAlive()) return;
        health += Settings.HEALTH_HOUSEA;
        health = Math.min(health + Settings.HEALTH_HOUSEA, 10);
    }

    public void minusHealth(int count) {
        if (!isAlive()) return;
        health -= count;
    }

    //public static HoumeA getHouseA() {
   //     String[] animals = {"Корова", "Кот", "Заяц", "Курица"};
    //    HoumeA houme = null;
    //}
}
