package blogspot.demo.swagger.domain;

import io.swagger.annotations.ApiModelProperty;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Blog {

	private int blogId;
	private String name;
	private Collection<BlogEntry> blogEntry;

	public Blog() {

	}

	public Blog(String name) {
		this.name = name;
	}

	public Blog(String name, Collection<BlogEntry> blogEntry) {
		this.name = name;
		this.blogEntry = blogEntry;
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

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Collection<BlogEntry> getBlogEntry() {
		return blogEntry;
	}

	@ApiModelProperty(hidden=true)
	public void setBlogEntry(Collection<BlogEntry> blogEntry) {
		this.blogEntry = blogEntry;

	}
}
