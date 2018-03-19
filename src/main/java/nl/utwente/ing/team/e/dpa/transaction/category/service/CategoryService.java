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

    List<Category> getCategories(Authenticated current);

    Category create(NewCategoryDto newCategoryDto, Authenticated current);

    Category find(Long id);

    void delete(Long id);

    Category update(Long id, NewCategoryDto newCategoryDto);

    Category findByName(String category);
}
