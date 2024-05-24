document.addEventListener('DOMContentLoaded', function() {
    // 게시물 작성 버튼에 클릭 이벤트 추가
    document.getElementById('post-button').addEventListener('click', updatePreview);
    
    // 엔터 키로 줄바꿈 적용
    document.getElementById('mate_title').addEventListener('input', updatePreview);
    document.getElementById('mate_cont').addEventListener('input', updatePreview);
    document.getElementById('post-tags').addEventListener('input', updatePreview);
    document.getElementById('post-image').addEventListener('input', updatePreview);
    });
    
     function write_check(){//function키워드로 write_check()라는 함수를 정의
	if($.trim($('#mate_title').val()) ==''){
$('#error_title').html("<font size='2' color='red'>글제목을 입력하세요.</font>");
        $('#title').val('').focus();
        return false;		
	}
	
	if($.trim($('#mate_title').val()) != ''){
		$('#error_title').text('');
	}
	
	if($.trim($('#mate_cont').val()) == ''){
$('#error_content').html("<font size='2' color='red'>글내용을 입력하세요.</font>");
       $('#content').val('').focus();
       return false;		
	}
	
	if($.trim($('#mate_cont').val()) != ''){
       $('#error_content').text('');		
	}
 }

   