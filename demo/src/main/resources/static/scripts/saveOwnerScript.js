const formOwner = document.getElementById('formOwner');
const idCard = document.getElementById('idCard');
const firstName = document.getElementById('firstName'); // Added for first name
const firstLastName = document.getElementById('firstLastName');
const secondLastName = document.getElementById('secondLastName');
const email = document.getElementById('email');
const phone = document.getElementById('phone');

formOwner.addEventListener('submit', (e) => {
    e.preventDefault();
    const idOwner = idCard.value;
    const nameOwner = firstName.value; // Changed variable name from 'name' to 'firstName'
    const firstLastNameOwner = firstLastName.value;
    const secondLastNameOwner = secondLastName.value;
    const emailOwner = email.value;
    const phoneOwner = phone.value;

    if (idOwner === '' || nameOwner === '' || firstLastNameOwner === '' || secondLastNameOwner === '' || emailOwner === '' || phoneOwner === '') {
        alert('Por favor ingrese todos los datos');
        return;
    }
    if(isNaN(idOwner) || isNaN(phoneOwner)){
        alert('Por favor ingrese solo números en el campo de identificación y teléfono');
        return;
    }

    formOwner.submit();
});