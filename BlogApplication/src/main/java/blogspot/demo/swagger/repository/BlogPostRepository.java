package blogspot.demo.swagger.repository;

import org.springframework.data.repository.CrudRepository;

import blogspot.demo.swagger.domain.BlogEntry;

public interface BlogPostRepository extends CrudRepository<BlogEntry, Integer> {
	
}
