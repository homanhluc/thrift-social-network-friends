
function login() {
    var username = $('#txt_name_login').val();
    $.ajax({
        url: 'http://localhost:9001/login',
        type: "GET",
        data:{'name': username},
        success: function (data) {
            console.log(data);
            $.setCookie("sessionId",data);
            window.location.href = 'http://localhost:8080/';
        },
        error: function (data) {
            console.log("Loi");
        }
    });
}
function register() {
    var username = $('#txt_name_register').val();
}