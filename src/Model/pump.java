/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import Esper.configs;

/**
 *
 * @author Lenovo
 */
public class pump extends Thread{
    private InsulinDose dose;
    private Date timeOfLastPump;

    pump(float currdose) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
     public Date getTimeOfLastPump() {
        return timeOfLastPump;
    }
     
     
  //pump the dose  
  public boolean pump(InsulinDose dose, boolean availabledose){
      //check if amount of dose is available
   availabledose= dose.doseAvailability(dose.getCurrdose());
  if(availabledose==true){
      // if available get the time of last pump 
    getTimeOfLastPump();
    return true;
  
  }else {
  return false;
  }
  
  }
 
  
  
  
  
  
  @Override
  public void run(){
  
     while(true){
        try{
  
        this.sleep(1000);
        
  }catch(InterruptedException ex){
  
    Logger.getLogger(pump.class.getName()).log(Level.SEVERE, null, ex);
  
  }
    configs.sendEvent(new pump(dose.getCurrdose()));
  
  }
  
  }  
  

   

    
    
 

   
}
