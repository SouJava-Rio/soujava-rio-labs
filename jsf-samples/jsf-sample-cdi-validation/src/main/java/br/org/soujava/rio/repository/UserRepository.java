package br.org.soujava.rio.repository;

import java.util.List;

import br.org.soujava.rio.domain.User;

/**
 * Classe de acesso e persistência de dados de usuários ( {@link User} )
 * @author arruda
 *
 */
public interface UserRepository {

	public User findById(Integer id);

	public List<User> findAll();

	public void save(User user);

	public void update(User user);

	public void delete(User user);

}
