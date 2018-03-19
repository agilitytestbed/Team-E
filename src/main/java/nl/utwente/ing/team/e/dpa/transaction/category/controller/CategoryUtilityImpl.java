package nl.utwente.ing.team.e.dpa.transaction.category.controller;

import nl.utwente.ing.team.e.dpa.framework.BaseUtility;
import nl.utwente.ing.team.e.dpa.transaction.category.Category;
import nl.utwente.ing.team.e.dpa.transaction.category.dto.NewCategoryDto;
import nl.utwente.ing.team.e.dpa.transaction.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Martijn Noorlander
 */
@RestController
public class CategoryUtilityImpl extends BaseUtility implements CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryUtilityImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ResponseEntity<List<Category>> getCategories() {
        return new ResponseEntity<>(categoryService.getCategories(getCurrent()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Category> addCategory(NewCategoryDto newCategoryDto) {
        return new ResponseEntity<>(categoryService.create(newCategoryDto, getCurrent()), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Category> getCategory(Long id) {
        return new ResponseEntity<>(categoryService.find(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity deleteCategory(Long id) {
        categoryService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Category> updateCategory(Long id, NewCategoryDto newCategoryDto) {
        return new ResponseEntity<>(categoryService.update(id, newCategoryDto), HttpStatus.OK);
    }
}
