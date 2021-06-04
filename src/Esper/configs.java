/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esper;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import Events.*;
import com.espertech.esper.client.EPStatement;
import Events.reservoir;
import Events.pumpstate;
import Events.bloodreading;

/**
 *
 * @author hp
 */
public class configs {
    
    private static EPServiceProvider engine = EPServiceProviderManager.getDefaultProvider();
    
    
    
    public static void Eventsregisteration()
    {
        engine.getEPAdministrator().getConfiguration().addEventType(bloodreading.class);
        engine.getEPAdministrator().getConfiguration().addEventType(reservoir.class);
        engine.getEPAdministrator().getConfiguration().addEventType(pumpstate.class);
     engine.getEPAdministrator().getConfiguration().addEventType(pumps.class);
//        engine.getEPAdministrator().getConfiguration().addEventType(.class);
       
        System.out.println("Events been registered succesfully");
    
    }
    
    public static EPStatement createStatment(String s)
    {
        EPStatement result = engine.getEPAdministrator().createEPL(s);
        
        System.out.println("EPL statment been created succesfully");
        return result;
    }
    
    public static void sendEvent(Object o)
    {
        engine.getEPRuntime().sendEvent(o);
    }
}
