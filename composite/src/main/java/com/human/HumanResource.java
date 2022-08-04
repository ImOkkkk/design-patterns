package com.human;

/**
 * @author ImOkkkk
 * @date 2022/8/4 13:31
 * @since 1.0
 */
public abstract class HumanResource {
  protected long id;
  protected double salary;

  public HumanResource(long id) {
    this.id = id;
  }
  public long getId() {
    return id;
  }
  public abstract double calculateSalary();
}
