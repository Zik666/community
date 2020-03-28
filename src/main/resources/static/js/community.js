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
    const subCommentContainer = $("#subCommentContainer-" + id);
    commentBtn.toggleClass("active");
    if (commentBtn.hasClass("active") && subCommentContainer.children().length === 0) {
        $.getJSON( "/comment/" + id, function(data) {
            $.each(data.data, function(index, comment) {
                const mediaBody = $("<div/>", {
                    "class": "media-body"
                }).append($("<small/>", {
                    "class": "d-flex",
                    "html": comment.user.name + ' • ' + moment(comment.gmtCreate).format("YYYY-MM-DD HH:MM")
                })).append($("<small/>", {
                    "class": "d-flex",
                    "html": comment.content
                }));
                const img = $("<img/>", {
                    "class": "rounded m-1",
                    "width": 32,
                    "height": 32,
                    "src": comment.user.avatarUrl
                });
                const commentElement = $("<li/>", {
                    "class": "media list mx-2 py-2",
                }).append(img).append(mediaBody);
                subCommentContainer.append(commentElement);
            });
        });
    }
}

function selectTag(e) {
    const tag = $("#tag");
    const value = e.getAttribute("data-tag");
    const previous = tag.val();
    if (previous.indexOf(value) === -1) {
        if (previous) {
            tag.val(previous + ',' + value);
        } else {
            tag.val(value);
        }
    }
}

function showSelectTag() {
    $("#select-tag").show();
}