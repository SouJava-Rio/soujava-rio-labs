package br.org.soujava.rio.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import br.org.soujava.rio.domain.User;
import br.org.soujava.rio.repository.UserRepository;

/**
 * @author arruda
 */
@Named
public class UserService {

	@Inject
	private UserRepository userRepository;
	
	/**
	 * Consultar usuário pelo ID
	 * 
	 * @param id
	 * @return Optional<User>
	 */
	public Optional<User> findById(Integer id){
		return Optional.empty();
	}

	/**
	 * Consultar todos usuários
	 * 
	 * @return
	 */
	public List<User> findAll(){
		return Collections.emptyList();
	}
	
	/**
	 * Criar usuário
	 * 
	 * @param user
	 */
	public void save(User user){
		
	}

	/**
	 * Atualizar usuário 
	 * 
	 * @param user
	 */
	public void update(User user){
		
	}
	
	/**
	 * Excluir usuário
	 * @param user
	 */
	public void delete(User user){
		
	}

}
