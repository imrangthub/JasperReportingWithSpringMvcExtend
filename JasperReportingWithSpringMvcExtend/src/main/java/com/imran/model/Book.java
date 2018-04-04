package com.imran.model;


public class Book {
		
		private long id;
		private String name;
		private String type;
		private Integer author_id;
		
		
		
		
		public Integer getAuthor_id() {
			return author_id;
		}
		public void setAuthor_id(Integer author_id) {
			this.author_id = author_id;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
			

}
