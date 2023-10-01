/**
 * Represents an item in the cart with its details and operations.
 *
 * @author Chris Markel
 * @version 1.0
 */
package com.gcu.cst452.model;

public class CartItem
{
	// Member Variables
	private Integer id;
	private String name;
	private String description;
	private Float price;
	private Integer qty;
	private Float total;

	/**
	 * Constructor to initialize the CartItem object with provided values.
	 *
	 * @param id The ID of the cart item.
	 * @param name The name of the cart item.
	 * @param description The description of the cart item.
	 * @param price The price of the cart item.
	 * @param qty The quantity of the cart item.
	 */
	public CartItem(Integer id, String name, String description, Float price, Integer qty) {
		this.setId(id);
		this.name = name;
		this.description = description;
		this.price = price;
		this.qty = qty;
		setTotal();
	}

	/**
	 * Gets the ID of the cart item.
	 *
	 * @return The ID of the cart item.
	 */
	public Integer getId()
	{
		return id;
	}

	/**
	 * Sets the ID of the cart item.
	 *
	 * @param id The new ID of the cart item.
	 */
	public void setId(Integer id)
	{
		this.id = id;
	}

	/**
	 * Gets the name of the cart item.
	 *
	 * @return The name of the cart item.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the name of the cart item.
	 *
	 * @param name The new name of the cart item.
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Gets the description of the cart item.
	 *
	 * @return The description of the cart item.
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * Sets the description of the cart item.
	 *
	 * @param description The new description of the cart item.
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * Gets the price of the cart item.
	 *
	 * @return The price of the cart item.
	 */
	public Float getPrice()
	{
		return price;
	}

	/**
	 * Sets the price of the cart item and recalculates the total.
	 *
	 * @param price The new price of the cart item.
	 */
	public void setPrice(Float price)
	{
		this.price = price;
		setTotal();
	}

	/**
	 * Gets the quantity of the cart item.
	 *
	 * @return The quantity of the cart item.
	 */
	public Integer getQty()
	{
		return qty;
	}

	/**
	 * Sets the quantity of the cart item and recalculates the total.
	 *
	 * @param qty The new quantity of the cart item.
	 */
	public void setQty(Integer qty)
	{
		this.qty = qty;
		setTotal();
	}

	/**
	 * Gets the total price of the cart item.
	 *
	 * @return The total price of the cart item.
	 */
	public Float getTotal()
	{
		return total;
	}

	/**
	 * Calculates and sets the total price of the cart item.
	 */
	private void setTotal()
	{
		this.total = this.price * this.qty;
	}

	/**
	 * Returns a string representation of the CartItem object.
	 *
	 * @return A string representation of the CartItem object.
	 */
	@Override
	public String toString()
	{
		return this.id + ";" + this.name + ";" + this.description + ";" + String.valueOf(this.price) + ";" + String.valueOf(this.qty);
	}
}
