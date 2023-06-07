package com.smhrd.database;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// 데이터베이스 연결, sql 실행 등의 역할 
public class SqlSessionManager {
	// 실제 연결, 실행 등의 역할을 수행할 session을 생성해주는 factory
	// ---> db의 session : 'db연결, sql문 실행, 연결 끊기'의 일련의 작업! 
	// -> 이 작업들을 전부 해주는 factory를 만들어준 것임
	// 이를 실행하기 위한 id,pw,nick의 정보들은 아래 xml 파일 안에 들어있다
	public static SqlSessionFactory sqlSessionFactory;
	
   //클래스 초기화 블럭 : 클래스가 처음 로딩될 때 딱 한번만 수행
	static {
      //설정정보 가지고 오기위한 mybatis-config.xml 경로 작성
      String resource = "com/smhrd/database/mybatis-config.xml";
      Reader reader; // 실제로 경로 가져오기! (java.io - import하기)
      
      try {// String resource 경로에서 오타 났을 때를 대비한 try~catch

         //문자열 경로로 파일읽기
         reader = Resources.getResourceAsReader(resource); //ibatis.io - import하기
         //읽은 정보를 토대로 DB 관련 기능을 가진 SqlSessionFactory 생성
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
      }catch (IOException e) {
         e.printStackTrace();
      }
   }

	// static 초기화 불럭에서 생성된 factory를 반환해주는 method
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
}