package com.pk.main.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author PranaySK
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
	private Date timestamp;
	private String message;
	private String details;
}
