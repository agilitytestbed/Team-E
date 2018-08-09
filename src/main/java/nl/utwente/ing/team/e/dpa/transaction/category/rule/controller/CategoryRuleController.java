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

    /**
     * Retrieve all rules linked tot the <code>Authenticated</code> session
     * @return ResponseEntity HTTP 200 OK <code>List</code> of <code>CategoryRuleDto</code>
     */
    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<CategoryRuleDto>> getRules();

    /**
     * Add a rule to the session
     * @param newRule <code>NewCategoryRule</code> dto with rule
     * @return ResponseEntity HTTP 201 CREATED <code>CategoryRuleDto</code> created rule
     */
    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<CategoryRuleDto> addRule(@RequestBody @Valid NewCategoryRule newRule);

    /**
     * Retrieve a specific rule
     * @param id int id of Rule
     * @return ResponseEntity HTTP 200 OK <code>CategoryRuleDto</code> rule
     */
    @RequestMapping(value = "/{id}", method = GET)
    ResponseEntity<CategoryRuleDto> getRule(@PathVariable("id") Long id);

    /**
     * Update a rule in the session
     * @param id int id of rule
     * @param newRule <code>NewCategoryRule</code> updated rule
     * @return ResponseEntity HTTP 200 OK <code>CategoryRuleDto</code> updated rule
     */
    @RequestMapping(value = "/{id}", method = PUT)
    ResponseEntity<CategoryRuleDto> updateRule(@PathVariable("id") Long id, @RequestBody @Valid NewCategoryRule newRule);

    /**
     * Delete a rule
     * @param id int id of rule
     * @return ResponseEntity HTTP 204 NO CONTENT
     */
    @RequestMapping(value = "/{id}", method = DELETE)
    ResponseEntity deleteCategoryRule(@PathVariable("id") Long id);

}
