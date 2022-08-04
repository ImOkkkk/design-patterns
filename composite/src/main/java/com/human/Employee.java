package com.human;

/**
 * @author ImOkkkk
 * @date 2022/8/4 13:32
 * @since 1.0
 */
public class Employee extends HumanResource{

  public Employee(long id, double salary) {
    super(id);
    this.salary = salary;
  }

  @Override
  public double calculateSalary() {
    return salary;
  }
}
