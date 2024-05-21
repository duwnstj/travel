<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
<link rel="stylesheet" type="text/css" href="../css/plan.css">
<link rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.0/css/all.min.css"
    integrity="sha512-10/jx2EXwxxWqCLX/hHth/vu2KY3jCF70dCQB8TSgNjbCVAC/8vai53GfMDrO2Emgwccf2pJqxct9ehpzG+MTw=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<div class="wrapper">
    <div class="container">
        <ul class="tab_menu">
            <div class="tab_items">
                <li class="tab_item">
                    <a class="first_btn" data-toggle="tab" href="#link" role="tablist">STEP 1<br>국가 확인</a>
                </li>
                <li class="tab_item">
                    <a class="second_btn" data-toggle="tab" href="#link2" role="tablist">STEP 2<br>날짜 확인</a>
                </li>
                <li class="tab_item">
                    <a class="third_btn" data-toggle="tab" href="#link3" role="tablist">STEP 3<br>장소 선택</a>
                </li>
            </div>
            <div class="pb_8">
                <li class="tab_item2">
                    <button class="next_btn">다음</button>
                </li>
            </div>
        </ul>
        <div class="content">
            <!-- 내용 -->
        </div>
    </div>
    <div id="map"></div>
</div>

	<%-- 외부 javascript 파일 연결 --%>
	<script src="https://kit.fontawesome.com/9d75e77952.js"
		crossorigin="anonymous"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDVcRV8bAVHd5nWXqNmKZ9A68LBW-nWtLM&callback=initMap"
		async defer></script>
	<script src="../script/plan.js"></script>
</body>
</html>