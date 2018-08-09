package nl.utwente.ing.team.e.dpa.transaction.category.service;

import nl.utwente.ing.team.e.dpa.framework.exception.NotFoundException;
import nl.utwente.ing.team.e.dpa.framework.exception.UnauthorizedException;
import nl.utwente.ing.team.e.dpa.security.authentication.Authenticated;
import nl.utwente.ing.team.e.dpa.transaction.TransactionRepository;
import nl.utwente.ing.team.e.dpa.transaction.category.Category;
import nl.utwente.ing.team.e.dpa.transaction.category.CategoryRepository;
import nl.utwente.ing.team.e.dpa.transaction.category.dto.NewCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Martijn Noorlander
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(TransactionRepository transactionRepository, CategoryRepository categoryRepository) {
        this.transactionRepository = transactionRepository;
        this.categoryRepository = categoryRepository;
    }

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
    public Category find(Long id, Authenticated authenticated) {
        Category category = categoryRepository.findOne(id);
        if(category == null){
            throw new NotFoundException("The category with id: " + id + " was not found");
        }
        if(!category.getAuthenticated().equals(authenticated)){
            throw new UnauthorizedException("Transaction does not belong to this user");
        }
        return category;
    }

    @Override
    public void delete(Long id, Authenticated authenticated) {
        Category category = categoryRepository.findOne(id);
        if(category == null){
            throw new NotFoundException("The category with id: " + id + " was not found");
        }
        if(!category.getAuthenticated().equals(authenticated)){
            throw new UnauthorizedException("Transaction does not belong to this user");
        }
        transactionRepository.findALlByCategory(category).forEach(t -> {
            t.setCategory(null);
            transactionRepository.save(t);
        });
        categoryRepository.delete(id);
    }

    @Override
    public Category update(Long id, NewCategoryDto newCategoryDto, Authenticated authenticated) {
        Category category = categoryRepository.findOne(id);
        if(category == null){
            throw new NotFoundException("The category with id: " + id + " was not found");
        }
        if(!category.getAuthenticated().equals(authenticated)){
            throw new UnauthorizedException("Transaction does not belong to this user");
        }
        category.setName(newCategoryDto.getName());
        return categoryRepository.save(category);
    }

    @Override
    public Category findByName(String categoryName, Authenticated authenticated) {
        Category category = categoryRepository.findByNameAndAuthenticated(categoryName, authenticated);
        if(category == null){
            throw new NotFoundException("The category with name: " + categoryName + " was not found");
        }
        if(!category.getAuthenticated().equals(authenticated)){
            throw new UnauthorizedException("Transaction does not belong to this user");
        }
        return category;
    }

}
