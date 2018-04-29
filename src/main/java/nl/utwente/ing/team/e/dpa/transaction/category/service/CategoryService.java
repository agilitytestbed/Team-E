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
     * @param current <code>Authenticated</code> session
     * @return <code>List<Categories></code> categories of session
     */
    List<Category> getCategories(Authenticated current);

    /**
     * Create a new category
     * @param newCategoryDto
     * @param current
     * @return
     */
    Category create(NewCategoryDto newCategoryDto, Authenticated current);

    Category find(Long id);

    void delete(Long id);

    Category update(Long id, NewCategoryDto newCategoryDto);

    Category findByName(String category);
}
