 'use strict';

	const pwd=document.getElementById('textPassword');
	const pwdCheck =document.getElementById('password-check');
	 pwdCheck.addEventListener('change', function() {
	     if(pwdCheck.checked) {
	         pwd.setAttribute('type', 'text');
	     } else {
	         pwd.setAttribute('type', 'password');
	     }
	 }, false);

     document.getElementById('touroku').onclick = function () {
        if(registar_form.password.value !== registar_form.password_confirm.value) {
          event.preventDefault();
        document.getElementById('error_message').textContent=`※パスワードが一致していません`;

            return false;

         } else if (registar_form.password.value == registar_form.password_confirm.value) {
            document.getElementById('error_message').textContent=``;

         }
          pwdCheck.addEventListener('change', function() {
		     if(pwdCheck.checked) {
		         pwd.setAttribute('type', 'text');
		     } else {
		         pwd.setAttribute('type', 'password');
		     }
		 }, false);
   };
    // [リセット]ボタンをクリックしたときの処理 */
     registar_form.onreset = function () {
       error_message.textContent = "";
     };

   //パスワード確認用フォーム
//function CheckPassword(password_confirm){

    //入力値取得

   // var input1 = password.value;
   // var input2 = password_confirm.value;

    //パスワード比較
   // if(input1 != input2){
       // password_confirm.setCustomValidity("存在しています")
   // }else{
        //password_confirm.setCustomValidity("")
   // }
   // }


/*document.form.registar.addEventListener('click', function() {
    var result = window.confirm('これで登録しても宜しいですか？');
    if( result == true ) {
 	window.location.href = "/app/RegistarServlet";

    }
    else {

        return false

    }
});
*/

 document.getElementById('registar_form').onsubmit = function (event) {
			let result = window.confirm('この内容で登録しますか？');
			if(result === true){
				window.location.href = 'LoginServlet';
				return true;
			}else {
				return false;
			}

		}


