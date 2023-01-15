package yu.chap6.mapper;

import java.sql.PreparedStatement;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import yu.chap6.model.ArticleVO;
import yu.chap6.model.Article_contentVO;

@Mapper
public interface ArticleMapper {
	
	public List<ArticleVO> getAllArticles();
	
	public void insert(ArticleVO article);
	
	public void insertContent(Article_contentVO article_content);
	
	public void plus(ArticleVO article);
	
	public ArticleVO getArticleById(int article_no);
	
	public Article_contentVO getArticleContentById(int article_no);

	public void updateTitle(ArticleVO article);
	
	public void updateContent(Article_contentVO article_content);

	public void delete(int article_no);
	
	public void deleteContent(int article_no);
}
