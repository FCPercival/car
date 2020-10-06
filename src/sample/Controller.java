package sample;

import eu.hansolo.medusa.Gauge;
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
    @FXML
    Gauge ui_p_giri;
    @FXML
    Gauge ui_p_velocità;


    protected GearOOP gearOOP=new GearOOP();

    public void gearUp(){
        if ((gearOOP.getGear() == 6 && gearOOP.getGear()+1==7)){ui_giri.setStyle("-fx-background-color: black");
            return;}

        gearOOP.setGear((short) (gearOOP.getGear()+1));
        ui_t_marcia.setText(String.valueOf(gearOOP.getGear()));
        System.out.println(gearOOP.getGear());

        //ui_giri.setProgress(0.2);
        gearOOP.setGiri(2000);
        try {
            ui_p_giri.setValue(gearOOP.getGiri());
        }catch (NullPointerException npe){
            System.out.println(npe);
        }

        //ui_p_giri.setValue(2000);
        //VAL DA CAMBIARE SET OOP
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
                if(!ui_b_velocità.isPressed() || gearOOP.getVelocità() >= gearOOP.getMaxVelocità()-11 || gearOOP.getGiri()>=gearOOP.getMaxGiri()-120) /*|| ui_velocità.getProgress()>=0.999999 ||ui_giri.getProgress()>=0.999999*/
                    return;

                //System.out.println(ui_velocità.getProgress() + 0.01);
                //ui_velocità.setProgress(ui_velocità.getProgress() + 0.01);
                //System.out.println(ui_p_velocità.getValue());

                gearOOP.setGiri(gearOOP.getGiri() + 75);

                //ui_p_giri.setValue(ui_p_giri.getValue() + 25);
                //ui_p_velocità.setValue(ui_p_velocità.getValue() + 0.4);

                gearOOP.setVelocità(gearOOP.getVelocità() + 1);



                try {
                    ui_p_giri.setValue(gearOOP.getGiri());
                }catch (NullPointerException npe){
                    System.out.println(npe);
                    continue;
                }
                try {
                    ui_p_velocità.setValue(gearOOP.getVelocità());
                }catch (NullPointerException npe){
                    System.out.println(npe);
                    continue;
                }

                //ui_giri.setProgress(ui_giri.getProgress() + 0.065);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e);
                    continue;
                }


                //ui_t_velocità.setText(String.valueOf(Math.round(ui_velocità.getProgress()*gearOOP.getMaxVelocità()))+" "+gearOOP.getMisuraVelocità());
                //ui_t_giri.setText(String.valueOf(Math.round(ui_giri.getProgress()*gearOOP.getMaxGiri()))+" "+gearOOP.getMisuraGiri());
//*Vecchio codice
//try {
//                    if(!ui_b_velocità.isPressed() || ui_p_velocità.getValue() >= gearOOP.getMaxVelocità()-11 || ui_p_giri.getValue()>=gearOOP.getMaxGiri()-120){ /*|| ui_velocità.getProgress()>=0.999999 ||ui_giri.getProgress()>=0.999999*/
//                return;}
//        } catch (NullPointerException e) {
//            System.out.println("NullPointerException");
//            continue;
//        }
//
//
//        //System.out.println(ui_velocità.getProgress() + 0.01);
//        //ui_velocità.setProgress(ui_velocità.getProgress() + 0.01);
//        //System.out.println(ui_p_velocità.getValue());
//        try {
//            ui_p_giri.setValue(ui_p_giri.getValue() + 25);
//        } catch (NullPointerException e) {
//            continue;
//        }
//        //ui_p_giri.setValue(ui_p_giri.getValue() + 25);
//        //ui_p_velocità.setValue(ui_p_velocità.getValue() + 0.4);
//        try {
//            ui_p_velocità.setValue(ui_p_velocità.getValue() + 0.4);
//        } catch (NullPointerException e) {
//            continue;
//        }
//
//
//        //ui_giri.setProgress(ui_giri.getProgress() + 0.065);
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            System.out.println(e);
//        }
//
//        ui_t_velocità.setText(String.valueOf(Math.round(ui_velocità.getProgress()*gearOOP.getMaxVelocità()))+" "+gearOOP.getMisuraVelocità());
//        ui_t_giri.setText(String.valueOf(Math.round(ui_giri.getProgress()*gearOOP.getMaxGiri()))+" "+gearOOP.getMisuraGiri());


            }




        }).start();
    }
    public void infoBox(){
        sample.InfoBox.display("Info","Car project developed by Federico Chiodo, in collaboration with armor293");


    }

    public void exit(){
        System.exit(0);
    }

    public void initialize(){
        //System.out.println("fatto");
        

    }


}
