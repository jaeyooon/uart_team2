package com.multi.frame;

import java.io.FileOutputStream;
import org.springframework.web.multipart.MultipartFile;

public class Util {
	public static void saveFile(MultipartFile mf, String item_admindir, String item_custdir) {
		byte [] data;
		String itemimg = mf.getOriginalFilename();
		try {
			data = mf.getBytes();
			FileOutputStream fo1 = 
					new FileOutputStream(item_admindir+itemimg);
			fo1.write(data);
			fo1.close();
			FileOutputStream fo2 =
					new FileOutputStream(item_custdir+itemimg);
			fo2.write(data);
			fo2.close();
		}catch(Exception e) {
			
		}
		
	}
	
}




