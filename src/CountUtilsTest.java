import java.io.IOException;

import org.junit.Test;

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
