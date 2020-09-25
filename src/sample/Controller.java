package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;

public class Controller extends Thread{

    @FXML
    public ProgressBar ui_giri;
    @FXML
    ProgressBar ui_velocità;
    @FXML
    Button ui_b_velocità;


    protected GearOOP gearOOP=new GearOOP();

    public void gearUp(){
        ui_giri.setStyle("-fx-background-color: black");
        gearOOP.setGear((short) (gearOOP.getGear()+1));
        System.out.println(gearOOP.getGear());
    }
    public void gearDown(){
        gearOOP.setGear((short) (gearOOP.getGear()-1));
        System.out.println(gearOOP.getGear());
    }
    public void speedUp(){
        new Thread(() -> {
            while (true){
                if(!ui_b_velocità.isPressed() || ui_velocità.getProgress()>=0.999999 ||ui_giri.getProgress()>=0.999999)
                    return;
                System.out.println(ui_velocità.getProgress() + 0.01);
                ui_velocità.setProgress(ui_velocità.getProgress() + 0.01);
                ui_giri.setProgress(ui_giri.getProgress() + 0.065);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }




        }).start();
    }

    public void initialize(){
        //System.out.println("fatto");


    }


}
