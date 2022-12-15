package telran.java45.person.dao;

import java.time.LocalDate;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import telran.java45.person.dto.CityPopulationDto;
import telran.java45.person.model.Child;
import telran.java45.person.model.Employee;
import telran.java45.person.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

	@Query("select p from Person p where p.address.city=:city")
	Stream<Person> findPersonsByCity(@Param("city") String city);
	
	@Query("select p from Person p where p.name=?1")
	Stream<Person> findPersonsByName(String name);

	Stream<Person> findByBirthDateBetween(LocalDate from, LocalDate to);
	
	@Query("select new telran.java45.person.dto.CityPopulationDto(p.address.city, count(p)) from Person p group by p.address.city order by count(p) desc")
	Iterable<CityPopulationDto> getCitiesPopulation();

	Stream<Child> findChildrenBy();
	
	Stream<Employee> findBySalaryBetween(int min, int max);

}
