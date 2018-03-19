package nl.utwente.ing.team.e.dpa.transaction.category.service;

import nl.utwente.ing.team.e.dpa.framework.BaseUtility;
import nl.utwente.ing.team.e.dpa.security.authentication.Authenticated;
import nl.utwente.ing.team.e.dpa.transaction.category.Category;
import nl.utwente.ing.team.e.dpa.transaction.category.CategoryRepository;
import nl.utwente.ing.team.e.dpa.transaction.category.dto.NewCategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Martijn Noorlander
 */
@Service
public class CategoryServiceImpl extends BaseUtility implements CategoryService {

    CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories(Authenticated current) {
        return categoryRepository.findAllByAuthenticated(current);
    }

    @Override
    public Category create(NewCategoryDto newCategoryDto, Authenticated current) {
        Category category = new Category(newCategoryDto, current);
        return categoryRepository.save(category);
    }

    @Override
    public Category find(Long id) {
        Category category = categoryRepository.getOne(id);
        if(category == null){
            // TODO Throw 404
        }
        return category;
    }

    @Override
    public void delete(Long id) {
        Category category = categoryRepository.getOne(id);
        if(category == null){
            // TODO Throw 404
        }
        categoryRepository.delete(id);
    }

    @Override
    public Category update(Long id, NewCategoryDto newCategoryDto) {
        Category category = categoryRepository.getOne(id);
        if(category == null){
            // TODO Throw 404
        }
        category.setName(newCategoryDto.getName());
        return categoryRepository.save(category);
    }

    @Override
    public Category findByName(String categoryName) {
        Category category = categoryRepository.findByNameAndAuthenticated(categoryName, getCurrent());
        if(category == null){
            // TODO Throw 404
        }
        return category;
    }

}
