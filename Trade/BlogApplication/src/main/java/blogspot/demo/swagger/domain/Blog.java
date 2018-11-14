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
	private String displayFormat;
	private int scale;
	private int dpl;
	private int fpl;
	private int decimal;
	private double rawPrice;
	
	private String DP;
	private String FP;
	

	private Collection<BlogEntry> blogEntry;

	public Blog() {

	}
	
	public Blog(String name,String displayFormat,int scale,int dpl,int fpl,int decimal, double rawPrice,String DP,String FP) {
		this.name = name;
		this.displayFormat=displayFormat;
		this.scale=scale;
		this.dpl=dpl;
		this.fpl=fpl;
		this.decimal=decimal;
		this.rawPrice=rawPrice;
		this.DP=DP;
		this.FP=FP;
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

	public String getDisplayFormat() {
		return displayFormat;
	}

	public void setDisplayFormat(String displayFormat) {
		this.displayFormat = displayFormat;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public int getDpl() {
		return dpl;
	}

	public void setDpl(int dpl) {
		this.dpl = dpl;
	}

	public int getFpl() {
		return fpl;
	}

	public void setFpl(int fpl) {
		this.fpl = fpl;
	}

	public int getDecimal() {
		return decimal;
	}

	public void setDecimal(int decimal) {
		this.decimal = decimal;
	}

	public double getRawPrice() {
		return rawPrice;
	}

	public void setRawPrice(double rawPrice) {
		this.rawPrice = rawPrice;
	}

	public String getDP() {
		return DP;
	}

	public void setDP(String dP) {
		DP = dP;
	}

	public String getFP() {
		return FP;
	}

	public void setFP(String fP) {
		FP = fP;
	}


}
