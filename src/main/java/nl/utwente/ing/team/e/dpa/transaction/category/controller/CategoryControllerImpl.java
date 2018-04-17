package nl.utwente.ing.team.e.dpa.transaction.category.controller;

import nl.utwente.ing.team.e.dpa.framework.BaseUtility;
import nl.utwente.ing.team.e.dpa.transaction.category.Category;
import nl.utwente.ing.team.e.dpa.transaction.category.dto.NewCategoryDto;
import nl.utwente.ing.team.e.dpa.transaction.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Martijn Noorlander
 */
@RestController
public class CategoryControllerImpl extends BaseUtility implements CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryControllerImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ResponseEntity<List<Category>> getCategories() {
        return new ResponseEntity<>(categoryService.getCategories(getCurrent()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Category> addCategory(@RequestBody @Valid NewCategoryDto newCategoryDto) {
        return new ResponseEntity<>(categoryService.create(newCategoryDto, getCurrent()), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Category> getCategory(@PathVariable("id") Long id) {
        return new ResponseEntity<>(categoryService.find(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity deleteCategory(@PathVariable("id") Long id) {
        categoryService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Long id, @RequestBody @Valid NewCategoryDto newCategoryDto) {
        return new ResponseEntity<>(categoryService.update(id, newCategoryDto), HttpStatus.OK);
    }
}
