package com.yt.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="PROJECT_TAB")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter

public class Project
{
	@Id
	@SequenceGenerator(name="gen1",sequenceName="PROJECT_SQU",initialValue=100,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Integer projectId;
	
	
	@Column(length=30)
	@NonNull
	private String projectName;
	
	
	@Column(length=30)
	@NonNull
	private String projComp;
	
	@ManyToMany(targetEntity=Programmer.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="PROJECT_PROGRAMMER_TAB",joinColumns=@JoinColumn(name="project_Id",referencedColumnName="projectId"),
	inverseJoinColumns=@JoinColumn(name="programmerId",referencedColumnName="progId"))
	private Set<Programmer> programmerInfo = new HashSet<>();

	
	
	public Project() 
	{
		System.out.println("Project.Project()");
	
	}



	@Override
	public String toString() 
	{
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", projComp=" + projComp + "]";
	}
	


}
