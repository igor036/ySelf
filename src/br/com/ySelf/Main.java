package br.com.ySelf;

import org.opencv.core.Core;
import org.opencv.core.Mat;

import br.com.ySelf.util.MatUtil;


public class Main {
	
	public static void main(String[] args) {
		
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		Mat img = MatUtil.readImg("C:\\Users\\igor.lima\\Desktop\\teste opencv\\perfil5.jpg");
		MatUtil.merge(img, MatUtil.DOG_PNG);
		MatUtil.show(img, "teste2");
		
	}

}
