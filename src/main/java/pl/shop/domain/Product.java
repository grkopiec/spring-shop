package pl.shop.domain;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement
public class Product {
	private Long id;
	@JsonIgnore
	private MultipartFile image;
	@JsonIgnore
	private MultipartFile manual;
	private String name;
	private BigDecimal price;
	private String description;
	private String manufacturer;
	private String category;
	private Long inStock;
	private Long inOrder;
	private Boolean discontinued;
	private String condition;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@XmlTransient
	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	@XmlTransient
	public MultipartFile getManual() {
		return manual;
	}
	
	public void setManual(MultipartFile manual) {
		this.manual = manual;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getInStock() {
		return inStock;
	}

	public void setInStock(Long inStock) {
		this.inStock = inStock;
	}

	public Long getInOrder() {
		return inOrder;
	}

	public void setInOrder(Long inOrder) {
		this.inOrder = inOrder;
	}

	public Boolean getDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(Boolean discontinued) {
		this.discontinued = discontinued;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", image=" + image + ", manual=" + manual + ", name=" + name + ", price=" + price
				+ ", description=" + description + ", manufacturer=" + manufacturer + ", category=" + category
				+ ", inStock=" + inStock + ", inOrder=" + inOrder + ", discontinued=" + discontinued + ", condition="
				+ condition + "]";
	}
}
