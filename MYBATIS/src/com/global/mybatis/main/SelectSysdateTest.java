package com.global.mybatis.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.global.mybatis.dto.Music;

public class SelectSysdateTest {
	public static void main (String[] args) throws IOException {
		String resource = "com/global/mybatis/config/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		System.out.println(sqlSessionFactory);
		try (SqlSession session = sqlSessionFactory.openSession()) {
			List<Music> musicList = session.selectList("com.global.mybatis.mapper.MusicMapper.selectMusic");
			  musicList.stream().forEach(m -> {
				  System.out.println(m.getCreate_date());
				  System.out.println(m.getTitle());
				  System.out.println(m.getVoacal());
				  System.out.println(m.getCreate_date());
				  System.out.println("--------------------------");
			  });
			}
	}

}
