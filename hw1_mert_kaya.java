//ETULang Lexical Analyzer
//Written By Mert KAYA - 161101061
//2/10/2021

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.PrintWriter;
import java.util.Scanner; // Import the Scanner class to read text files

public class hw1_mert_kaya {

	static String outputFileName;
	static String outputFileText;
	static PrintWriter out;
	static boolean onComment = false;

	//Method to read the given .ETU file
	private static String readTheEtuFile(String fileName){
		
		outputFileText = "";
		
		//Try-catch for better exception handling
		try {
			out = new PrintWriter(outputFileName);
			//File name must have .ETU at the end.
			if(!checkFileName(fileName)){
				out.print("File extention must be .ETU.\nTerminated.");
				try {
				} catch (Exception e) {
					e.printStackTrace();
				}
				out.close();
				System.exit(0);
			}

			//Created file object and scanned through it line by line
			File myObj = new File(fileName);
			Scanner myReader = new Scanner(myObj,"utf-8");
		
			String allOfProgram = "";
			//Line by line file reading loop
			while (myReader.hasNext()) {
				String partOfProgram = myReader.next();
				allOfProgram = allOfProgram +" "+ partOfProgram + " ";
			}

			//End of file reading part
			myReader.close();
			return allOfProgram;

		}catch (FileNotFoundException e) {
			out.print("An error occurred.\n");
			out.close();
			e.printStackTrace();
			System.exit(0);
			return "";
		}
	}

	//Checks whether input file has .ETU extention or not
	private static boolean checkFileName(String fileName){
		int indexOfDot = fileName.indexOf(".");
		String shouldBeETU = fileName.substring(indexOfDot);
		return shouldBeETU.equalsIgnoreCase(".ETU");
	}



	private static void parseTheProgram(String program){
		
		//program = program.toLowerCase();
		String[] programArray = program.split(" ");

		onComment = false;

		for(int i = 0 ; i < programArray.length ; i++){

			//If a part of program contains all whitespaces
			if(programArray[i].isBlank()){
				continue;
			}

			//If a comment part started or not
			if(programArray[i].contains("%")){
				charByCharTokenCheck(programArray[i]);
				continue;
			}

			if(onComment){
				//It is on comment mode so no analyzing
				continue;
			}

			if(programArray[i].equalsIgnoreCase("program")){
				out.print("Next token is RES_WORD	Next lexeme is program\n");
				continue;
			}

			if(programArray[i].equalsIgnoreCase("begin")){
				out.print("Next token is RES_WORD	Next lexeme is begin\n");
				continue;
			}

			if(programArray[i].equalsIgnoreCase("end")){
				out.print("Next token is RES_WORD	Next lexeme is end\n");
				
				continue;
			}

			if(programArray[i].equalsIgnoreCase("if")){
				out.print("Next token is RES_WORD	Next lexeme is if\n");
				continue;
			}

			if(programArray[i].equalsIgnoreCase("then")){
				out.print("Next token is RES_WORD	Next lexeme is then\n");
				continue;
			}

			if(programArray[i].equalsIgnoreCase("else")){
				out.print("Next token is RES_WORD	Next lexeme is else\n");
				continue;
			}

			if(programArray[i].equalsIgnoreCase("while")){
				out.print("Next token is RES_WORD	Next lexeme is while\n");
				continue;
			}

			if(programArray[i].equalsIgnoreCase("integer")){
				out.print("Next token is RES_WORD	Next lexeme is integer\n");
				continue;
			}

			if(programArray[i].equalsIgnoreCase("var")){
				out.print("Next token is RES_WORD	Next lexeme is var\n");
				continue;
			}

			charByCharTokenCheck(programArray[i]);

			continue;

		}

		//END OF FILE

		out.print("Next token is end of file Next lexeme is EOF");

	}

