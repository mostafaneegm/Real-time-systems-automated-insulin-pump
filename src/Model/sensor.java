 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Esper.configs;
import Events.bloodreading;
import Model.screen;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mostafa
 */
public class sensor extends Thread{
    
    private float normalreading;
    protected float oldreding;
    protected float currentreading;
    protected float lastreading;
    private InsulinPumpSystem insulinpumpsystem;

//    public sensor(float normalreading, float oldreding, float currentreading, float lastreading) {
//        this.normalreading = normalreading;
//        this.oldreding = oldreding;
//        this.currentreading = currentreading;
//        this.lastreading = lastreading;
//    }
    

    
     public sensor(InsulinPumpSystem insulinpumpsystem) {
       this.currentreading=80;
       this.insulinpumpsystem=insulinpumpsystem;
    }
    

    public float getNormalreading() {
        return normalreading;
    }

    public void setNormalreading(float normalreading) {
        this.normalreading = normalreading;
    }

    public float getOldreding() {
        return oldreding;
    }

    public void setOldreding(float oldreding) {
        this.oldreding = oldreding;
    }

    public float getCurrentreading() {
        return currentreading;
    }

    public void setCurrentreading(float currentreading) {
        this.currentreading = currentreading;
    }

    public float getLastreading() {
        return lastreading;
    }

    public void setLastreading(float lastreading) {
        this.lastreading = lastreading;
    }
     
  private float random(float min, float max) {
        
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        
        Random r = new Random();
        return r.nextInt((int) ((max - min) + 1)) + min;
    }
    
    public float measuresugarreading()
    {   
       currentreading +=random(80,400);
//    Random r = new Random();
//    currentreading=40+r.nextFloat()*(150-40);
    return currentreading;
    }
    
    public String comparereadings(float oldreading, float lastreading,float currentreading)
    {
        String mesg=" ";
        float mr1 = 0;
        float mr2 = 0;
        
        screen s = new screen();
        if(currentreading>lastreading)
        {
            mr1 = currentreading - lastreading;
            
            if(lastreading > oldreading)
            { mr2 = lastreading  - oldreading;
 
              if(mr1 == mr2 && currentreading >= 80.0 && currentreading <= 130.0 )
              {
                  mesg="you sugar is increasing in regular way";
                  s.displaymessage1();
                  
                  
              }else {mesg ="your sugar measurment is not okay";}}
            else{mesg ="your sugar measurment is not okay";}

            
            }else{mesg ="your sugar measurment is not okay";}
    return mesg;
        }
    
    public void Displaycurrentreading(float currentreading)
    {
       
        System.out.println("The current reading is"+"  "+ currentreading);
    }
    
    
    
    
    @Override
    public void run() {
        while (true) {
            
            try {
                this.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(sensor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            configs.sendEvent(new bloodreading(currentreading));
        }
    }
    
    
    

    
    
    
    
    }
