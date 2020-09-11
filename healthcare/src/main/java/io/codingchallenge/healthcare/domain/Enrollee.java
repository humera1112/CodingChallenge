/**
 * 
 */
package io.codingchallenge.healthcare.domain;

import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author v.huggila
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "")
public class Enrollee {
	@Schema(description = "Id of the Enroller", defaultValue = "1")
	@NonNull
	private Long id;
	@Schema(description = "Name of the Enroller", defaultValue = "John")
	@NonNull
	private String name;
	@Schema(description = "Activation status", defaultValue = "true")
	@NonNull
	private Boolean activationStatus;
	@Schema(description = "Phone Number of the Enroller", defaultValue = "4153145689")
	private String phoneNumber;
	@Schema(description = "Date of Birth of the Enroller", defaultValue = "100620")
	@NonNull
	private String dob;
	private List<Dependant> dependants = new ArrayList<>();

}