	//Checks for a token in a given string
	//Does comment control and res_word control too
	private static void charByCharTokenCheck(String text) {
		
		boolean digitControl = false;
		boolean alphaControl = false;
		

		for(int i = 0 ; i < text.length() ; i++){

			char checkedChar = text.charAt(i);

			//COMMENT CONTROL
			if(checkedChar == '%'){
				onComment = !onComment;
				continue;
			}

			if(onComment){
				continue;
			}

			if( i-1 >= 0){
				if(Character.isDigit(text.charAt(i-1))){
					digitControl = true;
				}
			}else{
				if(i == 0){
					if(Character.isDigit(text.charAt(i))){
						digitControl = true;
					}
				}
			}

			//identifier check
			if((Character.isAlphabetic(checkedChar) || Character.isDigit(checkedChar)) && !digitControl){


				alphaControl = true;
				String identifier = "";
				while(Character.isAlphabetic(checkedChar) || Character.isDigit(checkedChar)){
					checkedChar = text.charAt(i);
					identifier += checkedChar;
					i = i+1;
					if(i < text.length()){
						checkedChar = text.charAt(i);
						
					}else{
						//i = i-1;
						//alphaControl = false;
						break;
					}
				}

				//Check for 15 chars
				if(identifier.length() > 15){
					i = i-1;
					
					//LONG INT_CONST PART
					boolean long_int = false;
					for(int i2 = 0 ; i2 < identifier.length() ; i2++){
						long_int = true;
						if(!Character.isDigit(identifier.charAt(i2))){
							long_int = false;
							break;
						}
					}
					if(long_int){
						out.print("Next token is INT_LIT Next lexeme is " + identifier + "\n");
						continue;
					}

					out.print("Next token is UNKNOWN Next lexeme is " + identifier + "\n");
					//alphaControl = false;
					continue;
				}else{
					i = i-1;

					if(identifier.equalsIgnoreCase("begin")){
						out.print("Next token is RES_WORD Next lexeme is begin\n");
						continue;
					}else if(identifier.equalsIgnoreCase("end")){
						out.print("Next token is RES_WORD Next lexeme is end\n");
						continue;
					}else if(identifier.equalsIgnoreCase("if")){
						out.print("Next token is RES_WORD Next lexeme is if\n");
						continue;
					}else if(identifier.equalsIgnoreCase("then")){
						out.print("Next token is RES_WORD Next lexeme is then\n");
						continue;
					}else if(identifier.equalsIgnoreCase("else")){
						out.print("Next token is RES_WORD Next lexeme is else\n");
						continue;
					}else if(identifier.equalsIgnoreCase("while")){
						out.print("Next token is RES_WORD Next lexeme is while\n");
						continue;
					}else if(identifier.equalsIgnoreCase("program")){
						out.print("Next token is RES_WORD Next lexeme is program\n");
						continue;
					}else if(identifier.equalsIgnoreCase("integer")){
						out.print("Next token is RES_WORD Next lexeme is integer\n");
						continue;
					}else if(identifier.equalsIgnoreCase("var")){
						out.print("Next token is RES_WORD Next lexeme is var\n");
						continue;
					}


					//all digit check
					boolean allDigit = true;
					for(int i2 = 0 ; i2 < identifier.length() ; i2++){
						if(!Character.isDigit(identifier.charAt(0))){
							allDigit = false;
							break;
						}
					}

					//Contains all digits
					if(allDigit){
						out.print("Next token is INT_LIT Next lexeme is " + identifier + "\n");
						digitControl = false;
						continue;
					}

					out.print("Next token is identifier Next lexeme is " + identifier + "\n");
					continue;
				}

				//alphaControl = false;
			}

			//only digit check - part
			if(Character.isDigit(checkedChar) && !alphaControl ){

				digitControl = true;
				String number = "";
				while(Character.isDigit(checkedChar)){
					number += checkedChar;
					checkedChar = text.charAt(i);
					i = i+1;
					if(i < text.length() ){
						checkedChar = text.charAt(i);
					}else{
						break;
					}
				}
				
				if(i < text.length() - 1){
					if(Character.isAlphabetic(text.charAt(i+1))){
						out.print("ERROR - Numeric then alphabetic Error\n");
						try{
							while(Character.isAlphabetic(text.charAt(i+1))){
								i = i + 1;
							}
						}catch(Exception e){
							out.close();
						}
						continue;
					}else{
						i = i-1;
						out.print("Next token is INT_LIT Next lexeme is " + number + "\n");
						continue;
					}
				}
				i = i-1;
				out.print("Next token is INT_LIT Next lexeme is " + number + "\n");
				digitControl = false;
				continue;
			}
			
			alphaControl = false;
			digitControl = false;

			//1 char tokens part
			if(checkedChar == '('){
				out.print("Next token is LPARANT	Next lexeme is (\n");
				continue;
			}


			if(checkedChar == ')'){
				
				out.print("Next token is RPARANT	Next lexeme is )\n");
				continue;
			}

			if(checkedChar == '+'){
				
				out.print("Next token is ADD	Next lexeme is +\n");
				continue;
			}

			if(checkedChar == '-'){
				
				out.print("Next token is SUBT	Next lexeme is -\n");
				continue;
			}

			if(checkedChar == '/'){
				out.print("Next token is DIV	Next lexeme is /\n");
				continue;
			}

			if(checkedChar == '*'){
				
				out.print("Next token is MULT	Next lexeme is *\n");
				continue;
			}

			if(checkedChar == ';'){
				
				out.print("Next token is SEMICOLON	Next lexeme is ;\n");
				continue;
			}


			if(checkedChar == '<'){
				if(text.length() != i+1){
					if(text.charAt(i+1) == '>'){
						
						out.print("Next token is NOTEQ	Next lexeme is <>\n");
						i = i+1;
						continue;
					}else if(text.charAt(i+1) == '='){
						
						out.print("Next token is LESS_EQ	Next lexeme is <=\n");
						i = i+1;
						continue;
					}
				}
				
				out.print("Next token is LESS	Next lexeme is <\n");
				continue;
			}

			if(checkedChar == '>'){
				if(text.length() != i+1){
					if(text.charAt(i+1) == '='){
						
						out.print("Next token is GRE_EQ	Next lexeme is >=\n");
						i = i+1;
						continue;
					}
				}
				
				out.print("Next token is GREATER	Next lexeme is >\n");
				continue;
			}


			if(checkedChar == ':'){
				if(text.length() != i+1){
					if(text.charAt(i+1) == '='){
						
						out.print("Next token is ASSIGNM	Next lexeme is :=\n");
						i = i+1;
						continue;
					}
				}
				
				out.print("Next token is COLON	Next lexeme is :\n");
				continue;
			}


			if(checkedChar == '('){
				
				out.print("Next token is LPARANT	Next lexeme is (\n");
				continue;
			}

			if(checkedChar == ','){
				
				out.print("Next token is COMMA	Next lexeme is ,\n");
				continue;
			}

			if(Character.isDigit(checkedChar)){
				out.print("Next token is INT_LIT Next lexeme is "+checkedChar+"\n");
				digitControl = false;
				continue;
			}
			out.print("Next token is UNKNOWN	Next lexeme is "+checkedChar+"\n");
		}

	}


  public static void main(String[] args) {

	outputFileName = args[1];
	String program = readTheEtuFile(args[0]);
	parseTheProgram(program);
	out.close();
  }
}