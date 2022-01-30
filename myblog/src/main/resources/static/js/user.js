let index = {
    init:function (){
        $("#btn-save").on("click",()=>{ //function()대신 ()=>을사용하는이유는 this를 바인딩하기위해
            this.save();
        });
        // $("#btn-login").on("click",()=>{
        //     this.login();
        // });
    },
    save:function (){
        //alert('user의 save함수 호출됨')
        let data={
            username:$("#username").val(), //#username은 username이란 아이디를 가지고있는 곳의 값을 가져와서 username에 저장
            password:$("#password").val(),
            email:$("#email").val()
        };
        //console.log(data);
        $.ajax({//회원가입 수행 요청
            type:"POST",
            url:"/auth/joinProc",
            data:JSON.stringify(data),
            contentType:"application/json; charset = utf-8",
            dataType:"json"//응답이 왔을때 응답된데이터가 생긴게 json이라면 자바스크립트로 변경시켜줌
        }).done(function (resp){ //결과가 정상이면 수행
            alert("회원가입이 완료되었습니다.")
            location.href="/"
        }).fail(function (error){ //결과가 이상하면 수행
            alert(JSON.stringify(error));
        });//ajax통신을 이용하여 3개의 데이터를 json으로 변경하고 insert요청
    },

    // login:function (){
    //     //alert('user의 save함수 호출됨')
    //     let data={
    //         username:$("#username").val(), //#username은 username이란 아이디를 가지고있는 곳의 값을 가져와서 username에 저장
    //         password:$("#password").val(),
    //     };
    //     //console.log(data);
    //     $.ajax({
    //         type:"POST",
    //         url:"/api/user/login",
    //         data:JSON.stringify(data),
    //         contentType:"application/json; charset = utf-8",
    //         dataType:"json"//응답이 왔을때 응답된데이터가 생긴게 json이라면 자바스크립트로 변경시켜줌
    //     }).done(function (resp){ //결과가 정상이면 수행
    //         alert("로그인이 완료되었습니다.")
    //         location.href="/"
    //     }).fail(function (error){ //결과가 이상하면 수행
    //         alert(JSON.stringify(error));
    //     });//ajax통신을 이용하여 3개의 데이터를 json으로 변경하고 insert요청
    // }
}

index.init();