package br.com.ySelf;

import org.opencv.core.Core;
import br.com.ySelf.window.MainWindow;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
    
    private static final MainWindow window = new MainWindow();
    
    public static void main(String[] args) {
                                                                                                                                                                                                                                                                     
        try {
            
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
            window.setVisible(true);
            
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
    
    public static void showMain(){
        window.setVisible(true);
    }
}
