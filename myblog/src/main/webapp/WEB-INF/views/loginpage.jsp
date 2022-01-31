<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp"%>

<div class="container">
    <form action="/auth/loginProc" method="post">
        <div class="form-group">
            <label for="username">Username :</label>
            <input type="username" class="form-control" placeholder="Enter username" id="username" name="username">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" placeholder="Enter password" id="password" name="password">
        </div>
        <button id="btn-login" class="btn btn-primary mb-3">로그인</button>
    </form>
</div>
<%--위 form태그의 action은 따르 컨트롤러를 만들지않는다 security가 훔쳐가게 할것--%>
<%@ include file="layout/footer.jsp"%>
<%--<script src="/js/user.js"></script>--%>


