 'use strict';

function pushHideButton() {
    	var txtPass = document.getElementById("textPassword");
    	var btnPass = document.getElementById("buttonPassword");

    	if(txtPass.type === "password"){
    		txtPass.type = "text";
    		btnPass.value ="非表示";

    	} else{
    		txtPass.type = "password";
    		btnPass.value ="表示";

    	}
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

 /**
 *
 */