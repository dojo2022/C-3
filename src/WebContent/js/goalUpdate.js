/**
 *
 */
document.getElementById('delete').onclick = function(){

	let re = window.confirm('この内容で削除しますか？');
			if(re === true){
				window.location.href = 'GoalUpdateServlet';
				return true;
			} else {
				return false;
			}

}