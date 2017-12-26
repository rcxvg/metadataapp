package com.rcggs.metadata.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Util {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String content = new Scanner(new File("C:/Users/aluris/Documents/createjob.txt")).useDelimiter("\\Z").next();
		System.out.println(content);

	}

	public String readTextFile(String filePath) {
		Scanner scanner = null;
		try {
			ClassLoader classLoader = (ClassLoader)getClass().getClassLoader();
			scanner = new Scanner(new File(filePath));
			return  scanner.useDelimiter("\\Z").next();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			scanner.close();
		}
		
		return null;

	}
}
