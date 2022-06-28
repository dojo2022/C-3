/**
 *
 */
"use strict";

//プレゼントボタン（交換ボタン）を押されたとき
function change(form) {
	form.submit();
}


/*//プレゼントボタン（交換ボタン）を押されたとき
    function joysExchange(form){
		form.submit();
	}*/
/*
     btn.onclick = function(){
    	modal.style.display = 'block';
    }

    // バツ印がクリックされた時
buttonClose.addEventListener('click', modalClose);
function modalClose() {
  modal.style.display = 'none';
}

// モーダルコンテンツ以外がクリックされた時
addEventListener('click', outsideClose);
function outsideClose(e) {
  if (e.target == modal) {
    modal.style.display = 'none';
  }
 }
*/

//ログアウトアラート
document.getElementById('logout').onclick = function(event) {
	let re = window.confirm('ログアウトしますか？');
	if (re === true) {
		window.location.href = 'LogoutServlet';
		return true;
	} else {
		return false;
	}
};
