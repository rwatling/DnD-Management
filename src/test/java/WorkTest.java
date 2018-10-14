import static org.junit.Assert.*;

import org.junit.Test;

import main.java.Work;

public class WorkTest {

	@Test
	public void testReturnOne() {
		Work w = new Work();
		assertEquals(1, w.returnOne() );
	}

}
