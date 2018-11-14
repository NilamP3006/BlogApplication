package blogspot.demo.swagger.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import blogspot.demo.swagger.domain.Blog;
import blogspot.demo.swagger.domain.BlogEntry;
import blogspot.demo.swagger.exceptions.NotFoundException;
import blogspot.demo.swagger.repository.BlogRepository;
import blogspot.demo.swagger.service.BlogService;


@Api(tags = "blogs")
@RestController
public class BlogPost {

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private BlogService blogRepositoryService;

	

	//
	@ApiOperation("Retrieves the blogentry in which is has enrolled a blog.")
	@RequestMapping(method = RequestMethod.GET, value = "/api/blog/{blogId}/blogEntry", produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<BlogEntry> getBlogEntry(
			@ApiParam(name="blogId", value = "The ID of the blog.", required = true)
			@PathVariable Integer blogId) {
		return requireNotNull(blogRepository.findOne(blogId), blogId)
				.getBlogEntry();
	}

	//
	@ApiOperation("Creates a new blog.")
	@RequestMapping(method = RequestMethod.POST, value = "/api/blog", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Blog> createBlog(
			@ApiParam(name="blog", value = "The Blog.", required = true)
			@RequestBody Blog blog) {

		Blog newBlog = blogRepositoryService.create(blog);

		return ResponseEntity.created(blogURI(newBlog.getId())).body(
				newBlog);
	}

	
	@ApiOperation("Updates an existing blog entry.")
	@RequestMapping(method = RequestMethod.PUT, value = "/api/blog/{blogId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Blog> udpateBlog(
			@ApiParam(name="blogId", value = "The ID of the blog.", required = true)
			@PathVariable Integer blogId, 
			@ApiParam(name="blogId", value = "The blog.", required = true)
			@RequestBody Blog blog) {

		blog.setId(blogId);

		Blog updateBlog = blogRepositoryService.udpateBlog(blog);

		return ResponseEntity.created(blogURI(updateBlog.getId())).body(
				updateBlog);
	}

	

	private static URI blogURI(Integer blogId) {
		return toUri("/api/blog/{blogId}", blogId);
	}

	private static URI blogEntryURI(Integer blogId) {
		return toUri("/api/blog/{blogId}/blogEntry", blogId);
	}

	private static URI toUri(String path, Integer blogId) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path(path)
				.buildAndExpand(blogId).toUri();
	}

	private static Blog requireNotNull(Blog s, Integer blogId) {
		if (s == null)
			throw new NotFoundException("Blog with Id " + blogId
					+ " not found!");
		else
			return s;
	}

}