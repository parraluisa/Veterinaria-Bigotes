const formPet = document.getElementById('formPet');
const ownerId = document.getElementById('ownerId');
const name = document.getElementById('name');
const breed = document.getElementById('breed');
const age = document.getElementById('age');
const weight = document.getElementById('weight');
const disease = document.getElementById('disease');
const imgUrl = document.getElementById('imgUrl');
const entry = document.getElementById('entry');
const departure = document.getElementById('departure');

formPet.addEventListener('submit', (e) => {
    e.preventDefault();
    const idOwnerPet = ownerId.value;
    const namePet = name.value;
    const breedPet = breed.value;
    const agePet = age.value;
    const weightPet = weight.value;
    const diseasePet = disease.value;
    const imgUrlPet = imgUrl.value;
    const entryPet = entry.value;
    const departurePet = departure.value;

    if (idOwnerPet === '' || namePet === '' || breedPet === '' || agePet === '' || weightPet === '' || diseasePet === '' || imgUrlPet === '' || entryPet === '' || departurePet === '') {
        alert('Por favor ingrese todos los datos');
        console.log('Por favor ingrese todos los datos');
        return;
    }
    const entryDate = new Date(entryPet);
    const departureDate = new Date(departurePet);

    if (entryDate > departureDate) {
        alert('La fecha de salida no puede ser menor a la de entrada');
        return;
    }

    formPet.submit();

});

