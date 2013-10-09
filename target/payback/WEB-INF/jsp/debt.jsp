<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<head>
    <meta http-equiv='Content-type' content='text/html; charset=utf-8'>
    <meta http-equiv="cache-control" content="no-cache, must-revalidate">
    <meta http-equiv="pragma" content="no-cache">
    <title>떼인돈 받아드립니다.</title>

    <link href="https://github.global.ssl.fastly.net/assets/github-4288f026700410ae032b5d324dea2b4571789d7c.css"
          media="all" rel="stylesheet" type="text/css">
    <link href="https://github.global.ssl.fastly.net/assets/github2-88d5087029dbe346f413843c4cb0149921840ef5.css"
          media="all" rel="stylesheet" type="text/css">

<body class="logged_in  env-production macintosh vis-public" style="">
<div class="wrapper">

<div class="pagehead repohead instapaper_ignore readability-menu">
    <div class="container">

        <h1>
            <span class="mega-octicon octicon-repo"></span>
          <span class="author">
            <a href="/${userId}/payback" class="url fn" itemprop="url" rel="author"><span
                    itemprop="title">${userId}</span></a></span>
            <span class="repohead-name-divider">/</span><strong><a href="/${userId}/payback" class="js-current-repository js-repo-home-link">payback</a></strong>
        </h1>
    </div>
    <!-- /.container -->
</div>

<div class="container">
<div class="repository-with-sidebar repo-container">
<div id="js-repo-pjax-container" class="repository-content context-loader-container" data-pjax-container="">
<div id="issues_next">
<div class="tabnav">
    <div class="tabnav-right">
        <div class="tabnav-widget selected">
            <a href="#" class="button minibutton primary selected bigger js-new-issue-button" style="cursor:default">New Debt</a>
        </div>
    </div>

    <ul class="tabnav-tabs">
        <li><a href="/${userId}/payback/new" class="tabnav-tab ">Payback</a></li>

    </ul>
</div>


<form accept-charset="UTF-8" action="/${userId}/payback/new" class="js-new-issue-form" id="new_issue" method="post">
<div class="columns discussion-timeline-cols">
<div class="column main">


<div class="discussion-bubble composer">
<a href="/youreme"><img class="discussion-bubble-avatar" height="48"
                        src="https://0.gravatar.com/avatar/162a14615ced6a439f7415599428a54b?d=https%3A%2F%2Fidenticons.github.com%2F99437eb69ac9f45ccbfec67c4b874026.png&amp;s=140"
                        width="48"></a>

<div class="discussion-bubble-content bubble">
<div class="discussion-bubble-inner">

<div class="discussion-topic">


<div class="discussion-topic-header">
    <dl class="form">
        <dd>
            <div class="fieldWithErrors">
                <input autofocus="autofocus" class="required title js-auto-save" id="reason" name="reason" placeholder="[reason] 빌린 or 빌려준 이유 (ex> 점심 식대)" required="required" size="30" tabindex="1" type="text">
            </div>
        </dd>
    </dl>
</div>

    <div class="discussion-topic-header">
        <dl class="form">
            <dd>
                <div class="fieldWithErrors">
                    <input autofocus="autofocus" class="required title js-auto-save" id="debtor" name="debtor" placeholder="[nickname] 빌려준 사람 / 빌린 사람 (ex> hunky)" required="required" size="30" tabindex="1" type="text">
                </div>
            </dd>
        </dl>
    </div>

    <div class="discussion-topic-header">
        <dl class="form">
            <dd>
                <div class="fieldWithErrors">
                    <input autofocus="autofocus" class="required title js-auto-save" id="amount" name="amount" placeholder="[amount] 금액(ex> 1000)" required="required" size="30" tabindex="1" type="text">
                </div>
            </dd>
        </dl>
    </div>

    <!-- /.topic-comment-header -->


<div class="composer-infobar js-infobar">

    <div class="discussion-topic-header">
      <span class="form">
          <select id="type" name="type">
              <option value = 0>빌린 돈</option>
              <option value = 1>빌려준 돈</option>
          </select>
      </span>

    </div>
</div>

</div>
<!-- /.comment -->


</div>
<!-- /.discussion-bubble-content -->
</div>
<!-- /.discussion-bubble-inner -->


<div class="form-actions">
    <button type="submit" class="button primary" tabindex="1" >
        Submit new Debt
    </button>
</div>

</div>
<!-- /.discussion-bubble -->

</div>

</div>
</form>
</div>


</div>

</div>
<!-- /.repo-container -->
<div class="modal-backdrop"></div>
</div>
</div>
</div>
</body>
</html>