package nl.utwente.ing.team.e.dpa.transaction.category.rule.controller;

import nl.utwente.ing.team.e.dpa.framework.BaseUtility;
import nl.utwente.ing.team.e.dpa.transaction.category.rule.dto.CategoryRuleDto;
import nl.utwente.ing.team.e.dpa.transaction.category.rule.dto.NewCategoryRule;
import nl.utwente.ing.team.e.dpa.transaction.category.rule.service.CategoryRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Martijn Noorlander
 */
@RestController
public class CategoryRuleControllerImpl extends BaseUtility implements CategoryRuleController{

    private final CategoryRuleService categoryRuleService;

    @Autowired
    public CategoryRuleControllerImpl(CategoryRuleService categoryRuleService) {
        this.categoryRuleService = categoryRuleService;
    }

    @Override
    public ResponseEntity<List<CategoryRuleDto>> getRules() {
        return new ResponseEntity<>(categoryRuleService.getRules(getCurrent()).stream().map(CategoryRuleDto::new).collect(Collectors.toList()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoryRuleDto> addRule(@RequestBody @Valid NewCategoryRule newRule) {
        return new ResponseEntity<>(new CategoryRuleDto(categoryRuleService.addRule(newRule, getCurrent())), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CategoryRuleDto> getRule(@PathVariable("id")Long id) {
        return new ResponseEntity<>(new CategoryRuleDto(categoryRuleService.getRule(id, getCurrent())), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoryRuleDto> updateRule(@PathVariable("id") Long id, @RequestBody @Valid  NewCategoryRule newRule) {
        return new ResponseEntity<>(new CategoryRuleDto(categoryRuleService.updateRule(id, newRule, getCurrent())), HttpStatus.OK);
    }

    @Override
    public ResponseEntity deleteCategoryRule(@PathVariable("id")Long id) {
        categoryRuleService.deleteRule(id, getCurrent());
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
