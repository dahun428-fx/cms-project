<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="content-area ui container" align="center">
	<div class="contents column">
		<div class="column">
			<!-- login form -->

			<form class="ui form" id="signinForm" method="post" action="signin.do">
				<div class="field">
					<label>아이디</label>
					<input type="text" placeholder="아이디를 입력하세요." name="emp_id" >
				</div>
				<div class="field">
					<label>비밀번호</label>
					<input type="password" placeholder="비밀번호를 입력하세요." name="emp_pwd">
				</div>
				<div class="field" id="find-area">
					<a href="#">아이디 | 비밀번호 찾기</a>
				</div>
				<div class="field">
					<button class="fluid ui blue button" type="button">로그인</button>
					<br>
					<button class="fluid ui grey button" type="button" >회원가입</button>
				</div>
			</form>

			<!-- login form -->
		</div>
	</div>
</div>