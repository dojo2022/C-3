'use strict';

var formObj = document.getElementById('profile_form');

/*編集するが選択されているときの処理*/
document.querySelector('input[value ="yes"]').onchange = function(){
formObj.update.disabled = false;
}


/*編集しないが選択されているときの処理*/
 document.querySelector('input[value ="no"]').onchange = function(){
formObj.update.disabled = true;
}

//ログアウトアラート
	document.getElementById('logout').onclick = function (event) {
		let re = window.confirm('ログアウトしますか？');
		if(re === true){
			window.location.href = 'LogoutServlet';
			return true;
		}else {
			return false;
		}
	};
