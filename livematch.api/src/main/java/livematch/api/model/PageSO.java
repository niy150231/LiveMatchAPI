package livematch.api.model;

import java.io.Serializable;

/**
 * 
 * @author Bright
 * Date: 07.02.2025
 * Desc: Page Search Object
 * @param <T>
 */
public class PageSO<T> implements Serializable {

	private static final long serialVersionUID = 961257666774158655L;

	private int page = 0;

	private Integer rows = 10;

	private String sidx;

	private String sord = "asc";

	private int totalCount = 0;

	private int totalPageCount = 0;

	private int startIndex = 0;

	private int endIndex = 0;

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Integer getRows() {
		return this.rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public int getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPageCount() {
		this.totalPageCount = ((getTotalCount() - 1) / getRows() + 1);
		return this.totalPageCount;
	}

	public int getStartIndex() {
		return this.startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return this.endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public String getSidx() {
		return this.sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSord() {
		return this.sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

}

