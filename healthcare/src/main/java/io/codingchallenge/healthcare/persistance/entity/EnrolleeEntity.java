/**
 * 
 */
package io.codingchallenge.healthcare.persistance.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author v.huggila
 *
 */
@Entity
@Table(name = "t_usr_enroll")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrolleeEntity implements Serializable {

	private static final long serialVersionUID = -6768418913570506311L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull
	private Long id;

	@NonNull
	@Column(name = "name")
	private String name;

	@NonNull
	@Column(name = "act_status")
	private Boolean activationStatus;

	@Nullable
	@Column(name = "phone_num")
	private String phoneNumber;

	@NonNull
	@Column(name = "dob")
	private Date dob;

	@Nullable
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id")
	private List<DependantEntity> dependants = new ArrayList<>();

}
