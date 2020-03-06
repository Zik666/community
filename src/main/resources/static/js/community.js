function post() {
    const questionId = $("#question_id").val();
    const content = $("#comment_content").val();
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/comment",
        data: JSON.stringify({
            "parentId":questionId,
            "content":content,
            "type":1
        }),
        success: function (response) {
            if (response.code == 200) {
                $("#comment_section").hide();
            } else {
                alert(response.message());
            }
            console.log(response);
        },
        data_type: "json"
    })
}