/**
 *
 */
 'use strict';
 function exec(){
 	document.getElementById("tab0").submit();
 }
 function onRadioButtoChange(){

	//ラジオボタンが押されているかどうか調べて変数に入れている
	check0 = document.tag_id0.tag.checked;
	check1 = document.tag_id0.tag.checked;
	check2 = document.tag_id0.tag.checked;
	check3 = document.tag_id0.tag.checked;
	check4 = document.tag_id0.tag.checked;
	check5 = document.tag_id0.tag.checked;

	if(check0 = true){
		document.getElementById("tag_id0").submit();
	} else if(check1 = true){
		document.getElementById("tag_id1").submit();
	}
}
