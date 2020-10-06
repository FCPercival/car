package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;

public class GearOOP {

    /*
     * Gear -1 -> Retro
     * Gear 0 -> Folle
     * Gear 1 -> Prima
     * Gear 2 -> Seconda
     * Gear 3 -> Terza
     * Gear 4 -> Quarta
     * Gear 5 -> Quinta
     * Gear 6 -> Sesta
     */

    private short gear=0;
    private int giri=0;
    private int velocità=0;
    private final int maxVelocità=250;
    private final int maxGiri=5000;
    private final int threshold=4300;
    private final String misuraVelocità="Km/h";
    private final String misuraGiri="RPM";

    public String getMisuraGiri() {
        return misuraGiri;
    }

    public int getMaxGiri() {
        return maxGiri;
    }


    public void setGiri(int giri) {
        this.giri = giri;
    }
    public void setVelocità(int velocità) {
        this.velocità = velocità;
    }

    public String getMisuraVelocità() {
        return misuraVelocità;
    }

    public int getGiri() {
        return giri;
    }
    public int getMaxVelocità() {
        return maxVelocità;
    }

    public int getVelocità() {
        return velocità;
    }

    public short getGear() {
        return gear;
    }

    public void setGear(short gear) {
        if ((this.gear== -1 && gear== -2) || (this.gear == 6 && gear==7)){
            return;}

        this.gear = gear;

    }
}
