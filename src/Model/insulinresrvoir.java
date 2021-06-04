/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Esper.configs;
import Events.reservoir;
//import Events.pumps;
import Model.InsulinDose; 
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author mostafa
 */
public class insulinresrvoir extends Thread{
    private float amountofinsulin;
    private boolean insulinreplacement;
    private InsulinDose insulindose;
    private InsulinPumpSystem insulinpumpsystem;
    
     public insulinresrvoir(InsulinPumpSystem insulinpumpsystem) {
       
       this.insulinpumpsystem=insulinpumpsystem;
    }

    public insulinresrvoir() {
    }
    
    
    public float checkamountofinsulin (float amountofinsulin)
    {
        return amountofinsulin;
    }
    
    public boolean comparedose(InsulinDose insulindosee)
    {
        boolean result=false;
        if(insulindose.getCurrdose() < amountofinsulin)
        {result = true;}
        else{ result = false;}
        return result;
    }
    
    public float checkreplacement(boolean replacement)
    {
        insulinresrvoir i = new insulinresrvoir();
        boolean remainings = insulindose.doseAvailability(insulindose.getCurrdose());
        if(remainings == false){insulinreplacement = true; i.setAmountofinsulin(100);}
        return i.getAmountofinsulin();
    }

    public float getAmountofinsulin() {
        return amountofinsulin;
    }

    public void setAmountofinsulin(float amountofinsulin) {
        this.amountofinsulin = amountofinsulin;
    }

    public InsulinDose getInsulindose() {
        return insulindose;
    }

    public void setInsulindose(InsulinDose insulindose) {
        this.insulindose = insulindose;
    }
    
    @Override
public void run(){
    while(true){

        try{
        
            this.sleep(1000);
        
        } catch (InterruptedException ex){
        Logger.getLogger(reservoir.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        configs.sendEvent(new reservoir(amountofinsulin));
}


}
}
