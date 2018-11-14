package blogspot.demo.swagger;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import blogspot.demo.swagger.domain.Blog;
import blogspot.demo.swagger.domain.BlogEntry;
import blogspot.demo.swagger.repository.BlogPostRepository;
import blogspot.demo.swagger.repository.BlogRepository;

@Component
public class DataLoader implements ApplicationRunner {

	private BlogRepository blogRepository;

	@Autowired
	public DataLoader(BlogRepository blogRepository,
			BlogPostRepository blogPostRepository) {
		this.blogRepository = blogRepository;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Blog blog = new Blog("Nilam Pakhare");

		BlogEntry blogname = new BlogEntry("My Blog Application");
		BlogEntry blognametest = new BlogEntry("MyBlog");

		blog.setBlogEntry(new HashSet<>(Arrays.asList(blogname, blognametest)));

		blogRepository.save(blog);
	}
}
