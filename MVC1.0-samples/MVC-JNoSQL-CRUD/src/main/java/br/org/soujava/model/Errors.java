package br.org.soujava.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.mvc.binding.ValidationError;

@Named("error")
@RequestScoped
public class Errors {

	private List<ValidationError> errors = new ArrayList<>();

    public void setErrors(List<ValidationError> messages) {
        this.errors = messages;
    }

    public String getErrors() {
        return errors.stream()
                .map(ValidationError::getMessage)
                .collect(Collectors.joining("<br>"));
    }

    public String getMessage(String param) {
    	System.out.println(param);
        return errors.stream()
                .filter(v -> v.getParamName().equals(param))
                .map(ValidationError::getMessage)
                .findFirst()
                .orElse("");
    }
}