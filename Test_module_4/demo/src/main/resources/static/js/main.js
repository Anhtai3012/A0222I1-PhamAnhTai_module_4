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
        url: `/api/product/${$("#deleteId").val()}`,
        dataType: "json",
        contentType: "application/json",
        success: function (event) {
            alert("err")
            console.log(event)
            window.location="http://localhost:8080/api/product";
        },
        error: function () {
            // $("#editForm").modal("hide");
            $("#message").html("DELETE not ok");
            // $("#modelConfirm").modal("show");
        }
    })
}
function showInfoEdit(id, content, date, reporter, title,category_id) {
    // $('#name').val(name);
    document.getElementById("id").value = id;
    document.getElementById("content").value = content;
    document.getElementById("date").value = date;
    document.getElementById("reporter").value = reporter;
    document.getElementById("title").value = title;
    document.getElementById("category").value = category_id;
}
function saveEdit() {
    let id = $('#id').val();
    if (id === '') {
        createForm(id);
        return;
    }
    let content = $('#content').val();
    let date = $('#date').val();
    let reporter = $('#reporter').val();
    let title = $('#title').val();
    let category_id = $('#category').val() ;
    let data = {
        id: id,
        content: content,
        date: date,
        reporter: reporter,
        title: title,
        category: category_id
    }
    console.log(data)
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        url: "http://localhost:8080/api/product/edit",
        data: JSON.stringify(data),
        success: function (event) {
            window.location = 'http://localhost:8080/api/product';
            // $('#exampleModal').modal('hide');
        },
        error: function (event) {
            if (event.status == 400) {
                document.getElementById("errPoint").innerText = event.responseJSON.content;
            }
        }
    })
}
function createForm() {
    let id = $('#id').val();
    let content =$('#content').val()
    let date = $('#date').val()
    let reporter = $('#reporter').val()
    let title = $('#title').val();
    let category_id = $('#category').val()
    let data = {
        // id: id,
        content: content,
        date: date,
        reporter: reporter,
        title: title,
        category: category_id
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        url: "http://localhost:8080/api/product/create",
        data: JSON.stringify(data),
        success: function (event) {
            window.location = 'http://localhost:8080/api/product';
        },
        error: function (event) {
            console.log(event);
            if (event.status === 400){
                $("#error1").html(event.responseJSON.content);
                $("#error3").html(event.responseJSON.reporter);
                $("#error4").html(event.responseJSON.title);
            }
        }
    })
}