<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp"%>


<div class="container">
    <form>
        <input type="hidden" id="id" value="${board.id}">
        <div class="form-group">
            <label>Title</label>
            <input value="${board.title}" type="text" class="form-control" placeholder="Enter Title" id="title" >
        </div>
        <div class="form-group">
            <label>Content</label>
            <textarea class="form-control summernote" id="content" rows="5" cols="">${board.content}</textarea>
        </div>
        <button id="btn-update" class="btn btn-primary mb-3">글수정완료</button>
    </form>
</div>

<script>
    $('.summernote').summernote({
        tabsize: 2,
        height: 300
    });
</script>
<%@ include file="layout/footer.jsp"%>
<script src="/js/board.js"></script>
