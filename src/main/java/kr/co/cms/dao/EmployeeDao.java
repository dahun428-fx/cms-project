package kr.co.cms.dao;

import java.util.List;

import kr.co.cms.vo.Employee;
import kr.co.cms.vo.UserRole;

public interface EmployeeDao {

	List<UserRole> getRoleArrByEmployeeId(String employeeId);
	Employee getEmployeeById(String id);
}
