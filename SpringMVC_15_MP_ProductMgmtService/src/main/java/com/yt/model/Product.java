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
@Table(name="MINI_PROJ_PRODUCT")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Product 
{
	
	@Id
	@SequenceGenerator(name="gen1",sequenceName="PROD_SQU",initialValue=100,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.IDENTITY)
	private Integer pid;
	
	@Column(length=30)
	@NonNull
	private String pname;
	
	@Column(length=30)
	@NonNull
	private String pcat;
	
	@Column(length=30)
	@NonNull
	private String pmanfac;
	
	private Double pprice;
	
	@Version
	private Integer updateCount;
	
	@CreationTimestamp
	private LocalDateTime creationTime;
	
	@UpdateTimestamp
	private LocalDateTime updatedOn;
	
	@Column(length=30)
	private String createdBy;
	
	@Column(length=30)
	private String updatedBy;
	
	

}
