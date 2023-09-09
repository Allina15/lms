package LMS.ServiceImpl;

import LMS.Models.Person;
import LMS.Services.PersonService;

public class PersonServiceImpl implements PersonService {
  private Person person;

    public PersonServiceImpl(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String updatePassword(String email,String password) {
        if (person.getEmail().equals(email)){
            person.setPassword(password);
        }
        return "Пароль озгортулду";
    }

    @Override
    public String toString() {
        return "PersonServiceImpl{" +
                "person=" + person +
                '}';
    }
}
