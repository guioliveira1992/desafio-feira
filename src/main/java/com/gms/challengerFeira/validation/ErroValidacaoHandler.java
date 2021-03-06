package com.gms.challengerFeira.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gms.challengerFeira.dto.ErroFormDTO;




@RestControllerAdvice
public class ErroValidacaoHandler {
	
	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroFormDTO> handle(MethodArgumentNotValidException exception) {
		List<ErroFormDTO> erroFormDTOs = new ArrayList<>();
		List<FieldError> fieldErros = exception.getBindingResult().getFieldErrors();
		
		fieldErros.forEach(e->{
			String mensagem = "Campo '"+ e.getField() +"' "+ messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErroFormDTO erroFormDTO = new ErroFormDTO(HttpStatus.BAD_REQUEST.value(), mensagem);
			erroFormDTOs.add(erroFormDTO);
		});
		return erroFormDTOs;
		
	}
}
