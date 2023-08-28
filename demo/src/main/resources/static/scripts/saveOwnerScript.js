const formOwner = document.getElementById('formOwner');
const idCard = document.getElementById('idCard');
const name = document.getElementById('name');
const firstLastName = document.getElementById('firstLastName');
const secondLastName = document.getElementById('secondLastName');
const email = document.getElementById('email');
const phone = document.getElementById('phone');

formOwner.addEventListener('submit', (e) => {
    const idOwner = idCard.value;
    const nameOwner = name.value;
    const firstLastNameOwner = firstLastName.value;
    const secondLastNameOwner = secondLastName.value;
    const emailOwner = email.value;
    const phoneOwner = phone.value;

    if (idOwner === '' || nameOwner === '' || firstLastNameOwner === '' || secondLastNameOwner === '' || emailOwner === '' || phoneOwner === '') {
        e.preventDefault(); // Prevent the form from submitting
        alert('Por favor ingrese todos los datos');
    }
});