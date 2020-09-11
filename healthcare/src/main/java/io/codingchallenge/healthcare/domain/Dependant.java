/**
 * 
 */
package io.codingchallenge.healthcare.domain;

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
public class Dependant {
	@Schema(description = "Id of the Dependant", defaultValue = "1")
	@NonNull
	private Long id;
	@Schema(description = "Name of the Dependant", defaultValue = "Smith")
	@NonNull
	private String name;
	@Schema(description = "Date of Birth of the Dependant", defaultValue = "100620")
	@NonNull
	private String dob;
}
