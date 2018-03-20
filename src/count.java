import java.io.*;
import java.util.Vector;

public class count {
	public static boolean cFlag=false;
	public static boolean wFlag=false;
	public static boolean lFlag=false;
	String outFilePath;
	private static OutputStream outStream;
	File filePath;
	private File outPutFile;
	
	public count(File filePath,String outFilePath) throws IOException{
		this.filePath=filePath;
		this.outFilePath=outFilePath;
		this.outPutFile=new File(outFilePath);
		this.outStream=new FileOutputStream(outPutFile);
		
	}
	public static void calculate(File filename) throws IOException {
		InputStreamReader f=null;
		int charCaculate=0;
		int wordCaculate=0;
		int lineCaculate=0;
		try {
		f=new InputStreamReader(new FileInputStream(filename));
		BufferedReader page = new BufferedReader(f);
		while(page.read()!=-1) {
				String lineWords=page.readLine();
				charCaculate=charCaculate+lineWords.length();
				wordCaculate=wordCaculate+lineWords.split("").length;
				lineCaculate=lineCaculate+1;
		} 
		f.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		if(cFlag) {
			String o="文件名:"+filename.getName()+",字符数:"+charCaculate+"\r\n";
			outStream.write(o.getBytes());
		}
		if(wFlag) {
			String o2="文件名:"+filename.getName()+",字符数:"+wordCaculate+"\r\n";
			outStream.write(o2.getBytes());
		}
		if(lFlag) {
			String o3="文件名:"+filename.getName()+",字符数:"+lineCaculate+"\r\n";
			outStream.write(o3.getBytes());
		}
	}
	
	public void countWords(Vector<String> argsList) throws IOException{
		
		if(argsList.contains("-c"))
		{cFlag=true;calculate(filePath);}
		if(argsList.contains("-w"))
		{wFlag=true;calculate(filePath);}
		if(argsList.contains("-l"))
		{lFlag=true;calculate(filePath);}
		
	}
	
}