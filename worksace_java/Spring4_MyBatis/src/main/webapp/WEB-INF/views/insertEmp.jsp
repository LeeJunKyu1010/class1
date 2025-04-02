<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="insertEmp">
		<table border="1">
			<tr>
				<th>empno</th>
				<td><input type="text" name="empno"></td>
			</tr>
			<tr>
				<th>ename</th>
				<td><input type="text" name="ename"></td>
			</tr>
			<tr>
				<th>job</th>
				<td><input type="text" name="job"></td>
			</tr>
			<tr>

				<th>mgr</th>
				<td><input type="text" name="mgr"></td>
			</tr>
			<tr>

				<th>hiredate</th>
				<td><input type="date" name="hiredate"></td>
			</tr>
			<tr>

				<th>sal</th>
				<td><input type="text" name="sal"></td>
			</tr>
			<tr>

				<th>comm</th>
				<td><input type="text" name="comm"></td>
			</tr>
			<tr>
				<th>deptno</th>
				<td><input type="text" name="deptno"></td>
			</tr>

		</table>

		<button type="submit" name="action" value="click">등록</button>
		<a href="emp"><button type="button">등록취소</button></a>

	</form>
	<!-- <script>
	// fetch 사용법
		fetch('joinEmp',{ // 어디 주소로 갈지
			method : 'POST', // 어디 method로 갈지
			headers : {
				'Content-Type' : 'application/json' // json을 사용할때
			},
			body : JSON.stringify( param ) // json을 param에 적음
		}).then(function(resp){
			return resp.json()
		}).then((data)=>{
			console.log(data)
		}).catch ((err)=>{
			console.error('ERROR joinEmp fetch',err)
		})
	
	
	lat a = 10
	setTimeout (function(){
		a = 20
	}, 1000 )
	console.log(a) // 10
	// 20이 출력되게 하려면?
	
			// Proimse는 resolve() 또는 rejcet()가 실행될때 까지 기다려준다
	let p = new Promise( function(resolve, reject) {
		setTimeout (function(){
			if(a == 10){
				a = 20				
				resolve(a)
			}else{
				reject('ERRRRRRR')
			}
		}, 1000 )
	})
	p.then(function(data){
		console.log(data)
	})
	p.catch (function(data){
		console.log(data)
	})
	
	function async_await({
		setTimeout (function(){
			a = 20
		}, 1000 )
	})
	
	</script> -->
</body>
</html>