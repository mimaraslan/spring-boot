package com.mimaraslan.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Employee {	
	private  @NonNull long id;
	private  @NonNull String firstName;
	private  @NonNull String lastName;
	private  @NonNull String emailId;
}