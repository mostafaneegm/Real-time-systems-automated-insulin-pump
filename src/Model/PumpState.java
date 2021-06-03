/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Lenovo
 */
public class PumpState {
    private boolean pumpstate;
    private InsulinPumpSystem insulinpumpsystem;
    
    
    public PumpState(InsulinPumpSystem insulinpumpsystem){
    this.pumpstate=pumpstate;
    this.insulinpumpsystem=insulinpumpsystem;
    
    }
  public void setState(boolean pumpstate) {
        this.pumpstate = pumpstate;
        if (pumpstate) {
            insulinpumpsystem.getGui().StatusTxt().setText("ON");
        } else {
            insulinpumpsystem.getGui().StatusTxt().setText("OFF");
        }

    }


}
