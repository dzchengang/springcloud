package com.sdstc.system.model;

import lombok.Data;

@Data
public class UserInfo {
	private Long id;
	private String account;
	private String name;
	private String pwd;
}