package yu.chap6.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import yu.chap6.model.MemberVO;

@Mapper
public interface MemberMapper {
	
	public List<MemberVO> listMembers();
	
	public int addMember(MemberVO member);
	
	public MemberVO getMemberByEmail(String email);
	
	public int deleteMember(String id);
}
