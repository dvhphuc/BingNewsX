package controller;

import com.sun.net.httpserver.HttpServer;
import model.Article;
import service.ArticleService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/api/myendpoint")
public class ArticleController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Article> articles = null;
        try {
            articles = new ArticleService().getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        response.getWriter().println(articles);
    }
}
