package hwork6;

public class Mouse {
    private int speedM = 0;

    public Mouse(int speedM) {
        setSpeedM(speedM);
    }

    public int getSpeedM() {
        return speedM;
    }

    public void setSpeedM(int speedM) {
        if (speedM < 0) throw new IllegalArgumentException("Отрицательная скорость");
        this.speedM = speedM;
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "speed=" + speedM +
                '}';
    }
}
