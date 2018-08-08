package nl.utwente.ing.team.e.dpa.transaction.category.rule.controller;

import nl.utwente.ing.team.e.dpa.transaction.category.rule.dto.CategoryRuleDto;
import nl.utwente.ing.team.e.dpa.transaction.category.rule.dto.NewCategoryRule;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 * @author Martijn Noorlander
 */
@RequestMapping("/categoryRules")
public interface CategoryRuleController {

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<CategoryRuleDto>> getRules();

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<CategoryRuleDto> addRule(@RequestBody @Valid NewCategoryRule newRule);

    @RequestMapping(value = "/{id}", method = GET)
    ResponseEntity<CategoryRuleDto> getRule(@PathVariable("id") Long id);

    @RequestMapping(value = "/{id}", method = PUT)
    ResponseEntity<CategoryRuleDto> updateRule(@PathVariable("id") Long id, @RequestBody @Valid NewCategoryRule newRule);

    @RequestMapping(value = "/{id}", method = DELETE)
    ResponseEntity deleteCategoryRule(@PathVariable("id") Long id);

}
