package kr.co.cms.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import kr.co.cms.vo.Employee;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		//아이디 받기
		String userId = authentication.getName();
		String userPw = (String) authentication.getCredentials();
		
		//DB에서 접근한 employee
		Employee employee = (Employee) userDetailsService.loadUserByUsername(userId);
		
		System.out.println("test employee : " + employee);
		//bean에 등록된 passwordEncoder를 이용하여 화면에서 받아온 userPw 와 DB employee의 Pw(암호화된)와 다르면 예외 발생
//		if(!passwordEncoder.matches(userPw, employee.getPassword())) {
//			throw new BadCredentialsException("아이디나 비밀번호가 틀립니다.");
//		}
		if(!userPw.equals(employee.getPassword())) {
			throw new BadCredentialsException("아이디나 비밀번호가 틀립니다.");
		}
		//사용할 수 없는 아이디일 경우 예외 발생
		if(!employee.isEnabled()) {
			throw new BadCredentialsException("사용할 수 없는 아이디 입니다.");
		}
		
		//이상이 없으면 userId, userPw, 권한을 토큰에 담아 전송
		return new UsernamePasswordAuthenticationToken(userId, userPw, employee.getAuthorities());
	}
	//토큰 타입과 일치할 때 인증
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
	
}
