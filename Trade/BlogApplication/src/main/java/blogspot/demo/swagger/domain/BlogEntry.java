package blogspot.demo.swagger.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BlogEntry {

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