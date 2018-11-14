package blogspot.demo.swagger.repository;

import org.springframework.data.repository.CrudRepository;

import blogspot.demo.swagger.domain.Blog;

public interface BlogRepository extends CrudRepository<Blog, Integer> {
	
}