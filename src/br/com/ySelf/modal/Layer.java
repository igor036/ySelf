/*
Authors: Igor Joaquim dos Santos Lima
GitHub: https://github.com/igor036
*/
package br.com.ySelf.modal;

import br.com.ySelf.window.Window;
import org.opencv.core.Mat;

public class Layer {
    
    private Window window;
    
    public Layer(){}
    
    public Layer(Window window){
        this.window = window;
    }

    public Window getWindow() {
        return window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public void setNextLayerMat(Mat img) {
        this.window.setNextLayerMat(img);
    }
    
    public void showWindow(){
        window.setVisible(true);
    }
    
    public void hideWindow(){
        window.setVisible(false);
    }
    
    public Mat getImg(){
        return window.getImg();
    }
}
