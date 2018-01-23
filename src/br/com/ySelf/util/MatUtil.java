/*
Authors: Igor Joaquim dos Santos Lima
GitHub: https://github.com/igor036
*/

package br.com.ySelf.util;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.opencv.core.Core;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;

public abstract class MatUtil extends JFrame {

    /* URL IMAGES
     *-------------------------------------------------------->
     */
    
    //dog
    public static final String DOG_SNOUT = "img\\Dog\\dog_snout.png";
    public static final String DOG_LEFT_EAR = "img\\Dog\\dog_left_ear.png";
    public static final String DOG_RIGHT_EAR = "img\\Dog\\dog_right_ear.png";
    
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
    
    public static void dog(Mat img) {

        Rect[] faces = Detection.rectOfFace(img);

        Mat dog_snout     = readImg(DOG_SNOUT);
        Mat dog_left_ear  = readImg(DOG_LEFT_EAR);
        Mat dog_right_ear = readImg(DOG_RIGHT_EAR);
        
        for (Rect fr : faces) {            
            
            int width  = (int)(fr.width  * 0.35);
            int height = (int)(fr.height * 0.35);
            
            int x = fr.x + (int)(fr.width * 0.07);
            int y = Math.abs(fr.y - (int)(fr.width * 0.15));
            
            int sloopOfFace = Detection.sloopOfFace(img.submat(fr));
            
            Size size = new Size(width, height);
            
            //resize
            Imgproc.resize(dog_left_ear, dog_left_ear, size);
            Imgproc.resize(dog_right_ear, dog_right_ear, size);
            Imgproc.resize(dog_snout, dog_snout, new Size(width * 0.85, height * 0.85));
            
            //rotation
            rotate(dog_left_ear, sloopOfFace);
            rotate(dog_right_ear, sloopOfFace);
            rotate(dog_snout, sloopOfFace);
            
            //left ear
            Mat region_left_ear = img.submat( new Rect(x, y, width, height));
            overlay(region_left_ear, dog_left_ear);
            
            
            //right ear
            x +=  fr.width - (fr.width * 0.35);
            y += Math.abs(sloopOfFace);
            x += sloopOfFace;
            
            Mat region_right_ear = img.submat( new Rect(x, y, width, height));
            overlay(region_right_ear, dog_right_ear);
            
            //snout
            
            Rect[] eyesOfFace = Detection.eyesOfFace(img.submat(fr));
            
            if (eyesOfFace.length == 0 || eyesOfFace[0].x < eyesOfFace[1].x) 
                x = fr.x + eyesOfFace[0].x + eyesOfFace[0].width;
            else 
                x = fr.x + eyesOfFace[1].x + eyesOfFace[1].width;
            
            
            x -= fr.width * 0.06;
            y = fr.y + (fr.height/2) - Math.abs(sloopOfFace);
            x += sloopOfFace;
            
            Mat region_snout = img.submat( new Rect(x, y, width, height));
            overlay(region_snout, dog_snout);
        }
    }
    
    public static void rotate(Mat img,double angle) {
        
        Point center = new Point(img.cols()/2, img.rows()/2);
        Mat rot_mat = Imgproc.getRotationMatrix2D(center, angle, 1);
        Mat rotated = new Mat();
        
        Imgproc.warpAffine(img, img, rot_mat, img.size(), Imgproc.INTER_CUBIC);
        
    }
    
    public static void glasses(Mat img, String png) {

        if (!fileExist(png))
            throw new RuntimeException("Mascara GLASSES não encontrada!");

        Rect[] eyes = Detection.rectOfEye(img);
        Mat sub = readImg(png);


        for (Rect rect : eyes) {
            
            /*
            double sloopOfFace = Detection.sloopOfFace(img.submat(rect));
            rotate(sub, sloopOfFace);*/
            
            Mat face = img.submat(rect);
            Imgproc.resize(sub, sub, face.size());
            overlay(face, sub);
  
        }
    }
    
    public static void widget(Mat img, Mat widget,int wx,int wy){
        
        final int width = wx+widget.width() > img.width() ? img.width(): wx+widget.width();
        final int heigth = wy+widget.height() > img.height() ?  img.height() : wy+widget.height();
        
        Point a = new Point(wx, wy);
        Point b = new Point(width,heigth);
        
        Mat widgetRegion = img.submat(new Rect(a, b));
       
        overlay(widgetRegion, widget);
    }
    
