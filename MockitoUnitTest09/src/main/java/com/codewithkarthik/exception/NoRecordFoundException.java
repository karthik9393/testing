package com.codewithkarthik.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoRecordFoundException extends RuntimeException {
	
	private String code;
	private String message;

}
