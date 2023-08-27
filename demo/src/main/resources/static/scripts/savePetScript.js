const formPet = document.getElementById('formPet');
const idOwner = document.getElementById('idOwner');
const name = document.getElementById('name');
const breed = document.getElementById('breed');
const age = document.getElementById('age');
const weight = document.getElementById('weight');
const disease = document.getElementById('disease');
const imgUrl = document.getElementById('imgUrl');
const entry = document.getElementById('entry');
const departure = document.getElementById('departure');

formPet.addEventListener('submit', (e) => {

    const idOwnerPet = idOwner.value;
    const namePet = name.value;
    const breedPet = breed.value;
    const agePet = age.value;
    const weightPet = weight.value;
    const diseasePet = disease.value;
    const imgUrlPet = imgUrl.value;
    const entryPet = entry.value;
    const departurePet = departure.value;

    if (idOwnerPet === '' || namePet === '' || breedPet === '' || agePet === '' || weightPet === '' || diseasePet === '' || imgUrlPet === '' || entryPet === '' || departurePet === '') {
        e.preventDefault(); // Prevent the form from submitting
        alert('Por favor ingrese todos los datos');
    }

    if (entryPet > departurePet) {
        e.preventDefault(); // Prevent the form from submitting
        alert('La fecha de salida no puede ser menor a la de entrada');
    }
});