    private static void overlay(Mat img, Mat widget){
        
        for (int x = 0; x < widget.rows(); x++) {
            for (int y = 0; y < widget.cols(); y++){
                
                double[] pixel1  = img.get(x, y);
                double[] pixel2  = widget.get(x, y);
                
                //PNG WITH OPACITY
                if (pixel2.length == 4) {
                    
                    double alpha = pixel2[3] / 255f;
                    
                    for(int i = 0; i < 3; i ++)  
                        pixel1[i] = pixel2[i] * alpha + pixel1[i] * (1 -alpha);
                    
                } 
                
               //PHOTO WITHOUT OPACITY
                else 
                    for(int i = 0; i < 3; i ++)  
                        pixel1[i] = pixel2[i];
                
                
                img.put(x, y, pixel1);
            }
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
    
    
    public static void glitchWave(Mat img, int waveLength ,EColor color, Rect region) {
           
        Mat subRegion = img.submat(region);
        Mat sub = copy(subRegion);
        
        for (int x = 0; x < sub.rows(); x++) {
            for(int y = 0; y < sub.cols(); y++) {
                
                double[] pixel1 = subRegion.get(x, y);
                
                int xWave = x - waveLength >= 0 ? x-waveLength : waveLength-x;
                int yWave = y - waveLength >= 0 ? y-waveLength : waveLength-y;
                
                double[] pixel2 = sub.get(xWave, yWave);
                pixel1[color.colorValue()] = pixel2[color.colorValue()];
                
                subRegion.put(x, y, pixel1);
            }
        }
    }    
    
    public static void sumMat(Mat img, Mat mask){
        
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
    
    public static void darken(Mat img, int darkLevel, Rect region) {
        
        Mat sub = img.submat(region);
        
        for (int x = 0; x < sub.rows(); x++) {
            for(int y = 0; y < sub.cols(); y++) {
                
                double[] pixel = sub.get(x, y);
                
                for (int rgb = 0; rgb < 3; rgb++)
                    pixel[rgb] -= darkLevel;
                
                sub.put(x, y, pixel);
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
    
    public static void morphology(Mat img,int morph_size, Rect region) {
             
        Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(morph_size, morph_size));
        Imgproc.morphologyEx(img.submat(region), img.submat(region), Imgproc.MORPH_OPEN, element);
        
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
    
    public static void inversor(Mat img,Rect region){
        
        Mat sub = img.submat(region);
        byte[] buffer = toByteArray(sub);
        
        for (int i = 0; i < buffer.length; i++)
            buffer[i] *= -1;
        
        sub.put(0,0, buffer);
    }
    
    public static Mat copy(Mat img){
        Mat imgCopy = new Mat();
        img.copyTo(imgCopy);
        return imgCopy;
    }
    
    public static byte[] toByteArray(Mat mat) {

        int size = (int) (mat.total() * mat.channels());
        byte[] buffer = new byte[size];

        mat.get(0, 0, buffer);

        return buffer;
    }
    
    public static void blur(Mat mat, int size) {
        
        if (size % 3 != 0)
            size += 3;
        
        Imgproc.GaussianBlur(mat, mat, new Size(size, size), Core.BORDER_DEFAULT);
    }
    
    public static void blur(Mat mat, int size, Rect region) {
        
        if (size % 3 != 0)
            size += 3;
        
        Imgproc.GaussianBlur(mat.submat(region), mat.submat(region), new Size(size, size), Core.BORDER_DEFAULT);
    }
    
    public static void grayScale(Mat img,Rect region){
        
        Mat sub = img.submat(region);
        Imgproc.cvtColor(sub, sub, Imgproc.COLOR_RGB2GRAY);
        Imgproc.cvtColor(sub,sub,Imgproc.COLOR_GRAY2BGR);
        
        sub.copyTo(img.submat(region));
    }
        
    
    public static void grayScale(Mat img) {
        Imgproc.cvtColor(img, img, Imgproc.COLOR_RGB2GRAY);
    }
    
    public static void delete(Mat img, Rect region) {
        img.submat(region).setTo(new Scalar(0, 0, 0));
    }
    
    public static void delete(Mat img, int x, int y, int size){
        Rect region = new Rect(x, y, size,size);
        img.submat(region).setTo(new Scalar(0, 0, 0));
    }
    
    
    public static Mat readImg(String url) {
        return Imgcodecs.imread(url,Imgcodecs.IMREAD_UNCHANGED);
    }
    
    private static boolean fileExist(String url) {
        return new File(url).exists();
    }
    
    public static Mat cut(Mat img,Rect region) {
        return img.submat(region);
    }
    
    public static void save(String path, Mat img) {
        Imgcodecs.imwrite(path, img);
    }
    
    public static void copyToRegion(Mat img, Mat copy,Rect region){
        copy.copyTo(img.submat(region));
    }
    
    public static Rect getRect(JComponent c){
    
        int x = c.getX();
        int y = c.getY();
        
        int width  =  c.getWidth();
        int height =  c.getHeight();
        
        return new Rect(x, y, width, height);
    }
}
