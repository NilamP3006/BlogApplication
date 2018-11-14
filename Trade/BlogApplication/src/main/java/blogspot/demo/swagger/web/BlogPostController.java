package blogspot.demo.swagger.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import blogspot.demo.swagger.domain.BlogEntry;
import blogspot.demo.swagger.repository.BlogPostRepository;


@Api(tags="blogpostentry")
@RestController
public class BlogPostController {

	@Autowired
	private BlogPostRepository blogPostRepository;

	@ApiOperation("Retrieves all Blogs.")
	@RequestMapping(
			method = RequestMethod.GET, 
			value = "/api/blogEntry", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BlogEntry> getBlogEntry() {
		//todo: paging
		List<BlogEntry> blogEntry = new ArrayList<>();
		blogPostRepository.findAll().forEach(blogEntry::add);
		return blogEntry;
	}

	
}
