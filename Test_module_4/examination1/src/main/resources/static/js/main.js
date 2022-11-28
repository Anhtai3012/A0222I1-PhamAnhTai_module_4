$(document).ready(function () {

    $('#saveButton').on('click', function () {
        saveEdit();
    })
    $('#deletethis').on('click',function () {
        deletethis();
    })
});
function deletethis() {
    $.ajax({
        type: "DELETE",
        url: `/${$("#deleteId").val()}`,
        dataType: "json",
        contentType: "application/json",
        success: function (event) {
            alert("err")
            console.log(event)
            window.location="http://localhost:8080";
        },
        error: function () {
            // $("#editForm").modal("hide");
            $("#message").html("DELETE not ok");
            // $("#modelConfirm").modal("show");
        }
    })
}
function showInfoEdit(id, title, content, answer, date,status,questionTypes_id) {
    // $('#name').val(name);
    document.getElementById("id").value = id;
    document.getElementById("title").value = title;
    document.getElementById("content").value = content;
    document.getElementById("answer").value = answer;
    document.getElementById("date").value = date;
    document.getElementById("status").value = status;
    document.getElementById("question").value = questionTypes_id;
}
function saveEdit() {
    let id = $('#id').val();
    if (id === '') {
        createForm(id);
        return;
    }
    let title = $('#title').val();
    let content = $('#content').val();
    let answer = $('#answer').val();
    let date = $('#date').val();
    let status = $('#status').val();
    let questionTypes_id = $('#question').val() ;
    let data = {
        id: id,
        title: title,
        content: content,
        answer: answer,
        date: date,
        status: status,
        questionType: questionTypes_id
    }
    console.log(data)
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        url: "http://localhost:8080/edit",
        data: JSON.stringify(data),
        success: function (event) {
            window.location = 'http://localhost:8080';
            // $('#exampleModal').modal('hide');
        },
        error: function (event) {
            if (event.status == 400) {
                // document.getElementById("errPoint").innerText = event.responseJSON.content;
                $("#error1").html(event.responseJSON.title);
                $("#error2").html(event.responseJSON.content);
                $("#error3").html(event.responseJSON.answer);
                // $("#error5").html(event.responseJSON.status);
            }
        }
    })
}
function createForm() {
    // let id = $('#id').val();
    let title = $('#title').val();
    let content = $('#content').val();
    let answer = $('#answer').val();
    let date = $('#date').val();
    let status = $('#status').val();
    let questionTypes_id = $('#question').val() ;
    let data = {
        // id: id,
        title: title,
        content: content,
        answer: answer,
        date: date,
        status: status,
        questionType: questionTypes_id
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        url: "http://localhost:8080/create",
        data: JSON.stringify(data),
        success: function (event) {
            window.location = 'http://localhost:8080';
        },
        error: function (event) {
            console.log(event);
            if (event.status === 400){
                $("#error1").html(event.responseJSON.title);
                $("#error2").html(event.responseJSON.content);
                $("#error3").html(event.responseJSON.answer);
            }
        }
    })
}