package com.tvazteca.Borrado.document;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ParentCategories {
	private String _id;
	private String name;
	private String date_created;
	public ParentCategories(String _id, String name, String date_created) {
		super();
		this._id = _id;
		this.name = name;
		this.date_created = date_created;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate_created() {
		return date_created;
	}
	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}
	@Override
	public String toString() {
		return "Parent [_id=" + _id + ", name=" + name + ", date_created=" + date_created + "]";
	}
	
	
}
