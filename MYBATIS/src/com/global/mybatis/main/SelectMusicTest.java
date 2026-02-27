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

public class SelectMusicTest {
	public static void main (String[] args) throws IOException {
		String resource = "com/global/mybatis/config/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		System.out.println(sqlSessionFactory);
		try (SqlSession session = sqlSessionFactory.openSession()) {
			List<HashMap> musicList = session.selectOne("com.global.mybatis.mapper.MusicMapper.selectMusic");
			  musicList.stream().forEach(System.out::println);
			}
	}

}
