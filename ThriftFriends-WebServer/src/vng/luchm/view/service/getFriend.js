// load list
$.ajax({
    url: 'http://localhost:9001/all',
    type: "GET",
    dataType: "json",
    success: function (data) {
        console.log(data);
        $.each(data, function (index, val) {
            $.ajax({
                url: 'components/friend.html',
                type: 'GET',
                success: function (html) {
                    console.log(val);
                    $('#friend-component').prepend(html).find('#username').text(val.UserName).end()
                        .find('#iduser').text(val.Id).end()
                        .find('#mutual').attr('href', '#' + val.Id).end()
                        .find('#aa').attr('id', val.Id).end()
                        .find('#mutual').attr('onclick', "showMutual('" + val.Id + "')").end()
                        .find('#mutual-component').attr('id', 'mutual-component-' + val.Id).end();
                }
            });
        });
    },
    error: function (data) {
        console.log("Loi");
    }
});
function showMutual(iduser) {
    $.ajax({
        url: 'components/mutual.html',
        type: 'GET',
        success: function (html) {
            $.ajax({
                url: 'http://localhost:9001/user',
                data: { 'id': iduser },
                type: "GET",
                dataType: "json",
                success: function (data) {
                    $('#mutual-component-' + iduser).prepend(html).find('#username').text(data.UserName).end()
                        .find('#iduser').text(data.Id).end()
                        .find('.collapse').attr('id', data.Id).end();
                    $("#mutual[href$='"+"#"+iduser+"']").removeAttr("onclick");
                },
                error: function (data) {
                    console.log("Loi");
                }
            });
        }
    });

}