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


/**
 *
 */