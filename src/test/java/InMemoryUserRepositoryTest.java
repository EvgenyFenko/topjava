import org.testng.annotations.Test;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.inmemory.InMemoryUserRepository;
import ru.javawebinar.topjava.util.UserUtil;

public class InMemoryUserRepositoryTest {

    @Test
    public void checkDeletingUser() {
        InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository();
        inMemoryUserRepository.delete(2);
        inMemoryUserRepository.getAll().forEach(s-> System.out.println(s.toString()));
    }

    @Test
    public void checkSavingUser() {
        InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository();
        User user = inMemoryUserRepository.save(UserUtil.USERS.get(0));
        System.out.println(user.getName());
    }

    @Test
    public void checkGettingUserById() {
        System.out.println("User by id " + " = " + new InMemoryUserRepository().get(3));
    }

    @Test
    public void checkGettingAllUsers() {
        InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository();
        inMemoryUserRepository.getAll().forEach(s-> System.out.println(s.toString()));
    }

    @Test
    public void checkGettingUserByEmail() {
        InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository();
        System.out.println("User found by email - " + inMemoryUserRepository.getByEmail("email1@email.com"));
    }
}
