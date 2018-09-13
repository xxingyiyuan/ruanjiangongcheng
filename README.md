项目相关要求

**基本要求**

- wc.exe -c file.c //返回文件 file.c 的字符数（实现）
- wc.exe -w file.c //返回文件 file.c 的词的数目（实现）
- wc.exe -l file.c //返回文件 file.c 的行数（实现）

**解题思路**

- 困难描述
  - 对于正则表达式的使用不太熟悉,所以在考虑统计单词数时花了很长时间
  - 对main函数的参数不理解
- 做过哪些尝试
  - 搜索与正则表达式的有关资料,然后自己尝试了很多匹配规则,发现很多情况都没有考虑到
  - 在同学的指导下理解了main方法参数的含义
- 有何收获
  - 回顾了之前学过的一些知识点,io流,正则表达式
  - 接触到一些新知识,比如说使用单元测试,上传到guihub等等

**设计实现过程**

- 每个功能用一个方法实现,把所有方法封装成一个工具类

**代码说明**

- 统计字符数
  - 先用isFile()方法判断传进来的参数是否有误
  - 每次读取一行,统计每行字符串的长度
  - 直到readLine()==null结束
  - 输出结果

```java
public static void countChar(String filepath) throws IOException {
	File file = new File(filepath);
	if (file.isFile()) {
		BufferedReader br = new BufferedReader(new FileReader(file));
		int count = 0;
		String str = null;
		while ((str = br.readLine()) != null) {
			count+=str.length();
		}
		System.out.println(file.getName()+"的字符个数为:" + count);
		br.close();	
	}else {
		System.out.println("文件不存在");
	}
```
- 统计单词数
  - 先用isFile()方法判断传进来的参数是否有误
  - 每次读取一行,用split(" ").length统计一行的单词数
  - 直到readLine()==null结束
  - 输出结果
```java
public static void countWord(String filepath) throws IOException {
		File file = new File(filepath);
		if (file.isFile()) {
			BufferedReader br = new BufferedReader(new FileReader(file));
			int count = 0;
			String line = null;
			while ((line = br.readLine()) != null) {
				count+=line.trim().split(" ").length;
			}
			System.out.println(file.getName()+"的单词个数为:" + count);
			br.close();
		}else {
			System.out.println("文件不存在");
		}
	}
```

- 统计行数
  - 先用isFile()方法判断传进来的参数是否有误
  - 每次读取一行,若br.readLine() != null,则count++
  - 直到readLine()==null结束
  - 输出结果

```java
public static void countLine(String filepath) throws IOException {
		File file = new File(filepath);
		if (file.isFile()) {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			int count = 0;
			while (br.readLine() != null) {
				count++;
			}
			System.out.println(file.getName()+"的行数为:" + count);
			br.close();
		}else {
			System.out.println("文件不存在");
		}
	}
```

- main函数
  - 用args[]获取从命令行传进来的参数
  - 执行switch语句调用对应方法

```java
	public static void main(String[] args) throws IOException {
		String param = args[0];
		switch (param) {
		case "-c":
			CountUtils.countChar(args[1]);
			break;
		case "-w":
			CountUtils.countWord(args[1]);
			break;
		case "-l":
			CountUtils.countLine(args[1]);
			break;
		default:
			System.out.println("参数有误");
		}
	}
```

- 测试类

```java
public class CountUtilsTest {
	
	@Test
	public void testCountChar() throws IOException{
		CountUtils.countChar("test/1.txt");
		CountUtils.countChar("test/2.txt");
		CountUtils.countChar("test/3.txt");
	}
	@Test
	public void testCountWord() throws IOException{
		CountUtils.countWord("test/1.txt");
		CountUtils.countWord("test/2.txt");
		CountUtils.countWord("test/3.txt");
	}
	@Test
	public void testCountLine() throws IOException{
		CountUtils.countLine("test/1.txt");
		CountUtils.countLine("test/2.txt");
		CountUtils.countLine("test/3.txt");
	}
}
```



**测试运行**

- 测试结果

  ![1536822130539](C:\Users\袁杏仪\AppData\Local\Temp\1536822130539.png)

 - 代码覆盖率

   ![1536821979217](C:\Users\袁杏仪\AppData\Local\Temp\1536821979217.png)

## PSP

| **PSP2.1**                                | **Personal Software Process Stages**    | **预估耗时（分钟）** | **实际耗时（分钟）** |
| :---------------------------------------- | --------------------------------------- | :------------------: | :------------------: |
| Planning                                  | 计划                                    |          30          |          50          |
| · Estimate                                | · 估计这个任务需要多少时间              |          30          |          50          |
| Development                               | 开发                                    |         660          |         670          |
| · Analysis                                | · 需求分析 (包括学习新技术)             |         120          |         100          |
| · Design Spec                             | · 生成设计文档                          |          30          |          30          |
| · Design Review                           | · 设计复审 (和同事审核设计文档)         |          30          |          30          |
| · Coding Standard                         | · 代码规范 (为目前的开发制定合适的规范) |          30          |          30          |
| · Design                                  | · 具体设计                              |          30          |          60          |
| · Coding                                  | · 具体编码                              |         300          |         240          |
| · Code Review                             | · 代码复审                              |          30          |          60          |
| · Test                                    | · 测试（自我测试，修改代码，提交修改）  |          60          |         120          |
| Reporting                                 | 报告                                    |         150          |         160          |
| · Test Report                             | · 测试报告                              |          90          |         120          |
| · Size Measurement                        | · 计算工作量                            |          30          |          20          |
| · Postmortem & Process   Improvement Plan | · 事后总结, 并提出过程改进计划          |          30          |          20          |
| 合计                                      |                                         |         840          |         880          |

**项目小结**

这次项目只实现了基本功能,可能因为对项目所用到的知识不太了解,还有就是以前学过的知识也基本忘记,所以做起来有点难度,分析功能时也考虑了很多种情况,但最后实现出来的结果很一般。
