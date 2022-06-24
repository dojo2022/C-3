'use strict';
/*
var vue = new Vue ({
  el: '#app',
  data: {
    today:''
   },
  created: function(){
    this.today= new Date();
  }
 })

 created: function(){
    let todaySet = new Date();
    let YYYY = todaySet.getFullYear();
    let MM = ('00' + (todaySet.getMonth()+1)).slice(-2);
    let DD = ('00' + todaySet.getDate()).slice(-2);
    this.today = YYYY + '-' + MM + '-' + DD
  },*/

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

function Registar_JSP(){
  var val_from = document.getElementsByName("starting_date")[0].value;
  //var val_to = document.getElementsByName("ending_date")[0].value;

  if(val_from != ""){

    // 日付オブジェクトを生成
    var fromDate = new Date(val_from);
    var todayDate = new Date();
    var Date = todayDate.getDate();
    console.log(Date);
    console.log(fromDate);
    //var toDate = new Date(val_to);
    console.log(Date);
    // 開始日と終了日の差を計算
    var judge = (fromDate - DAte);

    if(judge < 0){
      alert("本日以降の日付を指定してください。");
      return false;
    }else{
      return true;
    }
  }else{
    return true;
  }
}