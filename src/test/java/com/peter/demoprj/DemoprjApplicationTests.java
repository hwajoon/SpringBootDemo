package com.peter.demoprj;

import com.peter.demoprj.domain.UserProfile;
import com.peter.demoprj.mapper.UserProfileMapper;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoprjApplicationTests {
	@Autowired
	private DataSource ds;

	@Autowired
	private UserProfileMapper mapper;

	@Test
	public void testUserProfileMapper() throws Exception {
		UserProfile userProfile = mapper.getLoginInfo("222");
		System.out.println("UserProfile >>> = " + userProfile);
		assertEquals("홍길동2", userProfile.getName());

		String uname = mapper.getUsername("111");
		System.out.println("uname >>> = " + uname);
		assertEquals("홍길동1", uname);
	}

	@Ignore @Test
	public void testDataSource() throws Exception {
		System.out.println("DS=" + ds);

		try(Connection conn = ds.getConnection())
		{
			System.out.println("PETER : Cooooooooooon=" + conn);
			assertThat(conn).isInstanceOf(Connection.class);

			assertEquals(2, getLong(conn, "select 2"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private long getLong(Connection conn, String sql)
	{
		long result=0;
		try(Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				result = rs.getLong(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return result;
	}

/*
	void contextLoads() {
	}
*/
}
