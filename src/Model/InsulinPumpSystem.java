/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Esper.configs;
//import Events.bloodreading;
//import Events.pump;
import Events.pumpstate;
//import Events.reservoir;
//import Events.glucosesensor;
import View.GUI;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.InsulinDose;
import Model.insulinresrvoir;
import Model.pump;
import Model.sensor;
import Model.screen;
/**
 *
 * @author Lenovo
 */
public class InsulinPumpSystem {
    private GUI gui;
    
    
    private boolean pumppstate= false;
    
    private InsulinDose dose;
    private insulinresrvoir reservoir;
    private pump p;
    private sensor sen;
    private pumpwarning warn;
    private PumpState s;

    public InsulinPumpSystem(InsulinDose dose, sensor sen) {
        this.dose = dose;
        this.sen = sen;
    }
    
   
    
    
    public InsulinPumpSystem (){
        gui = new GUI();
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
        
        dose =new InsulinDose(this);
        reservoir= new insulinresrvoir (this);
        p = new pump (this);
        sen = new sensor (this);
        warn =new pumpwarning();
        sen.start();
    }
    
    public boolean isSystemOn(){
    return pumppstate;
    }
    public void SugarMeasure(float read) throws InterruptedException{
    System.out.println("the sugar measure is "+ " "+read);
    gui.ReadingTxt().setText(read+" ");
    
    if(read >=400){
    warn.needtopump();
    configs.sendEvent(new pumpstate(false) );
    }
    
    }
    

    public GUI getGui() {
        return gui;
    }

    public boolean isPumppstate() {
        return pumppstate;
    }

    public pump getP() {
        return p;
    }

    public sensor getSen() {
        return sen;
    }
    public void setState(boolean pumpState){
    this.pumppstate=pumpState;
    this.s.setState(pumpState);
    gui.getonBtn().setEnabled(!pumpState);
    gui.getoffBtn().setEnabled(pumpState);
   
    
    }
    public void alarm(){
    if(sen.currentreading< dose.checkAmountOfInsulinInResrvoir()){
    System.out.println("IMPORTANT!!! please refill the Resrvoir ");
    }
    }
    
}
