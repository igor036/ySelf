/*
Authors: Igor Joaquim dos Santos Lima
GitHub: https://github.com/igor036
*/


/* RGB 
 * pixel[0] = green
 * pixel[1] = blue
 * pixel[2] = red
 */
        
package br.com.ySelf.util;

public enum EColor {
    
    GREEN(0), 
    BLUE(1), 
    RED(2); 
    
    private final int color;
    
    private EColor(int color){
        this.color = color;
    }
    
    public int colorValue(){
        return this.color;
    }
}
