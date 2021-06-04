/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Events;

/**
 *
 * @author Lenovo
 */
public class bloodreading {
    
    private final float currentreading;
    
   public  bloodreading(float currentreading)
    {
        this.currentreading=currentreading;
    
    }

    public float getRead() {
        return currentreading;
    }
    
    
    
}
