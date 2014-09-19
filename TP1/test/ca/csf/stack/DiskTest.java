package ca.csf.stack;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DiskTest {

	private Disk disk;
	
	@Before
	public void setUp() throws Exception {
		disk = new Disk(0);
	}
	
	@Test
	public void whenDiskCreated_thenDiskIsOfCorrectLength() {
		assertEquals(0, disk.getLongueur());
	}

}
