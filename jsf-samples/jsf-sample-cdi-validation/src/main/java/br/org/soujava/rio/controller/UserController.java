package br.org.soujava.rio.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.org.soujava.rio.domain.User;
import br.org.soujava.rio.service.UserService;

@Named
@RequestScoped
public class UserController implements Serializable {

	@Inject
	private UserService userService;
	
	private User user;
	
	public UserController(){
		this.user = new User();
	}
}
