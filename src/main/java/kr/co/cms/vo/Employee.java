package kr.co.cms.vo;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Employee implements UserDetails {

	private int no;
	private String id;
	private String pwd;
	private String name;
	private Date birthDate;
	private String gender;
	private String phone;
	private String email;
	private String address;
	private Date joinDate;
	private Date withDrawDate;
	private String status;
	private int departmentCode;
	Collection<GrantedAuthority> authorities;
	/*
	 * CREATE TABLE employee
(
	EMP_NO number NOT NULL,
	EMP_ID varchar2(45) NOT NULL UNIQUE,
	EMP_PWD varchar2(100) NOT NULL,
	EMP_NAME varchar2(45) NOT NULL,
	BIRTH date NOT NULL,
	GENDER varchar2(45) NOT NULL,
	PHONE varchar2(45),
	EMAIL varchar2(45),
	ADDRESS varchar2(45),
	JOIN_DATE timestamp,
	WITHDRAW_DATE timestamp,
	EMP_STATUS varchar2(0),
	DEPT_CODE number NOT NULL,
	PRIMARY KEY (EMP_NO)
);

	 * 
	 */
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	public String getPassword() {
		return pwd;
	}
	public String getUsername() {
		return id;
	}
	public boolean isAccountNonExpired() {
		return true;
	}
	public boolean isAccountNonLocked() {
		return true;
	}
	public boolean isCredentialsNonExpired() {
		return true;
	}
	public boolean isEnabled() {
		return true;
	}
}
