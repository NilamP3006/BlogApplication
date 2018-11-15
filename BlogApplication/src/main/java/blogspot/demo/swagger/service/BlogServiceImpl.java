package blogspot.demo.swagger.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blogspot.demo.swagger.domain.Blog;
import blogspot.demo.swagger.domain.BlogEntry;
import blogspot.demo.swagger.exceptions.NotFoundException;
import blogspot.demo.swagger.repository.BlogRepository;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepository blogRepository;
	
	@Override
	public Blog create(Blog blogDTO) {
		
		Blog blog = new Blog(blogDTO.getName());

		return  blogRepository.save(blog);
	}

	@Override
	public Blog udpateBlog(Blog blogDTO) {
		
		Blog existingBlog = requireNotNull(blogRepository.findOne(blogDTO.getId()), blogDTO.getId());
		//
		existingBlog.setName(blogDTO.getName());
		
		return  blogRepository.save(existingBlog);
		
	}

	private static Blog requireNotNull(Blog s, Integer blogId)
	{
		if (s == null)
			throw new NotFoundException("Blog with Id " + blogId + " not found!");
		else
			return s;
	}

	@Override
	public Blog updateBlogEntry(Blog blog,
			Collection<BlogEntry> blogEntry) {

		//maybe some error hanling, etc?
		blog.setBlogEntry(blogEntry);
		
		return blogRepository.save(blog);
	}
	
}
