package tech.feily.simpleweb.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class OperateFile {
	
	static OutputStream os = null;
	static InputStream is = null;
	static File file= null;
	static byte[] byteData =null;
	
	public static void write(String filePath, String stringData, boolean flag) throws IOException {
		byteData = stringData.getBytes();
		file = new File(filePath);
		if (!file.exists()) file.createNewFile();
		os = new FileOutputStream(file,flag);
		os.write(byteData);
		os.close();
	}

	public static String read(String filePath) throws IOException {
		file = new File(filePath);
		if (!file.exists()) file.createNewFile();;
		is = new FileInputStream(file);
		byteData = new byte[(int) file.length()];
		is.read(byteData);
		is.close();
		return new String(byteData);
	}
	
}
