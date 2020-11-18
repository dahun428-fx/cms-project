package kr.co.cms.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.co.cms.dao.EmployeeDao;
import kr.co.cms.vo.Employee;
import kr.co.cms.vo.UserRole;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	
	
	
	/**
	 * 스프링 Security 유저 정보 반환
	 * <p>
	 * UserDetails 인터페이스를 반환한 {@link kr.co.cms.vo.Employee} 객체가 반환된다.
	 * 
	 * <p>
	 * Employee 객체에는 사용자정보, 접근권한(List<GrantedAuthority>), 계정관련정보를 포함하고 있다.
	 * 
	 * <p>
	 * 로그인 입력화면에서 아이디, 비밀번호를 입력 후 로그인 요청을 서버에 보내면, Spring Security 가 해당 메소드를
	 * 실행하여 Employee 객체를 조회한다. 
	 * 
	 */
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		Employee employee = employeeDao.getEmployeeById(userId);
		if(employee == null) {
			throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다.");
		}
		Collection<GrantedAuthority> authorities = this.getAuthorities(userId);
		employee.setAuthorities(authorities);
		
		return employee;
	}
	/**
	 * 지정한 사용자 아이디로 조회한 사용자의 접근 권한 정보를 반환한다.
	 * 권한명으로 {@link SimpleGrantedAuthority} 객체를 생성해서 콜렉션에 담고 반환한다.
	 * @param userId 사용자 아이디
	 * @return 사용자가 보유하고 있는 권한 정보
	 */
	Collection<GrantedAuthority> getAuthorities(String userId){
		List<UserRole> roles = employeeDao.getRoleArrByEmployeeId(userId);
		if(roles.isEmpty()) {
			new UsernameNotFoundException("접근 권한 정보가 존재하지 않습니다.");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(UserRole role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		
		return authorities;
	}
	
}
