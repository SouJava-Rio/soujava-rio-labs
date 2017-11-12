package br.org.soujava.rio.repository.jpa;

import java.util.List;

import javax.inject.Named;

import br.org.soujava.rio.domain.User;
import br.org.soujava.rio.repository.UserRepository;
/**
 * Implementação de {@link UserRepository} utilizando JPA
 * 
 * @author arruda
 *
 */
@Named
public class UserRepositoryImpl implements UserRepository{

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
	}
}
