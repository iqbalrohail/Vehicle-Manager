package com.vehicle.manager.data.transfer.object;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
		
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
	private int id;
	private String username;
	private String password;
	private String photo;


	@OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.LAZY ,mappedBy = "user")
	private List<Employee> employeeList = new ArrayList<>();
}
