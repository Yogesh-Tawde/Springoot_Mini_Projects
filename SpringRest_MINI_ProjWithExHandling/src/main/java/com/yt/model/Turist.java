package com.yt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="REST_TURIST_TAB")
public class Turist 
{
	
	@Id
	@SequenceGenerator(name="gen1",sequenceName="REST_SQU",initialValue=100,allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen1")
	private Integer tid;
	
	@Column(length=30)
	@NonNull
	private String name;
	
	@Column(length=30)
	@NonNull
	private String city;
	
	@Column(length=30)
	@NonNull
	private String packageType;
	
	@NonNull
	private Double budget;

}
