<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>POME | ヒント</title>

<link rel="icon" type="image/png" href="/app/img/favicon.ico"/>
<!-- ↑ファビコン設定　タブ左やブックマーク時に表示されるアイコン -->
<link rel="apple-touch-icon" type="image/png"
	href="app/img/pome_favicon.png">
<!-- ↑アップルタッチアイコン　スマホのホーム画面に追加したときに表示されるアイコン -->


<link rel="stylesheet" type="text/css" href="css/color.css">
<link rel="stylesheet" type="text/css" href="css/hint.css">
</head>
<body>
<header>

</header>

<!-- ここからメイン -->
<main>
<img src="/app/img/hint.png" width="50" height="50" >ヒントページ

<h2>機能説明</h2>

<div class="qanda">
<dl class="question">
<dt>POMEとは？</dt>
<dd>
<p>頑張りたいことや、やらなければいけない事を登録し、達成した時には褒めてもらえるアプリです。また、自分へのご褒美（Joys）を登録し、褒められると同時に貯まっていくポイントによってJoysと交換できる機能がついています。</p>
</dd>
</dl>
<dl class="question">
<dt>目標とは？</dt>
<dd>
<p>目標とは、頑張りたいことや、やらなければならない事です。終日・繰り返し・長期の期間の分かれた登録や、仕事・家事・趣味・勉強・その他にタグ分けしての登録が可能です。</p>
</dd>
</dl>
<dl class="question">
<dt>終日・繰り返し・長期とは？</dt>
<dd>
<p>
終日目標：一日のうちに一度達成したいときに使います。<br>
繰り返し目標：設定した期間内、毎日達成したいときに使います。<br>
長期目標：設定した期間内に一度だけ達成したいときに使います。<br>
</p>
</dd>
</dl>
<dl class="question">
<dt>終日・繰り返し・長期の具体的な使い分けは？</dt>
<dd>
<p>具体例：あなたが長期試験の勉強に取り組みたい場合。<br>
終日目標：参考書を買う<br>
繰り返し目標：30分勉強する<br>
長期目標：模擬試験を受ける<br></p>
</dd>
</dl>
<dl class="question">
<dt>「褒めてもらえる」とは？</dt>
<dd>
<p>目標の中でも今日やることを達成した際に、HOMEの表内にある、各項目の右のチェックボックスをクリックすると、褒めてもらえるページに遷移します。その際に難易度に合わせてポイントをもらうことができます。</p>
</dd>
</dl>
<dl class="question">
<dt>簡単（2pt）・難しい（5pt）とは？</dt>
<dd>
<p>自分の目標に対する難易度を決めることができます。それぞれ達成した時に、もらえるポイント数が異なります。</p>
</dd>
</dl>
<dl class="question">
<dt>Joys（ジョイス）とは？</dt>
<dd>
<p>Joys（ジョイス）とは、ユーザーが登録した、日々で行えるささやかな贅沢から奮発しないと買えない豪華な物などの自分へのご褒美のことです。</p>
</dd>
</dl>
<dl class="question">
<dt>ささやか（10pt）・豪華（50pt）とは？</dt>
<dd>
<p>日頃にできるささやかな贅沢と、奮発しないとできないことを分けて登録することができます。それぞれ、必要なポイント数が異なります。</p>
</dd>
</dl>
<dl class="question">
<dt>登録はどこからできますか？</dt>
<dd>
<p>HOMEや一覧表示されている表の右下にあるプラスマークをクリックし、登録したい情報を記入してから登録ボタンを押すことで登録できます。</p>
</dd>
</dl>

<dl class="question">
<dt>編集はどこからできますか？</dt>
<dd>
<p>一覧表示されている各項目の右にある鉛筆マークをクリックし、変更したい情報を変えてから更新ボタンを押すことで更新できます。</p>
</dd>
</dl>
<dl class="question">
<dt>削除はどこからできますか？</dt>
<dd>
<p>一覧表示されている各項目の右にある鉛筆マークをクリックし、削除ボタンを押すことで削除できます。</p>
</dd>
</dl>
</div>
<hr>
<a href = "HomeServlet">
戻る
</a >

</main>
<!-- フッター被り解決 -->
<div class = "empty"></div>


<script src="js/hint.js"></script>
</body>
</html>
