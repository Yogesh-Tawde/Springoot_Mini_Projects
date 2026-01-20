package com.yt.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name="PROGRAMMER_TAB")
@AllArgsConstructor
@Getter
@Setter
public class Programmer 
{
	
	
	@Id
	@SequenceGenerator(name="gen1",sequenceName="PROGRAMMER_SQU",initialValue=1,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Integer progId;
	
	
	@Column(length=30)
	@NonNull
	private String progName;
	
	
	@Column(length=30)
	@NonNull
	private String proLang;
	
    
	@ManyToMany(targetEntity=Project.class,fetch=FetchType.LAZY,mappedBy="programmerInfo")
	private Set<Project> projectInfo = new HashSet<>();


	public Programmer() 
	{
		System.out.println("Programmer.Programmer()");
	}


	@Override
	public String toString() 
	{
		return "Programmer [proId=" + progId + ", progName=" + progName + ", proLang=" + proLang + "]";
	}
	
	
	
	
	
}
