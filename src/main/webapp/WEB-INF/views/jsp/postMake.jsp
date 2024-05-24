<%@ page contentType="text/html; charset=UTF-8"%>
<link rel="stylesheet" href="../css/postMake.css">
<jsp:include page="../include/header.jsp" />


<h1 class="header-title">게시글 작성하기</h1>


<div class="container">
	<div class="input-container">
	<form action="/post_make_Ok" method="Post" onsubmit="write_check()">
	
		<input type="text" name="mate_title" id="mate_title" placeholder="제목을 입력하세요...">
		<br><span id="error_title"></span>
		<textarea name="mate_cont" id="mate_cont" placeholder="내용을 입력하세요..."></textarea>
		<br><span id="error_content"></span>
		<input type="file" id="post-image" accept="image/*">
		<!-- 이미지 업로드를 위한 input 추가 -->
		<input type="text" id="post-tags" placeholder="태그를 입력하세요... (쉼표로 구분)">
		<select id="limit-select">
			<!-- 제한된 인원을 선택할 수 있는 드롭다운 -->
			<option value="1">1명</option>
			<option value="2">2명</option>
			<option value="3">3명</option>
			<!-- 필요한 만큼 인원 제한을 추가할 수 있습니다. -->
		</select>
		
			<button type="submit" id="post-button">게시물 작성</button>
		</form>
	</div>
</div>

<script src="../script/postMake.js"></script>

