package yu.chap6.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleVO {
	int article_no;
	int writer;
	String name;
	String title;
	String regdate;
	String moddate;
	int read_cnt;
}
