/*
Authors: Igor Joaquim dos Santos Lima
GitHub: https://github.com/igor036
*/


package br.com.ySelf.util;

import br.com.ySelf.modal.ESloopFaceDirection;
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
    private static CascadeClassifier eyes_cascade;
    private static CascadeClassifier left_eye_cascade;
    private static CascadeClassifier right_eye_cascade;
    private static CascadeClassifier nose_cascade;
    private static boolean faceIsStarted = false;
    private static boolean eyeIsStarted = false;
    private static boolean noseIsStarted = false;
    private static boolean showDetection = false;
    
    public static Rect[] rectOfFace(Mat img) {

        if (!faceIsStarted) {
            face_start();
        }

        MatOfRect matOfFaces = new MatOfRect();
        Mat processImg = preProcess(img);

        face_cascade.detectMultiScale(processImg, matOfFaces);

        Rect[] faces = matOfFaces.toArray();
        drawnRects(faces, img);
        
        return faces;
    }
    
    public static Rect[] rectsOfEyes(Mat img){
        
        if (!eyeIsStarted) {
            eye_start();
        }
        
        Mat processImg = preProcess(img);
        MatOfRect matOfRightEye = new MatOfRect();
        MatOfRect matOfLeftEye = new MatOfRect();
        
        right_eye_cascade.detectMultiScale(processImg, matOfRightEye);
        left_eye_cascade.detectMultiScale(processImg, matOfLeftEye);
        
        Rect rightEye = matOfRightEye.toArray()[0];
        Rect leftEye = matOfLeftEye.toArray()[0];

        Rect[] eyesOfFace = new Rect[] {rightEye, leftEye};
        drawnRects(eyesOfFace, img);
        
        return eyesOfFace;
    }
    
    public static Rect rectOfNose(Mat img){
        
        if(!noseIsStarted)
            nose_start();
        
        MatOfRect matOfNoses = new MatOfRect();
        Mat processImg = preProcess(img);

        nose_cascade.detectMultiScale(processImg, matOfNoses);
        
        Rect[] noses = matOfNoses.toArray();
        if (noses.length > 1 && noses[1].x < noses[0].x)
            return noses[1];
        
        return noses[0];
    }
    
    public static int anchorPointX(Mat img, double sloopOfFace, ESloopFaceDirection direction) {
        Rect[] eyes = rectsOfEyes(img);
        int x = (int)((eyes[0].x + eyes[1].x) / 2);
        return (int)Math.abs(x += img.width() / 400 + sloopOfFace * 2 * direction.getInvFlag());
    }
    
    public static int anchorPointY(Mat img){
        return img.height() / 2;
    }
    
    public static double slopOfFace(Mat img) {
        Rect[] eyes = rectsOfEyes(img);
        Rect rightEye = eyes[0];
        Rect leftEye = eyes[1];
        return (rightEye.y - leftEye.y);
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
    
    private static void nose_start() {

        nose_cascade = new CascadeClassifier();
        if (!nose_cascade.load("xml\\haarcascade_nose.xml")) {
            System.out.println("error loading xml nose cascade!");
            System.exit(1);
        }

        noseIsStarted = true;
    }
    
    private static void face_start() {

        face_cascade = new CascadeClassifier();
        if (!face_cascade.load("xml\\haarcascade_frontalface_alt.xml")) {
            System.out.println("error loading xml face cascade!");
            System.exit(1);
        }

        faceIsStarted = true;
    }
    
    private static void eye_start() {
    
        eyes_cascade = new CascadeClassifier();
        left_eye_cascade = new CascadeClassifier();
        right_eye_cascade = new CascadeClassifier();
        
        if (!eyes_cascade.load("xml\\haarcascade_eye.xml") || 
                !left_eye_cascade.load("xml\\haarcascade_lefteye_2splits.xml") ||
                !right_eye_cascade.load("xml\\haarcascade_righteye_2splits.xml")) {
            System.out.println("error loading xml eye cascade!");
            System.exit(1);
        }

        eyeIsStarted = true;
    }
    
    private static Mat preProcess(Mat img) {
        Mat processImg = new Mat();
        Imgproc.cvtColor(img, processImg, Imgproc.COLOR_RGB2GRAY);
        Imgproc.equalizeHist(processImg, processImg);
        return processImg;
    }
    
    private static void drawnRects(Rect[] rects, Mat img) {
        if(showDetection) {
            for (Rect r : rects) {
                Point a = new Point(r.x, r.y);
                Point b = new Point(r.x + r.width, r.y + r.height);
                Imgproc.rectangle(img, a, b, new Scalar(0, 0, 255));
            }
        }
    }
}