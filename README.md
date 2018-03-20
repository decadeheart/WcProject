# 软件测试第二周个人作业WordCount

github地址：https://github.com/decadeheart/WcProject

## **一.PSP表格**

 

| **PSP2.1**                              | **PSP****阶段**          | **预估耗时****（分钟）** | **实际耗时****（分钟）** |
| --------------------------------------- | ---------------------- | ---------------- | ---------------- |
| Planning                                | 计划                     | 20分钟             | 30分钟             |
| · Estimate                              | · 估计这个任务需要多少时间         | 2天               | 4天               |
| Development                             | 开发                     | 2天               | 3天               |
| · Analysis                              | · 需求分析 (包括学习新技术)       | 2天               | 1天               |
| · Design Spec                           | · 生成设计文档               | -                | -                |
| · Design Review                         | · 设计复审 (和同事审核设计文档)     | -                | -                |
| · Coding Standard                       | · 代码规范 (为目前的开发制定合适的规范) | 20分钟             | 20分钟             |
| · Design                                | · 具体设计                 | 2小时              | 3小时              |
| · Coding                                | · 具体编码                 | 4天               | 3天               |
| · Code Review                           | · 代码复审                 | 0.5天             | 0.5天             |
| · Test                                  | · 测试（自我测试，修改代码，提交修改）   | 0.5天             | 0.5天             |
| Reporting                               | 报告                     | 30分钟             | 30分钟             |
| · Test Report                           | · 测试报告                 | 30分钟             | 30分钟             |
| · Size Measurement                      | · 计算工作量                | 2小时              | 1小时              |
| · Postmortem & Process Improvement Plan | · 事后总结, 并提出过程改进计划      | 1小时              | 0.5小时            |
|                                         | 合计                     | 10天              | 12天              |

## 二、解题思路

作为一个web端js选手，是真的忘记了之前java怎么写的了，所以还需要重新配置环境，安装eclipse，本来打算使用c++写的，而且cpp也写得差不多，后来武老师又说周二要指导java的单元测试，想到使用其他语言的风险和无法继续后面的任务，还是硬着头皮选择了java语言，于是后面基本是靠百度搜索才知道了每一个函数的使用方法。具体的代码，主要是分为读取函数方法和计算方法，读取文件之后调用计算方法，根据读取到的参数来决定输出的内容

## 三、代码说明

- main.java实现参数解析，函数调用

  这里贴入一些主要函数的代码

  ```
      //获取控制台参数
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
      //主函数进行调用
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
  ```

  ​

- count.java实现文件读取关闭以及计数功能

  这里贴入一些主要函数的代码

  ```
  //计数方法
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
  	//根据flag调用
  		public void countWords(Vector<String> argsList) throws IOException{
  		
  		if(argsList.contains("-c"))
  		{cFlag=true;calculate(filePath);}
  		if(argsList.contains("-w"))
  		{wFlag=true;calculate(filePath);}
  		if(argsList.contains("-l"))
  		{lFlag=true;calculate(filePath);}
  		
  	}
  ```

  ​

## 四、测试

待续

## 五、参考链接

+ http://blog.csdn.net/qq_29513537/article/details/69347959

+ https://jingyan.baidu.com/article/db55b60990f6084ba30a2fb8.html

+ https://www.cnblogs.com/gwq369/p/5316020.html

+ http://blog.csdn.net/sebatinsky/article/details/4708855

+ https://jingyan.baidu.com/article/546ae1853f71a91149f28c85.html

+ http://www.jb51.net/article/48722.htm

  ​