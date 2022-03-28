function editUser(id) {
    var firstName = $('#firstNameModal').val();
    var lastName = $('#lastNameModal').val();
    var age = $('#editAge').val();
    var email = $('#editEmail').val();
    var password = $('#editPassword').val();
    var roles = $('#selectEdit').val();

    $.ajax({
        type: "POST",
        contentType: "application/json; charset=utf-8",
        url: "http://localhost:8080/admin/edit/" + id,
        data: JSON.stringify({
            'firstName': firstName,
            'lastName': lastName, 'age': age, 'email': email,
            'password': password, 'roles': roles
        }),
        async: false,
    });

    showAllUsers();
}

function deleteUser(id) {
    $.ajax({
        url: 'http://localhost:8080/admin/delete/' + id,
        method: 'get',
        async: false,
    })
    showAllUsers()
}

function getUserById(id) {
    var user

    $.ajax({
        url: 'http://localhost:8080/getUserById/' + id,
        method: 'get',
        contentType: 'application/json',
        async: false,
        success: function (data) {
            user = data
        }
    })
    return user
}

function getAllUsers() {
    var users

    $.ajax({
        url: 'http://localhost:8080/admin/getAllUsers',
        method: 'get',
        contentType: 'application/json',
        async: false,
        success: function (response) {
            users = response
        }
    })
    return users
}

function getAllRoles() {
    var roles

    $.ajax({
        url: 'http://localhost:8080/admin/getAllRoles',
        method: 'get',
        contentType: 'application/json',
        async: false,
        success: function (response) {
            roles = response
        }
    })
    return roles
}

function showEditUser(id) {
    var user = getUserById(id)
    var roles = getAllRoles()
    var rolesHTML = ""
    var footer = ""

    document.getElementById("idModal").value = user.id;
    document.getElementById("firstNameModal").value = user.firstName;
    document.getElementById("lastNameModal").value = user.lastName;
    document.getElementById("editAge").value = user.age;
    document.getElementById("editEmail").value = user.email;
    document.getElementById("editPassword").value = user.password;

    for (role of roles) {
        rolesHTML += "<option value='" + role.name + "'>" + role.name.substring(5) + "</option>"
    }

    document.getElementById("selectEdit").innerHTML = rolesHTML;

    footer += '<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>' +
        '<button type="button" class="btn btn-primary" onclick="editUser(' + id + ')" data-dismiss="modal">Edit</button>'
    $("#footerEdit").html(footer)
}

function showDeleteUser(id) {
    var user = getUserById(id)
    var rolesHTML = ""
    var footer = ""

    document.getElementById("idModalDelete").value = user.id;
    document.getElementById("firstNameModalDelete").value = user.firstName;
    document.getElementById("lastNameModalDelete").value = user.lastName;
    document.getElementById("ageModalDelete").value = user.age;
    document.getElementById("emailModalDelete").value = user.email;
    for (role of user.roles) {
        rolesHTML += "<option value='" + role.name + "'>" + role.name.substring(5) + "</option>"
    }
    document.getElementById("selectDelete").innerHTML = rolesHTML;

    footer += "<button type='button' class='btn btn-secondary' " +
        "data-dismiss='modal'>Close</button>" +
        "<button type='button' class='btn btn-danger' onclick='deleteUser(" + id + ")' data-dismiss='modal'>" +
        "Delete</button>"
    $("#footerDelete").html(footer)
}

function addNewUser() {

    var firstName = $('#firstName').val();
    var lastName = $('#lastName').val();
    var age = $('#age').val();
    var email = $('#email').val();
    var password = $('#password').val();
    var roles = $('#selectNew').val();


    $.ajax({
        type: "POST",
        contentType: "application/json; charset=utf-8",
        url: "http://localhost:8080/admin/addNewUser",
        data: JSON.stringify({
            'firstName': firstName,
            'lastName': lastName, 'age': age, 'email': email,
            'password': password, 'roles': roles
        })
    });

    showAllUsers()
}

function showAllUsers() {
    var users = getAllUsers()
    var table

    for (user of users) {
        table += "<tr><td>" + user.id + "</td>"
            + "<td>" + user.firstName + "</td>"
            + "<td>" + user.lastName + "</td>"
            + "<td>" + user.age + "</td>"
            + "<td>" + user.email + "</td>"
            + "<td>";
        for (role of user.roles) {
            table += role.name.substring(5) + " ";
        }
        table += '</td><td><button id="buttonEdit" type="button" class="btn btn-info" data-toggle="modal" ' +
            'data-target="#editModal" onclick="showEditUser(' + user.id + ')">'
            + 'Edit</button></td>';
        table += '<td><button id="buttonDelete" type="button" class="btn btn-danger" data-toggle="modal" ' +
            'data-target="#deleteModal" onclick="showDeleteUser(' + user.id + ')">Delete</button></td>';
        table += '</tr>';
    }
    $("#all-users").html(table);
}

function renderRoles() {
    var rolesHTML = ""
    var roles = getAllRoles()
    for (role of roles) {
        rolesHTML += "<option value='" + role.name + "'>" + role.name.substring(5) + "</option>"
    }

    document.getElementById("selectNew").innerHTML = rolesHTML;
}

showAllUsers()