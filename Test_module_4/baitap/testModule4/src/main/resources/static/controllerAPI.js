let baseUrl = window.location.origin;


$(document).ready(function () {
    $("#deleteIt").on("click", function () {
        deleteById();
    });

    $("#update-Button").on("click", function () {
        updateDataInModalUpdate();
    });

    $("#edit-Button").on("click", function () {
        editDataInEditModal();
    });

    $("#messageClose").on("click", function () {
        window.location = baseUrl;
    });

    $('#updateModal').on('hide.bs.modal', function () {
        $("#error-update-content").html("");
        $("#error-update-title").html("");
        $("#error-update-type").html("");
    });

    $('#editModal').on('hide.bs.modal', function () {
        $("#error-edit-content").html("");
        $("#error-edit-title").html("");
        $("#error-edit-type").html("");
    });

})

function showInfoEdit(id, title, content, answer, type_id, status_id) {
    $("#idEdit").val(id);
    $("#edit-title").val(title);
    $("#edit-content").val(content);
    $("#edit-answer").val(answer);
    $("#typeEdit").val(type_id);
    $("#statusEdit").val(status_id);
    $("#editModal").modal("show");
}

function getDataByJson() {
    return {
        title: $("#update-title").val(),
        content: $("#update-content").val(),
        typeQuestion: $("#typeCreate").val(),
    };
}

function updateDataInModalUpdate() {
    $.ajax({
        type: "POST",
        url: `${baseUrl}/api/`,
        contentType: "application/json",
        dataType: 'json',
        data: JSON.stringify(getDataByJson()),
        success: function (event) {
            window.location = baseUrl;
        },
        error: function (event) {
            editError(event)
        },
    })
}

function editDataInEditModal() {
    let data = {
        id: $("#idEdit").val(),
        title: $("#edit-title").val(),
        content: $("#edit-content").val(),
        answer: $("#edit-answer").val(),
        typeQuestion: $("#typeEdit").val(),
        statusQuestion: $("#statusEdit").val(),
    }
    $.ajax({
        type: "PUT",
        url: `${baseUrl}/api/`,
        contentType: "application/json",
        dataType: 'json',
        data: JSON.stringify(data),
        success: function (event) {
            $('#message').html(`edit success ${event.title}`);
            $('#messageModal').modal('show');
        },
        error: function (event) {
            console.log(event);
            $("#error-edit-content").html(event.responseJSON.content);
            $("#error-edit-title").html(event.responseJSON.title);
            $("#error-edit-type").html(event.responseJSON.typeQuestion);
        }
    })
}

function showInfo(id) {
    $.ajax({
        type: "GET",
        url: `${baseUrl}/api/${id}`,
        success: function (event) {
            $("#title").html(event.title);
            $("#content").html(event.content);
            $("#answer").html(event.answer == null ? "N/A" : event.answer);
            $("#typeQuestion").html(event.typeQuestion.name);
            $("#dateCreate").html(converterDayCorrect(event.date_create));
            $("#status").html(event.statusQuestion.name);
            $("#infoModal").modal("show");
        }
    })
}

function deleteById() {
    $.ajax({
        type: "DELETE",
        url: `${baseUrl}/api/${$('#deleteId').val()}`,
        success: function (event) {
            $('#message').html(`delete success!!!`);
            $('#messageModal').modal('show');
        },
        error: function () {
            $('#message').html(`server is maintenance. try again !!!`);
            $('#messageModal').modal('show');
        }
    })
}



function editError(data) {
    console.log(data)
    switch (data.status) {
        case 400:
            $("#error-update-content").html(data.responseJSON.content);
            $("#error-update-title").html(data.responseJSON.title);
            $("#error-update-type").html(data.responseJSON.typeQuestion);
            break;
    }
}