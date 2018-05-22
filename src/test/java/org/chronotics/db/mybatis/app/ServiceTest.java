package org.chronotics.db.mybatis.app;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.chronotics.db.mybatis.app.Application.class})
public class ServiceTest {
	@BeforeClass
	public static void setup() {
	}

	@Test
	public void test() {
	}
}
