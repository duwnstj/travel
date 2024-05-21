<%@ page contentType="text/html; charset=UTF-8"%>
<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.7.1/kakao.min.js"
  integrity="sha384-kDljxUXHaJ9xAb2AzRd59KxjrFjzHa5TAoFQ6GbYTCAG0bjM55XohjjDT7tDDC01" crossorigin="anonymous"></script>
<script>
  Kakao.init('01b686264cda6f2563e41cb2d408b00e'); // 사용하려는 앱의 JavaScript 키 입력
</script>

<a id="kakao-login-btn" href="javascript:loginWithKakao()">
  <img src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg" width="222"
    alt="카카오 로그인 버튼" />
</a>
<p id="token-result"></p>
<button class="api-btn" onclick="sendToFriends()" style="visibility:hidden">친구에게 메시지 보내기</button>

<script>
  function loginWithKakao() {
    Kakao.Auth.authorize({
      redirectUri: 'https://developers.kakao.com/tool/demo/oauth',
      state: 'sendfriend_feed',
      scope: 'friends,talk_message', // 앱 동의 항목 설정 및 사용자 동의 필요
    });
  }

  function sendToFriends() {
    if (!confirm('메시지를 전송하시겠습니까?')) { return; }

    Kakao.Picker.selectFriends({
      showMyProfile: false,
      maxPickableCount: 10,
      minPickableCount: 1,
    })
      .then(function(res) {
        var uuids = res.users.map(function(e) { return e.uuid; });

        return Kakao.API.request({
          url: '/v1/api/talk/friends/message/default/send',
          data: {
            receiver_uuids: uuids,
            template_object: {
              object_type: 'feed',
              content: {
                title: '베리베리 치즈 케익',
                description:
                  '#케익 #딸기 #블루베리 #카페 #디저트 #달달함 #분위기 #삼평동',
                image_url:
                  'http://k.kakaocdn.net/dn/bDgfik/btqwQWk4CRU/P6wNJJiQ3Ko21KNE1TiLw1/kakaolink40_original.png',
                link: {
                  // [내 애플리케이션] > [플랫폼] 에서 등록한 사이트 도메인과 일치해야 함
                  mobile_web_url: 'https://developers.kakao.com',
                  web_url: 'https://developers.kakao.com',
                },
              },
              social: {
                like_count: 286,
                comment_count: 45,
                shared_count: 845,
              },
              buttons: [
                {
                  title: '웹으로 보기',
                  link: {
                    mobile_web_url: 'https://developers.kakao.com',
                    web_url: 'https://developers.kakao.com',
                  },
                },
                {
                  title: '앱으로 보기',
                  link: {
                    mobile_web_url: 'https://developers.kakao.com',
                    web_url: 'https://developers.kakao.com',
                  },
                },
              ],
            },
          },
        });
      })
      .then(function(res) {
        alert('success: ' + JSON.stringify(res));
      })
      .catch(function(err) {
        alert('error: ' + JSON.stringify(err));
      });
  }

  // 아래는 데모를 위한 UI 코드입니다.
  displayToken()
  function displayToken() {
    var token = getCookie('authorize-access-token');

    if(token) {
      Kakao.Auth.setAccessToken(token);
      document.querySelector('#token-result').innerText = 'login success, ready to send a message';
      document.querySelector('button.api-btn').style.visibility = 'visible';
    }
  }

  function getCookie(name) {
    var parts = document.cookie.split(name + '=');
    if (parts.length === 2) { return parts[1].split(';')[0]; }
  }
</script>