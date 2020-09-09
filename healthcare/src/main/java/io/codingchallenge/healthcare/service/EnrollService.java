/**
 * 
 */
package io.codingchallenge.healthcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.codingchallenge.healthcare.domain.Enrollee;
import io.codingchallenge.healthcare.persistance.EnrollRepository;

/**
 * @author v.huggila
 *
 */

@Service
public class EnrollService {

	@Autowired
	private EnrollRepository repository;

	/**
	 * @param enrollee
	 */
	public void add(Enrollee enrollee) {
		repository.save(enrollee);

	}

	public void remove(Enrollee enrollee) {
		repository.delete(enrollee);
	}

	public void modify(Enrollee enrollee) {
		repository.save(enrollee);
	}

}
