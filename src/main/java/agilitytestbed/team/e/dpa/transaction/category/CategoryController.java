package agilitytestbed.team.e.dpa.transaction.category;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @author Martijn Noorlander
 * @since 4-2-2018.
 */
@RestController
@RequestMapping("/categories")
public interface CategoryController {

    @RequestMapping(value = "/", method = GET)
    public ResponseEntity<List<Category>> getCategories();

    @RequestMapping(value = "/", method = POST)
    public ResponseEntity<Category> addCategory(@RequestBody NewCategoryDto newCategoryDto);

    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity<Category> getCategory(@PathVariable("id") Long id);

    @RequestMapping(value = "/{id}", method = PUT)
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Long id, @RequestBody NewCategoryDto newCategoryDto);

    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity deleteCategory(@PathVariable("id") Long id);


}
