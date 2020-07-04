import org.testng.annotations.Test;
import ru.javawebinar.topjava.repository.inmemory.InMemoryMealRepository;

public class InMemoryMealRepositoryTest {

    @Test
    public void getAllMeals() {
        InMemoryMealRepository inMemoryMealRepository = new InMemoryMealRepository();
        inMemoryMealRepository.getAll().forEach(s-> System.out.println(s));
    }
}
