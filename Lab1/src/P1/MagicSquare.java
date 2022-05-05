package P1;

import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class MagicSquare {
	static int errkind = 0;
	private BufferedReader in;

	public boolean isLegalMagicSquare(String fileName) {

		int linenum = 0, num = 0;
		String[] line = null;
		int[][] array = new int[200][200];
		String FileName = fileName;
		File myFile = new File("src/P1/txt/" + FileName);
		if (!myFile.exists()) {
			System.err.println("Can't Find " + FileName);
		}

		try {
			in = new BufferedReader(new FileReader(myFile));
			String str;
			while ((str = in.readLine()) != null) {
				int rownum = 0;
				line = str.split("\t");
				for (String s : line) {
					try {
						if (s.contains(" ") || s.contains("\\,")) {
							errkind = 2;
							return false;
						}
						if(Integer.parseInt(s)<=0)
						{
							errkind = 3;
							return false;
						}
						array[linenum][rownum] = Integer.parseInt(s);
						rownum++;
						num++;
					} catch (Exception e) {
						errkind = 3;
						return false;
					}
				}
				linenum++;
			}
			in.close();

		} catch (IOException e) {
			e.getStackTrace();
		}

		if (num != linenum * linenum) {
			errkind = 1;
			return false;
		}
		int[] sum = new int[300];
		int k = 0;
		for (int i = 0; i < linenum; i++) {
			int temp = 0;
			for (int j = 0; j < linenum; j++) {
				temp = temp + array[i][j];
			}
			sum[k] = temp;
			k++;
		}
		for (int i = 0; i < linenum; i++) {
			int temp = 0;
			for (int j = 0; j < linenum; j++) {
				temp = temp + array[j][i];
			}
			sum[k] = temp;
			k++;
		}
		int temp = 0;
		for (int i = 0; i < linenum; i++) {

			temp = temp + array[i][i];

		}
		sum[k] = temp;
		k++;
		temp = 0;
		for (int i = 0; i < linenum; i++) {

			temp = temp + array[i][linenum - i - 1];
		}
		sum[k] = temp;
		k++;
		for (int i = 0; i < k; i++) {
			if (sum[0] != sum[i]) {
				errkind = 4;
				return false;
			}
		}
		return true;

	}

	public static boolean generateMagicSquare(int n) throws IOException {
		if (n < 0 || n % 2 == 0) {
			return false;
		}
		int magic[][] = new int[n][n];
		int row = 0, col = n / 2, i, j, square = n * n;

		for (i = 1; i <= square; i++) {
			magic[row][col] = i;
			if (i % n == 0)
				row++;
			else {
				if (row == 0)
					row = n - 1;
				else
					row--;
				if (col == (n - 1))
					col = 0;
				else
					col++;
			}
		}
		File file = new File("src/P1/txt/6.txt");
		FileWriter out = new FileWriter(file);
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				out.write(magic[i][j] + "\t");
			}
			out.write("\r\n");
		}
		out.close();
		return true;

	}

	public static void main(String args[]) throws IOException {
		MagicSquare MagicSquare1 = new MagicSquare();
		String[] name = new String[5];
		name[0] = "1.txt";
		name[1] = "2.txt";
		name[2] = "3.txt";
		name[3] = "4.txt";
		name[4] = "5.txt";
		for (String s : name) {
			System.out.println(s + "\t" + MagicSquare1.isLegalMagicSquare(s));
			if (errkind == 1)
				System.out.println("Your input is NOT a matrix");
			else if (errkind == 2)
				System.out.println("Your input is NOT all divided by \\t ");
			else if (errkind == 3)
				System.out.println("Your input is NOT all Positive integer");
		}
		Scanner input = new Scanner(System.in);
		System.out.println("please input n:");
		int n = input.nextInt();
		input.close();
		boolean x = generateMagicSquare(n);
		if (x == true) {
			System.out.println("6.txt" + "\t" + MagicSquare1.isLegalMagicSquare("6.txt"));
		} else
			System.out.println("Your n is illegal,it should be positive and odd ");
		System.exit(0);
	}
}