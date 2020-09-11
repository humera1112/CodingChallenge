/**
 * 
 */
package io.codingchallenge.healthcare.persistance;

import org.springframework.stereotype.Repository;

import io.codingchallenge.healthcare.persistance.entity.EnrolleeEntity;

import org.springframework.data.repository.CrudRepository;

/**
 * @author v.huggila
 *
 */
@Repository
public interface EnrollRepository extends CrudRepository<EnrolleeEntity, Long> {

}
