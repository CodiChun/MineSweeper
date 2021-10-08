package defult;


import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Run the mine sweeper.
 * @author Codi Chun
 * @version Oct 7, 2021
 */
public class Main {
	private static String myLine;
	private static int myFieldNumber = 0;
	//private static String[] strings;
	private static StringBuilder myResult = new StringBuilder();
	
	public static void main(String[] args) throws FileNotFoundException {
		//read from redirection
		 Scanner input = new Scanner(System.in);
		 myLine = input.nextLine();
		 while (!myLine.equals("0 0")) {
				String[] numbers = myLine.split(" ");
				int n = Integer.valueOf(numbers[0]);
				int m = Integer.valueOf(numbers[1]);
				String[][] matrix1 = new String[n + 2][m + 2];
				String[][] matrix2 = new String[n + 2][m + 2];
				if (n > 0 && m > 0) {
					myFieldNumber ++;
					//System.out.println("Field #" + fieldNumber + ":");
					//adding one line above the one line below
					for(int j=0;j<m+2;j++) {
						matrix1[0][j] = ".";
						matrix2[0][j] = "0";
						matrix1[n+2-1][j] = ".";
						matrix2[n+2-1][j] = "0";
					}
					
					//creating the grid to matrix1 and 2
					for(int i = 1; i < n + 2 - 1; i++) {
						myLine = input.nextLine();
						int k=0;
						//adding one column in front in one column behind
						matrix1[i][0]=".";
						matrix1[i][m + 2-1] = ".";
						matrix2[i][0] = "0";
						matrix2[i][m + 2-1] = "0";
						
						//Storing the grid to matrix1 and 2
						for(int j = 1; j < m+2-1;j++) {
							matrix1[i][j] = Character.toString(myLine.charAt(k));
							matrix2[i][j] = "0";
							k++;
						}						
					}

					//Edit the matrix2 based on matrix1
					for(int i=1;i<n+2-1;i++) {
						for(int j=1; j<m+2-1;j++) {
							
							if(matrix1[i][j].equals("*")) {
								matrix2[i][j] = "*";
								changePreviousLine(i,j,m,matrix2);
								changeSameLine(i,j,m,matrix2);
								changeNextLine(i,j,m,matrix2);
							}
						}
					}
					//Storing the matrix2 to result
					myResult.append("Field #" + myFieldNumber + ":\n");
					if(n>0 && m>0) {
						for(int i=1;i<n+2-1;i++) {
							for(int j=1; j<m+2-1;j++) {
								//System.out.print(matrix2[i][j]);
								myResult.append(matrix2[i][j]);
							}
							//System.out.println();
							myResult.append("\n");
						}
						//System.out.println();
						myResult.append("\n");
					}				
					myLine = input.nextLine();
				}
		 }
		input.close();
		System.out.println(myResult.toString());
				

	}
	
	public static void changeSameLine(int i, int j, int m, String[][]matrix2) {
	
		if (!matrix2[i][j-1].equals("*")) {
			//change the left one
			int cn2 = Integer.parseInt(matrix2[i][j-1])+1;
			String c2 = Integer.toString(cn2);
			matrix2[i][j-1] = c2;
		}
			
			//change the right one
			if (!matrix2[i][j+1].equals("*")) {
			int cn3 = Integer.parseInt(matrix2[i][j+1])+1;
			String c3 = Integer.toString(cn3);
			matrix2[i][j+1] = c3;
		}
	}
	
	public static void changeNextLine(int i, int j, int m, String[][]matrix2) {

		if(!matrix2[i+1][j].equals("*")) {
			//change the below one
			int cn6 = Integer.parseInt(matrix2[i+1][j])+1;
			String c6 = Integer.toString(cn6);
			matrix2[i+1][j] = c6;
		}
		if(!matrix2[i+1][j-1].equals("*")) {
			//change the left one of the below one
			int cn2 = Integer.parseInt(matrix2[i+1][j-1])+1;
			String c2 = Integer.toString(cn2);
			matrix2[i+1][j-1] = c2;
		}
		if(!matrix2[i+1][j+1].equals("*")) {
			//change the right one of the below one
			int cn3 = Integer.parseInt(matrix2[i+1][j+1])+1;
			String c3 = Integer.toString(cn3);
			matrix2[i+1][j+1] = c3;
		}	
	}
	
	public static void changePreviousLine(int i, int j, int m, String[][]matrix2) {

		if (!matrix2[i-1][j].equals("*")) {
			//change the above one
			int cn1 = Integer.parseInt(matrix2[i-1][j])+1;
			String c1 = Integer.toString(cn1);
			matrix2[i-1][j] = c1;
		}
		
		if(!matrix2[i-1][j-1].equals("*")) {
			//change the left of the above one
			int cn2 = Integer.parseInt(matrix2[i-1][j-1])+1;
			String c2 = Integer.toString(cn2);
			matrix2[i-1][j-1] = c2;
		}
		
		if(!matrix2[i-1][j+1].equals("*")) {
			//change the right of the above one
			int cn3 = Integer.parseInt(matrix2[i-1][j+1])+1;
			String c3 = Integer.toString(cn3);
			matrix2[i-1][j+1] = c3;
		}
	}
}
