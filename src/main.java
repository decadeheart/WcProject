import java.io.File;
 import java.io.IOException;
import java.util.Vector;

public class main{
	
	public static Vector<String> argsList;
	public static File filePath;
	public static String outPath="result.txt";
	
	//首先获取参数
    public static void getArgs(String[] args){
    	argsList=new Vector<String>();
        for(int i=0;i<args.length;i++){
            if(args[i].equals("-o")){
            	outPath=args[i];

            }
            else if(args[i].equals("-c")||args[i].equals("-w")||args[i].equals("-l"))
            	argsList.addElement(args[i]);
            
            filePath=new File(args[i]);
            System.out.println(filePath);
        }
        return;
    }
	public static void main(String args[]){
		getArgs(args);
		try {
			count wordCount = new count(filePath,outPath);
			wordCount.countWords(argsList);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		return;
		
	}
}


