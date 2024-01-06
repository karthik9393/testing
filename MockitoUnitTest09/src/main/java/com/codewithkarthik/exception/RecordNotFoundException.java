package com.codewithkarthik.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor 
@NoArgsConstructor
public class RecordNotFoundException extends RuntimeException {
	private String code;
	private String message;
	

}
