/**
 *
 */

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
