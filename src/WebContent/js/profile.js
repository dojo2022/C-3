'use strict';

var formObj = document.getElementById('profile_form');

/*編集するが選択されているときの処理*/
document.puerySelecter('input[value ="yes"]').onchang = function(){
formObj.update.disabled = false;
}


/*編集しないが選択されているときの処理*/
 document.puerySelecter('input[value ="no"]').onchang = function(){
formObj.update.disabled = true;
}