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

//カレンダー終了日が開始日より早い日付を選択された時のアラート
function homeRegistar_JSP(){
  var val_from = document.getElementsByName("starting_date")[0].value;
  var val_to = document.getElementsByName("ending_date")[0].value;

  if(val_from != "" && val_to != ""){

    // 日付オブジェクトを生成
    var fromDate = new Date(val_from);
    var toDate = new Date(val_to);
    // 開始日と終了日の差を計算
    var judge = (toDate - fromDate);

    if(judge < 0){
      alert("終了日には開始日以降の日付を指定してください。");
      return false;
    }else{
      return true;
    }
  }else{
    return true;
  }
 }
