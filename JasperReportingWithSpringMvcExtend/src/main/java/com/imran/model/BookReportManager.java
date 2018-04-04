package com.imran.model;


public class BookReportManager {
		
	private long id;
		private Boolean isIdShow;
		private Boolean isNameShow;
		private Boolean isTypeShow;
		private Boolean isAuthorShow;
		private Boolean isAuthorTableShow;
		
		
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		
		
		
		public Boolean getIsIdShow() {
			return isIdShow;
		}
		public void setIsIdShow(Boolean isIdShow) {
			this.isIdShow = isIdShow;
		}
		public Boolean getIsNameShow() {
			return isNameShow;
		}
		public void setIsNameShow(Boolean isNameShow) {
			this.isNameShow = isNameShow;
		}
		public Boolean getIsTypeShow() {
			return isTypeShow;
		}
		public void setIsTypeShow(Boolean isTypeShow) {
			this.isTypeShow = isTypeShow;
		}
		public Boolean getIsAuthorShow() {
			return isAuthorShow;
		}
		public void setIsAuthorShow(Boolean isAuthorShow) {
			this.isAuthorShow = isAuthorShow;
		}
		public Boolean getIsAuthorTableShow() {
			return isAuthorTableShow;
		}
		public void setIsAuthorTableShow(Boolean isAuthorTableShow) {
			this.isAuthorTableShow = isAuthorTableShow;
		}
		
		@Override
		public String toString() {
			return "BookReportManager [id=" + id + ", isIdShow=" + isIdShow + ", isNameShow=" + isNameShow
					+ ", isTypeShow=" + isTypeShow + ", isAuthorShow=" + isAuthorShow + ", isAuthorTableShow="
					+ isAuthorTableShow + "]";
		}
		
		
		
		
		
				

}
