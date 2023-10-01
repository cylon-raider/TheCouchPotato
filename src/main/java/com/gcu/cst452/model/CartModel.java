/**
 * Represents a cart model with its details and operations.
 *
 * @author Chris Markel
 * @version 1.0
 */
package com.gcu.cst452.model;

import java.util.ArrayList;
import java.util.List;

public class CartModel
{
	// Member Variables
	private int userId;
	List<CartItem> items;

	/**
	 * Default constructor.
	 */
	public CartModel() { }

	/**
	 * Constructor to initialize the CartModel object with provided user ID and items.
	 *
	 * @param userId The ID of the user.
	 * @param items The list of cart items.
	 */
	public CartModel(int userId, List<CartItem> items)
	{
		this.userId = userId;
		this.items = items;
	}

	/**
	 * Constructor to initialize the CartModel object with provided user ID and items as a string.
	 *
	 * @param userId The ID of the user.
	 * @param items The string representation of cart items.
	 */
	public CartModel(int userId, String items)
	{
		this.userId = userId;
		this.items = ParseItemsStringToItemList(items);
	}

	/**
	 * Gets the user ID.
	 *
	 * @return The user ID.
	 */
	public int getUserId()
	{
		return userId;
	}

	/**
	 * Sets the user ID.
	 *
	 * @param userId The new user ID.
	 */
	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	/**
	 * Gets the list of cart items.
	 *
	 * @return The list of cart items.
	 */
	public List<CartItem> getItems()
	{
		return items;
	}

	/**
	 * Sets the list of cart items.
	 *
	 * @param items The new list of cart items.
	 */
	public void setItems(List<CartItem> items)
	{
		this.items = items;
	}

	/**
	 * Sets the list of cart items from a string.
	 *
	 * @param items The string representation of cart items.
	 */
	public void setItems(String items)
	{
		this.items = ParseItemsStringToItemList(items);
	}

	/**
	 * Adds a cart item to the list.
	 *
	 * @param item The cart item to be added.
	 */
	public void addItem(CartItem item) {
		this.items.add(item);
	}

	/**
	 * Removes a cart item from the list.
	 *
	 * @param item The cart item to be removed.
	 */
	public void removeItem(CartItem item) {
		this.items.remove(item);
	}

	/**
	 * Parses the string representation of cart items to a list of CartItem objects.
	 *
	 * @param items The string representation of cart items.
	 * @return The list of CartItem objects.
	 */
	private List<CartItem> ParseItemsStringToItemList(String items)
	{
		List<CartItem> itemList = new ArrayList<>();
		if(items.contains(":")) {
			String[] itemListAsStrings = items.split(":");
			for(String item : itemListAsStrings)
			{
				String[] itemProperties = item.split(";");
				itemList.add(new CartItem(Integer.parseInt(itemProperties[0]), itemProperties[1], itemProperties[2], Float.parseFloat(itemProperties[3]), Integer.parseInt(itemProperties[4])));
			}
		} else if (items.contains(";")){
			String[] itemProperties = items.split(";");
			itemList.add(new CartItem(Integer.parseInt(itemProperties[0]), itemProperties[1], itemProperties[2], Float.parseFloat(itemProperties[3]), Integer.parseInt(itemProperties[4])));
		}
		return itemList;
	}

	/**
	 * Converts the list of cart items to a string representation.
	 *
	 * @return The string representation of the list of cart items.
	 */
	public String ItemListToString()
	{
		List<CartItem> tempList = new ArrayList<>(this.items);
		StringBuilder items = new StringBuilder();
		for(CartItem item : this.items)
		{
			items.append(item.toString());
			tempList.remove(item);
			if(!tempList.isEmpty()) {
				items.append(":");
			}
		}
		return items.toString();
	}
}
