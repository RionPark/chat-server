package com.dev.chat.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

	public static final String ROOT = "C:\\works\\files\\";
	
	public static String saveFile(MultipartFile file) {
		String originFileName = file.getOriginalFilename(); //cat.jpg
		int idx = originFileName.lastIndexOf(".");
		String extName = originFileName.substring(idx); // .jpg
		String fileName = UUID.randomUUID().toString() + extName; //eb63352e-b954-47fa-b732-e626d0624418.jpg
		File targetFile = new File(ROOT + fileName);
		try {
			file.transferTo(targetFile);
			return fileName;
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString());
	}
}
