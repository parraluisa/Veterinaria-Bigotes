document.addEventListener('DOMContentLoaded', function () {
    const formPet = document.getElementById('formPet');
    const ownerIdInput = document.getElementById('ownerId');
    const nameInput = document.getElementById('name');
    const breedInput = document.getElementById('breed');
    const birthdayInput = document.getElementById('birthday');
    const weightInput = document.getElementById('weight');
    const diseaseInput = document.getElementById('disease');
    const imgUrlInput = document.getElementById('imgUrl');

    function isValidUrl(url) {
        // Regular expression for a valid URL
        var urlPattern = /^(https?|ftp):\/\/[^\s/$.?#].[^\s]*$/i;
        return urlPattern.test(url);
    }

    formPet.addEventListener('submit', function (e) {
        e.preventDefault();

        const idOwnerPet = ownerIdInput.value;
        const namePet = nameInput.value;
        const breedPet = breedInput.value;
        const birthdayPet = birthdayInput.value;
        const weightPet = weightInput.value;
        const diseasePet = diseaseInput.value;
        const imgUrlPet = imgUrlInput.value;

        if (!idOwnerPet || !namePet || !breedPet || !birthdayPet || !weightPet || !diseasePet || !imgUrlPet) {
            alert('Por favor ingrese todos los datos');
            console.log('Por favor ingrese todos los datos');
            return;
        }

        if (!isValidUrl(imgUrlPet)) {
            alert('La URL de la imagen no es válida');
            console.log('La URL de la imagen no es válida');
            return;
        }
        if (isNaN(idOwnerPet)) {
            alert('Por favor ingrese solo números en el campo de identificación');
            console.log('Por favor ingrese solo números en el campo de identificación');
            return;
        }

        formPet.submit();
    });
});
