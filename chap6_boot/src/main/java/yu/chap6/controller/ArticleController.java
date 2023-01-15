package yu.chap6.controller;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import yu.chap6.model.ArticleVO;
import yu.chap6.model.Article_contentVO;
import yu.chap6.model.MemberVO;
import yu.chap6.repository.ArticleRepository;

@Controller
public class ArticleController {
	@Autowired
	ArticleRepository dao;

	@RequestMapping("/ex2/list")
	public String listArticles(Model model) {
		List<ArticleVO> articles = dao.getAllArticles();
		model.addAttribute("articles", articles);
		
		return "listArticles";
	}

	@RequestMapping("/ex2/logout")
	public String logoutProcess(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "redirect:list";
	}
	
	@RequestMapping("/ex2/read")
	public String read(HttpServletRequest request, Model model) {
		int article_no = Integer.parseInt(request.getParameter("article_no"));

		ArticleVO article = dao.getArticleById(article_no);
		Article_contentVO article_content = dao.getArticleContentById(article_no);

		model.addAttribute("article", article);
		model.addAttribute("content", article_content.getContent());
		
		dao.plus(article);

		return "readArticles";
	}
	
	@RequestMapping("/ex2/write")
	public String write(HttpServletRequest request) {
		if (request.getMethod().equals("GET")) {
			return "writeForm";
		} else if (request.getMethod().equals("POST")){
			MemberVO member = (MemberVO) request.getSession().getAttribute("login");
			
			Date now = new Date();
			SimpleDateFormat fformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			String regdate = fformat.format(now);
			String content = request.getParameter("content");
			String title = request.getParameter("title");
			
			ArticleVO article = new ArticleVO(0, member.getId(), member.getName(), title, regdate, null, 0);
			
            dao.insert(article, content);
			
			return "redirect:list";
		}
		return null;
	}
	
	@RequestMapping("/ex2/update")
	public String update(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("login");
		int article_no = Integer.parseInt(request.getParameter("article_no"));
		HashMap<String, Boolean> errors = new HashMap<>();

		if (member == null) {
			errors.put("update", true);
			model.addAttribute("errors", errors);
			return "errorPage";
		}

		if (request.getMethod().equals("GET")) {
			ArticleVO article = dao.getArticleById(article_no);
			int id = article.getWriter();

			if (member.getId() != id) {
				errors.put("update", true);
				model.addAttribute("errors", errors);
				return "errorPage";
			} else {
				Article_contentVO aritcle_content = dao.getArticleContentById(article_no);
				errors.put("update", false);
				model.addAttribute("errors", errors);
				model.addAttribute("article", article);
				model.addAttribute("content", aritcle_content.getContent());

				return "updateForm";
			}
				
		} else if (request.getMethod().equals("POST")){
			Date now = new Date();
			SimpleDateFormat fformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String moddate = fformat.format(now);
			
			String content = request.getParameter("content");
			String title = request.getParameter("title");

			
			HashMap<String, Boolean> map = new HashMap<>();
			map.put("update", true);
			model.addAttribute("complete", map);
			model.addAttribute("errors", errors);
		
			ArticleVO article = new ArticleVO(article_no, 0, null, title, null, moddate, 0);
            Article_contentVO article_content = new Article_contentVO(article_no, content);
			
			dao.updateTitle(article);
			dao.updateContent(article_content);
			return "completePage";
		}
		return null;
	}

	@RequestMapping("/ex2/delete")
	public String delete(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("login");
		HashMap<String, Boolean> errors = new HashMap<>();
		
		int article_no = Integer.parseInt(request.getParameter("article_no"));
		ArticleVO article = dao.getArticleById(article_no);
		int id = article.getWriter();
		
		if (member == null) {
			errors.put("delete", true);
			model.addAttribute("errors", errors);
			return "errorPage";
		}

		if (member.getId() != id) {
			errors.put("delete", true);
			model.addAttribute("errors", errors);
			return "errorPage";

		} else {
			errors.put("delete", false);
			model.addAttribute("errors", errors);
			
			dao.deleteContent(article_no);
			dao.delete(article_no);
			
			HashMap<String, Boolean> map = new HashMap<>();
			map.put("delete", true);
			model.addAttribute("complete", map);
			
			return "completePage";
		}
	}

}
