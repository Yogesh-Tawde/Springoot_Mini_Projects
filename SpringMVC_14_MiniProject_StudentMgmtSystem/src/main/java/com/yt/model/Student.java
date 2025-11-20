package com.yt.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="MINI_PROJ_STUDENT_TAB")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Student 
{
	
	@Id
	@SequenceGenerator(name="gen1",sequenceName="MP_STUD_SQU",initialValue=1,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.IDENTITY)
	private Integer sid;
	
	@Column(length=30)
	@NonNull
	private String sname;
	
	@Column(length=30)
	@NonNull
	private String sgrade;
	
	@Column(length=30)
	@NonNull
	private String sadd;
	
	@NonNull
	private Long scontact;
	
	@Version
	private Integer updateCount;
	
	@CreationTimestamp
	@Column(insertable=true,updatable=false)
	private LocalDateTime creationTime;
	
	@UpdateTimestamp
	@Column(insertable=false,updatable=true)
	private LocalDateTime updatedOn;
	
    
	@Column(length=30)
	private String createdBy;
	
	@Column(length=30)
	private String updatedBy;
	
	
	
	

}
