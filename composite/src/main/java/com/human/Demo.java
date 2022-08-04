package com.human;

import java.util.List;

/**
 * 将一组对象（员工和部门）组织成树形结 构，以表示一种‘部分 - 整体’的层次结构（部门与子部门的嵌套结构）。
 * 组合模式让客户端可以统一单个对象（员工）和组合对象（部门）的处理逻辑（递归遍历）
 *
 * @author ImOkkkk
 * @date 2022/8/4 13:35
 * @since 1.0
 */
public class Demo {
  private static final long ORGANIZATION_ROOT_ID = 1001;
  private DepartmentRepo departmentRepo; // 依赖注入
  private EmployeeRepo employeeRepo; // 依赖注入

  // 依赖注入
  public void buildOrganization() {
    Department rootDepartment = new Department(ORGANIZATION_ROOT_ID);
    buildOrganization(rootDepartment);
  }

  private void buildOrganization(Department department) {
    List<Long> subDepartmentIds = departmentRepo.getSubDepartmentIds(department.getId());
    for (Long subDepartmentId : subDepartmentIds) {
      Department subDepartment = new Department(subDepartmentId);
      department.addSubNode(subDepartment);
      buildOrganization(subDepartment);
    }
    List<Long> employeeIds = employeeRepo.getDepartmentEmployeeIds(department.getId());
    for (Long employeeId : employeeIds) {
      double salary = employeeRepo.getEmployeeSalary(employeeId);
      department.addSubNode(new Employee(employeeId, salary));
    }
  }
}
