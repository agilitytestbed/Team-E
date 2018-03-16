package nl.utwente.ing.team.e.dpa.transaction.category;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Martijn Noorlander
 */
@RestController
public class CategoryControllerImpl implements CategoryController {
    @Override
    public ResponseEntity<List<Category>> getCategories() {
        return null;
    }

    @Override
    public ResponseEntity<Category> addCategory(NewCategoryDto newCategoryDto) {
        return null;
    }

    @Override
    public ResponseEntity<Category> getCategory(Long id) {
        return null;
    }

    @Override
    public ResponseEntity deleteCategory(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Category> updateCategory(Long id, NewCategoryDto newCategoryDto) {
        return null;
    }
}
