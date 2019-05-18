// 프론트 기능을 담당하는 자바스크립트 파일 
// post.hbs

var post =
{
    init  : function()
    {
        var _this = this;
        console.log(this);
        $('#btn-list').on('click', function()
        {
            _this.list();
        });
        $('#btn-modify').on('click', function()
        {
            _this.modify();
        });
        $('#btn-delete').on('click', function()
        {
            _this.delete();
        });
    },
    list : function()
    {
        window.location.href = '/';
    },
    modify :function()
    {
        if(confirm('게시글을 수정하시겠습니까?'))
        {
            var data = 
            {
                id: $('#id').val(),
                title: $('#title').val(),
                author: $('#author').val(),
                content: $('#content').val()
            };

            $.ajax({
                type: 'POST',
                url: '/posts/modify',
                dataType: 'json',
                contentType:'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function() {
                alert('글이 수정되었습니다.');
                location.reload();
            }).fail(function (error) {
                alert(JSON.error);
                console.log(error);
            });
           
        }
    },
    delete : function()
    {
        if(confirm('게시글을 삭제하시겠습니까?'))
        {
        // 삭제
            var data = $('#delete-id').val();

            $.ajax({
                type: 'POST',
                url: '/posts/delete',
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
                data: data
            }).done(function(id){
                alert(id + '번 글이 삭제되었습니다.!!');
                location.href='/';
            }).fail(function(id){
                alert(JSON.stringify(error));
                console.log(error);
            });
        }
    }
}

post.init();