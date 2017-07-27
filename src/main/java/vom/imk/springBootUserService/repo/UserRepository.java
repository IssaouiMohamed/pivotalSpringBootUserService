package vom.imk.springBootUserService.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import vom.imk.springBootUserService.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
