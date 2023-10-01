/**
 * Generic Data Access Interface to define CRUD operations.
 *
 * @param <T> the type of objects this interface handles.
 *
 * @author Chris Markel
 * @version 1.0
 */
package com.gcu.cst452.data;

import java.util.List;

public interface DataAccessInterface <T>{

    /**
     * Retrieves all objects of type T.
     *
     * @return A list of objects of type T.
     */
    List<T> getAll();

    /**
     * Retrieves a specific object of type T by its ID.
     *
     * @param id The ID of the object to retrieve.
     * @return An object of type T.
     */
    T getById(int id);

    /**
     * Creates a new object of type T in the data store.
     *
     * @param t The object of type T to create.
     * @return A boolean indicating the success of the operation.
     */
    boolean create(T t);

    /**
     * Updates an existing object of type T in the data store.
     *
     * @param t The object of type T to update.
     * @return A boolean indicating the success of the operation.
     */
    boolean update(T t);

    /**
     * Deletes a specific object of type T from the data store.
     *
     * @param t The object of type T to delete.
     * @return A boolean indicating the success of the operation.
     */
    boolean delete(T t);
}
