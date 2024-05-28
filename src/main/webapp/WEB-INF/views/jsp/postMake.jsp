<%@ page contentType="text/html; charset=UTF-8"%>

<link rel="stylesheet" href="../css/postMake.css">
<jsp:include page="../include/header.jsp" />

<h1 class="header-title">게시글 작성하기</h1>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>


<div class="container">
	<div class="input-container">
	<form method="Post" action="/post_make_Ok" onsubmit="return write_check();"
	enctype="multipart/form-data"> <%--text와 file등 혼합된 경우 서버에 원할하게 보내기 위한 기능 --%>
	
		<input type="text" name="mate_title" id="mate_title" placeholder="제목을 입력하세요...">
		
		<textarea name="mate_cont" id="mate_cont" placeholder="내용을 입력하세요..."></textarea>
		
		<!-- 파일 첨부 기능을 위한 input 기능 -->
		<input type="file" name="uploadFile2" id="uploadFile2" accept="image/*">
		
		
		<input type="text" name="mt_hashtag" id="mt_hashtag" placeholder="태그를 입력하세요... (쉼표로 구분)">
		
        <label for="limit-select">톡방 제한인원을 선택하세요 최대 4명</label>
        <select id="limit-select" name="limit-select">
            <option value="" disabled selected>선택하세요</option>
            <option value="1">1명</option>
            <option value="2">2명</option>
            <option value="3">3명</option>
            <option value="4">4명</option>
        </select>
    
		
			<button type="submit" id="post-button">게시물 작성</button>
			<input type="button" value="목록" onclick="location='main?page=${page}';">
		</form>
	</div>
</div>

<script src="../script/postMake.js"></script>

