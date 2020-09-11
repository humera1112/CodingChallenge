/**
 * 
 */
package io.codingchallenge.healthcare.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.time.LocalDate;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.codingchallenge.healthcare.domain.EnrollResponse;
import io.codingchallenge.healthcare.domain.Enrollee;
import io.codingchallenge.healthcare.exception.ServiceException;
import io.codingchallenge.healthcare.persistance.EnrollRepository;
import io.codingchallenge.healthcare.persistance.entity.DependantEntity;
import io.codingchallenge.healthcare.persistance.entity.EnrolleeEntity;

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
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public EnrollResponse add(Enrollee enrollee) {
		EnrolleeEntity enrolleeEntity = buildEntityFromDomain(enrollee);

		try {
			EnrolleeEntity addedEntity = repository.save(enrolleeEntity);

			EnrollResponse enrollResponse = new EnrollResponse();

			BeanUtilsBean.getInstance().copyProperties(enrollResponse, addedEntity);
			return enrollResponse;
		} catch (Exception e) {
			throw new ServiceException("Exception while processing service request" + e.getMessage());
		}

	}

	/**
	 * @param enrollee
	 * @param enrolleeEntity
	 * @return
	 */
	protected EnrolleeEntity buildEntityFromDomain(Enrollee enrollee) {
		EnrolleeEntity enrolleeEntity = new EnrolleeEntity();
		enrolleeEntity.setActivationStatus(enrollee.getActivationStatus());
		enrolleeEntity.setName(enrollee.getName());
		enrolleeEntity.setPhoneNumber(enrollee.getPhoneNumber());
		enrolleeEntity = (EnrolleeEntity) fetchDob(enrollee.getDob(), enrolleeEntity);
		enrollee.getDependants().forEach(e -> {
			DependantEntity dependantEntity = new DependantEntity();
			dependantEntity = (DependantEntity) fetchDob(e.getDob(), dependantEntity);
			dependantEntity.setName(e.getName());

		});
		return enrolleeEntity;
	}

	/**
	 * @param dateOfBirth
	 * @param enrolleeEntity
	 */
	protected Object fetchDob(String dateOfBirth, Object obj) {
		String day = dateOfBirth.substring(0, 2);
		String month = dateOfBirth.substring(2, 4);
		String year = dateOfBirth.substring(4, dateOfBirth.length());

		if (obj instanceof EnrolleeEntity) {

			((EnrolleeEntity) obj).setDob(
					Date.valueOf(LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day))));
		} else if (obj instanceof DependantEntity) {
			((DependantEntity) obj).setDob(
					Date.valueOf(LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day))));
		}
		return obj;
	}

	/**
	 * @param id
	 */
	public void delete(Long id) {
		if (repository.existsById(id)) {

			repository.deleteById(id);
		} else {
			throw new ServiceException("No record found");
		}

	}

	/**
	 * @param enrollee
	 */
	public void update(Enrollee enrollee) {
		EnrolleeEntity enrolleeEntity = new EnrolleeEntity();
		enrolleeEntity.setActivationStatus(enrollee.getActivationStatus());

		repository.save(enrolleeEntity);

	}

}
