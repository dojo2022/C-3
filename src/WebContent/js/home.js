/**
 *
 */

//タグごと表示のラジオボタン
	let btn0 = document.getElementById('btn0');
    btn0.onclick = function(){
        f0.submit();
    }

    let btn1 = document.getElementById('btn1');
    btn1.onclick = function(){
        f1.submit();
    }

    let btn2 = document.getElementById('btn2');
    btn2.onclick = function(){
        f2.submit();
    }

    let btn3 = document.getElementById('btn3');
    btn3.onclick = function(){
        f3.submit();
	}

	let btn4 = document.getElementById('btn4');
    btn4.onclick = function(){
        f4.submit();
	}

	let btn5 = document.getElementById('btn5');
    btn5.onclick = function(){
        f5.submit();
    }




	//今日やることを達成したときの処理
    function formSubmit(form){
		form.submit();
	}


  /*  // バツ印がクリックされた時
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

	document.getElementById('logout').onclick = function (event) {
		let re = window.confirm('ログアウトしますか？');
		if(re === true){
			window.location.href = 'LogoutServlet';
			return true;
		}else {
			return false;
		}
	};


// goal.jsから追加
 	function labelClick(ele){
 		ele.parentNode.submit();
 	}

