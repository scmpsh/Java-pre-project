function sendRequest(id) {
    $.ajax({
        method: 'get',
        url: '/user/becomeAnAdmin/' + id,
        contentType: 'application/json',
        async: false,
    })
    showUser()
}

function showAdmRequest(id) {
    var footer = ""

    footer += "<button type='button' class='btn btn-secondary' " +
        "data-dismiss='modal'>Close</button>" +
        "<button type='button' class='btn btn-success' onclick='sendRequest(" + id + ")' data-dismiss='modal'>" +
        "YES!</button>"
    $("#footerAdmRequest").html(footer)
    showUser()
}

function getUser() {
    var user

    $.ajax({
        url: '/getAuthorizedUser',
        method: 'get',
        contentType: 'application/json',
        async: false,
        success: function (data) {
            user = data
        }
    })

    return user;
}

function showUser() {
    var user = getUser();
    var table = "";

    table += "<tr><td>" + user.id + "</td>"
        + "<td>" + user.firstName + "</td>"
        + "<td>" + user.lastName + "</td>"
        + "<td>" + user.age + "</td>"
        + "<td>" + user.email + "</td>"
        + "<td>";
    for (role of user.roles) {
        table += role.name.substring(5) + " ";
    }
    if (user.request === false) {
        table += '</td><td><button id="buttonSubmitAdminRole" type="button" class="btn btn-info" data-toggle="modal" ' +
            'data-target="#admRequestModal" onclick="showAdmRequest(' + user.id + ')">Want become an Admin</button>'
    } else if (user.request === true){
        table += '</td><td><button id="buttonSubmitAdminRole" type="button" class="btn btn-info" data-toggle="modal" ' +
            'data-target="#admRequestModal" disabled>Your request is being processed</button>'
    }

    table += "</td></tr>";

    $("#about-user").html(table);
}

showUser()