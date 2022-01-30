<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp"%>


<div class="container">
    <form>
        <div class="form-group">
            <label for="title">Title</label>
            <input type="text" class="form-control" placeholder="Enter Title" id="title" >
        </div>
        <div class="form-group">
            <label for="content">Content</label>
            <textarea class="form-control summernote" id="content" rows="5" cols=""></textarea>
        </div>
        <button id="btn-save" class="btn btn-primary mb-3">글쓰기완료</button>
    </form>
</div>

<script>
    $('.summernote').summernote({
        placeholder: 'Hello Bootstrap 4',
        tabsize: 2,
        height: 300
    });
</script>
<%@ include file="layout/footer.jsp"%>

