package mobile;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "mobile")

public class mobileModel implements Serializable {
	private static final long serialVersionUID = 1L;
	int id, price = 0;
	String name, description;

	public mobileModel() {
	}

	public mobileModel(int id, String name, int price, String description) {
		super();
		this.id = id;
		this.price = price;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	@XmlElement
	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		} else if (!(object instanceof mobileModel)) {
			return false;
		} else {
			mobileModel user = (mobileModel) object;
			if (id == user.getId() && name.equals(user.getName()) && price == user.getPrice()
					&& description.equals(user.getDescription())) {
				return true;
			}
		}
		return false;
	}

}
