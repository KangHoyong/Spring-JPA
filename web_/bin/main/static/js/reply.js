// reply.js

var reply = 
{
    init : function()
    {
        var _this = this;
        console.log(this);
        $('#btn-replysave').on('click' , function()
        {
            _this.save();
        });
        
    },
    save : function ()
    {
        var data = {
            replyContent: $('#replyContent').val(),
            authorId: $('#authorId').val()
        };

        $.ajax({
            type: 'POST',
            url: '/posts/reply',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('댓글이 등록되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(error);
        });
    }
}
reply.init();