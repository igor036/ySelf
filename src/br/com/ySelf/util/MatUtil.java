/*
Authors: Igor Joaquim dos Santos Lima
GitHub: https://github.com/igor036
 */
package br.com.ySelf.util;

import br.com.ySelf.modal.EColor;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
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
        //lbImg.setBounds(0, 0, (int) img.size().width, (int) img.size().height);
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

        Mat dog_snout = readImg(DOG_SNOUT);
        Mat dog_left_ear = readImg(DOG_LEFT_EAR);
        Mat dog_right_ear = readImg(DOG_RIGHT_EAR);

        for (Rect fr : faces) {

            Mat face = img.submat(fr);

            int width = (int) (fr.width * 0.35);
            int height = (int) (fr.height * 0.35);

            int x = fr.x + (int) (fr.width * 0.04), xOverlay;
            int y = Math.abs(fr.y - (int) (fr.width * 0.15)), yOverlay;

            double density = Detection.density(img, fr);
            int slopOfFace = Detection.slopOfFace(face);

            Size size = new Size(width, height);

            //resize
            Imgproc.resize(dog_left_ear, dog_left_ear, size);
            Imgproc.resize(dog_right_ear, dog_right_ear, size);
            Imgproc.resize(dog_snout, dog_snout, new Size(width * 0.85, height * 0.85));

            //rotation
            rotate(dog_left_ear, density + slopOfFace);
            rotate(dog_right_ear, density + slopOfFace);
            rotate(dog_snout, density + slopOfFace);

            //left ear
            xOverlay = (int) Math.abs(x + (slopOfFace + density * 2) * -1);
            yOverlay = (int) Math.abs(y + (slopOfFace + density * 2));

            Mat region_left_ear = img.submat(new Rect(xOverlay, yOverlay, width, height));
            overlay(region_left_ear, dog_left_ear);

            //right ear
            xOverlay = (int) Math.abs(x + fr.width - (fr.width * 0.35) + (slopOfFace + density) * -1);
            yOverlay = (int) Math.abs((y + (slopOfFace + density * 2) * -1));

            Mat region_right_ear = img.submat(new Rect(xOverlay, yOverlay, width, height));
            overlay(region_right_ear, dog_right_ear);

            //snout       
            xOverlay = fr.x + (int) (Detection.anchorPoint(face) - fr.width * 0.05);
            yOverlay = fr.y + (fr.height / 2) - (int) Math.abs(slopOfFace + density) * (int) (fr.width * 0.01);

            Mat region_snout = img.submat(new Rect(xOverlay, yOverlay, width, height));
            overlay(region_snout, dog_snout);
        }
    }
    
    public static void rotate(Mat img, double angle) {

        Point center = new Point(img.cols() / 2, img.rows() / 2);
        Mat rot_mat = Imgproc.getRotationMatrix2D(center, angle, 1);

        Imgproc.warpAffine(img, img, rot_mat, img.size(), Imgproc.INTER_CUBIC);
        //Imgproc.warpAffine(img, rot_mat, rot_mat, rot_mat.size());
    }

    public static void glasses(Mat img, String png) {

        if (!fileExist(png)) 
            throw new RuntimeException("Mascara GLASSES não encontrada!");
        

        Rect[] eyes = Detection.rectOfEye(img);
        Mat sub = readImg(png);

        for (Rect rect : eyes) {

            double sloopOfFace = Detection.slopOfFace(img.submat(rect));
            rotate(sub, sloopOfFace);

            Mat face = img.submat(rect);
            Imgproc.resize(sub, sub, face.size());
            overlay(face, sub);

        }
    }
    
    public static void widget(Mat img, Mat widget, int wx, int wy) {

        final int width = wx + widget.width() > img.width() ? img.width() : wx + widget.width();
        final int heigth = wy + widget.height() > img.height() ? img.height() : wy + widget.height();

        Point a = new Point(wx, wy);
        Point b = new Point(width, heigth);

        Mat widgetRegion = img.submat(new Rect(a, b));

        overlay(widgetRegion, widget);
    }

    public static void overlay(Mat img, Mat widget) {

        for (int x = 0; x < widget.rows(); x++) {
            for (int y = 0; y < widget.cols(); y++) {

                double[] pixel1 = img.get(x, y);
                double[] pixel2 = widget.get(x, y);

                //PNG WITH OPACITY
                if (pixel2.length == 4) {

                    double alpha = pixel2[3] / 255f;

                    for (int i = 0; i < 3; i++) 
                        pixel1[i] = pixel2[i] * alpha + pixel1[i] * (1 - alpha);

                } //PHOTO WITHOUT OPACITY
                else {
                    for (int i = 0; i < 3; i++) {
                        pixel1[i] = pixel2[i];
                    }
                }

                img.put(x, y, pixel1);
            }
        }
    }
    
    public static void glitchWave(Mat img, int waveLength, EColor color) {

        Mat sub = copy(img);

        for (int x = 0; x < sub.rows(); x++) {
            for (int y = 0; y < sub.cols(); y++) {

                double[] pixel1 = img.get(x, y);

                int xWave = x - waveLength >= 0 ? x - waveLength : waveLength - x;
                int yWave = y - waveLength >= 0 ? y - waveLength : waveLength - y;

                double[] pixel2 = sub.get(xWave, yWave);
                pixel1[color.colorValue()] = pixel2[color.colorValue()];

                img.put(x, y, pixel1);
            }
        }
    }
    
    

    public static void sumMat(Mat img, Mat mask) {

        Imgproc.resize(mask, mask, img.size());

        for (int x = 0; x < img.rows(); x++) {
            for (int y = 0; y < img.cols(); y++) {

                double[] pixel1 = img.get(x, y);
                double[] pixel2 = mask.get(x, y);

                for (int rgb = 0; rgb < 3; rgb++)
                    pixel1[rgb] += pixel2[rgb];

                img.put(x, y, pixel1);
            }
        }
    }
   
    public static void noise(Mat img, int noise) {
        
        if (noise != 0) { 
            
            Random random = new Random();
        
            for (int x = 0; x < img.rows(); x++) {
                for (int y = 0; y < img.cols(); y++) {

                    double[] pixel = img.get(x, y);
                    int value = random.nextInt(noise);

                    for (int i = 0; i < pixel.length; i++)
                        pixel[i] += value;

                    img.put(x, y, pixel);

                }
            }
        }
    }

    public static void cartoon(Mat img) {
        
        Mat process = new Mat();
        Mat hierarchy = new Mat();
  
        Imgproc.cvtColor(img, img, Imgproc.COLOR_BGRA2BGR);
        Imgproc.pyrMeanShiftFiltering(img.clone(), img, 25, 40);       
        Imgproc.cvtColor(img, process, Imgproc.COLOR_RGB2GRAY);
        Imgproc.adaptiveThreshold(process,process, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C,Imgproc.THRESH_BINARY,9,2);
        Imgproc.cvtColor(process, process, Imgproc.COLOR_GRAY2RGB);
        
        for (int x = 0; x < img.rows(); x++) {
            for (int y = 0; y < img.cols(); y++) {
                
                double[] pixel = process.get(x, y);
                
                if (pixel[0] == 0 && pixel[1] == 0 && pixel[2] == 0)
                    img.put(x, y, pixel);
            }
        }
    }
    
    public static void sepia(Mat img){
    
        /* R = pixel[2] / tr = 0.393R + 0.769G + 0.189B
         * G = pixel[1] / tg = 0.349R + 0.686G + 0.168B
         * B = pixel[0] / tb = 0.0272R + 0.534G + 0.131B
         */
        
        for (int x = 0; x < img.rows(); x++) {
            for (int y = 0; y < img.cols(); y++) {
            
                
                double R = img.get(x, y)[2], 
                       G = img.get(x, y)[1], 
                       B = img.get(x, y)[0];
                
                double[] data = {
                    0.272*R + 0.534*G + 0.131*B,
                    0.349*R + 0.686*G + 0.168*B,
                    0.393*R + 0.769*G + 0.189*B
                };
                
                img.put(x, y, data);
            }
        }
    }
    
    public static void lilac(Mat img, boolean[] colors){
        
        for (int x = 0; x < img.rows(); x++) {
            for (int y = 0; y < img.cols(); y++) {
                

                double b = img.get(x, y)[0],
                       g = img.get(x, y)[1],
                       r = img.get(x, y)[2];
                
                double[] data = {
                    colors[0] ? 0.5f * (255 + g + r) : b,
                    colors[1] ? 0.25 * (510 + r + g - 2 * b) : g,
                    colors[2] ? 0.5f * 1.0f / 3.0f * (r + g + b) : r
                };
                
                img.put(x, y, data);
            }
        }
    }
    
    
    public static void contrastAndBrightness(Mat img,double alpha, double beta) {
        
        alpha *= 0.4;
        beta *= 0.4;
        
        for (int x = 0; x < img.rows(); x++) {
            for (int y = 0; y < img.cols(); y++) {
                
                double[] pixel = img.get(x, y);
                
                for (int i = 0; i < 3; i++)
                    pixel[i] = (int)(alpha * (pixel[i] + beta));
                
                img.put(x,y,pixel);
            }
        }
    }
    

    
    public static void focus(Mat img, Rect region) {
        
        Mat old = copy(img).submat(region);
        Mat focusRegion = copy(img).submat(region);
        Mat kernel = Imgproc.getStructuringElement(2, new Size(23,23));
        
        //pre-process
        Imgproc.cvtColor(focusRegion, focusRegion, Imgproc.COLOR_RGB2GRAY);
        Imgproc.Sobel(focusRegion, focusRegion, -1,1,0);
        Imgproc.threshold(focusRegion, focusRegion,35, 255, Imgproc.THRESH_BINARY);
        Imgproc.morphologyEx(focusRegion, focusRegion, Imgproc.MORPH_CLOSE,kernel);
        Imgproc.GaussianBlur(focusRegion, focusRegion, new Size(3,3), 0,0,Core.BORDER_DEFAULT);
       
       
        //focus
        blur(img, 9);
        Mat copy = img.submat(region);
        
        for (int x = 0; x < copy.rows(); x++) {
            for (int y = 0; y < copy.cols(); y++) {
                
                double[]pixel = focusRegion.get(x, y);
                if (pixel[0] == 255)
                    copy.put(x, y, old.get(x, y));
            }
        }
    }

    public static void inversor(Mat img) {

        byte[] buffer = toByteArray(img);

        for (int i = 0; i < buffer.length; i++)
            buffer[i] *= -1;

        img.put(0, 0, buffer);
    }
    
    public static void inversor(Mat img, Rect region) {

        Mat sub = img.submat(region);
        byte[] buffer = toByteArray(sub);

        for (int i = 0; i < buffer.length; i++) 
            buffer[i] *= -1;

        sub.put(0, 0, buffer);
    }
   

    public static Mat copy(Mat img) {
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
    
    public static void vhs(Mat img, String VHS) {

        if (!fileExist(VHS)) 
            throw new RuntimeException("Mascara VHS não encontrada!");

        Mat vhs = readImg(VHS);
        sumMat(img, vhs);
    }
    
    public static void blur(Mat mat, int size) {

        if (size % 3 != 0) 
            size += 3;

        Imgproc.GaussianBlur(mat, mat, new Size(size, size), Core.BORDER_DEFAULT);
    }

    public static void blur(Mat mat, int size, Rect region) {

        if (size % 3 != 0) {
            size += 3;
        }

        Imgproc.GaussianBlur(mat.submat(region), mat.submat(region), new Size(size, size), Core.BORDER_DEFAULT);
    }

    public static void grayScale(Mat img, Rect region) {

        Mat sub = img.submat(region);
        Imgproc.cvtColor(sub, sub, Imgproc.COLOR_RGB2GRAY);
        Imgproc.cvtColor(sub, sub, Imgproc.COLOR_GRAY2BGR);

        sub.copyTo(img.submat(region));
    }
    
    public static void morphology(Mat img, int morph_size) {

        Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(morph_size, morph_size));
        Imgproc.morphologyEx(img, img, Imgproc.MORPH_OPEN, element);

    }

    public static void morphology(Mat img, int morph_size, Rect region) {

        Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(morph_size, morph_size));
        Imgproc.morphologyEx(img.submat(region), img.submat(region), Imgproc.MORPH_OPEN, element);

    }
    
    public static void resize(Mat img) {

        Size size = new Size(img.width() * 0.05, img.height() * 0.05);
        Imgproc.resize(img, img, size);
    }

    public static void grayScale(Mat img) {
        
        Imgproc.cvtColor(img, img, Imgproc.COLOR_RGB2GRAY);
        Imgproc.cvtColor(img, img, Imgproc.COLOR_GRAY2BGR);
    }

    public static void resize(Mat img, Size size) {
        Imgproc.resize(img, img, size);
    }
   
    public static void delete(Mat img, Rect region) {
        img.submat(region).setTo(new Scalar(0, 0, 0));
    }

    public static void delete(Mat img, int x, int y, int size) {
        Rect region = new Rect(x, y, size, size);
        img.submat(region).setTo(new Scalar(0, 0, 0));
    }

    public static Mat readImg(String url) {
        return Imgcodecs.imread(url, Imgcodecs.IMREAD_UNCHANGED);
    }

    private static boolean fileExist(String url) {
        return new File(url).exists();
    }

    public static Mat cut(Mat img, Rect region) {
        return img.submat(region);
    }

    public static void save(String path, Mat img) {
        Imgcodecs.imwrite(path, img);
    }
    
    public static void paint(int[] color,int width,int height, int x, int y, Mat img){
        img.submat(new Rect(x, y, width, height)).setTo(new Scalar(color[0],color[1],color[2]));
    }

    public static double[] pixel(Mat img, int x, int y) {
        return img.get(x, y);
    }
    
    public static void copyToRegion(Mat img, Mat copy, Rect region) {
        copy.copyTo(img.submat(region));
    }
    
    public static void cartoon(Mat img,Rect region){
        cartoon(img.submat(region));
    }
    
    public static void glitchWave(Mat img, int waveLength, EColor color, Rect region) {
        glitchWave(img.submat(region), waveLength, color);
    }
    
    public static void noise(Mat img, int noise, Rect region) {
        noise(img.submat(region),noise);
    }
    
    public static void sepia(Mat img, Rect region){
        sepia(img.submat(region));
    }
    
    public static void writeText(Text text, Mat img, Rect region ) {
    
        img = img.submat(region);
        Point point = new Point(0, img.height()/2);
        Imgproc.putText(img, text.getStr(), point,Core.FONT_ITALIC, text.getScale(), text.getColor(),text.getScale());
    }
    
    
    public static void contrastAndBrightness(Mat img,double alpha, double beta, Rect region) {
        contrastAndBrightness(img.submat(region), alpha, beta);
    }
    public static Rect getRect(JComponent c) {

        int x = c.getX();
        int y = c.getY();

        int width = c.getWidth();
        int height = c.getHeight();

        return new Rect(x, y, width, height);
    }
}
