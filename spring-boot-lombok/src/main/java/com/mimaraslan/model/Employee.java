package com.mimaraslan.model;

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
public class Employee {
	private @NonNull Long id;
	private @NonNull String firstName;
	private @NonNull String lastName;
	private @NonNull String email;
}