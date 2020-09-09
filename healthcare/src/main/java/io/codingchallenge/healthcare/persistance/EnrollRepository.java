/**
 * 
 */
package io.codingchallenge.healthcare.persistance;

import org.springframework.stereotype.Repository;

import io.codingchallenge.healthcare.domain.Enrollee;

import org.springframework.data.repository.CrudRepository;

/**
 * @author v.huggila
 *
 */
@Repository
public interface EnrollRepository extends CrudRepository<Enrollee, Long> {

}
