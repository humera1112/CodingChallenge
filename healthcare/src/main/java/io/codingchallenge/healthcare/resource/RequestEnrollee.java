/**
 * 
 */
package io.codingchallenge.healthcare.resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author v.huggila
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestEnrollee {
	private String name;
	private Boolean activationStatus;
	private String phoneNumber;
	private Date dob;
	List<EnrolleeDependant> dependants;

}
