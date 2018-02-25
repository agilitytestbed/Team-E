package agilitytestbed.team.e.dpa.transaction.category;

import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author Martijn Noorlander
 */
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
