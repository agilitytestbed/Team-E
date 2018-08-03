package nl.utwente.ing.team.e.dpa.transaction.category.controller;

import nl.utwente.ing.team.e.dpa.transaction.category.Category;
import nl.utwente.ing.team.e.dpa.transaction.category.dto.NewCategoryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Controller for Category objects
 * @author Martijn Noorlander
 * @since 4-2-2018.
 */
@RequestMapping("/categories")
public interface CategoryController {

    /**
     * Retrieve all categories for a provided session
     * @return ResponseEntity with categories
     */
    @RequestMapping(
            method = GET)
    ResponseEntity<List<Category>> getCategories();

    /**
     * Create a category with a given session
     * @param newCategoryDto Name of category
     * @return ResponseEntity with Category
     */
    @RequestMapping(method = POST)
    ResponseEntity<Category> addCategory(@RequestBody @Valid NewCategoryDto newCategoryDto);

    /**
     * Retrieve a category
     * @param id Id of specific category
     * @return ResponseEntity with Category
     */
    @RequestMapping(value = "/{id}", method = GET)
    ResponseEntity<Category> getCategory(@PathVariable("id") Long id);

    /**
     * Update a category with an id
     * @param id Id of category
     * @param newCategoryDto name of category
     * @return ResponseEntity with Category
     */
    @RequestMapping(value = "/{id}", method = PUT)
    ResponseEntity<Category> updateCategory(@PathVariable("id") Long id, @RequestBody NewCategoryDto newCategoryDto);

    /**
     * Delete a category with an id
     * @param id Id of category
     * @return ResponseEntity Void
     */
    @RequestMapping(value = "/{id}", method = DELETE)
    ResponseEntity deleteCategory(@PathVariable("id") Long id);


}
