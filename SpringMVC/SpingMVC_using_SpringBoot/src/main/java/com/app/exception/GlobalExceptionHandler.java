package com.app.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	// ✅ Logger for tracking errors (VERY IMPORTANT in real projects)
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	// ==============================
	// 1. HANDLE BUSINESS EXCEPTION
	// ==============================
	@ExceptionHandler(InvalidCredentialsException.class)
	public String handleInvalidCredentials(InvalidCredentialsException ex, Model model) {

		// log only message (clean log)
		logger.warn("Login failed: {}", ex.getMessage());

		model.addAttribute("errorMessage", ex.getMessage());

		// redirect back to login page
		return "users/login";
	}

	// ==============================
	// 2. HANDLE ALL OTHER EXCEPTIONS
	// ==============================
	@ExceptionHandler(Exception.class)
	public String handleGlobalException(Exception ex, Model model) {

		// full stack trace in logs (DO NOT show in UI)
		logger.error("Unexpected system error occurred: ", ex);

		model.addAttribute("errorMessage", "Something went wrong. Please contact support or try again later.");

		return "error";
	}
	
	// ==============================
	// 3. HANDLE DELETE EXCEPTIONS
	// ==============================
	@ExceptionHandler(UserNotFoundException.class)
	public String handleDeleteError(UserNotFoundException ex, Model model) {

	    model.addAttribute("errorMessage", ex.getMessage());

	    return "error";
	}
	
	// ==============================
	// 4. HANDLE RUNTIME EXCEPTIONS
	// ==============================
	@ExceptionHandler(RuntimeException.class)
	public String handleRuntime(RuntimeException ex, Model model) {
	    model.addAttribute("errorMessage", ex.getMessage());
	    return "admin/add-user";
	}
}