function comment2targetId(targetId, type, content) {
    if (!content) {
        alert("回复内容不能为空~~~");
        return;
    }
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/comment",
        data: JSON.stringify({
            "parentId":targetId,
            "content":content,
            "type":type
        }),
        success: function (response) {
            if (response.code === 200) {
                window.location.reload();
            } else {
                if (response.code === 2003) {
                    const isAccepted = confirm(response.message);
                    if (isAccepted) {
                        window.open("https://github.com/login/oauth/authorize?client_id=2708af41c946195294ad&redirect_uri=http://localhost:8887/callback&scope=user&state=1");
                        window.localStorage.setItem("closable", "true");
                    }
                } else {
                    alert(response.message);
                }
            }
            console.log(response);
        },
        data_type: "json"
    })
}

/**
* 提交回复
*/
function post() {
    const questionId = $("#question_id").val();
    const content = $("#comment_content").val();
    comment2targetId(questionId, 1, content);
}
/**
* 提交二级评论
*/
function comment(e) {
    const commentId = e.getAttribute("data-id");
    const content = $("#input-" + commentId).val();
    comment2targetId(commentId, 2, content)
}
/**
* 展开二级评论
*/
function collapseComments(e) {
    const id = e.getAttribute("data-id");
    const commentBtn = $("#commentBtn-" + id);
    commentBtn.toggleClass("active");
    // if (commentBtn.hasClass("active")) {
    //     $.getJSON( "/comment/" + id, function(data) {
    //         const commentBody = $("#comment-body-" + id);
    //         const items = [];
    //         $.each(data.data, function(comment) {
    //             const c = $("</div>", {
    //                 "class": "collapse py-0 border rounded",
    //                 html: comment.content
    //             });
    //             items.push(c);
    //         });
    //
    //         $("</div>", {
    //             "class":"collapse py-0 border rounded",
    //             "id":"comment-" + id,
    //             html: items.join("")
    //         }).appendTo(commentBody);
    //     });
    // }
}