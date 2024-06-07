document.addEventListener("DOMContentLoaded", function() {
  const acceptedPeople = ["User1", "User2", "User3"];

  // 수락한 인원 동적 추가
  const acceptedList = document.getElementById("acceptedList");
  acceptedPeople.forEach(person => {
    const listItem = document.createElement("li");
    listItem.textContent = person;
    acceptedList.appendChild(listItem);
  });

  const popup = document.getElementById("popup");
  let isDragging = false;
  let startX, startY, popupStartX, popupStartY;

  function handleDragStart(event) {
    isDragging = true;
    const rect = popup.getBoundingClientRect();
    startX = event.clientX;
    startY = event.clientY;
    popupStartX = rect.left;
    popupStartY = rect.top;
    event.preventDefault(); // 기본 동작 막기
    event.stopPropagation();
  }
  function handleDragEnd(event) {
  isDragging = false;
  document.body.style.cursor = 'default';
}

  function handleMouseMove(event) {
    if (isDragging) {
      const offsetX = event.clientX - startX;
      const offsetY = event.clientY - startY;

      // 팝업의 새 위치 계산
      let newPopupX = popupStartX + offsetX;
      let newPopupY = popupStartY + offsetY;

      // 문서 경계를 넘어가지 않도록 보정
      const maxX = window.innerWidth - popup.offsetWidth;
      const maxY = window.innerHeight - popup.offsetHeight;
      newPopupX = Math.max(0, Math.min(newPopupX, maxX));
      newPopupY = Math.max(0, Math.min(newPopupY, maxY));

      popup.style.transition = 'none'; // 드래그 중에는 transition 제거
      popup.style.left = newPopupX + 'px';
      popup.style.top = newPopupY + 'px';

      // 드래그 중에는 커서 위치를 따라가도록 설정
      document.body.style.cursor = 'move';

      event.stopPropagation();
    }
  }

  // 팝업창이 화면을 벗어나지 않도록 설정
  function handleWindowResize() {
    const rect = popup.getBoundingClientRect();
    const maxX = window.innerWidth - rect.width;
    const maxY = window.innerHeight - rect.height;
    popup.style.left = Math.max(0, Math.min(rect.left, maxX)) + 'px';
    popup.style.top = Math.max(0, Math.min(rect.top, maxY)) + 'px';
  }

  window.addEventListener('resize', handleWindowResize);
});

document.addEventListener("DOMContentLoaded", function() {
    var toggleButtons = document.querySelectorAll('.toggle-button');
    toggleButtons.forEach(function(button) {
        button.addEventListener('click', function(event) {
            var options = this.parentElement.querySelector('.options');
            // 클릭된 토글 버튼 아래에 옵션 요소를 나타내거나 감춥니다.
            if (options.style.display === "block") {
                options.style.display = "none";
            } else {
                // 모든 옵션창 닫기
                closeAllOptions();
                options.style.display = "block";
            }
            event.stopPropagation(); // 옵션 버튼을 클릭했을 때 문서의 다른 부분에 클릭 이벤트가 전달되지 않도록 합니다.
        });
    });

    // 문서의 다른 부분을 클릭했을 때 옵션 팝업을 닫습니다.
    document.addEventListener('click', function(event) {
        var options = document.querySelectorAll('.options');
        options.forEach(function(option) {
            if (option.style.display === "block" && !option.contains(event.target)) {
                option.style.display = "none";
            }
        });
    });

    // 모든 옵션창을 닫습니다.
    function closeAllOptions() {
        var options = document.querySelectorAll('.options');
        options.forEach(function(option) {
            option.style.display = "none";
        });
    }
});

 function del_check(){
	return confirm("정말로 이 게시물을 삭제하겠습니까?");
   
 }


function search() {
    var searchInput = document.getElementById("searchInput").value.trim();

    var searchArray = searchInput.split(","); // 쉼표를 기준으로 검색어를 분리

    for (var i = 0; i < searchArray.length; i++) {
        var searchTerm = searchArray[i].trim();

        if (searchTerm.startsWith("#")) {
            // 해시태그인 경우 #을 제거
            searchTerm = searchTerm.substring(1).trim();
        }
    }

    // 검색어를 쉼표로 구분하여 다시 합침
    document.getElementById("searchInput").value = searchArray.join(",");

    // Ajax를 사용하여 서버에 검색 요청을 보냄
    $.ajax({
        url: "/community_board", // 검색을 처리하는 컨트롤러의 URL
        method: "GET", // GET 방식으로 변경
        data: { searchInput: searchArray.join(",") }, // 검색어를 서버에 전달
        success: function(data) {
            // 검색 결과를 표시할 영역에 서버로부터 받은 HTML을 추가
            // 예시로는 id가 'search-results'인 영역에 검색 결과를 표시하도록 가정
            $("#search-results").html(data);
        },
        error: function(xhr, status, error) {
            // 검색 요청 실패 시 에러 메시지 출력
            console.error("검색 요청 실패:", status, error);
        }
    });

    // 검색 결과를 받기 위해 페이지를 새로고침하지 않음
    return false;
}





