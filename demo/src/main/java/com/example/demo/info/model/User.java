package com.example.demo.info.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
	private String id;
	private String department, rank, name, phone, email, pw;
	private int statement;
}
