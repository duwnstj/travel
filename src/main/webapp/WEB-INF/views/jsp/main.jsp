<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../include/header.jsp" />

<link rel="stylesheet" href="../css/main.css">

<h2 class="user-font">함께 여행을 떠나는 친구를 찾는 공간</h2>

<div class="post-container">
	<div class="search-container">
		<form method="get" action="community_board" onsubmit="return search();" >
		<input type="text" placeholder="제목,내용,#해시태그로 검색해보세요..."
			name="searchInput" id="searchInput" >
		<!-- 사용자 폰트 및 텍스트 색상 적용 -->
		<button type="submit" name="mt_hashtag" id="mt_hashtag" class="user-background-color">검색</button>
	
		
		
		
		<!-- 사용자 배경색 적용 -->
		</form>
	</div>
</div>

<div class="sidebar">
	<ul>
		<li><a onclick="location='postMake';">게시물 만들기</a></li>
		<!-- 게시물 만들기 버튼에 텍스트 색상 적용 -->
		<li><a onclick="location='Talk';">톡(TALK)</a></li>
		<!-- 톡(TALK) 버튼에 텍스트 색상 적용 -->
		<!-- 필요한 만큼 카테고리를 추가할 수 있습니다. -->
	</ul>
</div>


<!-- 인스타그램 스타일의 게시물 폼 추가 -->
	<c:forEach var="p" items="${posts}">
	<div class="instagram-post">
	
<div class="post-content">
		
		<img src="../images/profile.jpg" alt="프로필 사진">
		<p class="user-id">아이디:</p>
		
<!-- 수정 및 삭제 토글 버튼 -->
			<button type="button" class="toggle-button">옵션</button> <%--type="button"을 
			안써주면 button태그자체가 디폴트값이 제출(submit)이라서 바로 제출이된다.  --%>
			
			<div class="options">
				
				<form method="post" action="post_edit">
				<input type="hidden" name="mateno" value="${p.mateno}">
					<button type="submit" >게시물 수정하기</button>
					</form>
					<form method="post" action="post_del_ok" onsubmit="return del_check();">
					<input type="hidden" name="mateno" value="${p.mateno}">
					<button type="submit">게시물 삭제하기</button>
					</form>
			</div>
			
			
			<p class="user-title">제목:${p.mate_title}</p>
			<p class="user-cont">내용:${p.mate_cont}</p>
			<div class="image-grid">
				<c:forEach var="img" items="${p.images}">
					 <img
						src="${pageContext.request.contextPath}/upload${img.uploadFile}"
						alt="Upload image" />

				</c:forEach>
			</div>
			<div class="interactions">
				<button class="like-button" name="like" id="like"
					onclick="post_like">좋아요</button>
				<button class="comment-button">댓글</button>	
			</div>
			<p class="hashtag">해시태그:${p.mt_hashtag}"</p>
			<p class="user-updatedate">업데이트날짜:${p.updatedate}</p>
		</div>
		
	
</div>
</c:forEach>

<div class="pagination">
    <c:if test="${currentPage > 1}">
        <a href="community_board?page=${currentPage - 1}&searchInput=${param.searchInput}">&laquo; 이전</a>
    </c:if>
    <c:forEach var="i" begin="1" end="${totalPages}">
        <a href="community_board?page=${i}&searchInput=${param.searchInput}" class="${currentPage == i ? 'active': ''}">${i}</a>
    </c:forEach>
    <c:if test="${currentPage < totalPages}">
        <a href="community_board?page=${currentPage + 1}&searchInput=${param.searchInput}">다음 &raquo;</a>
    </c:if>
</div>

<jsp:include page="../include/footer.jsp" />
<!-- 외부 footer를 포함시킵니다. -->
<script src="../script/main.js"></script>
<!-- 외부 JavaScript 파일 로드 -->
