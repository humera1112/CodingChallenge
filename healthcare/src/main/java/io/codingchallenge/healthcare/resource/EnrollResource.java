/**
 * 
 */
package io.codingchallenge.healthcare.resource;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.codingchallenge.healthcare.domain.EnrollResponse;
import io.codingchallenge.healthcare.domain.Enrollee;
import io.codingchallenge.healthcare.service.EnrollService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

/**
 * @author v.huggila
 *
 */
@Schema(description = "This service has operations to ADD, UPDATE and DELETE enroller and/or Dependants information", title = "")
@RequestMapping("/healthcare")
@RestController
public class EnrollResource implements ErrorController {

	@Autowired
	private EnrollService service;
	private String errorPath = "/error";

	@Operation(method = "POST", description = "This endpoint is used to add a new Enroller or dependants", responses = @ApiResponse(responseCode = "200", description = "Successful", content = @Content(schema = @Schema(implementation = EnrollResponse.class))))

	@PostMapping(path = "/add", produces = "application/json")
	public void addEnrollee(@RequestBody Enrollee enrollee) {

		service.add(enrollee);

	}

	@Operation(method = "PUT", description = "This endpoint is used to update an existing Enroller or dependants")

	@PutMapping(path = "/update", produces = "application/json")
	public void updateEnrollee(@RequestBody Enrollee enrollee) {

		service.update(enrollee);

	}

	@Operation(method = "DELETE", description = "This endpoint is used to delete an existing Enroller or dependants")

	@DeleteMapping(path = "/delete/{id}", produces = "application/json")
	public void deleteEnrollee(@PathVariable Long id) {

		service.delete(id);

	}

	@GetMapping(path = "/error")
	public void handleError(HttpServletRequest request) {

	}

	@Override
	public String getErrorPath() {
		return errorPath;
	}
}
