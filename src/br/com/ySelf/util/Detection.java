package br.com.ySelf.util;

import org.opencv.objdetect.CascadeClassifier;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.Point;

public abstract class Detection {

    //var's
    private static CascadeClassifier face_cascade;
    private static CascadeClassifier eye_cascade;
    private static boolean faceIsStarted = false;
    private static boolean eyeIsStarted  = false;
    private static boolean showDetection = false;
    
    //const's
    private static final int ADJUSTMENT_X_WIDTH_GLASSES = 20;
    
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
    
    private static Rect[] eyesOfFace(Mat img){
    
        if (!eyeIsStarted) {
            eye_start();
        }
        
        MatOfRect matOfEyes = new MatOfRect();
        Mat processImg = preProcess(img);

        eye_cascade.detectMultiScale(img, matOfEyes);

        Rect[] eyes = matOfEyes.toArray();
        
        return eyes;
    }

    private static Mat preProcess(Mat img) {

        Mat processImg = new Mat();

        Imgproc.cvtColor(img, processImg, Imgproc.COLOR_RGB2GRAY);
        Imgproc.equalizeHist(processImg, processImg);

        return processImg;
    }
}
