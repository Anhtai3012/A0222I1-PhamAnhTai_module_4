$(document).ready(function () {
    // var myModal = new bootstrap.Modal(document.getElementById("exampleModal"), {});
    //  $('.table .eBtn').on('click',function (event) {
    //      event.preventDefault();
    //
    //      myModal.show();
    //  });
    $('#saveButton').on('click', function () {
        saveEdit();
    })
    $('#deletethis').on('click',function () {
        deletethis();
    })
});
// <button th:onclick="showInfoEdit([[${service.id})]],[[${service.name})]],[[${service.area})]],
//     [[${service.service_cost})]],[[${service.max_people})]],[[${service.standard_room})]],
// [[${service.description_other_convenience})]],[[${service.pool_area})]],[[${service.number_of_floors})]],
// [[${service.facility_text})]],[[${service.rentType.id})]],[[${service.serviceType.id})]]" t
function showInfoEdit(id, name, area, service_cost, max_people, standard_room, description_other_convenience, pool_area, number_of_floors,
                      facility_text, rentType_id, serviceType_id) {
    // $('#name').val(name);
    document.getElementById("id").value = id;
    document.getElementById("name").value = name;
    document.getElementById("area").value = area;
    document.getElementById("cost").value = service_cost;
    document.getElementById("people").value = max_people;
    document.getElementById("room").value = standard_room;
    document.getElementById("description").value = description_other_convenience;
    document.getElementById("pool").value = pool_area;
    document.getElementById("floor").value = number_of_floors;
    document.getElementById("text-f").value = facility_text;
    document.getElementById("rent").value = rentType_id;
    document.getElementById("service").value = serviceType_id;
}

function saveEdit() {

    let id = $('#id').val();
    if (id === '') {
        createForm(id);
        return;
    }
    let content = $('#content').val();
    let date = $('#date').val();
    let title = $('#title').val();
    let max_people = document.getElementById("people").value;
    let standard_room = document.getElementById("room").value;
    let description_other_convenience = document.getElementById("description").value;
    let pool_area = document.getElementById("pool").value;
    let number_of_floors = document.getElementById("floor").value;
    let facility_text = document.getElementById("text-f").value;
    let rentType_id = document.getElementById("rent").value;
    let serviceType_id = document.getElementById("service").value;
    let data = {
        id: id,
        name: name,
        area: area,
        service_cost: service_cost,
        max_people: max_people,
        standard_room: standard_room,
        description_other_convenience: description_other_convenience,
        pool_area: pool_area,
        number_of_floors: number_of_floors,
        facility_text: facility_text,
        rentType: rentType_id,
        serviceType: serviceType_id
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        url: "http://localhost:8080/api/service/edit",
        data: JSON.stringify(data),
        success: function (event) {
            window.location = 'http://localhost:8080/api/service';
            // $('#exampleModal').modal('hide');
        },
        error: function (event) {
            if (event.status == 400) {
                document.getElementById("errPoint").innerText = event.responseJSON.name;
            }
        }
    })
}

function createForm(id) {
    // let id = document.getElementById("id").value
    let name = document.getElementById("name").value;
    let area = document.getElementById("area").value;
    let service_cost = document.getElementById("cost").value;
    let max_people = document.getElementById("people").value;
    let standard_room = document.getElementById("room").value;
    let description_other_convenience = document.getElementById("description").value;
    let pool_area = document.getElementById("pool").value;
    let number_of_floors = document.getElementById("floor").value;
    let facility_text = document.getElementById("text-f").value;
    let rentType_id = document.getElementById("rent").value;
    let serviceType_id = document.getElementById("service").value;
    console.log("abc")
    let data = {
        // id: id,
        name: name,
        area: area,
        service_cost: service_cost,
        max_people: max_people,
        standard_room: standard_room,
        description_other_convenience: description_other_convenience,
        pool_area: pool_area,
        number_of_floors: number_of_floors,
        facility_text: facility_text,
        rentType: rentType_id,
        serviceType: serviceType_id
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        url: "http://localhost:8080/api/service/create",
        data: JSON.stringify(data),
        success: function (event) {
            // $('#exampleModal').modal('hide');
            window.location = 'http://localhost:8080/api/service';
        },
        error: function (event) {
            console.log(event);
            if (event.status === 400){
            $("#errorPeople").html(event.responseJSON.max_people);
            $("#errorCost").html(event.responseJSON.service_cost);
            $("#errorName").html(event.responseJSON.name);
            $("#errorArea").html(event.responseJSON.area);
            }
        }
    })
}
function deletethis() {
    console.log("123")
    $.ajax({
        // const id= document.getElementById("deleteId").value;
        type: "DELETE",
        url: `/api/service/${$("#deleteId").val()}`,
        dataType: "json",
        contentType: "application/json",
        success: function () {
            $("#delete").modal("hide");
            $("#message").html("DELETE ok")
            // $("#modelConfirm").modal("show");
        },
        error: function () {
            // $("#editForm").modal("hide");
            $("#message").html("DELETE not ok")
            // $("#modelConfirm").modal("show");
        }
    })
}