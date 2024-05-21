<%@ page contentType="text/html; charset=UTF-8"%>
<jsp:include page="../include/header.jsp" />
<link rel="stylesheet" type="text/css" href="../css/schedule.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.0/css/all.min.css"
	integrity="sha512-10/jx2EXwxxWqCLX/hHth/vu2KY3jCF70dCQB8TSgNjbCVAC/8vai53GfMDrO2Emgwccf2pJqxct9ehpzG+MTw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

		<%-- 버튼 박스 --%>
		<div class="button_box">
			<a href="add_schedule.jsp" class="btn_1">New Schedule</a>
			<a href="my_trip.jsp" class="btn_2">My Trip</a>
			<a href="WishList.jsp" class="btn_3">Wish List</a>
			<a href="share_c.jsp" class="btn_4">Share square</a>
		</div>
		<div class="container2">
			<%-- 검색창 --%>
			<div class="search_container">
				<input class="search_input" type="text" placeholder="어디로 여행을 떠나시나요?" />
				<button class="search_button" type="button">
					<i class="fa-solid fa-plane fa-2x"></i>
				</button>
			</div>
			<button class="btn_plan" onclick="location.href='plan.jsp'">
				<i class="fa-solid fa-plane-departure fa-2x fa-pull-right"></i> <span
					class="plan_span">NEW</span>
			</button>

			<ul class="list">
				<li><button class="btn_1" onclick="location.href='plan.jsp'">일본</button></li>
				<li><button class="btn_2" onclick="location.href='plan.jsp'">중국</button></li>
				<li><button class="btn_3" onclick="location.href='plan.jsp'">러시아</button></li>
				<li><button class="btn_4" onclick="location.href='plan.jsp'">미국</button></li>
				<li><button class="btn_5" onclick="location.href='plan.jsp'">캐나다</button></li>
				<li><button class="btn_6" onclick="location.href='plan.jsp'">베트남</button></li>
				<li><button class="btn_7" onclick="location.href='plan.jsp'">싱가포르</button></li>
				<li><button class="btn_8" onclick="location.href='plan.jsp'">말레이시아</button></li>
				<li><button class="btn_9" onclick="location.href='plan.jsp'">필리핀</button></li>
				<li><button class="btn_10" onclick="location.href='plan.jsp'">대만</button></li>
				<li><button class="btn_11" onclick="location.href='plan.jsp'">태국</button></li>
				<li><button class="btn_12" onclick="location.href='plan.jsp'">브라질</button></li>
				<li><button class="btn_13" onclick="location.href='plan.jsp'">영국</button></li>
				<li><button class="btn_14" onclick="location.href='plan.jsp'">스페인</button></li>
				<li><button class="btn_15" onclick="location.href='plan.jsp'">독일</button></li>
				<li><button class="btn_16" onclick="location.href='plan.jsp'">포루투갈</button></li>
				<li><button class="btn_17" onclick="location.href='plan.jsp'">스웨덴</button></li>
				<li><button class="btn_18" onclick="location.href='plan.jsp'">덴마크</button></li>
				<li><button class="btn_19" onclick="location.href='plan.jsp'">스위스</button></li>
				<li><button class="btn_20" onclick="location.href='plan.jsp'">이탈리아</button></li>

			</ul>
		</div>

<jsp:include page="../include/footer.jsp" />

<%-- 외부 javascript 파일 연결 --%>
<script src="https://kit.fontawesome.com/9d75e77952.js"
	crossorigin="anonymous"></script>
<script src="../script/schedule.js"></script>