package com.human;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ImOkkkk
 * @date 2022/8/4 13:33
 * @since 1.0
 */
public class Department extends HumanResource{

  public Department(long id) {
    super(id);
  }

  private List<HumanResource> subNodes = new ArrayList<>();

  public void addSubNode(HumanResource hr) {
    subNodes.add(hr);
  }
  @Override
  public double calculateSalary() {
    double totalSalary = 0;
    for (HumanResource hr : subNodes) {
      totalSalary += hr.calculateSalary();
    }
    this.salary = totalSalary;
    return totalSalary;
  }
}
