package yu.chap6.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberVO {
	int id;
	String email;
	String password;
	String name;
	String regdate;
}
