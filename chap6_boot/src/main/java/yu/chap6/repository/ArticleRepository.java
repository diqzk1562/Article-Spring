package yu.chap6.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import yu.chap6.model.ArticleVO;
import yu.chap6.model.Article_contentVO;

@Repository
public class ArticleRepository {

    @Autowired
    private SqlSessionTemplate session;

    public List<ArticleVO> getAllArticles() {
    	return session.selectList("yu.chap6.mapper.ArticleMapper.getAllArticles");
    }
    
    public int insert(ArticleVO article, String content) {
        session.insert("yu.chap6.mapper.ArticleMapper.insert", article);
        int article_no = article.getArticle_no();
        return this.insertContent(new Article_contentVO(article_no, content));
    }
    
    public int insertContent(Article_contentVO article_content) {
        return session.insert("yu.chap6.mapper.ArticleMapper.insertContent", article_content);
    }
    
    public int plus(ArticleVO article) {
    	article.setRead_cnt(article.getRead_cnt()+1);
    	return session.update("yu.chap6.mapper.ArticleMapper.plus", article);
    }
    
    public Article_contentVO getArticleContentById(int article_no) {
    	return session.selectOne("yu.chap6.mapper.ArticleMapper.getArticleContentById", article_no);
    }
    
    public ArticleVO getArticleById(int article_no) {
    	return session.selectOne("yu.chap6.mapper.ArticleMapper.getArticleById", article_no);
    }
    
    public int updateTitle(ArticleVO article) {
    	return session.update("yu.chap6.mapper.ArticleMapper.updateTitle", article);
    }
    
    public int updateContent(Article_contentVO article_content) {
    	return session.update("yu.chap6.mapper.ArticleMapper.updateContent", article_content);
    }
    
    public int delete(int article_no) {
    	return session.delete("yu.chap6.mapper.ArticleMapper.delete", article_no);
    }
    
    public int deleteContent(int article_no) {
    	return session.delete("yu.chap6.mapper.ArticleMapper.deleteContent", article_no);
    }
}