package com.codinghub.collegebuddy.commands;

import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadCommand {

	private MultipartFile[] files;

	public MultipartFile[] getFiles() {
		return files;
	}

	public void setFiles(MultipartFile[] files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "FileUploadCommand [files=" + Arrays.toString(files) + "]";
	}

}
