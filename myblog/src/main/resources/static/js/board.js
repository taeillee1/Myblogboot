let index = {
    init:function (){
        $("#btn-save").on("click",()=>{ //function()대신 ()=>을사용하는이유는 this를 바인딩하기위해
            this.save();
        });
        $("#btn-delete").on("click",()=>{
            this.deleteById();
        });
        $("#btn-update").on("click",()=>{
            this.updateById();
        });
        $("#btn-reply-save").on("click",()=>{
            this.replySave();
        });
    },
    save:function (){
        let data={
            title:$("#title").val(),
            content:$("#content").val()
        };
        //console.log(data);
        $.ajax({//회원가입 수행 요청
            type:"POST",
            url:"/api/board",
            data:JSON.stringify(data),
            contentType:"application/json; charset = utf-8",
            dataType:"json"//응답이 왔을때 응답된데이터가 생긴게 json이라면 자바스크립트로 변경시켜줌
        }).done(function (resp){ //결과가 정상이면 수행
            alert("글쓰기가 완료되었습니다.");
            location.href="/";
        }).fail(function (error){ //결과가 이상하면 수행
            alert(JSON.stringify(error));
        });
    },
    deleteById:function (){
        let id = $("#id").text();

        $.ajax({//회원가입 수행 요청
            type:"DELETE",
            url:"/api/board/"+id,
            contentType:"application/json; charset = utf-8",
            dataType:"json"//응답이 왔을때 응답된데이터가 생긴게 json이라면 자바스크립트로 변경시켜줌
        }).done(function (resp){ //결과가 정상이면 수행
            alert("삭제가 완료되었습니다.");
            location.href="/";
        }).fail(function (error){ //결과가 이상하면 수행
            alert(JSON.stringify(error));
        });
    },
    updateById:function (){
        let id = $("#id").val();
        let data={
            title:$("#title").val(),
            content:$("#content").val()
        };
        $.ajax({
            type:"PUT",
            url:"/api/board/"+id,
            data:JSON.stringify(data),
            contentType:"application/json; charset = utf-8",
            dataType:"json"//응답이 왔을때 응답된데이터가 생긴게 json이라면 자바스크립트로 변경시켜줌
        }).done(function (resp){ //결과가 정상이면 수행
            alert("글수정이 완료되었습니다.");
            location.href="/";
        }).fail(function (error){ //결과가 이상하면 수행
            alert(JSON.stringify(error));
        });
    },
    replySave:function (){
        let data={
            boardId:$("#boardId").val(),
            content:$("#reply-content").val()
        };
        console.log(data);
        $.ajax({//회원가입 수행 요청
            type:"POST",
            url:`/api/board/${data.boardId}/reply`,
            data:JSON.stringify(data),
            contentType:"application/json; charset = utf-8",
            dataType:"json"//응답이 왔을때 응답된데이터가 생긴게 json이라면 자바스크립트로 변경시켜줌
        }).done(function (resp){ //결과가 정상이면 수행
            alert("댓글작성이 완료되었습니다.");
            location.href=`/board/${data.boardId}`;
        }).fail(function (error){ //결과가 이상하면 수행
            alert(JSON.stringify(error));
        });
    }
}

index.init();