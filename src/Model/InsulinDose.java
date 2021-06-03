/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.sensor;
import java.util.logging.Level;
import java.util.logging.Logger;
import Events.bloodReadin;
/**
 *
 * @author Lenovo
 */
class InsulinDose extends Thread {
    private float lastdose;
    private float currdose;
    private float cumulativeDoseinDay; 
    protected float maxDoseinDay=400;
    protected float minDoseinDay=130;
    protected float safeZoneDose=180; 
    private int numberofdose;
   
    private insulinreservoir resrvoir;
    
    public InsulinDose(){
    //empty constructor
    }
    
     public float getLastdose() {
        return lastdose;
    }

    public void setLastdose(float lastdose) {
        this.lastdose = lastdose;
    }

    public float getCurrdose() {
        return currdose;
    }

    public void setCurrdose(float currdose) {
        this.currdose = currdose;
    }


    
    // calculate the dose based on the sugar read 
    // hint the dose calcualtion is based on hypothieses 
    public float mesuredose(float dose, sensor sen){
    if (sen.currentreading <=minDoseinDay){
        dose=0;
        
    }
    else if(sen.currentreading>=maxDoseinDay)
    {  dose=50;
    }
    else if(sen.currentreading>= safeZoneDose && sen.currentreading<= maxDoseinDay)
    {
        dose=40;
    }
        return dose;
}
    //check how much remaining dose in the pump 
    public boolean doseAvailability (float availableDose){
    pump p = new pump(currdose);
    availableDose=resrvoir.getinsulinamount();
    
    if (currdose<availableDose){
        p.pump(this);
        return true;
    }
    else
    {
    
    System.out.println("the amount of insulin in pump is less that the reqired dose");
    System.out.println("IMPORTANT!!!  please refill the reservoir");
    return false;
    }
    
}
 // caclualte amount of insulin in the reservoir
 public float checkAmountOfInsulinInResrvoir(){
    float insulinAmount= resrvoir.getinsulinamount();
    System.out.println("amount of insulin is"+ insulinAmount);
    return insulinAmount;
 }

   
public void caclulateCumulativDose(){
if(numberofdose>=5){
}

}

@Override
public void run(){
    while(true){

        try{
        
            this.sleep(1000);
        
        } catch (InterruptedException ex){
        Logger.getLogger(bloodReadin.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        Config.sendEvent(new pump(currdose));
}


}




}