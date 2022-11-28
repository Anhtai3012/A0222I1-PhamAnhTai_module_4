let basePage = 0;
let max_display = 1;
$(document).ready(function () {

    $('#saveButton').on('click', function () {
        saveEdit();
    })
    $('#deletethis').on('click', function () {
        deletethis();
    })
    $('#buttonSearch').on('click', function () {
        search();
    })
});

function deletethis() {
    $.ajax({
        type: "DELETE",
        url: `/${$("#deleteId").val()}`,
        dataType: "json",
        contentType: "application/json",
        success: function (event) {
            alert("xoa thanh cong")
            window.location = "http://localhost:8080";
        },
        error: function () {
            // $("#editForm").modal("hide");
            $("#message").html("DELETE not ok");
            // $("#modelConfirm").modal("show");
        }
    })
}

function showInfoEdit(id, title, content, answer, date, status, questionTypes_id) {
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
    let questionTypes_id = $('#question').val();
    let data = {
        id: id,
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
    let code = $('#code').val();
    let name = $('#name').val();
    let type = $('#type').val();
    let date = $('#date').val();
    let price = $('#price').val();
    let area = $('#area').val();
    let data = {
        // id: id,
        code: code,
        customer: name,
        service_type: type,
        date: date,
        price: price,
        area: area
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
            alert("them moi thanh cong");
        },
        error: function (event) {
            if (event.status === 400) {
                $("#error1").html(event.responseJSON.code);
                $("#error3").html(event.responseJSON.service_type);
                $("#error5").html(event.responseJSON.price);
                $("#error6").html(event.responseJSON.area);
            }
        }
    })
}

window.onload = () => {
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "GET",
        url: "http://localhost:8080/list",
        success: function (event) {
            const dataStr = JSON.stringify(event.content);
            localStorage.setItem('AllList', dataStr);
            drawTable(basePage);

            let page = drawPage(event.content);
            $("#page").html(page);
        }
    })
};

function drawPage(data) {
    let max_page = data.length / max_display;
    let pageHtml = '';
    for (let i = 0; i < max_page; i++) {
        pageHtml += `<li><button onclick="drawTable(${i})">${i + 1}</button></li>`
    }
    return pageHtml;
}

function drawTable(index) {
    let str = "";
    const dataStr = localStorage.getItem('AllList');
    const list = JSON.parse(dataStr);
    console.log(index)
    console.log(list)
    for (let i = index; i < max_display; i++) {
        str += `<tr>
                <td>${i + 1}</td>
                <td>${list[i].code}</td>
                <td>${list[i].customer.name}</td>
                <td>${list[i].service_type}</td>
                 <td>${list[i].date}</td>
                 <td>${list[i].price}</td>
                  <td>${list[i].area}</td>
                  <td>
                <button th:onclick=|showInfoDelete(${list[i].id})| type="button" class="btn btn-outline-danger"
                          data-bs-toggle="modal" data-bs-target="#delete">
                        <i class="fa-solid fa-eraser"></i>
                       Delete
                    </button>
                    
                  <a th:href="@{/{id}(id=${list[i].id})}"><button class="btn btn-primary">View</button></a>

                </td>
                </tr>`
    }
    console.log(str);
    $('#bodyTable').html(str);
}

function search() {
    let name = $("#nameSearch").val();
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "GET",
        url: `http://localhost:8080/list?name=${name}`,
        success: function (event) {
            $("#bodyTable").html(drawTable(event.content));
        }
    })

}
