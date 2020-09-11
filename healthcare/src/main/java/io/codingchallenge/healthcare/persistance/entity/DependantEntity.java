/**
 * 
 */
package io.codingchallenge.healthcare.persistance.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
public class DependantEntity implements Serializable {

	private static final long serialVersionUID = -5210684798104259983L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull
	private Long id;

	@NonNull
	private String name;

	@NonNull
	private Date dob;

}
