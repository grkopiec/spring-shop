package pl.shop.exceptions;


public class NoProductsFoundException extends RuntimeException {
	private static final long serialVersionUID = 9144039503930305524L;
	private String category;
	
	public NoProductsFoundException(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
