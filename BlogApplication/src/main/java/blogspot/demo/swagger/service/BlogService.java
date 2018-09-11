package blogspot.demo.swagger.service;

import java.util.Collection;

import blogspot.demo.swagger.domain.Blog;
import blogspot.demo.swagger.domain.BlogEntry;


public interface BlogService {

	
	public Blog create(Blog blog);
	
	public Blog udpateBlog(Blog blog);
	
	public Blog updateBlogEntry(Blog blog, Collection<BlogEntry> blogEntry);
	
}
