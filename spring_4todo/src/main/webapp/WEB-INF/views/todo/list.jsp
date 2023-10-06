<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>todo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<nav class="navbar navbar-expand-lg bg-body-tertiary">
				<div class="container-fluid">
					<a class="navbar-brand" href="#">Navbar</a>
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav me-auto mb-2 mb-lg-0">
							<li class="nav-item"><a class="nav-link active"
								aria-current="page" href="#">Home</a></li>
							<li class="nav-item"><a class="nav-link" href="register">Write</a></li>
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" href="#" role="button"
								data-bs-toggle="dropdown" aria-expanded="false"> Dropdown </a>
								<ul class="dropdown-menu">
									<li><a class="dropdown-item" href="#">Action</a></li>
									<li><a class="dropdown-item" href="#">Another action</a></li>
									<li><hr class="dropdown-divider"></li>
									<li><a class="dropdown-item" href="#">Something else
											here</a></li>
								</ul></li>
							<li class="nav-item"><a class="nav-link disabled"
								aria-disabled="true">Disabled</a></li>
						</ul>
						<!-- <form class="d-flex" role="search">
							<input class="form-control me-2" type="search"
								placeholder="Search" aria-label="Search">
							<button class="btn btn-outline-success" type="submit">Search</button>
						</form> -->
					</div>
				</div>
			</nav>
		</div>
		<div class ="row content">
		<div class="col">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">Search</h5>
					<form action="/todo/list">
						<div class="mb-3">
						<input type="checkbox" name="finished">완료여부
						</div>
						<div class="mb-3">
							<input type="checkbox" name="types" value="t">제목
							<input type="checkbox" name="types" value="w">작성자
							<input type="checkbox" name="types" value="c">내용
							<input name="keyword" class="form-control">
						</div>
						<div class="input-group mb-3 dueDateDiv">
							<input type="date" name="from" class="form-control">
							<input type="date" name="to" class="form-control">
						</div>
						<div class="input-group mb-3">
							<div class="front-end">
								<button class="btn btn-primary" type="submit">검색</button>
								<button class="btn btn-info" type="reset">초기화</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
		<div class="row content">
			<!-- 	<h1>Hello, Spring~^^</h1>
			<h3>content</h3> -->
			<div class="col">
				<div class="card">
					<div class="card-header">Featured</div>
					<div class="card-body">
						<h5 class="card-title">일정 관리</h5>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">번호</th>
									<th scope="col">제목</th>
									<th scope="col">작성자</th>
									<th scope="col">기한 날짜</th>
									<th scope="col">완료 여부</th>
								</tr>
							</thead>
							<tbody>
								<%-- <c:forEach items="${todoList }" var="dto"> --%>
								<c:forEach items="${responseDto.dtoList }" var="dto">
									<tr>
										<th scope="row"><c:out value="${dto.tno }" /></th>
										<td>
<%-- 										<a href="read?tno=${dto.tno }" --%>
										<a href="read?tno=${dto.tno }&${pageRequestDTO.link}" data-tno="${dto.tno }"
											class="text-decoration-none" > <c:out
													value="${dto.title }" />
										</a></td>
										<td><c:out value="${dto.writer }" /></td>
										<td><c:out value="${dto.dueDate }" /></td>
										<td><c:out value="${dto.finished }" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

						<nav aria-label="Page navigation example">
							<ul class="pagination">
								<c:if test='${responseDto.prev }'>
									<li class="page-item"><a class="page-link" href="#" data-num="${responseDto.start-1}"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
								</c:if>
								<c:forEach begin="${responseDto.start }" end="${responseDto.end }" var="num">
									<li class="page-item ${responseDto.page == num? 'active':''}">
									<a class="page-link" href="#" data-num="${num}">${num }</a></li>
								</c:forEach>
								<c:if test='${responseDto.next }'>
									<li class="page-item"><a class="page-link" href="#" data-num="${responseDto.end+1}"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
									</a></li>
								</c:if>
							</ul>
						</nav>
						<hr>
						<nav aria-label="Page navigation example">
							<ul class="pagination pagebtn">
								<li class="page-item"><button class="page-link" data-num="${responseDto.page-1}" 
										${responseDto.page ==1? 'disabled':'' }
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</button></li>
								<li class="page-item"><button class="page-link" data-num="${responseDto.page+1}"
										${responseDto.page == responseDto.last? 'disabled':'' }
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</button></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
		<div class="row footer">
			<!-- <h3>footer</h3> -->

			<div class="row fixed-bottom">
				<footer class="py-1 my-1">
					<!--  style="z-index:-100" -->
					<p class="text-center text-muted">FOOTER</p>
				</footer>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		document.querySelector(".pagination").addEventListener("click",function(e){
			e.preventDefault()
			e.stopPropagation()
			
			const target = e.target
			
			if(target.tagName !== 'A') {return}
			
			const num = target.getAttribute("data-num")
			self.location = `?page=\${num}`
			
		})
	
		document.querySelector(".pagebtn").addEventListener("click",function(e){
			e.preventDefault()
			e.stopPropagation()
			
			const target = e.target
			
			if(target.tagName !== 'BUTTON') {return}
			const num = target.getAttribute("data-num")
			self.location = `?page=\${num}`
		})
		
	</script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>