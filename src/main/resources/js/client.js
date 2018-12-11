$(document).ready(function() {

    assignDataToTable();
    remove();
    edit();
    userShow();

    function edit() {
        $('table').on('click', 'button[id="edit"]', function (e) {
            var id = $(this).closest('tr').children('td:first').text();
            var name = $(this).closest('tr').children('td:nth-child(2)').text();
            var age = $(this).closest('tr').children('td:nth-child(3)').text();
            var login = $(this).closest('tr').children('td:nth-child(4)').text();
            var password = $(this).closest('tr').children('td:nth-child(5)').text();

            $("#idChange").val(id);
            $("#nameChange").val(name);
            $("#ageChange").val(age);
            $("#loginChange").val(login);
            $("#passwordChange").val(password);

            $('#save').click(function () {
                $.ajax({
                    type: "POST",
                    url: "/changeUser",
                    data: {
                        idChange: $("#idChange").val(),
                        nameChange: $("#nameChange").val(),
                        ageChange: $("#ageChange").val(),
                        loginChange: $("#loginChange").val(),
                        passwordChange: $("#passwordChange").val(),
                    },

                    success: function () {
                        location.reload();
                    }
                });
            });
        });
    }

    function userShow() {
        $('#addUser').click(function () {
            $.ajax({
                type: "GET",
                url: "/registred",
            })

        })
    }

    function remove() {
    $('table').on('click', 'button[id="delete"]', function (e) {
        var id = $(this).closest('tr').children('td:first').text();
        $.ajax({
            type: "GET",
            url: "/removeUser/" + id,
            success: function (html) {
                $("#container").html(html);
               // assignDataToTable()
            }
        })
    });
}

    function assignDataToTable() {
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "http://localhost:8080/list",
            typeDate: "json",
            success: function(data) {

                var users = JSON.parse(JSON.stringify(data));
                for (var i in users)  {
                    $("tbody").
                    append("<tr> \
                            <td>" +  users[i].id + "</td> \
                            <td>" +  users[i].name + "</td> \
                            <td>" +  users[i].age + "</td> \
                            <td>" +  users[i].login + "</td> \
                            <td>" +  users[i].password + "</td> \
                            <td> \ <button id='delete' class='btn btn-danger'>delete</button> \</td> \
                          <td> \ <button id='edit' class='btn btn-warning' data-toggle='modal' data-target='#EditModal' >Edit</button> \ </td> \
                        </tr>");
                }
            },
        });
    }
});


