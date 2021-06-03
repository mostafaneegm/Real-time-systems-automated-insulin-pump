/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esper;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import org.apache.log4j.Logger;

/**
 *
 * @author Lenovo
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Logger.getRootLogger().setLevel(Level.OFF);
        
        configs.Eventsregisteration();
        
        final InsulinPumpSystem sys = new InsulinPumpSystem(null,null);
        final self_test selft = new self_test();
        
        configs.createStatment("blood reading").setSubscriber(new Object(){
        
        public void update(int read)throws InterruptedException 
        {
            sys.get
        }
        
        });
                
        
    }
    
}
