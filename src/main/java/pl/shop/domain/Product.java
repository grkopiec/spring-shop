package pl.shop.domain;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import pl.shop.validation.ProductCategory;
import pl.shop.validation.ProductId;

@XmlRootElement
public class Product {
	//@Pattern can not be applied for number objects, it is java pattern
	@ProductId
	//for configuration only for javax.validation.Validation we need around message by {...}
	@NotNull(message = "validation.product.id.null")
	private Long id;
	@JsonIgnore
	private MultipartFile image;
	@JsonIgnore
	private MultipartFile manual;
	//if we put in "message" parameter value like: "message = "name is required"" then we show this communicate directly
	@Size(min = 4, max = 50, message = "validation.product.name")
	private String name;
	@Min(value = 0, message = "validation.product.price.min")
	@Digits(integer = 8, fraction = 2, message = "validation.product.price.digits")
	@NotNull(message = "validation.product.price.null")
	private BigDecimal price;
	private String description;
	private String manufacturer;
	@ProductCategory
	@NotBlank(message = "validation.product.category")
	private String category;
	@Min(value = 0, message = "validation.product.inStock")
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
