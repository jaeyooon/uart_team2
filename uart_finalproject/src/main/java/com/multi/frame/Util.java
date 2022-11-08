package com.multi.frame;

import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

public class Util { // 파일덩어리(MultipartFile)를 서버의 어딘가에 저장함
	public static void saveFile(MultipartFile mf, String custdir) {
		byte [] data;
		String imgname = mf.getOriginalFilename();
		try {
			data = mf.getBytes();
			FileOutputStream fo = 
					new FileOutputStream(custdir+imgname); // 파일덩어리를 custdir 밑에 저장
			fo.write(data);
			fo.close();
			
		}catch(Exception e) {
			
		}
		
	}
	
}




