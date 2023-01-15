package yu.chap6.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import yu.chap6.model.MemberVO;

@Repository
public class MemberRepository {

    @Autowired
    private SqlSessionTemplate session;

    public List<MemberVO> listMembers() {
    	return session.selectList("yu.chap6.mapper.MemberMapper.listMembers");
    }
    
    public int addMember(MemberVO member) {
    	return session.insert("yu.chap6.mapper.MemberMapper.addMember", member);
    }
    
    public MemberVO getMemberByEmail(String email) {
    	return session.selectOne("yu.chap6.mapper.MemberMapper.getMemberByEmail", email);
    }
    
    public int deleteMember(String id) {
    	return session.delete("yu.chap6.mapper.MemberMapper.deleteMember", id);
    }
}