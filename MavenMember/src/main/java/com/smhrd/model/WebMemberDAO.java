package com.smhrd.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.database.SqlSessionManager;

// MyBatis DAO 정의
public class WebMemberDAO {
	// SqlSessionFactory 생성 : DB관련 기능을 직접 사용할 수 있는 세션을 생성
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();

	// 회원가입
	public int join(WebMember member) {
		// Factory 사용해서 Session 생성
		// true : auto commit(default->false)
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int cnt = 0;
		try {
			// insert(실제 실행 할 sql-namespace(xml),sql 실행할 때 넘겨줄 값(?))
			// 반환값 : sql 실행 성공(삽입 성공->1 / 실패->0)
			cnt = sqlSession.insert("WebMemberDAO.insert", member);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close(); // 자원 반환
		}
		return cnt;
	}

	// 로그인
	public WebMember login(WebMember member) {
		WebMember member2 = null;
		// 세션 생성
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			member2 = sqlSession.selectOne("WebMemberDAO.login", member);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return member2;

	}

	public int update(WebMember updateMember) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int cnt = 0;
		try {
			cnt = sqlSession.update("WebMemberDAO.update", updateMember);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return cnt;
	}

	public List<WebMember> select() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		List<WebMember> list = null;

		try {
			list = sqlSession.selectList("MemberDAO.select"); // 넘겨줘야하는 값이 없으면 매개인자 1개만!
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;
	}

	public int delete(String email) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int cnt = 0;
		try {
			cnt = sqlSession.delete("WebMemberDAO.delete",email);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return cnt;
	}

}
