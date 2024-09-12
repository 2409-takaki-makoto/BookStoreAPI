package com.example.BookStore.application.api.advice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.BookStore.application.api.errorresponse.ErrorResponse;
import com.example.BookStore.application.api.errorresponse.ValidationErrorDetail;
import com.example.BookStore.application.api.errorresponse.ValidationErrorResponse;
import com.example.BookStore.application.exception.BusinessException;
import com.example.BookStore.application.exception.SystemException;
import com.example.BookStore.application.exception.error.ErrorObject;

@RestControllerAdvice
public class ApiExceptionHandler {
	/** エラーレスポンスのステータス判定用 */
	final private static List<ErrorObject> NOT_FOUND_ERROR_LIST = new ArrayList<>();
	
	static {
		NOT_FOUND_ERROR_LIST.add(ErrorObject.ユーザー情報がみつかりません);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ValidationErrorResponse handleValidException(MethodArgumentNotValidException ex) {
		
		ex.printStackTrace();
		
		ValidationErrorResponse errorResponse = new ValidationErrorResponse();
		List<FieldError> errorList = ex.getBindingResult().getFieldErrors();

		for (FieldError error : errorList) {

			ValidationErrorDetail errorDetail = new ValidationErrorDetail(error.getField(), error.getDefaultMessage());
			errorResponse.add(errorDetail);
		}

		return errorResponse;
	}

	@ExceptionHandler(BusinessException.class)
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex) {
//		ex.printStackTrace();
		ErrorResponse errorResponse = new ErrorResponse(ex.getErrorDetail(), ex.getEmbedded());
		
		// 返却するHTTPステータスを確定する
		HttpStatus status = statusDetermination(ex.getErrorDetail());
		
		return new ResponseEntity<>(errorResponse, status);
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse handleSystemException(Exception ex) {
		ex.printStackTrace();
		
		if (ex instanceof SystemException) {
			SystemException sysEx = (SystemException)ex;
			
			if (sysEx.getEmbedded() != null) {
				return new ErrorResponse(sysEx.getErrorDetail(), sysEx.getEmbedded());
			} else {
				return new ErrorResponse(sysEx.getErrorDetail());				
			}
		}
		
		return new ErrorResponse(ErrorObject.予期せぬエラーが発生しました_1, "\nエラー情報: \n" + ex.toString());
		
	}
	
	private HttpStatus statusDetermination(ErrorObject error) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		if (NOT_FOUND_ERROR_LIST.contains(error)) {
			status = HttpStatus.NOT_FOUND;
		}
		
		return status;
	}

}
