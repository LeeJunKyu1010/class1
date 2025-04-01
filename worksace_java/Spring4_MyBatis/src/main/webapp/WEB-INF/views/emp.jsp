<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
th, td {
	border: 1px solid black;
}
</style>
</head>
<body>

	<form method="get" action="emp">
		<input type="text" name="empno" />
		<button type="submit" name="action" value="click">클릭</button>
		<a href="insertEmp"><button type="button">등록</button></a>
	</form>
	<table>
		<thead>
			<tr>
				<th>No.</th>
				<th>empno</th>
				<th>ename</th>
				<th>job</th>
				<th>mgr</th>
				<th>hiredate</th>
				<th>sal</th>
				<th>comm</th>
				<th>deptno</th>
		</thead>
		<tbody>
			<!-- 반복문 돌려서 배열로 된거 출력 -->
			<c:forEach var="dto" items="${select}" varStatus="loop">
				<tr>
					<td>${loop.count}</td>
					<td>${dto.empno}</td>
					<td><a href="detailEmp?empno=${dto.empno}">${dto.ename}</a></td>
					<td>${dto.job}</td>
					<td>${dto.mgr}</td>
					<td>${dto.hiredate}</td>
					<td>${dto.sal}</td>
					<td>${dto.comm}</td>
					<td>${dto.deptno}</td>
				</tr>
			</c:forEach>

		</tbody>

	</table>

	<button type="button" id="btn">진동</button>

	<div id="view"></div>

	<style>
#popup {
	border: 1px solid black;
	width: 300px;
	height: 500px;
	position: absolute;
	top: 30px;
	left: 20px;
	box-shadow: 0 5px 10px rgba(0, 0, 0, 0.4);
}

#popup .title {
	background: blue;
	color: white;
}

#popup .title:hover{
	cursor:grab;
}

#popup .title:active{
	cursor:grabbing;
}

#popup .content {
	background: white;
}

#dim {
	position: absolute;
	top: 0px;
	left: 0px;
	width: 100vw;
	height: 100vh;
	background-color: rgba(172, 172, 172, 0.7);
	/* backdrop-filter: blur(2px); */
}
</style>

	<div id="dim">

		<div id='popup'>
			<div class='title'>제목</div>
			<div class='content'>
				내용<br> 내용
			</div>
		</div>
	</div>

	<script>
		document.querySelector('#btn').addEventListener('click',()=>{
		//navigator.vibrate(5000) //ms
		if(navigator.vibrate){
		navigator.vibrate([1000]) //ms, 진동, 쉬기, 진동...			
		}else {
			alert('navigator.vibrate 없음')
		}
	})
	 if(screen.orientation){
            screen.orientation.addEventListener('change',()=>{
            	document.querySelector('#view').innerHTML = `
				type: \${screen.orientation.type}<br>
				angle:\${screen.orientation.angle}
				orientation: \${window.orientation}
			`
		})
	}else{
		alert('방향 지원 안함')
	}
		
		/*
			title에서 왼쪽 버튼을 누르면
			- 왼쪽 버튼이 눌렸다는걸 저장
			title에서 왼쪽 버튼을 떼면
			- 왼쪽 버튼이 떨어졌다는걸 저장
			
			마우스 최초 눌렀을때
			- 그때 마우스 위치값 저장
		*/
		
		let isDragable = false;
		
		let offsetX = 0;
		let offsetY = 0;
		
		
		document.querySelector('.title').addEventListener('mousedown',(event)=>{
			isDragable = true;
			
			document.querySelector('#view').innerHTML = `
				x : \${event.clientX}<br>
				y : \${event.clientY}<br>
			`
			
			offsetX = event.clientX
			offsetY = event.clientY
		})
		
		document.querySelector('.title').addEventListener('mouseup',()=>{
			isDragable = false;
		})
		
		document.querySelector('.title').addEventListener('mousemove',(event)=>{
			if(isDragable){
				let diff_X = event.clientX - offsetX
				let diff_Y = event.clientY - offsetY
				
				let popup = document.querySelector('#popup')
				
/* 				console.log(popup.style.top) */
				console.log(popup.offsetTop)
				
				popup.style.top = (popup.offsetTop + diff_Y) + 'px'
				popup.style.left = (popup.offsetLeft + diff_X) + 'px'
				
				offsetX = event.clientX
				offsetY = event.clientY
			}
		})
</script>
</body>
</html>