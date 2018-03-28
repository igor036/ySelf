
package br.com.ySelf.util;

import org.opencv.core.Scalar;


public class Text {
    
    private Scalar color;
    private int scale;
    private String str;

    public Text(){
        scale = 1;
        color = new Scalar(0,0,0);
        str = "";
    }
    
    public Scalar getColor() {
        return color;
    }

    public void setColor(Scalar color) {
        this.color = color;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
    
}
