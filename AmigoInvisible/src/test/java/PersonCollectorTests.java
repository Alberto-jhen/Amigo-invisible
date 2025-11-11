import org.invisibleFriend.users.Person;
import org.invisibleFriend.users.PersonCollector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonCollectorTests {

    PersonCollector personCollector;
    Person alberto;
    Person jorge;
    Person iris;
    Person diego;

    @BeforeEach
    public void setUp() {
        personCollector = new PersonCollector();
        alberto = new Person("Alberto");
        jorge = new Person("Jorge");
        iris = new Person("Iris");
        diego = new Person("Diego");
        alberto.setLastYearGifted(jorge);
        jorge.setLastYearGifted(iris);
        iris.setLastYearGifted(diego);
        diego.setLastYearGifted(alberto);
        personCollector.addPerson(alberto).addPerson(jorge).addPerson(iris).addPerson(diego);
    }

    @Test
    public void testAssignNextGift() {
        personCollector.assignNextGift();
        Assertions.assertNotNull(personCollector.getPerson(alberto.getNextGiftPerson()));
        Assertions.assertNotNull(personCollector.getPerson(jorge.getNextGiftPerson()));
        Assertions.assertNotNull(personCollector.getPerson(iris.getNextGiftPerson()));
        Assertions.assertNotNull(personCollector.getPerson(diego.getNextGiftPerson()));
    }
}
