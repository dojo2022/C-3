/**
 *
 */
 //削除アラート
 function chkDelete(ele){
			let re = window.confirm('この内容で削除しますか？');
			if(re === true){
				//window.location.href = 'GoalUpdateServlet';
				return true;
			} else {
				return false;
			}
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