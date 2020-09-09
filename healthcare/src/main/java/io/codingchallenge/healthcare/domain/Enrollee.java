/**
 * 
 */
package io.codingchallenge.healthcare.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
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
public class Enrollee implements Serializable {

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
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;

	@Nullable
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id")
	List<Dependant> dependants = new ArrayList<>();

}
