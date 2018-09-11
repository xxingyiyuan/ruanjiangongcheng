import java.io.IOException;

import org.junit.Test;

public class CountUtilsTest {
	
	@Test
	public void testCountChar() throws IOException{
		CountUtils.countChar("1.txt");
		CountUtils.countChar("2.txt");
		CountUtils.countChar("3.txt");
	}
	@Test
	public void testCountWord() throws IOException{
		CountUtils.countWord("1.txt");
		CountUtils.countWord("2.txt");
		CountUtils.countWord("3.txt");
	}
	@Test
	public void testCountLine() throws IOException{
		CountUtils.countLine("1.txt");
		CountUtils.countLine("2.txt");
		CountUtils.countLine("3.txt");
	}
}
