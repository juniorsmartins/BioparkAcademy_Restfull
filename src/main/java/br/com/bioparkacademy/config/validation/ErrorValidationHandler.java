package br.com.bioparkacademy.config.validation;

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

/**
 * @author JuniorMartins
 */
@RestControllerAdvice // Todos os erros de validação em qualquer controller serão invocados para cá
public class ErrorValidationHandler 
{
    @Autowired
    private MessageSource messageSource; // Internacionalização de mensagens - pega mensagens de erro em várias línguas
    
    @ResponseStatus(code = HttpStatus.BAD_REQUEST) // força a devolução de bad_request em situações de erro de validação
    @ExceptionHandler(MethodArgumentNotValidException.class) // capturará a exceção do parênteses em qualquer controler
    public List<ErrorFormDto> handle(MethodArgumentNotValidException methArgException)
    {
        List<ErrorFormDto> errosDtos = new ArrayList<>();
        
        List<FieldError> fieldErrors = methArgException.getBindingResult().getFieldErrors(); // busca erros de formulário
        fieldErrors.forEach(e -> 
        {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale()); // capta mensagem de erro
            ErrorFormDto erros = new ErrorFormDto(e.getField(), mensagem);
            errosDtos.add(erros);
        });

        return errosDtos;
    }
    
}




