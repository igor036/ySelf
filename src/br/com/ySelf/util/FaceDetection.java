package br.com.ySelf.util;

import org.opencv.objdetect.CascadeClassifier;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.Point;


public abstract class FaceDetection {
	
	private static CascadeClassifier face_cascade;
	private static boolean isStarted = false;
	
	private static void start() {
		
		face_cascade = new CascadeClassifier("xml\\haarcascade_frontalface_alt.xml");
		
		if (!face_cascade.load("xml\\haarcascade_frontalface_alt.xml")) {
			System.out.println("error loading xml face cascade!");
			System.exit(1);
		}
		
		isStarted = true;
	}
	
	public static Rect[] rectOfFace(Mat img) {
		
		if(!isStarted)
			start();
		
		MatOfRect matOfFaces = new MatOfRect();
		Mat processImg = preProcess(img);
		
		face_cascade.detectMultiScale(img,matOfFaces);
		
		Rect[] faces = matOfFaces.toArray();
		
		//draw rect in faces
		for (Rect r : faces) {
			
			Point a = new Point(r.x,r.y);
			Point b = new Point(r.x + r.width ,r.y + r.height);
			
			Imgproc.rectangle(img, a, b, new Scalar(0,0,255));
		}
		
		return faces;
	}
	
	private static Mat preProcess(Mat img) {
		
		Mat processImg = new Mat();
		
		Imgproc.cvtColor(img, processImg, Imgproc.COLOR_RGB2GRAY);
		Imgproc.equalizeHist(processImg, processImg);
		
		return processImg;
	}
}
