package com.util;

public class Parser {

	
	/**
	 * trimParser any return null.
	 * @param str
	 * @param delimiter
	 * @return String[]
	 */
	public static String[] trimParser(String str, String delimiter) {
		
		String[] parseResult = {};
		
		if(str!=null&&delimiter!=null) {
			parseResult = str.split(delimiter, 0);
			
			if(parseResult!=null) {
				for(int i = 0; i < parseResult.length; i++) {
					parseResult[i] = parseResult[i].trim();
				}
			}
		}
		
		return parseResult;
	}
	
	
	public static void main(String[] args) {
		String[] arr = trimParser(null,",");

		if(arr!=null) {
			System.out.println(arr.length);
			
			for(int i = 0; i < arr.length; i++) {
				System.out.println("=" + arr[i]);
			}
		}

	}
}
