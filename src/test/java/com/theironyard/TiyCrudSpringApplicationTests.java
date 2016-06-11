package com.theironyard;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TiyCrudSpringApplication.class)
@WebAppConfiguration
public class TiyCrudSpringApplicationTests {

    //find out what this could do
	@Test
	public void contextLoads() {
	}

    /**
     * This test would assert that "/" GET route creates an HTML page
     */

    /**
     * This test would assert that the PSQL database is properly connected to
     * the program.
     */

    /**
     * This test would create a test user and assert that the user was entered into the PSQL database
     */
}
