package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;

public class Controller extends Thread{

    @FXML
    public ProgressBar ui_giri;
    @FXML
    ProgressBar ui_velocità;
    @FXML
    Button ui_b_velocità;
    @FXML
    Text ui_t_velocità;
    @FXML
    Text ui_t_giri;
    @FXML
    Text ui_t_marcia;


    protected GearOOP gearOOP=new GearOOP();

    public void gearUp(){
        if ((gearOOP.getGear() == 6 && gearOOP.getGear()+1==7)){ui_giri.setStyle("-fx-background-color: black");
            return;}

        gearOOP.setGear((short) (gearOOP.getGear()+1));
        ui_t_marcia.setText(String.valueOf(gearOOP.getGear()));
        System.out.println(gearOOP.getGear());
        ui_giri.setProgress(0.2);
    }
    public void gearDown(){
        if((gearOOP.getGear()== -1 && (gearOOP.getGear()-1)== -2)){
            ui_giri.setStyle("-fx-background-color: black");
            return;
        }

        gearOOP.setGear((short) (gearOOP.getGear()-1));
        System.out.println(gearOOP.getGear());
        ui_t_marcia.setText(String.valueOf(gearOOP.getGear()));
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

                ui_t_velocità.setText(String.valueOf(Math.round(ui_velocità.getProgress()*gearOOP.getMaxVelocità()))+" "+gearOOP.getMisuraVelocità());
                ui_t_giri.setText(String.valueOf(Math.round(ui_giri.getProgress()*gearOOP.getMaxGiri()))+" "+gearOOP.getMisuraGiri());


            }




        }).start();
    }
    public void infoBox(){
        sample.InfoBox.display("Info","Car project developed by a fork of armor293");
    }

    public void initialize(){
        //System.out.println("fatto");


    }


}
