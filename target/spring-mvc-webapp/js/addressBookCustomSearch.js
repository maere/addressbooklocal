/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {


    $('#search-button').click(function () {

        $('.search-book-cover').hide();
        $('.address-list-main').show();
    });

    $('#close-list-button').click(function () {

        $('.address-list-main').hide();
        $('.search-book-cover').show();
 
    });


    function displayAddForm(id) {
        $(id).click(function (e) {
            e.preventDefault();

            var addForm = $(this).attr('href');
            $('.' + addForm).show();

        });

    }

    displayAddForm('#go-to-add-form');
    displayAddForm('#go-to-add-form-button');

    //----

    $('#add-button').on('click', function (e) {

        e.preventDefault();

        $.ajax({
            type: 'POST',
            url: 'address',
            data: JSON.stringify({
                firstName: $('#add-first-name').val(),
                lastName: $('#add-last-name').val(),
                street: $('#add-street').val(),
                city: $('#add-city').val(),
                state: $('#add-state').val(),
                zipCode: $('#add-zip').val()

            }),
            headers: {
                'accept': 'application/json',
                'Content-Type': 'application/json'
            },
            dataType: 'json'

        }).success(function (data, status) {

            $('#add-first-name').val('');
            $('#add-last-name').val('');
            $('#add-street').val('');
            $('#add-city').val('');
            $('#add-state').val('');
            $('#add-zip').val('');

                    loadAddresses();

        }).error(function (data, status) {
            $.each(data.responseJSON.fieldErrors, function (index, validationError) {
                var errorDiv = $('#validationErrors');
                errorDiv.append(validationError.message).append('<br>');
            });


        });
    });
});
//----------------------------------------------edited, but cross your fingers
function fillAddressTable(addressList, status)
{
    clearAddressTable();

    var aTable = $('#contentRows');

    $.each(addressList, function (index, address)
    {
        aTable
                .append($('<tr>')
                
                .append($('<td>').append($('<a>')
                        .attr({
                            'data-address-id': address.idNumber,
                            'data-toggle': 'modal',
                            'data-target': '#detailsModal'
                        }).text(address.firstName)))
                        
                .append($('<td>').text(address.lastName))
        
                .append($('<td>')
//                .append($('<a>')
//                        .attr({
//                            'data-address-id': address.idNumber,
//                            'data-toggle': 'modal',
//                            'data-target': '#editModal'
//                        })
//                        .text('Edit')
//                        ))
//                
//                .append($('<td>')
//                .append($('<a>').attr({'onClick': 'deleteAddress(' + address.idNumber + ')'}).text('Delete')
//                       )   //end of <a> tag for delete link
                )   // end of <td> tag for delete link
            );//end tr?
    });
}

//------------------------------------------edited: y
function loadAddresses() {

    $.ajax({
        url: "addresses"
    }).success(function (data, status) {

        fillAddressTable(data, status);

    });
}

function clearAddressTable() //edited - y
{
    $('#contentRows').empty();
}
//---------------------------------------------
$('#detailsModal').on('show.bs.modal', function (event) {

    var element = $(event.relatedTarget);

    var idNumber = element.data('address-id');

    var modal = $(this);

    $.ajax({
        type: 'GET',
        url: 'address/' + idNumber
    }).success(function (address)
    {
        modal.find('#address-id').text(address.idNumber);
        
        modal.find('#details-first').text(address.firstName);
        modal.find('#details-last').text(address.lastName);
        modal.find('#details-street').text(address.street);
        modal.find('#details-city').text(address.city);
        modal.find('#details-state').text(address.state);
        modal.find('#details-zip').text(address.zipCode);///
    });

});

//------------

$('#editModal').on('show.bs.modal', function (event) {

    var element = $(event.relatedTarget);

    var idNumber = element.data('address-id');

    var modal = $(this);

    $.ajax({
        type: 'GET',
        url: 'address/' + idNumber
    }).success(function (address) {
        modal.find('#address-id').text(address.idNumber);
        
        modal.find('#edit-address-id').val(address.idNumber);
        modal.find('#edit-first').val(address.firstName);
        modal.find('#edit-last').val(address.lastName);
        modal.find('#edit-street').val(address.street);
        modal.find('#edit-city').val(address.city);
        modal.find('#edit-state').val(address.state);
        modal.find('#edit-zip').val(address.zipCode);
    });

});
//-----
$('#edit-button').click(function (event) {

    event.preventDefault();

    $.ajax({
        type: 'PUT',
        url: 'address/' + $('#edit-address-id').val(),
        data: JSON.stringify(
                {
                    idNumber: $('#edit-address-id').val(),
                    firstName: $('#edit-first').val(),
                    lastName: $('#edit-last').val(),
                    street: $('#edit-street').val(),
                    city: $('#edit-city').val(),
                    state: $('#edit-state').val(),
                    zipCode: $('#edit-zip').val()
                }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    }).success(function () {
        loadAddresses();
    });
});



//----------------------
function deleteAddress(idNumber)
{
    var answer = confirm("Do you really want to delete this address?");

    if (answer === true)
    {
        $.ajax({
            type: 'DELETE',
            url: 'address/' + idNumber
        }).success(function () {
            loadAddresses();
        });
    }
}
//-----


$('#search-button').click(function (event) {

    event.preventDefault();

    $.ajax({
        type: 'POST',
        url: 'search/addresses',
        data: JSON.stringify({
            
            firstName: $('#search-first-name').val(),
            lastName: $('#search-last-name').val(),
            street: $('#search-street').val(),
            city: $('#search-city').val(),
            state: $('#search-state').val(),
            zipCode: $('#search-zip').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    }).success(function (data, status) {
        
        $('#search-first-name').val('');
        $('#search-last-name').val('');
        $('#search-street').val('');
        $('#search-city').val('');
        $('#search-state').val('');
        $('#search-zip').val('');

        fillAddressTable(data, status);
    });

});




//--------------------------------------------- for front page



//  





