package Kodlamaio.NortwindProje.business.abstracts;

import Kodlamaio.NortwindProje.core.entities.User;
import Kodlamaio.NortwindProje.core.utilities.results.DataResult;
import Kodlamaio.NortwindProje.core.utilities.results.Result;

public interface UserService {

	Result add(User user);
	DataResult<User> findByEmail(String email);
}
