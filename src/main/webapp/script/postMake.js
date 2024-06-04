document.addEventListener('DOMContentLoaded', function() {
    
    // 엔터 키로 줄바꿈 적용
    document.getElementById('mate_title').addEventListener('keydown', updatePreviewOnEnter);
    document.getElementById('mate_cont').addEventListener('keydown', updatePreviewOnEnter);
    document.getElementById('mt_hashtag').addEventListener('keydown', updatePreviewOnEnter);
    document.getElementById('uploadFile2').addEventListener('keydown', updatePreviewOnEnter);
    });
    
    function updatePreviewOnEnter(event){
    if(event.keyCode ===13){
		updatePreview();
	}
    }

     function write_check(){//function키워드로 write_check()라는 함수를 정의
	if($.trim($('#mate_title').val()) ==''){
		alert("제목을 입력하세요!");
        $('#mate_title').val('').focus();
        return false;		
	}
	if($.trim($('#mate_cont').val()) == ''){
		alert("글 내용을 입력하세요!");
       $('#mate_cont').val('').focus();
       return false;		
	}
	
   }
   
