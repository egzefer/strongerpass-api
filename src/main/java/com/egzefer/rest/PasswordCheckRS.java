package com.egzefer.rest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egzefer.service.PasswordCheckService;

@RestController
@RequestMapping("/password")
public class PasswordCheckRS {

	@Autowired
	private PasswordCheckService service;

	/**
	 * Checks whether the given password is valid or not, according to the
	 * validation rules
	 * 
	 * @param password
	 * @return the details about the password strength
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/check/{password}", method = GET)
	public ResponseEntity check(@PathVariable String password) {

		return ResponseEntity.status(HttpStatus.OK).body(service.check(password));
	}
}
