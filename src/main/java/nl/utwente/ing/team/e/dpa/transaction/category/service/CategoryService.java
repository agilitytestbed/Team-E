package nl.utwente.ing.team.e.dpa.transaction.category.service;

import nl.utwente.ing.team.e.dpa.security.authentication.Authenticated;
import nl.utwente.ing.team.e.dpa.transaction.category.Category;
import nl.utwente.ing.team.e.dpa.transaction.category.dto.NewCategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Martijn Noorlander
 * @since 4-2-2018.
 */
@Service
public interface CategoryService {

    /**
     * Retrieve all categories of a certain authenticated object
     *
     * @param current <code>Authenticated</code> session
     * @return <code>List<Categories></code> categories of session
     */
    List<Category> getCategories(Authenticated current);

    /**
     * Create a new category
     *
     * @param newCategoryDto Category to create
     * @param current        <code>Authenticated</code> session
     * @return <code>Category</code> created
     */
    Category create(NewCategoryDto newCategoryDto, Authenticated current);

    /**
     * Find a category by Id
     *
     * @param id Long Id of category
     * @return <code>Category</code> found
     */
    Category find(Long id, Authenticated current);

    /**
     * Delete a category by Id
     *
     * @param id Long Id of category
     */
    void delete(Long id, Authenticated current);

    /**
     * Update a category
     *
     * @param newCategoryDto new Category details
     * @param id             Long Id of category
     * @return <code>Category</code> updated
     */
    Category update(Long id, NewCategoryDto newCategoryDto, Authenticated current);

    /**
     * Find a category by name
     *
     * @param category String name of category
     * @return <code>Category</code> found
     */
    Category findByName(String category, Authenticated current);
}
