package com.global.mybatis.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.global.mybatis.dto.Music;

public class InsertMusicInfoTest {
	public static void main(String[] args) throws IOException {
		String resource = "com/global/mybatis/config/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		try (SqlSession session = sqlSessionFactory.openSession()) {
			
			Music music = new Music();

			music.setTitle("에일리언 에일리언");
			music.setVocal("나유탄 성인");
			int result = session.insert("com.global.mybatis.mapper.MusicMapper.insertMusic", music);
			
			if (result > 0) {
				System.out.println("데이터가 성공적으로 저장되었습니다. (저장된 행 개수: " + result + ")");
				session.commit(); 
			} else {
				System.out.println("데이터 저장에 실패했습니다.");
			}
		}
	}
	
}
