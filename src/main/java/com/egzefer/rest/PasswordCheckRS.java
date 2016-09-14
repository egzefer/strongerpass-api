package com.egzefer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.egzefer.dto.PasswordRequestDTO;
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
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public ResponseEntity check(@RequestBody PasswordRequestDTO dto) {

		return ResponseEntity.status(HttpStatus.OK).body(service.check(dto.getPassword()));
	}
}
