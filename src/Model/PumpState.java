/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author mostafa
 */
public class PumpState {
    private boolean state;
    private InsulinPumpSystem insulinpumpsystem;
    
    
    public PumpState(InsulinPumpSystem insulinpumpsystem){
    this.state=false;
    this.insulinpumpsystem=insulinpumpsystem;
    
    }
  public void setState(boolean state) {
        this.state = state;
        if (state) {
            insulinpumpsystem.getGui().getStatusTxt().setText("ON");
        } else {
            insulinpumpsystem.getGui().getStatusTxt().setText("OFF");
        }

    }   


}
