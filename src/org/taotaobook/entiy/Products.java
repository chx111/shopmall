package org.taotaobook.entiy;

public class Products {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imgurl == null) ? 0 : imgurl.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((writename == null) ? 0 : writename.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Products other = (Products) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imgurl == null) {
			if (other.imgurl != null)
				return false;
		} else if (!imgurl.equals(other.imgurl))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (writename == null) {
			if (other.writename != null)
				return false;
		} else if (!writename.equals(other.writename))
			return false;
		return true;
	}
	private String id;
	private String name;
	private String writename;
	private double price;
	private String imgurl;
	private String description;
	private String type;
	
	
	public Products(String id, String name, String writename, double price, String imgurl, String description,
			String type) {
		
		this.id = id;
		this.name = name;
		this.writename = writename;
		this.price = price;
		this.imgurl = imgurl;
		this.description = description;
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWritename() {
		return writename;
	}
	public void setWritename(String writename) {
		this.writename = writename;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public Products(String id, String name, String writename, double price, String imgurl, String description) {
		this.id = id;
		this.name = name;
		this.writename = writename;
		this.price = price;
		this.imgurl = imgurl;
		this.description = description;
	}
	public Products() {

	}
	
	
	
}
