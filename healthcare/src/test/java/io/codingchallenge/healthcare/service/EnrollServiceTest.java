/**
 * 
 */
package io.codingchallenge.healthcare.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import io.codingchallenge.healthcare.domain.Enrollee;
import io.codingchallenge.healthcare.persistance.entity.EnrolleeEntity;

/**
 * @author v.huggila
 *
 */
@ExtendWith(SpringExtension.class)
public class EnrollServiceTest {

	/**
	 * Test method for
	 * {@link io.codingchallenge.healthcare.service.EnrollService#buildEntityFromDomain(io.codingchallenge.healthcare.domain.Enrollee)}.
	 */
	@Test
	public void testBuildEntityFromDomain() throws Exception {
		EnrollService service = new EnrollService();
		Enrollee enrollee = null;
		EnrolleeEntity enrolleeEntity = service.buildEntityFromDomain(enrollee);

	}

	/**
	 * Test method for
	 * {@link io.codingchallenge.healthcare.service.EnrollService#fetchDob(java.lang.String, io.codingchallenge.healthcare.persistance.entity.EnrolleeEntity)}.
	 */
	@Test
	public void testFetchDob() throws Exception {

		EnrollService service = new EnrollService();
		EnrolleeEntity enrolleeEntity = new EnrolleeEntity();
		service.fetchDob("10051981", enrolleeEntity);
		assertEquals("1981-05-10", enrolleeEntity.getDob().toString());

	}

}
