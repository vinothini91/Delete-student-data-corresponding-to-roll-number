package hello;

import static java.nio.file.StandardOpenOption.APPEND;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DeleteStudentDetailCorrespondintToRollNumber {

	public static void main(String[] args) {
		try

		{

			boolean match = false;

			File file = new File("F:/vino--programs-2021/student4.txt");

			Path path = Paths.get(file.toString());
			OutputStream output = new BufferedOutputStream(Files.newOutputStream(path, APPEND));
			BufferedReader reader = new BufferedReader(new FileReader(file));

			String line = null;

			System.out.println("Enter Roll Number:");
			Scanner scan = new Scanner(System.in);

			int i = scan.nextInt();
			String number = String.valueOf(i);
			ArrayList<String> list = new ArrayList<String>();
			while ((line = reader.readLine()) != null) {

				String[] array1 = line.split(" ");
				Collections.addAll(list, array1);

				for (int j = 0; j < list.size(); j++)

				{

					String words = list.get(j);
					String position1 = words.substring(0, 1);
					String position2 = words.substring(0, 2);

					if (number.equals(position1)) {

						match = true;
						list.remove(j);

						System.out.println("Roll number exist");
						System.out.println("Record Deleted");
						break;

					} else if (number.equals(position2))

					{

						match = true;
						list.remove(j);
						System.out.println("Roll number exist");
						System.out.println("Record Deleted");
						break;
					}

				}

			}

			OutputStream student_overwrite = new BufferedOutputStream(Files.newOutputStream(path));
			FileWriter writer = new FileWriter(file);

			for (int k = 0; k < list.size(); k++) {
				String student_report = list.get(k);
				writer.write(student_report);
				writer.write("\n");

			}

			writer.close();

			InputStream input = Files.newInputStream(path);
			BufferedReader student_read = new BufferedReader(new InputStreamReader(input));

			String student_line = null;
			System.out.println("READ NEW STUDENT RECORD:");
			while ((student_line = student_read.readLine()) != null) {
				System.out.println(student_line);

			}

			if (!match)
				System.out.println("Roll number does not  exist");

		}

		catch (Exception e) {

		}

	}

}
