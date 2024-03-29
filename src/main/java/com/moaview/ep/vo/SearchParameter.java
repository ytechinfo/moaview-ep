package com.moaview.ep.vo;

import java.util.HashMap;
import java.util.Map;

/**
* @fileName		: SearchParameter.java
* @desc		: search parameter
* @author	: ytkim
 */
public class SearchParameter {

	/** 현재 페이지 */
	private int pageNo;

	/** 페이지 사이즈 */
	private int countPerPage;

	/** 검색카테고리 */
	private String category;

	/** 검색조건 */
	private String condition;

	/** 검색키워드 */
	private String keyword;
	
	/** 정렬 카테고리 */
	private String sortCategory;
	
	/** 오름차순 여부 */
	private boolean sortAscFlag;

	/** 검색 시작 index */
	private int startRow;

	/** 검색 끝 index */
	private int endRow;
	
	/** 페이지당 보여줄 페이지 갯수 */
	private int unitPage;

	private Map<String, Object> customParam;
	
	private String userId;

	private SearchParameter(int pageNo, int countPerPage, String category, String condition,
			String keyword, int startRow, int endRow, int unitPage,
			Map<String, Object> customParam, String sortCategory, boolean sortAscFlag, String userId) {
		this.pageNo = pageNo;
		this.countPerPage = countPerPage;
		this.category = category;
		this.condition = condition;
		this.keyword = keyword;
		this.startRow = startRow;
		this.endRow = endRow;
		this.unitPage = unitPage;
		this.customParam = customParam;
		this.userId = userId;
	}

	public static class Builder {
		private int pageNo;
		private int countPerPage;
		private String sortCategory;
		private boolean sortAscFlag;
		private String category;
		private String condition;
		private String keyword;
		private int startRow;
		private int endRow;
		private int unitPage;
		private Map<String, Object> customParam;
		private String userId;

		public Builder(String keyword, int pageNo, int countPerPage) {
			this.keyword = keyword;
			this.pageNo = pageNo;
			this.countPerPage = countPerPage;
			
			sortCategory="";
			sortAscFlag=true;
			customParam = new HashMap<String, Object>();
		}

		public Builder setPageNo(int pageNo) {
			this.pageNo = pageNo;
			return this;
		}

		public Builder setCountPerPage(int countPerPage) {
			this.countPerPage = countPerPage;
			return this;
		}

		public Builder setCategory(String category) {
			this.category = category;
			return this;
		}

		public Builder setCondition(String condition) {
			this.condition = condition;
			return this;
		}

		public Builder setKeyword(String keyword) {
			this.keyword = keyword;
			return this;
		}

		public Builder setStartRow(int startRow) {
			this.startRow = startRow;
			return this;
		}

		public Builder setEndRow(int endRow) {
			this.endRow = endRow;
			return this;
		}

		public Builder setUnitPage(int unitPage) {
			this.unitPage = unitPage;
			return this;
		}
		
		public Builder setSortCategory(String sortCategory) {
			this.sortCategory = sortCategory;
			return this;
		}

		public Builder setSortAscFlag(boolean sortAscFlag) {
			this.sortAscFlag = sortAscFlag;
			return this;
		}

		public Builder setCustomParam(Map<String, Object> customParam) {
			this.customParam = customParam; 
			return this;
		}
		public Builder addCustomParam(String key  , Object value) {
			this.customParam.put(key, value);
			return this;
		}
		
		/**
		 * @param userId the userId to set
		 */
		public void setUserId(String userId) {
			this.userId = userId;
		}

		public SearchParameter build() {
			
			if(keyword == null ) keyword = ""; 
			if(pageNo < 1) pageNo = 1;
			if(countPerPage < 1) countPerPage = 10;
			if(unitPage < 1) unitPage = 10;
			
			if(startRow == 0){
				this.startRow = ((pageNo - 1) * this.countPerPage) + 1;
			}
			
			if(endRow == 0){
				this.endRow = this.startRow + this.countPerPage - 1;
			}
			
			return new SearchParameter(pageNo, countPerPage, category, condition,
					keyword, startRow, endRow, unitPage,
					customParam, sortCategory, sortAscFlag, userId);
		}

	}

	public int getPageNo() {
		return pageNo;
	}

	public int getCountPerPage() {
		return countPerPage;
	}

	public String getCategory() {
		return category;
	}

	public String getCondition() {
		return condition;
	}

	public String getKeyword() {
		return keyword;
	}

	public int getStartRow() {
		return startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public int getUnitPage() {
		return unitPage;
	}
	
	public String getSortCategory() {
		return sortCategory;
	}

	public boolean isSortAscFlag() {
		return sortAscFlag;
	}

	public Map<String, Object> getCustomParam() {
		return customParam;
	}
	
	public SearchParameter addCustomParam(String key  , Object value) {
		this.customParam.put(key, value);
		return this;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 검색에 대한 정보를 문자열로 반환한다.
	 * 
	 * @return String 검색에 대한 정보
	 */
	@Override
	public String toString() {
		return "SearchParameter [pageNo=" + pageNo + ", CountPerPage=" + countPerPage + ", condition=" + condition
				+ ", keyword=" + keyword + ", category=" + category+ ", customParam=" + customParam +"]";
	}
}
