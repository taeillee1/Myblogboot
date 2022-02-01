<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp"%>
<div class="container">
    <form class="form-inline d-flex justify-content-end">
        <div class="form-group mx-sm-3 mb-2">
            <label for="searchText" class="sr-only">검색</label>
            <input type="text" class="form-control" id="searchText" name="searchText" value="${param.searchText}">
        </div>
        <button type="submit" class="btn btn-secondary mb-2">검색</button>
    </form>
    <c:forEach var="board" items="${boards.content}">

        <div class="card m-2">
            <div class="card-body">
                <h4 class="card-title">${board.title}</h4>
                <div>
                    <a href="/board/${board.id}" class="btn btn-primary justify-content-center">상세보기</a>

                </div>
                <div class="pagination justify-content-end">
                    조회수:<span><i>${board.count} </i></span>
                </div>

            </div>
        </div>

    </c:forEach>

    <ul class="pagination justify-content-center">
        <c:choose>
            <c:when test="${boards.first}">
                <li class="page-item disabled"><a class="page-link" href="?searchText=${param.searchText}&page=${boards.pageable.pageNumber-1}">Previous</a></li>
            </c:when>
            <c:otherwise>
                <li class="page-item"><a class="page-link" href="?searchText=${param.searchText}&page=${boards.pageable.pageNumber-1}">Previous</a></li>
            </c:otherwise>
        </c:choose>
        <c:forEach var="i" begin="1" end="${boards.totalPages}">
            <li class="page-item"><a class="page-link" href="?searchText=${param.searchText}&page=${i-1}">${i}</a></li>
        </c:forEach>
        <c:choose>
            <c:when test="${boards.last}">
                <li class="page-item disabled"><a class="page-link" href="?searchText=${param.searchText}&page=${boards.pageable.pageNumber+1}">Next</a></li>
            </c:when>
            <c:otherwise>
                <li class="page-item"><a class="page-link" href="?searchText=${param.searchText}&page=${boards.pageable.pageNumber+1}">Next</a></li>
            </c:otherwise>
        </c:choose>

    </ul>
</div>
<%@ include file="layout/footer.jsp"%>
<script src="/js/board.js"></script>
