package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

 public static void index() {
    	List<Article> articles = Article.find(
    		"order by postedAt desc"
    	).fetch(10);
        render(articles);
    }
    public static void show(Long id) {
        Article article = Article.findById(id);
        render(article);
    }

}