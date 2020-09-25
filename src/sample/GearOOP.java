package sample;


public class GearOOP {

    private short gear=1;
    private int giri=0;
    private int velocità=0;


    public GearOOP(short gear, int giri, int velocità) {
        this.gear = gear;
        this.giri = giri;
        this.velocità = velocità;
    }

    public int getGiri() {
        return giri;
    }

    public int getVelocità() {
        return velocità;
    }

    public short getGear() {
        return gear;
    }

    public void setGear(short gear) {
        this.gear = gear;
    }
}
