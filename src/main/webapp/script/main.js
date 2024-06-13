
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


function search(searchInput, searchType) {
    var searchArray = searchInput.split(",");

    for (var i = 0; i < searchArray.length; i++) {
        var searchTerm = searchArray[i].trim();

        if (searchTerm.startsWith("#")) {
            // #로 시작하는 경우, 해시태그이므로 # 제거
            searchTerm = searchTerm.substring(1).trim();
          
        }

        searchArray[i] = searchTerm;
    }

    // Join search terms back with commas
    document.getElementById("searchInput").value = searchArray.join(",");

    $.ajax({
        url: "/community_board", // Controller URL
        method: "GET", // GET method
        data: { 
            searchInput: searchArray.join(","),
            searchType: searchType // Include searchType
        },
        success: function(data) {
            // Update search results
            var searchResultsHtml = $(data).find("#search-results").html();
            $("#search-results").html(searchResultsHtml);

            // Update pagination
            var paginationHtml = $(data).find(".pagination").html();
            $(".pagination").html(paginationHtml);
        },
        error: function(xhr, status, error) {
            console.error("Search request failed:", status, error);
        }
    });

    return false; // Prevent form submission
}


    // 해시태그 클릭 이벤트 처리
    $('.hashtag-item').on('click', function(){
        var hashtagText = $(this).text(); // 클릭된 해시태그의 텍스트 가져오기
        var searchInput = hashtagText; // 검색어로 사용
        var searchType = ""; // 검색 타입은 전체로 설정

        search(searchInput, searchType); // 검색 함수 호출
    });
    

