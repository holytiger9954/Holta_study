package kr.or.human3;

import lombok.Data;

@Data
public class CalorieDTO {
	String type; // food 또는 exercise
	String name;
	int calorie;
}