package com.tvazteca.Borrado.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Categories {
	@Id
	private String _id;
	private String name;
	private Parent parent;
	private String type;
	
	public Categories() {
		
	}
	
	public Categories(String _id, String name, Parent parent, String type) {
		super();
		this._id = _id;
		this.name = name;
		this.parent = parent;
		this.type = type;
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

	public Parent getParent() {
        return parent;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	static class Parent {
		private final String _id;
        private final String name;
        private final String date_created;

       
        public Parent(String _id, String name, String date_created) {
        	this._id= _id;
            this.name = name;
            this.date_created = date_created;
        }

        public String _id() {
            return _id;
        }
        
        public String getName() {
            return name;
        }

        public String getDate_created() {
            return date_created;
        }
    }

	@Override
	public String toString() {
		return "Categories [_id=" + _id + ", name=" + name + ", parent=" + parent + ", type=" + type + "]";
	}
	
	
	
	
	
	
	
	
	
}
