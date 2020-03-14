package com.pk.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author PranaySK
 */

@Entity
@Table(name = "USERDETAIL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "email_id")
	public String emailId;

	@Column(name = "name")
	public String name;

	@Column(name = "profile_image")
	public String profileImage;
}
