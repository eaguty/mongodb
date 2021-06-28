package com.tvazteca.Borrado.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("categories")
public class Categories {
	@Id
	private String _id;
	@Field(name="name")
	private String name;
	@Field(name="parent")
	private ParentCategories parent;
	@Field(name="date_created")
	private String date_created;
	
	public Categories() {
		
	}
	
	public Categories(String _id, String name, ParentCategories parent, String date_created) {
		super();
		this._id = _id;
		this.name = name;
		this.parent = parent;
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

	public ParentCategories getParent() {
        return parent;
    }
	public void setParent(ParentCategories parent){
		this.parent = parent;
	}

	public String getDate_created() {
		return date_created;
	}

	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}

	@Override
	public String toString() {
		return "Categories [_id=" + _id + ", name=" + name + ", parent=" + parent + ", date_created=" + date_created
				+ "]";
	}
	

	

	
	
	
	
	
	
	
	
	
	
}
