package com.codinghub.collegebuddy.helper;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;

import org.springframework.web.multipart.MultipartFile;

import com.codinghub.collegebuddy.domain.Answer;
import com.codinghub.collegebuddy.domain.AnswerFile;
import com.codinghub.collegebuddy.domain.Question;
import com.codinghub.collegebuddy.domain.QuestionFile;

public class HelperClass {
	/**
	 * generate username using Email Address
	 *
	 * @param userEmail
	 * @return
	 */
	public static String generateUsername(String userEmail) {
		String username = null;
		if (userEmail != null) {
			username = userEmail.substring(0, userEmail.lastIndexOf("@"));
		}
		return username;
	}

	/**
	 * Encrypting password using 'password' with md5()
	 *
	 * @param password
	 * @return
	 */
	public static String encyptPassword(String input) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		// digest() method is called to calculate message digest
		// of an input digest() return array of byte
		byte[] messageDigest = md.digest(input.getBytes());

		// Convert byte array into signum representation
		BigInteger no = new BigInteger(1, messageDigest);

		// Convert message digest into hex value
		String hashtext = no.toString(16);
		while (hashtext.length() < 32) {
			hashtext = "0" + hashtext;
		}
		return hashtext;
	}

	public static boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

	public static double getRandomIntegerBetweenRange(double min, double max){
	    double x = (int)(Math.random()*((max-min)+1))+min;
	    return x;
	}
	
	/// Uploading Question Files
	public static Collection<QuestionFile> uploadQuestionFiles(Question question, MultipartFile[] files, String uploadFileDirectory) {
		/// let's create a StringBuilder variable to hold the name of the files
		StringBuilder fileNames = new StringBuilder();
		Collection<QuestionFile> fileUploads = new ArrayList<QuestionFile>();

		/// now let's get each file from the multipart files list
		for (MultipartFile file : files) {
			QuestionFile fp = new QuestionFile();
			/// let's create a fileName with upload path followed by original file name
			Path fileNameAndPath = Paths.get(uploadFileDirectory, file.getOriginalFilename());
			
			/// now append the filename with string builder var
			String customFileName = question.getId() + getRandomIntegerBetweenRange(99, 999) + file.getOriginalFilename();
			fileNames.append(customFileName);

			/// Now write the file onto the created fileNameAndPath
			try {
				Files.write(fileNameAndPath, file.getBytes());

				/// let's save each file to database
				fp.setFileName(file.getOriginalFilename());
				fp.setQuestion(question);
				fp.setFileType(file.getContentType());
				fp.setFileSize(file.getSize());
				fileUploads.add(fp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return fileUploads;
	}
	
	/// Uploading Answer Files
		public static Collection<AnswerFile> uploadAnswerFiles(Answer answer, MultipartFile[] files, String uploadFileDirectory) {
			/// let's create a StringBuilder variable to hold the name of the files
			
			StringBuilder fileNames = new StringBuilder();
			Collection<AnswerFile> fileUploads = new ArrayList<AnswerFile>();

			/// now let's get each file from the multipart files list
			for (MultipartFile file : files) {
				AnswerFile fp = new AnswerFile();
				/// let's create a fileName with upload path followed by original file name
				Path fileNameAndPath = Paths.get(uploadFileDirectory, file.getOriginalFilename());
				
				/// now append the filename with string builder var
				String customFileName = answer.getId() + getRandomIntegerBetweenRange(99, 999) + file.getOriginalFilename();
				fileNames.append(customFileName);

				/// Now write the file onto the created fileNameAndPath
				try {
					Files.write(fileNameAndPath, file.getBytes());

					/// let's save each file to database
					fp.setFileName(file.getOriginalFilename());
					fp.setAnswer(answer);
					fp.setFileType(file.getContentType());
					fp.setFileSize(file.getSize());
					fileUploads.add(fp);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			return fileUploads;
		}
}
