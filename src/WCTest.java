import java.io.IOException;

public class WCTest {
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
			System.out.println("²ÎÊýÓÐÎó");
		}
	}
}
