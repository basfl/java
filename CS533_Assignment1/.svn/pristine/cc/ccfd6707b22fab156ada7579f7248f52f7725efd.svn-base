package cs533.assignment1.basoltanifar.file.operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.QuestionAnswerMapHolders;

public class FileOrganizer {
	public static Map<Integer, String> questionAndAnswerMap = new HashMap<>();
	FileValidator fileValidator = new FileValidator();

	public Map<Integer, String> readFile(String path) throws IOException {
		java.io.FileReader f = new java.io.FileReader(path);
		try (BufferedReader br = new BufferedReader(f)) {

			/////////////////////////////////////////
			String questionTemp;
			List<String> QuestionTempList = new ArrayList<>();
			String AnswerTemp;
			String sCurrentLine;
			Integer cnt = 0;
			// QuestionAnswerMapHolders questionAnswerMapHolders;

			/////////////////////////////////

			while ((sCurrentLine = br.readLine()) != null) {
				if (sCurrentLine.isEmpty() || sCurrentLine.trim().equals("") || sCurrentLine.equals("\n")) {

				}

				if (sCurrentLine.startsWith("*")) {

					sCurrentLine = br.readLine();

				}
				/*
				 * convert @Q ,@q and @question or combaine to @Question to work
				 * with my algorithm
				 */
				if (sCurrentLine.toUpperCase().startsWith("@Q")) {
					sCurrentLine = sCurrentLine.replaceAll(sCurrentLine, "@QUESTION");
				}
				if (sCurrentLine.toUpperCase().startsWith("@QUESTION")) {

					while (!sCurrentLine.toUpperCase().startsWith("@ANSWERS")) {

						sCurrentLine = br.readLine();
						/*
						 * convert @A,@a and @answers or combain cases
						 * to @ANSWERS to work with my algorithm
						 */
						if (sCurrentLine.toUpperCase().startsWith("@A") || sCurrentLine.startsWith("@a")
								|| sCurrentLine.toLowerCase().startsWith("@answers")) {
							sCurrentLine = sCurrentLine.replaceAll(sCurrentLine, "@ANSWERS");

						}

						if (sCurrentLine.length() == 0 || sCurrentLine.startsWith("*")) {
							// empty line //

						} else if (sCurrentLine.length() > 0) {
							questionTemp = sCurrentLine;
							questionTemp = questionTemp + "\n";
							QuestionTempList.add(questionTemp);
							questionTemp = null;
						}

					}

				}
				if (sCurrentLine.startsWith("@ANSWERS")) {

					while (!sCurrentLine.startsWith("@END")) {
						sCurrentLine = br.readLine();
						/*
						 * convert @E,@e and @end to @END to work with my
						 * algorithm
						 */
						if (sCurrentLine.startsWith("@E") || sCurrentLine.startsWith("@e")
								|| sCurrentLine.toLowerCase().startsWith("@end")) {
							sCurrentLine = sCurrentLine.replaceAll(sCurrentLine, "@END");
						}
						if (sCurrentLine.length() == 0 || sCurrentLine.startsWith("*")) {
							// no empty line

						} else if (sCurrentLine.length() > 0) {

							AnswerTemp = sCurrentLine;
							AnswerTemp = AnswerTemp + "\n";

							QuestionTempList.add(AnswerTemp);
							AnswerTemp = null;
						}

					}
				}
				if (sCurrentLine.startsWith("@END")) {

					fixFinal(QuestionTempList, cnt);
					QuestionTempList.clear();

					cnt++;
				}

			} // end of while

			// System.out.println("finally the map is " +
			// questionAndAnswerMap.toString());
			
			return (questionAndAnswerMap);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			f.close();

		}
		return null;

	}

	public boolean validat() {

		return fileValidator.validate(questionAndAnswerMap);

	}

	private static void fixFinal(List<String> questionTempList, int cnt) {
		String finalFixStringTemp = null;
		// Map<Integer, String> questionAndAnswerMap = new HashMap<>();
		for (String tq : questionTempList) {
			finalFixStringTemp = finalFixStringTemp + tq;
		}
		// System.out.println("\n inside the loop" + finalFixStringTemp);
		questionAndAnswerMap.put(cnt, finalFixStringTemp);
		finalFixStringTemp = null;
		// System.out.println("\n **** "+questionAndAnswerMap.toString());

	}

}
