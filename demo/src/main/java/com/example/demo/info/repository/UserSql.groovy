package com.example.demo.info.repository

class UserSql {
	public static final String SELECT = """SELECT * FROM user WHERE 1=1""";
	public static final String UPDATE = """UPDATE user SET department = :department, rank = :rank, name = :name, phone = :phone, email = :email, pw = :pw, statement = : statement WHERE 1=1"""
	public static final String DELETE = """DELETE FROM user WHERE 1=1""";
	
	public static final String INSERT = """INSERT INTO user(id, department, rank, name, phone, email, pw, statement) values (:id, :department, :rank, :name, :phone, :email, :pw, :statement)""";
	
	public static final String ID_CONDITION = """ AND id = :id""";
	public static final String DEPARTMENT_CONDITION = """ AND department = :department""";
	public static final String STATEMENT_CONDITION = """ AND statement = :statement""";
}
