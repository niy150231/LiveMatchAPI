package livematch.api.utils;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import livematch.api.exception.BizException;

public class LogoDownloader {
	
	 public static void downloadAndSaveLogo(String logoUrl, String savePath) throws BizException {
		 // Combine the directory and file name to create the full save path
	        //String savePath = NasUtil.getUploadFilePath(fileName);
	        

	        try {
	            // Open a connection to the URL
	            URL url = new URL(logoUrl);

	            try (BufferedInputStream inputStream = new BufferedInputStream(url.openStream());
	                 FileOutputStream fileOutputStream = new FileOutputStream(savePath)) {

	                // Buffer for reading the input stream
	                byte[] buffer = new byte[1024];
	                int bytesRead;

	                // Write the input stream to the output file
	                while ((bytesRead = inputStream.read(buffer, 0, 1024)) != -1) {
	                    fileOutputStream.write(buffer, 0, bytesRead);
	                }
	            }
	        }  catch (MalformedURLException e) {
	            throw new BizException("", "Invalid URL format"+logoUrl);
	        } catch (IOException e) {
	            throw new BizException("", "Error occurred while downloading or saving the logo");
	        }
	    }
}	 
