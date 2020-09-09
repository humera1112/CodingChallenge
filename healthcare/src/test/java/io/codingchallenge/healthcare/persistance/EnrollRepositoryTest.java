/**
 * 
 */
package io.codingchallenge.healthcare.persistance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import io.codingchallenge.healthcare.domain.Dependant;
import io.codingchallenge.healthcare.domain.Enrollee;

/**
 * @author v.huggila
 *
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class EnrollRepositoryTest {

	@Autowired
	private EnrollRepository repository;

	/**
	 * Test method for
	 * {@link io.codingchallenge.healthcare.persistance.EnrollRepository#save(io.codingchallenge.healthcare.domain.Enrollee)}.
	 */

	@Test
	public void testAddEnrollee() throws Exception {

		Enrollee enrollee = new Enrollee();
		enrollee.setId(1L);
		enrollee.setActivationStatus(true);
		enrollee.setName("John");
		enrollee.setDob(Date.valueOf(LocalDate.of(1980, 02, 12)));
		Enrollee result = repository.save(enrollee);

		assertEquals("John", result.getName());
	}

	@Test
	public void testAddEnrolleeWithDependants() throws Exception {

		Enrollee enrollee = new Enrollee();
		enrollee.setId(2L);
		enrollee.setActivationStatus(true);
		enrollee.setName("John");
		enrollee.setDob(java.sql.Date.valueOf(LocalDate.of(1980, 02, 12)));
		List<Dependant> dependants = Arrays.asList(
				new Dependant(1L, "John Sr", Date.valueOf(LocalDate.of(1950, 12, 25))),
				new Dependant(2L, "Kate", Date.valueOf(LocalDate.of(1955, 8, 22))));
		enrollee.setDependants(dependants);
		Enrollee result = repository.save(enrollee);

		assertEquals("John", result.getName());
		assertEquals("John Sr", result.getDependants().get(0).getName());
		assertEquals("Kate", result.getDependants().get(1).getName());
	}

	@Test
	void testModifyEnrollee() {
		Enrollee enrollee = new Enrollee();
		enrollee.setId(3L);
		enrollee.setActivationStatus(true);
		enrollee.setName("John");
		enrollee.setDob(Date.valueOf(LocalDate.of(1980, 02, 12)));
		List<Dependant> dependants = Arrays.asList(
				new Dependant(1L, "John Sr", Date.valueOf(LocalDate.of(1950, 12, 25))),
				new Dependant(2L, "Kate", Date.valueOf(LocalDate.of(1955, 8, 22))));
		enrollee.setDependants(dependants);
		repository.save(enrollee);
		enrollee.setDob(Date.valueOf(LocalDate.of(1981, 02, 12)));
		enrollee.getDependants().get(0).setDob(Date.valueOf(LocalDate.of(1950, 01, 25)));
		Enrollee result = repository.save(enrollee);
		assertEquals(1981, result.getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear());
		assertEquals(Month.JANUARY, result.getDependants().get(0).getDob().toInstant().atZone(ZoneId.systemDefault())
				.toLocalDate().getMonth());

	}

	@Test
	void testRemoveEnrollee() {

		Enrollee enrollee = new Enrollee();
		enrollee.setId(4L);
		enrollee.setActivationStatus(true);
		enrollee.setName("Jake");
		enrollee.setDob(Date.valueOf(LocalDate.of(1970, 02, 12)));
		repository.save(enrollee);
		assertEquals(4L, enrollee.getId());
		repository.delete(enrollee);
		assertFalse(repository.existsById(enrollee.getId()));

	}

}
