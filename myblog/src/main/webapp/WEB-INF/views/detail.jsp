<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp"%>


<div class="container">
    <br/><br/>
    <div>
        글번호:<span id="id"><i>${board.id} </i></span>
        작성자:<span><i>${board.user.username} </i></span>
    </div>
    <br/>
    <div class="form-group">
        <label>Title</label>
        <h3>${board.title}</h3>
    </div>
    <hr/>
    <div class="form-group">
        <label>Content</label>
        <div>
            ${board.content}
        </div>
    </div>
    <a class="btn btn-secondary mb-3" href="/">돌아기기</a>
    <c:if test="${board.user.id==principal.user.id}">
        <a href="/board/${board.id}/updateForm" class="btn btn-warning mb-3">수정</a>
        <button id="btn-delete" class="btn btn-danger mb-3">삭제</button>
    </c:if>

    <div class="card mb-2">
        <form>
            <input type="hidden" value="${board.id}" id="boardId">
            <div class="card-body"><textarea id="reply-content" rows="1" class="form-control"></textarea></div>
            <div class="card-footer"><button type="button" id="btn-reply-save" class="btn btn-primary">등록</button></div>
        </form>

    </div>

    <div class="card mb-2">
        <div class="card-header">댓글 리스트</div>
        <ul id="reply--box" class="list-group">
            <c:forEach var="reply" items="${board.replys}">
                <li id="reply--1" class="list-group-item d-flex justify-content-between">
                    <div>${reply.content}</div>
                    <div class="d-flex">
                        <div>작성자 : ${reply.user.username} &nbsp&nbsp</div>
                        <button class="badge">삭제</button>
                    </div>
                </li>
            </c:forEach>

        </ul>
    </div>

</div>

<script>
    $('.summernote').summernote({
        tabsize: 2,
        height: 300
    });
</script>
<%@ include file="layout/footer.jsp"%>
<script src="/js/board.js"></script>
