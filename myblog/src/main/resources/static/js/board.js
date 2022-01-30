let index = {
    init:function (){
        $("#btn-save").on("click",()=>{ //function()대신 ()=>을사용하는이유는 this를 바인딩하기위해
            this.save();
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
            alert("글쓰기가 완료되었습니다.")
            location.href="/"
        }).fail(function (error){ //결과가 이상하면 수행
            alert(JSON.stringify(error));
        });
    }
}

index.init();