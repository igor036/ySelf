/*
Authors: Igor Joaquim dos Santos Lima
GitHub: https://github.com/igor036
*/

package br.com.ySelf.util;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.opencv.core.Core;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.Rect;
import org.opencv.core.Size;

public abstract class MatUtil extends JFrame {

    /* URL IMAGES
     *-------------------------------------------------------->
     */
    
    //dog
    public static final String DOG_PNG = "img\\dog.png";
    
    //glasses
    public static final String GLASSES_1 = "img\\glasses\\glasses_1.png";
    public static final String GLASSES_2 = "img\\glasses\\glasses_2.png";

    //vhs
    public static final String VHS_1 = "img\\VHS\\1.jpg";
    public static final String VHS_2 = "img\\VHS\\2.jpg";
    public static final String VHS_3 = "img\\VHS\\3.jpg";
    public static final String VHS_4 = "img\\VHS\\4.jpg";
    
    //vhs date
    public static final String VHS_DATE_1 = "img\\VHS\\vhs_date1.png";
    public static final String VHS_DATE_2 = "img\\VHS\\vhs_date2.jpg";
    
    /*-------------------------------------------------------->
     *END URL IMAGES
     */
    
    
    public static void show(Mat img, String title) {

        JLabel lbImg = new JLabel("");
        JFrame window = new JFrame(title);
        ImageIcon imgIcon = new ImageIcon(bufferedImg(img));

        lbImg.setIcon(imgIcon);
        window.setBounds(0, 0, (int) img.size().width, (int) img.size().height);
        window.add(lbImg);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);

    }

    public static void show(Mat img, JLabel lbImg) {
        lbImg.setBounds(0, 0, (int)img.size().width, (int)img.size().height);
        ImageIcon imgIcon = new ImageIcon(bufferedImg(img));
        lbImg.setIcon(imgIcon);
    }

    
    private static BufferedImage bufferedImg(Mat img) {

        int type = (img.channels() > 1) ? BufferedImage.TYPE_3BYTE_BGR : BufferedImage.TYPE_BYTE_GRAY;

        int bufferSize = img.channels() * img.cols() * img.rows();
        byte[] buffer = new byte[bufferSize];
        img.get(0, 0, buffer);

        BufferedImage bfImg = new BufferedImage(img.cols(), img.rows(), type);
        byte[] targetPixels = ((DataBufferByte) bfImg.getRaster().getDataBuffer()).getData();

        System.arraycopy(buffer, 0, targetPixels, 0, buffer.length);

        return bfImg;
    }
    
    public static void dog(Mat img, String png) {

        if (!fileExist(png))
            throw new RuntimeException("Mascara DOG não encontrada!");

        Rect[] faces = Detection.rectOfFace(img);
        Mat sub = readImg(png);

        for (Rect fr : faces) { 

            fr.x -= 5;
            fr.y += 5;
            fr.width += 15;
            fr.height += 70;

            if (img.width() - fr.width < 400) 
                fr.y -= 20;
            
            Mat face = img.submat(fr);
            Imgproc.resize(sub, sub, face.size());

            byte[] bufferImg = toByteArray(face);
            byte[] bufferSub = toByteArray(sub);

            for (int i = 0; i < bufferSub.length; i++) {

                if (bufferSub[i] != 0 && bufferSub[i] != 255) {
                    bufferImg[i] = bufferSub[i];
                }
            }

            face.put(0, 0, bufferImg);
        }
    }
    
    
    public static void glasses(Mat img, String png) {

        if (!fileExist(png))
            throw new RuntimeException("Mascara GLASSES não encontrada!");

        Rect[] eyes = Detection.rectOfEye(img);
        Mat sub = readImg(png);


        for (Rect rect : eyes) { 
            
            Mat face = img.submat(rect);
            Imgproc.resize(sub, sub, face.size());

            byte[] bufferImg = toByteArray(face);
            byte[] bufferSub = toByteArray(sub);

            for (int i = 0; i < bufferSub.length; i++) {

                if (bufferSub[i] != 0 && bufferSub[i] != 255) {
                    bufferImg[i] = bufferSub[i];
                }
            }

            face.put(0, 0, bufferImg);
        }
    }
    
    public static void glitchWave(Mat img, int waveLength ,EColor color){
           
        Mat sub = copy(img);
        
        for (int x = 0; x < sub.rows(); x++) {
            for(int y = 0; y < sub.cols(); y++) {
                
                double[] pixel1 = img.get(x, y);
                
                int xWave = x - waveLength >= 0 ? x-waveLength : waveLength-x;
                int yWave = y - waveLength >= 0 ? y-waveLength : waveLength-y;
                
                double[] pixel2 = sub.get(xWave, yWave);
                pixel1[color.colorValue()] = pixel2[color.colorValue()];
                
                img.put(x, y, pixel1);
            }
        }
    }
    
    private static void sumMat(Mat img, Mat mask){
        
        Imgproc.resize(mask, mask, img.size());
        
        for (int x = 0; x < img.rows(); x++) {
            for(int y = 0; y < img.cols(); y++) {
                
                double[] pixel1 = img.get(x, y);
                double[] pixel2 = mask.get(x, y);
                
                for (int rgb = 0; rgb < 3; rgb ++)
                    pixel1[rgb] += pixel2[rgb];
                
                img.put(x, y, pixel1);
            }
        }
    }
    
    public static void darken(Mat img, int darkLevel) {
        
        for (int x = 0; x < img.rows(); x++) {
            for(int y = 0; y < img.cols(); y++) {
                
                double[] pixel = img.get(x, y);
                
                for (int rgb = 0; rgb < 3; rgb++)
                    pixel[rgb] -= darkLevel;
                
                img.put(x, y, pixel);
            }    
        }
    }
    
    public static void widget(Mat img, Mat widget, Point point){
        
        for (int x = (int)point.x; x < img.rows(); x++) {
            for(int y = (int)point.y; y < img.cols(); y++) {
                
                double[] pixel1 = img.get(x, y);
                double[] pixel2 = widget.get(x-(int)point.x, y-(int)point.y);

                
                if (pixel2 != null)
                    for (int rgb = 0; rgb < 3; rgb++)
                        pixel1[rgb] = pixel2[rgb];
                else
                    break;
                
                img.put(x, y, pixel1);
            }
         }
    }
    
    public static void vhs(Mat img, String VHS){
        
        if (!fileExist(VHS))
            throw new RuntimeException("Mascara VHS não encontrada!");
        
        Mat vhs = readImg(VHS);
        sumMat(img, vhs);
    }
    
    public static void morphology(Mat img,int morph_size) {
             
        Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(morph_size, morph_size));
        Imgproc.morphologyEx(img, img, Imgproc.MORPH_OPEN, element);
        
    }
    
    public static void resize(Mat img) {
        
        Size size = new Size(img.width()-100,img.height()-100);
        Imgproc.resize(img, img, size);
    }
    
    public static void inversor(Mat img){
        
        byte[] buffer = toByteArray(img);
        
        for (int i = 0; i < buffer.length; i++)
            buffer[i] *= -1;
        
        img.put(0,0, buffer);
    }
    
    public static Mat copy(Mat img){
        Mat imgCopy = new Mat();
        img.copyTo(imgCopy);
        return imgCopy;
    }

    public static void blur(Mat mat, int size) {
        
        if (size % 3 != 0)
            size += 3;
        
        Imgproc.GaussianBlur(mat, mat, new Size(size, size), Core.BORDER_DEFAULT);
    }
    
    public static void grayScale(Mat img){
        Imgproc.cvtColor(img, img, Imgproc.COLOR_RGB2GRAY);
    }
    
    public static Mat readImg(String url) {
        return Imgcodecs.imread(url);
    }
    
    public static byte[] toByteArray(Mat mat) {

        int size = (int) (mat.total() * mat.channels());
        byte[] buffer = new byte[size];

        mat.get(0, 0, buffer);

        return buffer;
    }
    
    private static boolean fileExist(String url){
        return new File(url).exists();
    } 
}
