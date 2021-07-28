package Kodlamaio.NortwindProje.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlamaio.NortwindProje.business.abstracts.UserService;
import Kodlamaio.NortwindProje.core.dataAccess.UserDao;
import Kodlamaio.NortwindProje.core.entities.User;
import Kodlamaio.NortwindProje.core.utilities.results.DataResult;
import Kodlamaio.NortwindProje.core.utilities.results.Result;
import Kodlamaio.NortwindProje.core.utilities.results.SuccessDataResult;
import Kodlamaio.NortwindProje.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService {

	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı Eklendi");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		
		return new SuccessDataResult<User>(this.userDao.findByEmail(email),"Kullanıcı Bulundu");
	}

}
