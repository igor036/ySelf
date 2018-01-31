/*
Authors: Igor Joaquim dos Santos Lima
GitHub: https://github.com/igor036
*/

package br.com.ySelf;

import br.com.ySelf.modal.Layer;
import br.com.ySelf.util.MatUtil;
import br.com.ySelf.window.Layers;
import org.opencv.core.Core;
import br.com.ySelf.window.Window;
import java.util.ArrayList;
import java.util.List;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.opencv.core.Mat;

public class Main {
 
    private static final List<Layer> layers = new ArrayList<>();
    private static final Layers layersWindow = new Layers();
    private static Layer currentLayer;
    
    public static void main(String[] args) {
        
        currentLayer = new Layer(new Window("1° Camada"));
        currentLayer.showWindow();
        
        layers.add(currentLayer);
        
        layersWindow.setVisible(true);
        layersWindow.setLayersList(layers);
        
        try {
            
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
            
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public static List<Layer> getLayers(){
        return layers;
    }
    
    public static void removeLayer(int id){
        layers.remove(id);
        layersWindow.setLayersList(layers);
    }
    
    public static void addLayers(){
        
        Mat img = MatUtil.copy(layers.get(layers.size()-1).getImg());
        
        String title = (layers.size()+1) + " ° Camada";
        Layer layer = new Layer(new Window(img,title));
        
        layers.add(layer);
        layersWindow.setLayersList(layers);
        currentLayer.setNextLayerMat(layer.getImg());
        
    }
    
    public static void alterLayer(int id) {
        
        currentLayer.hideWindow();
        currentLayer = layers.get(id);
        currentLayer.showWindow();
        
        if (id >= 0 && id <= layers.size()-1) {
            
            Mat img = layers.get(id+1).getImg();
            currentLayer.setNextLayerMat(img);
        }
    }
}
