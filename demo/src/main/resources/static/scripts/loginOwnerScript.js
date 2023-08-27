// JavaScript code to show the error pop-up and handle form submission
const urlParams = new URLSearchParams(window.location.search);
const error = urlParams.get('error');

if (error === 'idNotFound') {
       alert('ID not found. Please try again.');
}

// Handling form submission
const formOwner = document.getElementById('formOwner');
const idCard = document.getElementById('idCard');

formOwner.addEventListener('submit', (e) => {
    const idOwner = idCard.value;

    if (idOwner === '') {
        e.preventDefault(); // Prevent the form from submitting
        alert('Please enter your ID');
    }
});
