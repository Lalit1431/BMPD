package bmpd.tests;

import java.util.ArrayList;

public class javacompiler {

	public static void main(String[] args) {
		 String test="TATA SIA AIRLINES LTD dba VISTARA (24)";
	       String[] arrOfStr = test.split("\\(", 2);
	        String text1=arrOfStr[1];
	        String text2=text1.replace(")","");
	       // System.out.println(text2);
	      //   System.out.println(arrOfStr[0].trim());
	        ArrayList<String> arr = new ArrayList<>(); 
	        arr.add(text2);
	       arr.add(arrOfStr[0].trim());
	        
	      System.out.println(arr.get(0));
	      

	}

}
