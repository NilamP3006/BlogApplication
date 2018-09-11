package blogspot.demo.swagger.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BlogEntry {

	private int blogId;
	private String name;

	public BlogEntry() {

	}

	public BlogEntry(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return blogId;
		
	}

	public void setId(int id) {
		this.blogId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}