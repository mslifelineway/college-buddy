package com.codinghub.collegebuddy.helper;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

public class UploadCroppedImage {

	public static byte[] DecodeString(String input_string) {
		byte[] imageByte = null;
		if (!input_string.equals(""))
			imageByte = Base64.getDecoder().decode(input_string);
		return imageByte;
	}

	public static boolean uploadImage(String image, String file_name, String filePath) throws IOException, Exception {
		boolean result = false;
		if (!image.equals("")) {
			int comma_index = image.indexOf(',');
			int semicolon_index = image.indexOf(';');
			int colon_index = image.indexOf(':');
			String image_ext = image.substring(colon_index + 1, semicolon_index);
			//// validating image type ////
			if (image_ext.equals("image/type") || image_ext.equals("image/png") || image_ext.equals("image/jpeg")) {
				///// generating image string for decoding because the input image is encoded
				String decodable_image = image.substring(comma_index + 1, image.length());
				///// decoding the image string
				byte[] imageByte = DecodeString(decodable_image);
				if (imageByte != null) {
					// create a buffered image
					ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
					BufferedImage image1 = ImageIO.read(bis);
					bis.close();
					////// creating a file to a specific path to upload image...
					File outputfile = new File(filePath + file_name);
					///// since, file has been created so write the image onto that file (writing
					///// decoded image string onto the created file)
					ImageIO.write(image1, "png", outputfile);
					result = true;
				}
			} else {
				result = false;
			}
		} else {
			result = false;
		}
		return result;
	}
}
