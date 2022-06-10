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
 /**
 *
 */