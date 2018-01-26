/*
Authors: Igor Joaquim dos Santos Lima
GitHub: https://github.com/igor036
*/


package br.com.ySelf.util;

import org.opencv.core.Core;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.Point;
import org.opencv.core.Size;

public abstract class Detection {

    //var's
    private static CascadeClassifier face_cascade;
    private static CascadeClassifier eye_cascade;
    private static CascadeClassifier nose_cascade;
    private static boolean faceIsStarted     = false;
    private static boolean eyeIsStarted      = false;
    private static boolean noseIsStarted     = false;
    private static boolean showDetection     = false;
    
    //const's
    private static final int ADJUSTMENT_X_WIDTH_GLASSES = 20;
    
    private static void nose_start() {

        nose_cascade = new CascadeClassifier("xml\\haarcascade_nose.xml");
        if (!nose_cascade.load("xml\\haarcascade_nose.xml")) {
            System.out.println("error loading xml nose cascade!");
            System.exit(1);
        }

        noseIsStarted = true;
    }
    
    private static void face_start() {

        face_cascade = new CascadeClassifier("xml\\haarcascade_frontalface_alt.xml");
        if (!face_cascade.load("xml\\haarcascade_frontalface_alt.xml")) {
            System.out.println("error loading xml face cascade!");
            System.exit(1);
        }

        faceIsStarted = true;
    }
    
    private static void eye_start() {
    
        eye_cascade = new CascadeClassifier("xml\\haarcascade_eye.xml");
        if (!eye_cascade.load("xml\\haarcascade_eye.xml")) {
            System.out.println("error loading xml eye cascade!");
            System.exit(1);
        }

        eyeIsStarted = true;
    }
    
    public static Rect[] rectOfFace(Mat img) {

        if (!faceIsStarted) {
            face_start();
        }

        MatOfRect matOfFaces = new MatOfRect();
        Mat processImg = preProcess(img);

        face_cascade.detectMultiScale(img, matOfFaces);

        Rect[] faces = matOfFaces.toArray();

        //draw rect in faces
        if(showDetection) {
            for (Rect r : faces) {

                Point a = new Point(r.x, r.y);
                Point b = new Point(r.x + r.width, r.y + r.height);

                Imgproc.rectangle(img, a, b, new Scalar(0, 0, 255));
            }
        }
        
        return faces;
    }
    
    public static Rect[] rectOfEye(Mat img){
        
        Rect[] faces = rectOfFace(img);
        Rect[] eyes = new Rect[faces.length];
        
        for (int i = 0; i < faces.length; i++) {
            
            Mat mf = img.submat(faces[i]);
            Rect[] eyesOfFace = eyesOfFace(img);
            
            if (eyesOfFace.length > 1) { 
                
                Point a = new Point(faces[i].x + ADJUSTMENT_X_WIDTH_GLASSES, eyesOfFace[1].y);
                Point b = new Point(faces[i].x + faces[i].width - ADJUSTMENT_X_WIDTH_GLASSES ,eyesOfFace[1].y + eyesOfFace[1].width);
                
                if (showDetection)
                    Imgproc.rectangle(img, a, b, new Scalar(0, 0, 255));
                
                eyes[i] = new Rect(a, b);
            }
        }
        
        return eyes;
    }
    
    public static Rect[] eyesOfFace(Mat img){
    
        if (!eyeIsStarted) {
            eye_start();
        }
        
        MatOfRect matOfEyes = new MatOfRect();
        Mat processImg = preProcess(img);
        
        Imgproc.resize(processImg, processImg, new Size(22, 15));

        eye_cascade.detectMultiScale(img, matOfEyes);

        Rect[] eyes = matOfEyes.toArray();
        
        return eyes;
    }
    
    public static Rect rectOfNose(Mat img){
        
        if(!noseIsStarted)
            nose_start();
        
        MatOfRect matOfNoses = new MatOfRect();
        Mat processImg = preProcess(img);

        nose_cascade.detectMultiScale(img, matOfNoses);
        
        Rect[] noses = matOfNoses.toArray();
        System.out.println(noses.length);
        if (noses.length > 1 && noses[1].x < noses[0].x)
            return noses[1];
        
        return noses[0];
    }
    
    public static double anchorPoint(Mat img){
        
        Rect[] eyes = eyesOfFace(img);
        
        if (eyes[0].x < eyes[1].x)
            return (eyes[0].x + eyes[1].x) / 2;
        
        return (eyes[1].x + eyes[0].x) / 2;
    }

    private static Mat preProcess(Mat img) {

        Mat processImg = new Mat();

        Imgproc.cvtColor(img, processImg, Imgproc.COLOR_RGB2GRAY);
        Imgproc.equalizeHist(processImg, processImg);

        return processImg;
    }
    
    public static int slopOfFace(Mat img) {
        
        Rect[] eyes = eyesOfFace(img);
        
        if (eyes.length <= 1)
            return 0;
        
        if (eyes[0].x < eyes[1].x)
            return eyes[0].y - eyes[1].y;
        
        return eyes[1].y - eyes[0].y;
    }
   
    public static double density(Mat img, Rect rect) {

        Mat process = new Mat();
        Mat kernel = Imgproc.getStructuringElement(2, new Size(23, 23));

        Imgproc.cvtColor(img, process, Imgproc.COLOR_RGB2GRAY);
        Imgproc.GaussianBlur(process, process, new Size(3, 3), 0, 0, Core.BORDER_DEFAULT);

        Imgproc.Sobel(process, process, -1, 1, 0);
        Imgproc.threshold(process, process, 100, 255, Imgproc.THRESH_BINARY);
        Imgproc.morphologyEx(process, process, Imgproc.MORPH_CLOSE, kernel);

        Mat temp = process.submat(rect);
        int count_white = Core.countNonZero(temp);
        int count_black = temp.cols() * temp.rows() - count_white;
        return (count_white / (double) count_black);

    }
}
