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
@Table(name="MINI_PROJ_IT_EMP_TABLE")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Employee 
{
	@Id
	@SequenceGenerator(name="gen1",sequenceName="MINI_PROJ_SQU",initialValue=100,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.IDENTITY)
	private Integer eid;
	
	@Column(length=30)
	@NonNull
	private String ename;
	
	@Column(length=30)
	@NonNull
	private String edeg;
	
	@Column(length=30)
	@NonNull
	private String eadd;
	
	@Column(length=30)
	@NonNull
	private Double esal;
	
	private Long emobile;
	
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
