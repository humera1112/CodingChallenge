/**
 * 
 */
package io.codingchallenge.healthcare.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.codingchallenge.healthcare.domain.Enrollee;
import io.codingchallenge.healthcare.service.EnrollService;

/**
 * @author v.huggila
 *
 */
@RestController
public class EnrollResource {

	@Autowired
	private EnrollService service;

	@PostMapping(path = "/add")
	public void addEnrollee(@RequestBody Enrollee enrollee) {

		service.add(enrollee);

	}

	@PutMapping(path = "/update")
	public void updateEnrollee(@RequestBody Enrollee enrollee) {

		service.add(enrollee);

	}

	@DeleteMapping(path = "/delete")
	public void deleteEnrollee(@RequestBody Enrollee enrollee) {

		service.add(enrollee);

	}

}
