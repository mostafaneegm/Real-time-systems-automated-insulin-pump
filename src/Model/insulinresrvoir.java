/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.InsulinDose; 
/**
 *
 * @author mostafa
 */
public class insulinresrvoir {
    private float amountofinsulin;
    private boolean insulinreplacement;
    private InsulinDose insulindose;
    
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
    
    
}
