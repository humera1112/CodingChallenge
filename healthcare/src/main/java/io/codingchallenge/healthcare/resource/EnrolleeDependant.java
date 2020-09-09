/**
 * 
 */
package io.codingchallenge.healthcare.resource;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.NonNull;

/**
 * @author v.huggila
 *
 */
public class EnrolleeDependant {
	@Id
	private Long id;

	@NonNull
	private String name;

	@NonNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
}
