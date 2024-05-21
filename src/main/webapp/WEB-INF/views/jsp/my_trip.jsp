<%@ page contentType="text/html; charset=UTF-8"%>
<jsp:include page="../include/header.jsp" />
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>My Trip</title>
<link rel="stylesheet" type="text/css" href="../css/my_trip.css">
<link rel="stylesheet" type="text/css" href="../css/posts.css">
<link rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.0/css/all.min.css"
    integrity="sha512-10/jx2EXwxxWqCLX/hHth/vu2KY3jCF70dCQB8TSgNjbCVAC/8vai53GfMDrO2Emgwccf2pJqxct9ehpzG+MTw=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
    <%-- 이거 수정 부탁드립니다. --%>
	<%-- 버튼 박스 --%>
	<div class="button_box">
		<a href="add_schedule.jsp" class="btn_1">New Schedule</a>
		<a href="my_trip.jsp" class="btn_2">My Trip</a>
		<a href="wish_list.jsp" class="btn_3">Wish List</a>
		<a href="share_square.jsp" class="btn_4">Share square</a>
	</div>
	<button class="btn_shcedule" type="button"
		onclick="location.href='add_schedule.jsp'">
		<i class="fa-solid fa-calendar-plus fa-2x"></i>
	</button>
	<p id="my_trip_p">My Trip</p>
	<%-- 게시글 영역 --%>
	<div class="posts">
		<div class="post" id="post1">
			<img src="../images/thumbnail1.jpg" alt="게시글 썸네일" class="thumbnail"
				onclick="goToPost(1)">
		</div>

		<div class="post" id="post2">
			<img src="../images/thumbnail2.jpg" alt="게시글 썸네일" class="thumbnail"
				onclick="goToPost(2)">
		</div>

		<div class="post" id="post3">
			<img src="../images/thumbnail3.jpg" alt="게시글 썸네일" class="thumbnail"
				onclick="goToPost(3)">
		</div>

		<div class="post" id="post4">
			<img src="../images/thumbnail4.jpg" alt="게시글 썸네일" class="thumbnail"
				onclick="goToPost(4)">
		</div>
		<div class="post" id="post5">
			<img src="../images/thumbnail5.jpg" alt="게시글 썸네일" class="thumbnail"
				onclick="goToPost(5)">
		</div>

		<div class="post" id="post6">
			<img src="../images/thumbnail6.jpg" alt="게시글 썸네일" class="thumbnail"
				onclick="goToPost(6)">
		</div>

		<div class="post" id="post7">
			<img src="../images/thumbnail7.jpg" alt="게시글 썸네일" class="thumbnail"
				onclick="goToPost(7)">
		</div>

		<div class="post" id="post8">
			<img src="../images/thumbnail8.jpg" alt="게시글 썸네일" class="thumbnail"
				onclick="goToPost(8)">
		</div>

	</div>

	<%-- 외부 javascript 파일 연결 --%>
	<script src="../script/posts.js"></script>
	<script src="https://kit.fontawesome.com/9d75e77952.js"
		crossorigin="anonymous"></script>

<jsp:include page="../include/footer.jsp"/>