package telran.java45.person.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@JsonTypeName("EmployeeDto")
public class EmployeeDto extends PersonDto {
	String company;
	int salary;
	
}
