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
            <a href="/${userId}/payback" class="url fn" itemprop="url" rel="author"><span itemprop="title">${userId}</span></a></span>
            <span class="repohead-name-divider">/</span><strong><a href="/${userId}/payback"
                                                                   class="js-current-repository js-repo-home-link">payback</a></strong>
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
                <div class="tabnav-widget ">
                    <a href="/${userId}/payback/new" class="button minibutton primary bigger js-new-issue-button"
                       data-hotkey="c">New Debt</a>
                </div>
            </div>

            <ul class="tabnav-tabs">
                <li><a href="/${userId}/payback" class="tabnav-tab selected">Payback</a></li>
            </ul>
        </div>
        <div id="issues_list" class="js-issues-results columns browser" data-pjax-container="" data-url="/${userId}/payback">

            <div class="column sidebar issues-list-sidebar js-issue-sidebar">
                <ul class="filter-list js-pjax-active" data-pjax="">
                    <li>
                        <a href="/${userId}/payback" class="filter-item selected">
                            <span class="count">${paybackCount.all}</span> Show All
                        </a></li>
                    <li>
                        <a href="/${userId}/payback/debt" class="filter-item">
                            <span class="count">${paybackCount.debt}</span> Assigned to you
                        </a></li>

                    <li>
                        <a href="/${userId}/payback/receivable" class="filter-item">
                            <span class="count">${paybackCount.receivable}</span> Created by you
                        </a></li>
                </ul>

                <div class="rule"></div>


                <div class="js-editable-labels-container">
                    <ul class="js-color-label-list filter-list color-label-list small js-editable-labels-show"
                        data-pjax="">
                        <h4>Friends</h4>
                        <c:forEach var="key" items="${debtKey}" varStatus="status">
                        <li>
                            <a href="/${key}/payback" class="filter-item color-label  labelstyle-fc2929 zeroed"
                               data-label="bug" rel="nofollow">
                                <span class="count">${dependency[key]}</span>
                                <span class="color" style="background-color: #fc2929">&nbsp;</span>
                                <span class="octicon octicon-remove-close"></span>
                                <span class="name">${key}</span>
                            </a>
                        </li>
                        </c:forEach>
                        <%--
                        <li>
                            <a href="/ari/payback" class="filter-item color-label  labelstyle-cccccc zeroed"
                               data-label="duplicate" rel="nofollow">
                                <span class="count">3500</span>
                                <span class="color" style="background-color: #cccccc">&nbsp;</span>
                                <span class="octicon octicon-remove-close"></span>
                                <span class="name">ari</span>
                            </a></li>
                        <li>
                            <a href="/kal/payback" class="filter-item color-label  labelstyle-84b6eb zeroed"
                               data-label="enhancement" rel="nofollow">
                                <span class="count">500</span>
                                <span class="color" style="background-color: #84b6eb">&nbsp;</span>
                                <span class="octicon octicon-remove-close"></span>
                                <span class="name">kal</span>
                            </a></li>
                        <li>
                            <a href="/quick/payback" class="filter-item color-label  labelstyle-e6e6e6 zeroed"
                               data-label="invalid" rel="nofollow">
                                <span class="count">2700</span>
                                <span class="color" style="background-color: #e6e6e6">&nbsp;</span>
                                <span class="octicon octicon-remove-close"></span>
                                <span class="name">quick</span>
                            </a></li>
                        <li>
                            <a href="/mathew/payback" class="filter-item color-label  labelstyle-cc317c zeroed"
                               data-label="question" rel="nofollow">
                                <span class="count">0</span>
                                <span class="color" style="background-color: #cc317c">&nbsp;</span>
                                <span class="octicon octicon-remove-close"></span>
                                <span class="name">mathew</span>
                            </a></li>
                        --%>
                    </ul>

                    <div class="rule"></div>

                </div>
            </div>

            <div class="column main">
                <div class="issues-list-options" data-pjax="">
                    <div class="select-menu js-issues-sort js-menu-container js-select-menu">
  <span class="minibutton select-menu-button js-menu-target" role="button" tabindex="0">
    <i>Sort:</i>
    <span class="js-select-button">Newest</span>
  </span>

                        <div class="select-menu-modal-holder js-menu-content js-navigation-container">

                            <div class="select-menu-modal">
                                <div class="select-menu-header">
                                    <span class="select-menu-title">Sort options</span>
                                    <span class="octicon octicon-remove-close js-menu-close"></span>
                                </div>
                                <div class="select-menu-list">
                                    <a class="select-menu-item js-navigation-open js-navigation-item selected"
                                       href="/${userId}/payback?direction=desc&amp;page=1&amp;sort=created">
                                        <span class="select-menu-item-icon octicon octicon-check"></span>
                                        <span class="select-menu-item-text js-select-button-text">Newest</span>
                                    </a>
                                    <a class="select-menu-item js-navigation-open js-navigation-item "
                                       href="/${userId}/payback?direction=asc&amp;page=1&amp;sort=created">
                                        <span class="select-menu-item-icon octicon octicon-check"></span>
                                        <span class="select-menu-item-text js-select-button-text">Oldest</span>
                                    </a>
                                </div>

                            </div>
                        </div>
                    </div>

                </div>

                <div class="chromed-list-browser issues">
                    <div class="issues issues-list js-issues-list js-navigation-container js-active-navigation-container js-form-issues js-selectable-issues">
                        <ul class="list-group issue-list-group">
                            <c:forEach var="payback" items="${paybackList}" varStatus="status">
                            <li class="list-group-item issue-list-item js-list-browser-item js-navigation-item read selectable <c:if test='${payback.creditor == userId}'>navigation-focus</c:if>">
                                <div class="issue-item-unread"></div>
                                <input type="checkbox" class="list-group-item-check js-issues-list-checkbox select-toggle-check" name="issues[]" value="8">
                                <span class="list-group-item-number">${payback.amount}</span>
                                <h4 class="list-group-item-name">
                                    <span class="type-icon octicon octicon-issue-opened open" title="Open issue"></span>
                                    <a href="#" class="js-navigation-open">[${payback.regdate}] <font color="#4169e1">${payback.reason}</font></a>
                                </h4>
                                <ul class="list-group-item-meta">
                                    <li>  [Creditor] ${payback.creditor} ==> [debtor] ${payback.debtor}
                                        <%--<time class="js-relative-date" datetime="2013-09-27T06:13:59-07:00"--%>
                                              <%--title="2013-09-27 06:13:59">2 days ago--%>
                                        <%--</time>--%>
                                    </li>
                                </ul>
                            </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>

                <div class="right">
                </div>
            </div>
        </div>
    </div>
</div>

</div>
<div class="modal-backdrop"></div>
</div>
</div>
</div>
</body>
</html>