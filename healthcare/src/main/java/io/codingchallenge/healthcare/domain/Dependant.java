/**
 * 
 */
package io.codingchallenge.healthcare.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author v.huggila
 *
 */
@Entity
@Table(name = "t_usr_dep")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dependant implements Serializable {

	private static final long serialVersionUID = -5210684798104259983L;

	@NonNull
	private String name;

	@NonNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;

}
