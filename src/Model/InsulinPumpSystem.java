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

import View.GUI;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.InsulinDose;
import Model.insulinresrvoir;
import Model.pump;
import Model.sensor;
/**
 *
 * @author Lenovo
 */
public class InsulinPumpSystem {
    private GUI gui;
    
    
    private boolean state= false;
    
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

    public PumpState getS() {
        return s;
    }
    
   
    
    
    public InsulinPumpSystem (){
       gui = new GUI();
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
        
        dose =new InsulinDose(this);
        reservoir= new insulinresrvoir (this);
        p = new pump (this);
        sen = new sensor (this);
        s= new PumpState(this);
        warn =new pumpwarning();
        sen.start();
        p.start();
        
    }
    
    public boolean isSystemOn(){
    return state;
    }
    public void SugarMeasure(float currentreading) throws InterruptedException{
    System.out.println("the sugar measure is "+ " "+currentreading);
    gui.getReadingTxt().setText(currentreading+" ");
    
    if(currentreading >=400){
    warn.needtopump();
    configs.sendEvent(new pumpstate(false) );
    }
    
    }
    public void amountOfInsulininResourvoir(float amountofinsulin){
    reservoir.checkamountofinsulin(amountofinsulin);
    
    }
    public void mesuredoseamount()
    {
    dose.mesuredose(sen);
    
    }    

    public GUI getGui() {
        return gui;
    }

    public boolean isPumppstate() {
        return state;
    }

    public pump getP() {
        return p;
    }

    public sensor getSen() {
        return sen;
    }

    public InsulinDose getDose() {
        return dose;
    }

    public insulinresrvoir getReservoir() {
        return reservoir;
    }

    public pumpwarning getWarn() {
        return warn;
    }
    
     public void setState(boolean state) {
        this.state = state;
       this.s.setState(state);
        gui.getonBtn().setEnabled(!state);
        gui.getoffBtn().setEnabled(state);
    }
    public void alarm(){
    if(sen.currentreading< dose.checkAmountOfInsulinInResrvoir()){
    System.out.println("IMPORTANT!!! please refill the Resrvoir ");
    }
    }
    
}
