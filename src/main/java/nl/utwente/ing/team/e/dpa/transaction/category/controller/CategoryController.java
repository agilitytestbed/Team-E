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
     *
     * @return
     */
    @RequestMapping(
            method = GET)
    ResponseEntity<List<Category>> getCategories();

    /**
     *
     * @param newCategoryDto
     * @return
     */
    @RequestMapping(method = POST)
    ResponseEntity<Category> addCategory(@RequestBody @Valid NewCategoryDto newCategoryDto);

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = GET)
    ResponseEntity<Category> getCategory(@PathVariable("id") Long id);

    /**
     *
     * @param id
     * @param newCategoryDto
     * @return
     */
    @RequestMapping(value = "/{id}", method = PUT)
    ResponseEntity<Category> updateCategory(@PathVariable("id") Long id, @RequestBody NewCategoryDto newCategoryDto);

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = DELETE)
    ResponseEntity deleteCategory(@PathVariable("id") Long id);


}
