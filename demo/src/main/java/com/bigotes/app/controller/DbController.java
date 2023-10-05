package com.bigotes.app.controller;

import com.bigotes.app.model.Drug;
import com.bigotes.app.model.Owner;
import com.bigotes.app.model.Pet;
import com.bigotes.app.model.Treatment;
import com.bigotes.app.model.Veterinarian;
import com.bigotes.app.repository.DrugRepository;
import com.bigotes.app.repository.OwnerRepository;
import com.bigotes.app.repository.PetRepository;
import com.bigotes.app.repository.TreatmentRepository;
import com.bigotes.app.repository.VeterinarianRepository;
import jakarta.transaction.Transactional;

import org.apache.poi.ss.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.Random;

@Controller
@Transactional
public class DbController implements ApplicationRunner {
    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    PetRepository petRepository;

    @Autowired
    VeterinarianRepository veterinarianRepository;

    @Autowired
    DrugRepository drugRepository;

    @Autowired
    TreatmentRepository treatmentRepository;

    @Override
    public void run(ApplicationArguments args) {

        createOwners();
        createPets();
        relatePetsToOwners();
        createVets();
        createDrugs();
        createTreatments();
        relateTreatments();

    }

    private void relatePetsToOwners() {
        for (long i = 1L; i < 101L; i++) {
            Owner owner = ownerRepository.findById(i).get();
            Pet pet = petRepository.findById(i).get();
            pet.setOwner(owner);
            petRepository.save(pet);
        }

        Random random = new Random(42);

        for (long i = 101L; i <= 150L; i++) {
            long idPropietarioAleatorio = (long) (random.nextDouble() * 100) + 1;
            Owner owner = ownerRepository.findById(idPropietarioAleatorio).get();
            Pet pet = petRepository.findById(i).get();
            pet.setOwner(owner);
            petRepository.save(pet);
        }
    }

    private void relateTreatments(){
        for (long i = 1L; i < 11L; i++) {
            Pet pet = petRepository.findById(i).get();
            Drug drug = drugRepository.findById(i).get();
            Veterinarian vet = veterinarianRepository.findById(i).get();
            Treatment treatment = treatmentRepository.findById(i).get();
            treatment.setPet(pet);
            treatment.setVeterinarian(vet);
            treatment.setDrug(drug);
            treatmentRepository.save(treatment);
        }
    }

    private void createVets() {
        // Crear veterinario 1
        veterinarianRepository.save(new Veterinarian(1000612796L ,"Andrés", "Garcia", "Montoya", "1234", "Cirujano", "https://images.pexels.com/photos/5327585/pexels-photo-5327585.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));
        // Crear veterinario 2
        veterinarianRepository.save(new Veterinarian(1000612797L ,"Maria", "Lopez", "Rodriguez", "5678", "Dermatologo", "https://images.pexels.com/photos/5407206/pexels-photo-5407206.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));
        // Crear veterinario 3
        veterinarianRepository.save(new Veterinarian(1000612798L ,"Carlos", "Martinez", "Perez", "4321", "Cardiologo", "https://images.pexels.com/photos/5327921/pexels-photo-5327921.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));
        // Crear veterinario 4
        veterinarianRepository.save(new Veterinarian(1000612799L ,"Isabel", "Gonzalez", "Silva", "9876", "Oncologo", "https://images.pexels.com/photos/6749778/pexels-photo-6749778.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));
        // Crear veterinario 5
        veterinarianRepository.save(new Veterinarian(1000612800L ,"Diego", "Rodriguez", "Lopez", "2468", "Neurologo", "https://images.pexels.com/photos/5867730/pexels-photo-5867730.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));
        // Crear veterinario 6
        veterinarianRepository.save(new Veterinarian(1000612801L ,"Ana", "Perez", "Fernandez", "1357", "Radiologo", "https://images.pexels.com/photos/5452201/pexels-photo-5452201.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));
        // Crear veterinario 7
        veterinarianRepository.save(new Veterinarian(1000612802L ,"Javier", "Sanchez", "Ramirez", "8765", "Radiologo", "https://images.pexels.com/photos/5452291/pexels-photo-5452291.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));
        // Crear veterinario 8
        veterinarianRepository.save(new Veterinarian(1000612803L ,"Sofia", "Hernandez", "Gomez", "3691", "Dentista", "https://images.pexels.com/photos/12495583/pexels-photo-12495583.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));
        // Crear veterinario 9
        veterinarianRepository.save(new Veterinarian(1000612804L ,"Luis", "Torres", "Diaz", "7412", "Cirujano", "https://images.pexels.com/photos/3279197/pexels-photo-3279197.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));
        // Crear veterinario 10
        veterinarianRepository.save(new Veterinarian(1000612805L ,"Elena", "Fernandez", "Molina", "5824", "Dentista", "https://images.pexels.com/photos/4167541/pexels-photo-4167541.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));
        // Crear veterinario 11
        veterinarianRepository.save(new Veterinarian(1000612806L, "Juan", "Perez", "Lopez", "1234", "Cirujano", "https://images.pexels.com/photos/8460157/pexels-photo-8460157.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
        // Crear veterinario 12
        veterinarianRepository.save(new Veterinarian(1000612807L, "Laura", "Garcia", "Martinez", "5678", "Dermatologo", "https://media.istockphoto.com/id/1227504152/es/foto/mujer-médico-llena-la-historia-clínica-y-escribe-receta-en-la-tableta.jpg?s=1024x1024&w=is&k=20&c=6znLs6DS5cgkYzUaeAy_2CnCLp962hklg9ts0Urzupg="));
        // Crear veterinario 13
        veterinarianRepository.save(new Veterinarian(1000612808L, "Pedro", "Lopez", "Rodriguez", "4321", "Cardiologo", "https://images.pexels.com/photos/12660379/pexels-photo-12660379.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
        // Crear veterinario 14
        veterinarianRepository.save(new Veterinarian(1000612809L, "Carmen", "Martinez", "Gonzalez", "9876", "Oncologo", "https://media.istockphoto.com/id/1249199278/es/foto/foto-de-perfil-de-atractiva-familia-doc-señora-pacientes-consulta-amigable-sonrisa-confiable.jpg?s=1024x1024&w=is&k=20&c=9_B0DyArRLvaVHcOy7w9AovzJI32wqLE7xs8sx80QIg="));
        // Crear veterinario 15
        veterinarianRepository.save(new Veterinarian(1000612810L, "Fernando", "Gonzalez", "Silva", "2468", "Neurologo", "https://images.pexels.com/photos/6303591/pexels-photo-6303591.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
        // Crear veterinario 16
        veterinarianRepository.save(new Veterinarian(1000612811L, "Ana", "Rodriguez", "Fernandez", "1357", "Radiologo", "https://media.istockphoto.com/id/1256122635/es/foto/retrato-de-primer-plano-de-bonito-atractivo-alegre-rubia-chica-doc-usando-gadget-conexión.jpg?s=1024x1024&w=is&k=20&c=3F3nAJiLOoDYJRjRk_HvWUfTenVICDtcHDZKRCpbLD4="));
        // Crear veterinario 17
        veterinarianRepository.save(new Veterinarian(1000612812L, "Miguel", "Perez", "Gomez", "8765", "Radiologo", "https://media.istockphoto.com/id/1269486200/es/foto/apuesto-joven-médico-en-el-pasillo-del-hospital-mirando-a-la-cámara-sonriendo.jpg?s=1024x1024&w=is&k=20&c=_135u4a6GZGSC0Wo504yAsROExyhXRT_DrNwmXZvcsk="));
        // Crear veterinario 18
        veterinarianRepository.save(new Veterinarian(1000612813L, "Sara", "Sanchez", "Ramirez", "3691", "Dentista", "https://media.istockphoto.com/id/1222193164/es/foto/concepto-de-consulta-médica-mujer-doctora-en-gafas-con-portátil.jpg?s=1024x1024&w=is&k=20&c=ZQVc8cuOu59NgKdWrWfVFk37TbNAiODV_5u1MFx8jp4="));
        // Crear veterinario 19
        veterinarianRepository.save(new Veterinarian(1000612814L, "Carlos", "Torres", "Diaz", "7412", "Cirujano", "https://media.istockphoto.com/id/1593890881/es/foto/retrato-de-un-joven-médico-indio-parado-en-una-clínica-en-el-consultorio-del-hospital-con-una.jpg?s=1024x1024&w=is&k=20&c=rzTesU4kjlMg4LshoxI5MFfoZ8vVNmZ_AdcvMSQpiXk="));
        // Crear veterinario 20
        veterinarianRepository.save(new Veterinarian(1000612815L, "Lorena", "Fernandez", "Molina", "5824", "Dentista", "https://media.istockphoto.com/id/1436148451/es/foto/doctora-sonriente-con-tableta-digital-de-pie-sobre-fondo-gris-aislado.jpg?s=1024x1024&w=is&k=20&c=uTl86-Boiidyq0C_3hAzXrnBM1_lH5TsklT0Tp4ONMs="));

    }

    private void createPets() {
        // Crear mascota 1
        petRepository.save(new Pet("Pompita", "British Shorthair", LocalDate.of(2015, 2, 12), 824.65, "Hipotiroidismo", "https://catinaflat.blog/wp-content/uploads/2022/03/british-shorthair-1.jpg"));
        // Crear mascota 2
        petRepository.save(new Pet("Fifi", "Abisinio", LocalDate.of(2023, 7, 24), 200.00, "rinotraqueítis felina", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.vBdcyqdY0z6igk5tfrflTQHaHa%26pid%3DApi&f=1&ipt=9a4ae16ea2d8f1a780e82c8a1ccbdbd022e6cfd3d22a02b712097477650fd6ac&ipo=images"));
        // Crear mascota 3
        petRepository.save(new Pet("Mimosa", "Maine Coon", LocalDate.of(2020, 4, 15), 4065.82, "Conjuntivitis", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.Dg-lJLyICJTPKLDcKOuYtgHaEo%26pid%3DApi&f=1&ipt=74cb2a44995bd708e41b783acc38bbe08949fdf0f140e082347bd5ab5efa6dd6&ipo=images"));
        // Crear mascota 4
        petRepository.save(new Pet("Gizmo", "Tonkinés", LocalDate.of(2015, 8, 15), 1988.20, "Pancreatitis", "https://images.unsplash.com/photo-1513977055326-8ae6272d90a7?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxleHBsb3JlLWZlZWR8MjB8fHxlbnwwfHx8fHw%3D&auto=format&fit=crop&w=600&q=60"));
        // Crear mascota 5
        petRepository.save(new Pet("Mila", "Siberiano", LocalDate.of(2021, 3, 19), 2694.84, "Otitis", "https://images.pexels.com/photos/866496/pexels-photo-866496.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 6
        petRepository.save(new Pet("Leo", "Rex Selkirk", LocalDate.of(2015, 7, 4), 4553.99, "Insuficiencia renal", "https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 7
        petRepository.save(new Pet("Pompita", "Persa", LocalDate.of(2016, 6, 8), 1782.87, "Problemas cardíacos", "https://images.pexels.com/photos/617278/pexels-photo-617278.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 8
        petRepository.save(new Pet("Puma", "Manx", LocalDate.of(2015, 9, 9), 1530.87, "Insuficiencia renal", "https://images.pexels.com/photos/104827/cat-pet-animal-domestic-104827.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 9
        petRepository.save(new Pet("Silvestre", "British Shorthair", LocalDate.of(2019, 4, 4), 1462.31, "Síndrome de Cushing", "https://images.pexels.com/photos/20787/pexels-photo.jpg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 10
        petRepository.save(new Pet("Dolly", "Sphynx", LocalDate.of(2016, 8, 25), 4872.04, "Problemas cardíacos", "https://images.pexels.com/photos/57416/cat-sweet-kitty-animals-57416.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 11
        petRepository.save(new Pet("Azul", "Azul Ruso", LocalDate.of(2015, 3, 16), 2991.73, "Síndrome de Cushing", "https://images.pexels.com/photos/774731/pexels-photo-774731.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 12
        petRepository.save(new Pet("Mimi", "Azul Ruso", LocalDate.of(2022, 11, 3), 1605.30, "Asma", "https://images.pexels.com/photos/209037/pexels-photo-209037.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 13
        petRepository.save(new Pet("Fifi", "Abisinio", LocalDate.of(2019, 8, 2), 4495.18, "Obesidad", "https://images.pexels.com/photos/1543793/pexels-photo-1543793.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 14
        petRepository.save(new Pet("Simba", "Rex Selkirk", LocalDate.of(2016, 9, 24), 4409.42, "Gusano del corazón", "https://images.pexels.com/photos/2194261/pexels-photo-2194261.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 15
        petRepository.save(new Pet("Oreo", "Maine Coon", LocalDate.of(2022, 3, 18), 1965.12, "Anemia", "https://images.pexels.com/photos/127028/pexels-photo-127028.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 16
        petRepository.save(new Pet("Calipso", "Azul Ruso", LocalDate.of(2017, 7, 6), 171.06, "Megacolon", "https://images.pexels.com/photos/2558605/pexels-photo-2558605.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 17
        petRepository.save(new Pet("Bonito", "Burmés", LocalDate.of(2018, 5, 25), 3739.40, "Disfunción cognitiva", "https://images.pexels.com/photos/669015/pexels-photo-669015.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 18
        petRepository.save(new Pet("Toby", "Tonkinés", LocalDate.of(2017, 8, 23), 2673.75, "Disfunción cognitiva", "https://images.pexels.com/photos/126407/pexels-photo-126407.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 19
        petRepository.save(new Pet("Stitch", "Scottish Fold", LocalDate.of(2017, 4, 19), 2769.45, "Problemas respiratorios", "https://images.pexels.com/photos/1276553/pexels-photo-1276553.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 20
        petRepository.save(new Pet("Nube", "Abisinio", LocalDate.of(2022, 11, 16), 2284.95, "Cáncer", "https://images.pexels.com/photos/1472999/pexels-photo-1472999.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 21
        petRepository.save(new Pet("Lilo", "Rex Selkirk", LocalDate.of(2020, 5, 6), 1293.37, "Gingivitis", "https://images.pexels.com/photos/33537/cat-animal-cat-portrait-mackerel.jpg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 22
        petRepository.save(new Pet("Moro", "Manx", LocalDate.of(2017, 11, 1), 2363.75, "Tumores mamarios", "https://images.pexels.com/photos/615369/pexels-photo-615369.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 23
        petRepository.save(new Pet("Pompón", "Ragdoll", LocalDate.of(2019, 11, 16), 222.38, "Alergias", "https://images.pexels.com/photos/1084425/pexels-photo-1084425.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 24
        petRepository.save(new Pet("Oreo", "Persa", LocalDate.of(2023, 5, 24), 4372.52, "Problemas dentales", "https://images.pexels.com/photos/1576193/pexels-photo-1576193.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 25
        petRepository.save(new Pet("Dolly", "British Shorthair", LocalDate.of(2020, 1, 9), 4543.43, "Conjuntivitis", "https://images.pexels.com/photos/1359307/pexels-photo-1359307.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 26
        petRepository.save(new Pet("Muffin", "Azul Ruso", LocalDate.of(2015, 1, 12), 251.56, "Estreñimiento", "https://images.pexels.com/photos/248280/pexels-photo-248280.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 27
        petRepository.save(new Pet("Garu", "Tonkinés", LocalDate.of(2023, 8, 25), 3286.32, "Hipertiroidismo", "https://images.pexels.com/photos/1510543/pexels-photo-1510543.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 28
        petRepository.save(new Pet("Kitty", "Rex Selkirk", LocalDate.of(2020, 1, 27), 4196.06, "Hipotiroidismo", "https://images.pexels.com/photos/1302290/pexels-photo-1302290.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 29
        petRepository.save(new Pet("Tommy", "Bengalí", LocalDate.of(2023, 1, 15), 4000.00, "Cáncer", "https://images.pexels.com/photos/208773/pexels-photo-208773.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 30
        petRepository.save(new Pet("Mimosa", "Bengalí", LocalDate.of(2019, 2, 9), 4989.53, "Obesidad", "https://images.pexels.com/photos/1183434/pexels-photo-1183434.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 31
        petRepository.save(new Pet("Tigre", "Noruego de Bosque", LocalDate.of(2016, 7, 14), 1925.31, "Anemia", "https://images.pexels.com/photos/736530/pexels-photo-736530.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 32
        petRepository.save(new Pet("Simona", "Azul Ruso", LocalDate.of(2020, 6, 1), 1566.90, "Rabia", "https://images.pexels.com/photos/127027/pexels-photo-127027.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 33
        petRepository.save(new Pet("Toby", "Bobtail Japonés", LocalDate.of(2017, 9, 27), 1627.76, "Gingivitis", "https://images.pexels.com/photos/735423/pexels-photo-735423.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 34
        petRepository.save(new Pet("Oreo", "Burmés", LocalDate.of(2018, 8, 22), 3643.26, "Disfunción cognitiva", "https://images.pexels.com/photos/54632/cat-animal-eyes-grey-54632.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 35
        petRepository.save(new Pet("Lilo", "Abisinio", LocalDate.of(2019, 1, 20), 4943.96, "Gusano del corazón", "https://images.pexels.com/photos/1870376/pexels-photo-1870376.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 36
        petRepository.save(new Pet("Galleta", "Burmés", LocalDate.of(2018, 10, 5), 376.85, "Parásitos intestinales", "https://images.pexels.com/photos/1560424/pexels-photo-1560424.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 37
        petRepository.save(new Pet("Stitch", "Persa", LocalDate.of(2022, 1, 13), 1155.14, "Resfriado", "https://images.pexels.com/photos/674570/pexels-photo-674570.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 38
        petRepository.save(new Pet("Puma", "Rex Selkirk", LocalDate.of(2017, 11, 2), 719.71, "Otitis", "https://images.pexels.com/photos/37337/cat-silhouette-cats-silhouette-cat-s-eyes.jpg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 39
        petRepository.save(new Pet("Mochito", "Devon Rex", LocalDate.of(2016, 7, 10), 2253.41, "Anemia", "https://images.pexels.com/photos/177809/pexels-photo-177809.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 40
        petRepository.save(new Pet("Silvestre", "Maine Coon", LocalDate.of(2023, 6, 10), 4979.12, "Hipertiroidismo", "https://images.pexels.com/photos/225406/pexels-photo-225406.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 41
        petRepository.save(new Pet("Selene", "Tonkinés", LocalDate.of(2023, 10, 19), 1439.10, "Problemas card�acos", "https://images.pexels.com/photos/62640/pexels-photo-62640.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 42
        petRepository.save(new Pet("Tommy", "Bobtail Japonés", LocalDate.of(2017, 5, 10), 2008.95, "Enfermedad hepática", "https://images.pexels.com/photos/65006/pexels-photo-65006.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 43
        petRepository.save(new Pet("Nala", "British Shorthair", LocalDate.of(2018, 10, 19), 4185.26, "Obesidad", "https://images.pexels.com/photos/1543801/pexels-photo-1543801.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 44
        petRepository.save(new Pet("Rocky", "Siamés", LocalDate.of(2021, 3, 27), 2136.08, "Problemas dentales", "https://images.pexels.com/photos/747795/pexels-photo-747795.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 45
        petRepository.save(new Pet("Cleo", "Bengalí", LocalDate.of(2018, 7, 7), 4901.27, "Gusano del corazón", "https://images.pexels.com/photos/1022158/pexels-photo-1022158.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 46
        petRepository.save(new Pet("Sassy", "Scottish Fold", LocalDate.of(2018, 7, 7), 628.78, "Obesidad", "https://images.pexels.com/photos/248350/pexels-photo-248350.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 47
        petRepository.save(new Pet("Stitch", "British Shorthair", LocalDate.of(2018, 10, 13), 619.86, "Problemas cardíacos", "https://images.pexels.com/photos/1049764/pexels-photo-1049764.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 48
        petRepository.save(new Pet("Azul", "Rex Selkirk", LocalDate.of(2023, 8, 12), 1342.83, "Tumores mamarios", "https://images.pexels.com/photos/236660/pexels-photo-236660.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 49
        petRepository.save(new Pet("Miau", "Siamés", LocalDate.of(2018, 7, 19), 2420.69, "Conjuntivitis", "https://images.pexels.com/photos/460985/pexels-photo-460985.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 50
        petRepository.save(new Pet("Lilo", "Gato de Bengala", LocalDate.of(2022, 6, 16), 2636.83, "Rabia", "https://images.pexels.com/photos/290164/pexels-photo-290164.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 51
        petRepository.save(new Pet("Garfio", "Maine Coon", LocalDate.of(2018, 4, 27), 4768.76, "Disfunción cognitiva", "https://images.pexels.com/photos/357141/pexels-photo-357141.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 52
        petRepository.save(new Pet("Galleta", "Sphynx", LocalDate.of(2022, 3, 6), 3822.80, "Parásitos intestinales", "https://images.pexels.com/photos/951336/pexels-photo-951336.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 53
        petRepository.save(new Pet("Cucho", "Siberiano", LocalDate.of(2021, 10, 4), 4636.06, "Asma", "https://images.pexels.com/photos/978555/pexels-photo-978555.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 54
        petRepository.save(new Pet("Sassy", "Siberiano", LocalDate.of(2019, 7, 16), 2878.20, "Problemas cardíacos", "https://images.pexels.com/photos/86243/pexels-photo-86243.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 55
        petRepository.save(new Pet("Leo", "Siamés", LocalDate.of(2019, 1, 21), 487.80, "Hipotiroidismo", "https://images.pexels.com/photos/1202481/pexels-photo-1202481.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 56
        petRepository.save(new Pet("Selene", "Bobtail Japonés", LocalDate.of(2017, 9, 17), 2290.89, "Alergias", "https://images.pexels.com/photos/208805/pexels-photo-208805.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 57
        petRepository.save(new Pet("Romeo", "Cornish Rex", LocalDate.of(2021, 11, 10), 2371.34, "Problemas dentales", "https://images.pexels.com/photos/2286016/pexels-photo-2286016.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 58
        petRepository.save(new Pet("Fifi", "Cornish Rex", LocalDate.of(2023, 11, 13), 3297.02, "Infección urinaria", "https://images.pexels.com/photos/302280/pexels-photo-302280.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 59
        petRepository.save(new Pet("Silvestre", "Rex Selkirk", LocalDate.of(2020, 3, 15), 1469.38, "Parásitos intestinales", "https://images.pexels.com/photos/1440403/pexels-photo-1440403.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 60
        petRepository.save(new Pet("Precioso", "Abisinio", LocalDate.of(2015, 7, 21), 2729.56, "Insuficiencia renal", "https://images.pexels.com/photos/1031460/pexels-photo-1031460.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 61
        petRepository.save(new Pet("Cleo", "Burmés", LocalDate.of(2022, 6, 14), 3178.08, "Insuficiencia renal", "https://images.pexels.com/photos/256632/pexels-photo-256632.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 62
        petRepository.save(new Pet("Nutella", "Ragdoll", LocalDate.of(2019, 2, 19), 951.49, "Problemas dentales", "https://images.pexels.com/photos/1930852/pexels-photo-1930852.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 63
        petRepository.save(new Pet("Mila", "Maine Coon", LocalDate.of(2016, 10, 16), 2380.18, "Asma", "https://images.pexels.com/photos/1818608/pexels-photo-1818608.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 64
        petRepository.save(new Pet("Cucho", "Scottish Fold", LocalDate.of(2019, 7, 8), 4341.03, "Anemia", "https://images.pexels.com/photos/1521305/pexels-photo-1521305.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 65
        petRepository.save(new Pet("Nutella", "Bengalí", LocalDate.of(2022, 2, 5), 2539.46, "Síndrome de Cushing", "https://images.pexels.com/photos/171227/pexels-photo-171227.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 66
        petRepository.save(new Pet("Kitty", "Scottish Fold", LocalDate.of(2023, 4, 22), 1590.04, "Leucemia felina", "https://images.pexels.com/photos/1444751/pexels-photo-1444751.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 67
        petRepository.save(new Pet("Dolly", "Scottish Fold", LocalDate.of(2022, 1, 18), 1867.15, "Problemas respiratorios", "https://images.pexels.com/photos/416195/pexels-photo-416195.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 68
        petRepository.save(new Pet("Kitty", "Noruego de Bosque", LocalDate.of(2015, 5, 2), 4279.74, "Conjuntivitis", "https://images.pexels.com/photos/192384/pexels-photo-192384.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 69
        petRepository.save(new Pet("Gizmo", "Siamés", LocalDate.of(2015, 4, 17), 4284.75, "Gusano del corazón", "https://images.pexels.com/photos/56857/animal-cat-kitten-funny-56857.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 70
        petRepository.save(new Pet("Sushi", "Cornish Rex", LocalDate.of(2023, 5, 13), 1841.63, "Pancreatitis", "https://images.pexels.com/photos/2064110/pexels-photo-2064110.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 71
        petRepository.save(new Pet("Fifi", "Devon Rex", LocalDate.of(2021, 3, 20), 1731.85, "Gingivitis", "https://images.pexels.com/photos/751050/pexels-photo-751050.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 72
        petRepository.save(new Pet("Toby", "Manx", LocalDate.of(2021, 1, 23), 4839.90, "Diarrea", "https://images.pexels.com/photos/137049/pexels-photo-137049.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 73
        petRepository.save(new Pet("Elvis", "Burmés", LocalDate.of(2021, 9, 16), 1177.89, "Conjuntivitis", "https://images.pexels.com/photos/279360/pexels-photo-279360.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 74
        petRepository.save(new Pet("Mimosa", "Noruego de Bosque", LocalDate.of(2020, 1, 8), 2104.97, "Problemas respiratorios", "https://images.pexels.com/photos/599492/pexels-photo-599492.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 75
        petRepository.save(new Pet("Tommy", "Bobtail Japonés", LocalDate.of(2023, 2, 16), 4000.00, "Problemas dentales", "https://images.pexels.com/photos/141496/pexels-photo-141496.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 76
        petRepository.save(new Pet("Galleta", "Noruego de Bosque", LocalDate.of(2020, 1, 10), 2325.24, "Hipertiroidismo", "https://images.pexels.com/photos/731553/pexels-photo-731553.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 77
        petRepository.save(new Pet("Mia", "Sphynx", LocalDate.of(2015, 4, 20), 2389.73, "Gingivitis", "https://images.pexels.com/photos/290263/pexels-photo-290263.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 78
        petRepository.save(new Pet("Dolly", "Siamés", LocalDate.of(2021, 1, 16), 584.26, "Pancreatitis", "https://images.pexels.com/photos/368890/pexels-photo-368890.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 79
        petRepository.save(new Pet("Miau", "Rex Selkirk", LocalDate.of(2015, 9, 26), 2504.69, "Insuficiencia renal", "https://images.pexels.com/photos/1296660/pexels-photo-1296660.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 80
        petRepository.save(new Pet("Oliver", "Bobtail Japonés", LocalDate.of(2020, 10, 3), 4137.16, "Megacolon", "https://images.pexels.com/photos/271889/pexels-photo-271889.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 81
        petRepository.save(new Pet("Max", "Manx", LocalDate.of(2023, 1, 18), 4000.00, "Megacolon", "https://images.pexels.com/photos/1457792/pexels-photo-1457792.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 82
        petRepository.save(new Pet("Mimosa", "Abisinio", LocalDate.of(2021, 4, 6), 3251.59, "Pancreatitis", "https://images.pexels.com/photos/800152/pexels-photo-800152.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 83
        petRepository.save(new Pet("Puma", "Siberiano", LocalDate.of(2021, 10, 28), 1897.08, "Gingivitis", "https://images.pexels.com/photos/1605481/pexels-photo-1605481.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 84
        petRepository.save(new Pet("Mochi", "Manx", LocalDate.of(2016, 8, 16), 1056.00, "Insuficiencia renal", "https://images.pexels.com/photos/162287/cat-british-shorthair-bkh-thoroughbred-162287.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 85
        petRepository.save(new Pet("Chanel", "Siberiano", LocalDate.of(2018, 9, 10), 2085.29, "Conjuntivitis", "https://images.pexels.com/photos/958181/pexels-photo-958181.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 86
        petRepository.save(new Pet("Max", "Rex Selkirk", LocalDate.of(2018, 11, 10), 4246.58, "Resfriado", "https://images.pexels.com/photos/1931367/pexels-photo-1931367.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 87
        petRepository.save(new Pet("Cheesecake", "Siberiano", LocalDate.of(2023, 6, 22), 273.06, "Obesidad", "https://images.pexels.com/photos/1440918/pexels-photo-1440918.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 88
        petRepository.save(new Pet("Selene", "Manx", LocalDate.of(2023, 11, 25), 4580.25, "Gingivitis", "https://images.pexels.com/photos/1492219/pexels-photo-1492219.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 89
        petRepository.save(new Pet("Duke", "Abisinio", LocalDate.of(2015, 7, 25), 4518.07, "Megacolon", "https://images.pexels.com/photos/1255093/pexels-photo-1255093.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 90
        petRepository.save(new Pet("Mimosa", "Sphynx", LocalDate.of(2018, 9, 2), 3417.43, "Rabia", "https://images.pexels.com/photos/161005/cat-kitten-pets-tom-cat-161005.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 91
        petRepository.save(new Pet("Minino", "Devon Rex", LocalDate.of(2016, 1, 13), 293.56, "Problemas respiratorios", "https://images.pexels.com/photos/248304/pexels-photo-248304.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 92
        petRepository.save(new Pet("Minino", "Siberiano", LocalDate.of(2015, 2, 2), 4531.47, "Tumores mamarios", "https://images.pexels.com/photos/1435632/pexels-photo-1435632.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 93
        petRepository.save(new Pet("Simona", "Burmés", LocalDate.of(2016, 8, 19), 2397.58, "Resfriado", "https://images.pexels.com/photos/730896/pexels-photo-730896.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 94
        petRepository.save(new Pet("Duke", "Bobtail Japonés", LocalDate.of(2023, 10, 9), 1072.70, "Enfermedad hepática", "https://images.pexels.com/photos/790033/pexels-photo-790033.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 95
        petRepository.save(new Pet("Sassy", "Bobtail Japonés", LocalDate.of(2023, 9, 6), 4136.58, "Rabia", "https://images.pexels.com/photos/2817422/pexels-photo-2817422.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 96
        petRepository.save(new Pet("Cheesecake", "Maine Coon", LocalDate.of(2016, 1, 24), 163.28, "Parásitos intestinales", "https://images.pexels.com/photos/1398185/pexels-photo-1398185.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 97
        petRepository.save(new Pet("Miau", "Abisinio", LocalDate.of(2017, 10, 14), 2035.42, "Alergias", "https://images.pexels.com/photos/17767/pexels-photo.jpg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 98
        petRepository.save(new Pet("Romeo", "Abisinio", LocalDate.of(2016, 1, 19), 2723.43, "Diabetes", "https://images.pexels.com/photos/55750/wildcat-animal-nature-cat-55750.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 99
        petRepository.save(new Pet("Pompita", "British Shorthair", LocalDate.of(2023, 6, 16), 4338.38, "Megacolon", "https://images.pexels.com/photos/764368/pexels-photo-764368.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 100
        petRepository.save(new Pet("Marshmallow", "Bengalí", LocalDate.of(2018, 5, 19), 3881.17, "Insuficiencia renal", "https://images.pexels.com/photos/1275461/pexels-photo-1275461.jpeg?auto=compress&cs=tinysrgb&w=600"));
        // Crear mascota 101
        petRepository.save(new Pet("Luna", "Bobtail Japonés", LocalDate.of(2022, 3, 20), 4000.00, "Problemas dentales", "https://images.pexels.com/photos/33492/cat-red-cute-mackerel.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
        // Crear mascota 102
        petRepository.save(new Pet("Simba", "Noruego de Bosque", LocalDate.of(2021, 1, 11), 2325.24, "Hipertiroidismo", "https://images.pexels.com/photos/582070/pexels-photo-582070.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
        // Crear mascota 103
        petRepository.save(new Pet("Bigotes", "Sphynx", LocalDate.of(2022, 4, 3), 2389.73, "Gingivitis", "https://images.pexels.com/photos/179237/pexels-photo-179237.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
        // Crear mascota 104
        petRepository.save(new Pet("Maw", "Siamés", LocalDate.of(20212, 1, 10), 2000.26, "Pancreatitis", "https://images.pexels.com/photos/160722/cat-tiger-getiegert-feel-at-home-160722.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
        // Crear mascota 105
        petRepository.save(new Pet("Simba", "Rex Selkirk", LocalDate.of(2015, 9, 21), 2504.69, "Insuficiencia renal", "https://images.pexels.com/photos/51439/pexels-photo-51439.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
        // Crear mascota 106
        petRepository.save(new Pet("Luna", "Bobtail Japonés", LocalDate.of(2021, 10, 3), 4137.16, "Megacolon", "https://images.pexels.com/photos/2646483/pexels-photo-2646483.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
        // Crear mascota 107
        petRepository.save(new Pet("Sassy", "Manx", LocalDate.of(2023, 1, 18), 2500.00, "Megacolon", "https://images.pexels.com/photos/667228/pexels-photo-667228.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
        // Crear mascota 108
        petRepository.save(new Pet("Romeo", "Abisinio", LocalDate.of(2021, 4, 6), 2800.29, "Pancreatitis", "https://images.pexels.com/photos/179222/pexels-photo-179222.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
        // Crear mascota 109
        petRepository.save(new Pet("Mimi", "Siberiano", LocalDate.of(2021, 10, 28), 2189.08, "Gingivitis", "https://images.pexels.com/photos/1107807/pexels-photo-1107807.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
        // Crear mascota 110
        petRepository.save(new Pet("Tommy", "Manx", LocalDate.of(2018, 3, 16), 1029.00, "Insuficiencia renal", "https://images.pexels.com/photos/160839/cat-animal-love-pet-160839.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
        // Crear mascota 111
        petRepository.save(new Pet("Lili", "Siberiano", LocalDate.of(2021, 1, 21), 3900.29, "Conjuntivitis", "https://images.pexels.com/photos/3780890/pexels-photo-3780890.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
        // Crear mascota 112
        petRepository.save(new Pet("Lucy", "Rex Selkirk", LocalDate.of(2022, 11, 10), 4246.58, "Resfriado", "https://images.pexels.com/photos/3581062/pexels-photo-3581062.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
        // Crear mascota 113
        petRepository.save(new Pet("Leo", "Siberiano", LocalDate.of(2023, 6, 22), 3400.06, "Obesidad", "https://images.pexels.com/photos/3652805/pexels-photo-3652805.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
        // Crear mascota 114
        petRepository.save(new Pet("Ziggy", "Manx", LocalDate.of(2017, 10, 25), 4000.25, "Gingivitis", "https://images.pexels.com/photos/16577560/pexels-photo-16577560/free-photo-of-difuso.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
        // Crear mascota 115
        petRepository.save(new Pet("Max", "Abisinio", LocalDate.of(2018, 7, 25), 2010.07, "Megacolon", "https://images.pexels.com/photos/14440674/pexels-photo-14440674.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
        // Crear mascota 116
        petRepository.save(new Pet("Bella", "Sphynx", LocalDate.of(2015, 9, 21), 2500.43, "Rabia", "https://images.pexels.com/photos/16577568/pexels-photo-16577568/free-photo-of-animal-mascota-mono-joven.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
        // Crear mascota 117
        petRepository.save(new Pet("Oreo", "Devon Rex", LocalDate.of(2023, 1, 7), 293.56, "Problemas respiratorios", "https://images.pexels.com/photos/7633208/pexels-photo-7633208.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
        // Crear mascota 118
        petRepository.save(new Pet("Maw", "Siberiano", LocalDate.of(2021, 3, 2), 5000.47, "Tumores mamarios", "https://images.pexels.com/photos/12692139/pexels-photo-12692139.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
        // Crear mascota 119
        petRepository.save(new Pet("Ella", "Burmés", LocalDate.of(2022, 8, 21), 3239.58, "Resfriado", "https://images.pexels.com/photos/13293093/pexels-photo-13293093.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
        // Crear mascota 120
        petRepository.save(new Pet("Oliver", "Bobtail Japonés", LocalDate.of(2018, 10, 9), 4420.70, "Enfermedad hepática", "https://images.pexels.com/photos/16577552/pexels-photo-16577552/free-photo-of-animal-mascota-mono-pelo.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
        // Crear mascota 121
        petRepository.save(new Pet("Max", "Bobtail Japonés", LocalDate.of(2019, 4, 6), 1200.58, "Rabia", "https://images.pexels.com/photos/16482823/pexels-photo-16482823/free-photo-of-animal-mascota-cabeza-gato.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
        // Crear mascota 122
        petRepository.save(new Pet("Fresa", "Maine Coon", LocalDate.of(2020, 1, 24), 3200.28, "Parásitos intestinales", "https://images.pexels.com/photos/6441460/pexels-photo-6441460.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
        // Crear mascota 123
        petRepository.save(new Pet("Whisky", "Abisinio", LocalDate.of(2021, 9, 3), 700.42, "Alergias", "https://images.pexels.com/photos/10863556/pexels-photo-10863556.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
        // Crear mascota 124
        petRepository.save(new Pet("Tequila", "Abisinio", LocalDate.of(2021, 1, 4), 4000.43, "Diabetes", "https://images.pexels.com/photos/12573568/pexels-photo-12573568.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
        // Crear mascota 125
        petRepository.save(new Pet("Cleopatra", "British Shorthair", LocalDate.of(2022, 5, 5), 2000.38, "Megacolon", "https://images.pexels.com/photos/13225461/pexels-photo-13225461.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
        // Crear mascota 126
        petRepository.save(new Pet("Bonifacio", "Persa", LocalDate.now(), 100.00, "Lupus", "https://images.pexels.com/photos/1404819/pexels-photo-1404819.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
        // Crear mascota 127
        petRepository.save(new Pet("Mia", "Siamese", LocalDate.of(2022, 5, 5), 255.00, "Alergias", "https://images.pexels.com/photos/2361952/pexels-photo-2361952.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));
        // Crear mascota 128
        petRepository.save(new Pet("Simba", "Maine Coon", LocalDate.of(2022, 3, 15), 1200.55, "Ninguna", "https://images.pexels.com/photos/1521306/pexels-photo-1521306.jpeg?auto=compress&cs=tinysrgb&w=400"));
        // Crear mascota 129
        petRepository.save(new Pet("Luna", "Persa", LocalDate.of(2022, 8, 20), 900.75, "Ninguna", "https://images.pexels.com/photos/236606/pexels-photo-236606.jpeg?auto=compress&cs=tinysrgb&w=400"));
        // Crear mascota 130
        petRepository.save(new Pet("Rocky", "Sphynx", LocalDate.of(2022, 4, 10), 1600.30, "Asma", "https://images.pexels.com/photos/991831/pexels-photo-991831.jpeg?auto=compress&cs=tinysrgb&w=400"));
        // Crear mascota 131
        petRepository.save(new Pet("Oreo", "Siamese", LocalDate.of(2021, 11, 5), 750.25, "Ninguna", "https://images.pexels.com/photos/736532/pexels-photo-736532.jpeg?auto=compress&cs=tinysrgb&w=400"));
        // Crear mascota 132
        petRepository.save(new Pet("Coco", "Scottish Fold", LocalDate.of(2022, 6, 8), 1100.80, "Ninguna", "https://images.pexels.com/photos/208773/pexels-photo-208773.jpeg?auto=compress&cs=tinysrgb&w=400"));
        // Crear mascota 133
        petRepository.save(new Pet("Toby", "Ragdoll", LocalDate.of(2022, 1, 25), 950.45, "Ninguna", "https://images.pexels.com/photos/2071881/pexels-photo-2071881.jpeg?auto=compress&cs=tinysrgb&w=400"));
        // Crear mascota 134
        petRepository.save(new Pet("Bella", "Siberian", LocalDate.of(2022, 7, 14), 1300.60, "Ninguna", "https://images.pexels.com/photos/1056252/pexels-photo-1056252.jpeg?auto=compress&cs=tinysrgb&w=400"));
        // Crear mascota 135
        petRepository.save(new Pet("Leo", "Maine Coon", LocalDate.of(2022, 2, 9), 1150.35, "Ninguna", "https://images.pexels.com/photos/177809/pexels-photo-177809.jpeg?auto=compress&cs=tinysrgb&w=400"));
        // Crear mascota 136
        petRepository.save(new Pet("Milo", "Bengal", LocalDate.of(2022, 9, 3), 950.75, "Ninguna", "https://images.pexels.com/photos/979003/pexels-photo-979003.jpeg?auto=compress&cs=tinysrgb&w=400"));
        // Crear mascota 137
        petRepository.save(new Pet("Max", "Russian Blue", LocalDate.of(2022, 10, 20), 900.50, "Ninguna", "https://images.pexels.com/photos/1770918/pexels-photo-1770918.jpeg?auto=compress&cs=tinysrgb&w=400"));
        // Crear mascota 138
        petRepository.save(new Pet("Oliver", "Sphynx", LocalDate.of(2022, 11, 15), 1600.40, "Ninguna", "https://www.pexels.com/photo/adult-brown-tabby-cat-747795/"));
        // Crear mascota 139
        petRepository.save(new Pet("Lucy", "Persa", LocalDate.of(2022, 12, 10), 850.70, "Ninguna", "https://images.pexels.com/photos/1120049/pexels-photo-1120049.jpeg?auto=compress&cs=tinysrgb&w=400"));
        // Crear mascota 140
        petRepository.save(new Pet("Charlie", "Siamese", LocalDate.of(2021, 8, 5), 700.55, "Ninguna", "https://images.pexels.com/photos/236660/pexels-photo-236660.jpeg?auto=compress&cs=tinysrgb&w=400"));
        // Crear mascota 141
        petRepository.save(new Pet("Lola", "Ragdoll", LocalDate.of(2022, 5, 18), 975.65, "Ninguna", "https://images.pexels.com/photos/982299/pexels-photo-982299.jpeg?auto=compress&cs=tinysrgb&w=400"));
        // Crear mascota 142
        petRepository.save(new Pet("Chloe", "Scottish Fold", LocalDate.of(2022, 3, 22), 1050.90, "Ninguna", "https://images.pexels.com/photos/2286016/pexels-photo-2286016.jpeg?auto=compress&cs=tinysrgb&w=400"));
        // Crear mascota 143
        petRepository.save(new Pet("Shadow", "British Shorthair", LocalDate.of(2021, 12, 30), 800.80, "Ninguna", "https://images.pexels.com/photos/1440403/pexels-photo-1440403.jpeg?auto=compress&cs=tinysrgb&w=400"));
        // Crear mascota 144
        petRepository.save(new Pet("Lily", "Siberian", LocalDate.of(2022, 6, 7), 1200.70, "Ninguna", "https://images.pexels.com/photos/977933/pexels-photo-977933.jpeg?auto=compress&cs=tinysrgb&w=400"));
        // Crear mascota 145
        petRepository.save(new Pet("Zoe", "Maine Coon", LocalDate.of(2022, 7, 2), 1250.40, "Ninguna", "https://images.pexels.com/photos/121920/pexels-photo-121920.jpeg?auto=compress&cs=tinysrgb&w=400"));
        // Crear mascota 146
        petRepository.save(new Pet("Tiger", "Bengal", LocalDate.of(2022, 4, 12), 950.60, "Ninguna", "https://images.pexels.com/photos/1818608/pexels-photo-1818608.jpeg?auto=compress&cs=tinysrgb&w=400"));
        // Crear mascota 147
        petRepository.save(new Pet("Misty", "Russian Blue", LocalDate.of(2022, 9, 25), 875.75, "Ninguna", "https://images.pexels.com/photos/2064110/pexels-photo-2064110.jpeg?auto=compress&cs=tinysrgb&w=400"));
        // Crear mascota 148
        petRepository.save(new Pet("Mocha", "Sphynx", LocalDate.of(2022, 11, 8), 1600.55, "Ninguna", "https://images.pexels.com/photos/416195/pexels-photo-416195.jpeg?auto=compress&cs=tinysrgb&w=400"));
        // Crear mascota 149
        petRepository.save(new Pet("Cleo", "Siamese", LocalDate.of(2022, 10, 15), 720.45, "Ninguna", "https://images.pexels.com/photos/751050/pexels-photo-751050.jpeg?auto=compress&cs=tinysrgb&w=400"));
        // Crear mascota 150
        petRepository.save(new Pet("Smokey", "Persa", LocalDate.of(2022, 12, 5), 950.80, "Ninguna", "https://images.pexels.com/photos/599492/pexels-photo-599492.jpeg?auto=compress&cs=tinysrgb&w=400"));

    }

    private void createOwners() {
        // Create owner 1
        ownerRepository.save(new Owner(1001298925L, "Esteban", "Gómez", "Buitrago", "3116721345", "esteban.buitrago@gmail.com"));
        // Create owner 2
        ownerRepository.save(new Owner(234567890L, "Jane", "Smith", "Doe", "5555678", "jane.smith@example.com"));
        // Create owner 3
        ownerRepository.save(new Owner(345678901L, "Juan", "Perez", "Perez", "5551784", "jupe@gmail.com"));
        // Create owner 4
        ownerRepository.save(new Owner(456789012L, "Paula", "Niño", "Lopez", "5559837", "pau@gmail.com"));
        // Create owner 5
        ownerRepository.save(new Owner(567890123L, "Pedro", "Quintero", "Relcon", "5552784", "pequint@example.com"));
        // Create owner 6
        ownerRepository.save(new Owner(678901234L, "Pablo", "Andro", "Hulca", "5551344", "hulca@exaple.com"));
        // Create owner 7
        ownerRepository.save(new Owner(789012345L, "Nathalie", "Hurtado", "Rojas", "7872432", "nathur@example.com"));
        // Create owner 8
        ownerRepository.save(new Owner(890123456L, "Nashly", "Valto", "Torres", "4323555", "nash@example.com"));
        // Create owner 9
        ownerRepository.save(new Owner(901234567L, "Janeth", "Cantero", "Gil", "9855432", "cantja@example.com"));
        // Create owner 10
        ownerRepository.save(new Owner(987654321L, "Enrrique", "Maldonado", "Polo", "9873748", "enrri@example.com "));
        // Create owner 11
        ownerRepository.save(new Owner(876543210L, "Eduardo", "Cruz", "Bolivar", "8752333", "eduardo@example.com"));
        // Create owner 12
        ownerRepository.save(new Owner(765432109L, "María", "Morales", "Rivera", "3225800", "mam@gmail.com"));
        // Create owner 13
        ownerRepository.save(new Owner(654321098L, "Miguel", "Uribe", "Velez", "3238876", "migue@example.com"));
        // Create owner 14
        ownerRepository.save(new Owner(543210987L, "Raul", "Nivia", "Velez", "3238888", "rau@example.com"));
        // Create owner 15
        ownerRepository.save(new Owner(432109876L, "Nelson", "Jimenez", "Alteri", "3230374", "neljia@example.com"));
        // Create owner 16
        ownerRepository.save(new Owner(210987654L, "Jimena", "Alvarez", "Estrada", "3237483", "jimeal@example.com"));
        // Create owner 17
        ownerRepository.save(new Owner(339527439L, "Alberto", "Nuñez", "Navarro", "6464316", "AlNuNa@example.com"));
        // create owner 18
        ownerRepository.save(new Owner(389629107L, "Alejandra", "Alvarez", "Chaparro", "7634480", "AlAlCh@example.com"));
        // create owner 19
        ownerRepository.save(new Owner(625390588L, "Paula", "Ortega", "Parra", "3228670", "PaOrPa@example.com"));
        // create owner 20
        ownerRepository.save(new Owner(854299681L, "Luis", "Silva", "Bustos", "7841868", "LuSiBu@example.com"));
        // create owner 21
        ownerRepository.save(new Owner(996211128L, "Alex", "Sanchez", "Galvis", "3005175", "AlSaGa@example.com"));
        // create owner 22
        ownerRepository.save(new Owner(813299857L, "Sebastian", "Alvarez", "Parada", "5106842", "SeAlPa@example.com"));
        // create owner 23
        ownerRepository.save(new Owner(542045102L, "Sara", "Castro", "Peña", "4724792", "SaCaPe@example.com"));
        // create owner 24
        ownerRepository.save(new Owner(378517623L, "Sara", "Linares", "Fuentes", "9073534", "SaLiFu@example.com"));
        // create owner 25
        ownerRepository.save(new Owner(420390569L, "Circe", "Castillo", "Salas", "1639592", "CiCaSa@example.com"));
        // create owner 26
        ownerRepository.save(new Owner(936618990L, "Andres", "Castillo", "Restrepo", "1243110", "AnCaRe@example.com"));
        // create owner 27
        ownerRepository.save(new Owner(455807491L, "Lety", "Rojas", "Chaparro", "4018208", "LeRoCh@example.com"));
        // create owner 28
        ownerRepository.save(new Owner(321227151L, "Alex", "Romero", "Zuñiga", "1299908", "AlRoZu@example.com"));
        // create owner 29
        ownerRepository.save(new Owner(892201172L, "Sara", "Parada", "Salas", "7293452", "SaPaSa@example.com"));
        // create owner 30
        ownerRepository.save(new Owner(560136473L, "Alejandro", "Gonzalez", "Ahumada", "6444285", "AlGoAh@example.com"));
        // create owner 31
        ownerRepository.save(new Owner(804999127L, "Nashly", "Silva", "Castillo", "4248438", "NaSiCa@example.com"));
        // create owner 32
        ownerRepository.save(new Owner(510972620L, "Jane", "Molina", "Lara", "7466902", "JaMoLa@example.com"));
        // create owner 33
        ownerRepository.save(new Owner(475470342L, "Enrrique", "Linares", "Castrillon", "7522873", "EnLiCa@example.com"));
        // create owner 34
        ownerRepository.save(new Owner(580071667L, "Juan", "Castro", "Zuñiga", "2646743", "JuCaZu@example.com"));
        // create owner 35
        ownerRepository.save(new Owner(257138356L, "Sofia", "Vasquez", "Restrepo", "8728577", "SoVaRe@example.com"));
        // create owner 36
        ownerRepository.save(new Owner(966440715L, "Nashly", "Castro", "Peña", "7943177", "NaCaPe@example.com"));
        // create owner 37
        ownerRepository.save(new Owner(124226767L, "Alberto", "Gómez", "Campos", "3457259", "AlGóCa@example.com"));
        // create owner 38
        ownerRepository.save(new Owner(698247603L, "Alejandro", "Alvarez", "Mendez", "4162734", "AlAlMe@example.com"));
        // create owner 39
        ownerRepository.save(new Owner(378490151L, "Alejandro", "Lopez", "Campos", "1636449", "AlLoCa@example.com"));
        // create owner 40
        ownerRepository.save(new Owner(821559054L, "María", "Romero", "Ahumada", "4374921", "MaRoAh@example.com"));
        // create owner 41
        ownerRepository.save(new Owner(640537211L, "Sebastian", "Morales", "Restrepo", "7952017", "SeMoRe@example.com"));
        // create owner 42
        ownerRepository.save(new Owner(938522664L, "Fernanda", "Silva", "Paredes", "9301132", "FeSiPa@example.com"));
        // create owner 43
        ownerRepository.save(new Owner(258352672L, "Erick", "Fernandez", "Chaparro", "3983051", "ErFeCh@example.com"));
        // create owner 44
        ownerRepository.save(new Owner(146073939L, "Oswaldo", "Linares", "Montoya", "4691450", "OsLiMo@example.com"));
        // create owner 45
        ownerRepository.save(new Owner(883159347L, "Alberto", "Buitrago", "Guerrero", "9776421", "AlBuGu@example.com"));
        // create owner 46
        ownerRepository.save(new Owner(661240045L, "Camilo", "Aguilar", "Cortes", "4661696", "CaAgCo@example.com"));
        // create owner 47
        ownerRepository.save(new Owner(517987000L, "Nathalie", "Silva", "Campos", "6793730", "NaSiCam@example.com"));
        // create owner 48
        ownerRepository.save(new Owner(572035520L, "Janeth", "Cabrera", "Miranda", "3305345", "JaCaMi@example.com"));
        // create owner 49
        ownerRepository.save(new Owner(167717438L, "Paula", "Hernandez", "Cortez", "1098594", "PaHeCo@example.com"));
        // create owner 50
        ownerRepository.save(new Owner(511947917L, "Eduardo", "Castillo", "Cortez", "2316386", "EdCaCo@example.com"));
        // create owner 51
        ownerRepository.save(new Owner(846422107L, "Sara", "Rodriguez", "Valencia", "9981032", "SaRoVa@example.com"));
        // create owner 52
        ownerRepository.save(new Owner(210241221L, "Sara", "Castro", "Lara", "2584197", "SaCaLa@example.com"));
        // create owner 53
        ownerRepository.save(new Owner(110619556L, "Sebastian", "Fernandez", "Mendoza", "2278777", "SeFeMe@example.com"));
        // create owner 54
        ownerRepository.save(new Owner(634672894L, "Camilo", "Rojas", "Chavez", "7865377", "CaRoCh@example.com"));
        // create owner 55
        ownerRepository.save(new Owner(975570482L, "Kevin", "Perez", "Torres", "8259213", "KePeTo@example.com"));
        // create owner 56
        ownerRepository.save(new Owner(547961919L, "Nathalie", "Castillo", "Aguilar", "3935301", "NaCaAg@example.com"));
        // create owner 57
        ownerRepository.save(new Owner(829169492L, "Oswaldo", "Hernandez", "Pinto", "4819985", "OsHePi@example.com"));
        // create owner 58
        ownerRepository.save(new Owner(549243502L, "Nathalie", "Ramirez", "Campos", "9388464", "NaRaCa@example.com"));
        // create owner 59
        ownerRepository.save(new Owner(196416649L, "Alejandra", "Silva", "Valencia", "9822918", "AlSiVa@example.com"));
        // create owner 60
        ownerRepository.save(new Owner(567352636L, "Sebastian", "Gomez", "Restrepo", "4602777", "SeGoRe@example.com"));
        // create owner 61
        ownerRepository.save(new Owner(798173831L, "Pablo", "Rodriguez", "Parada", "7579155", "PaRoPa@example.com"));
        // create owner 62
        ownerRepository.save(new Owner(655985260L, "John", "Romero", "Peña", "7391355", "JoRoPe@example.com"));
        // create owner 63
        ownerRepository.save(new Owner(455935310L, "Luis", "Linares", "Chavez", "9025652", "LuLiCh@example.com"));
        // create owner 64
        ownerRepository.save(new Owner(657949991L, "Alberto", "Ruiz", "Ahumada", "7569365", "AlRuAh@example.com"));
        // create owner 65
        ownerRepository.save(new Owner(984312956L, "Oswaldo", "Ramirez", "Lara", "3372955", "OsRaLa@example.com"));
        // create owner 66
        ownerRepository.save(new Owner(539264339L, "Sandra", "Rojas", "Sepulveda", "7499509", "SaRoSe@example.com"));
        // create owner 67
        ownerRepository.save(new Owner(677979915L, "Circe", "Linares", "Torres", "5744770", "CiLiTo@example.com"));
        // create owner 68
        ownerRepository.save(new Owner(622637951L, "Oswaldo", "Rodriguez", "Chaparro", "6573517", "OsRoCh@example.com"));
        // create owner 69
        ownerRepository.save(new Owner(136989434L, "Pedro", "Vargas", "Chavez", "9301463", "PeVaCh@example.com"));
        // create owner 70
        ownerRepository.save(new Owner(890223436L, "Nathalie", "Castro", "Paredes", "6412083", "NaCaPa@example.com"));
        // create owner 71
        ownerRepository.save(new Owner(149819435L, "Lety", "Parada", "Valencia", "9386544", "LePaVa@example.com"));
        // create owner 72
        ownerRepository.save(new Owner(283639477L, "Luis", "Torres", "Aguilar", "6408054", "LuToAg@example.com"));
        // create owner 73
        ownerRepository.save(new Owner(198897671L, "María", "Ramirez", "Sepulveda", "9689679", "MaRaSe@example.com"));
        // create owner 74
        ownerRepository.save(new Owner(316420753L, "Pedro", "Castillo", "Cortes", "3008839", "PeCaCo@example.com"));
        // create owner 75
        ownerRepository.save(new Owner(407918405L, "Javier", "Aguilar", "Lara", "8883505", "JaAgLa@example.com"));
        // create owner 76
        ownerRepository.save(new Owner(587267274L, "Andres", "Perez", "Chavez", "4644344", "AnPeCh@example.com"));
        // create owner 77
        ownerRepository.save(new Owner(441949057L, "Alberto", "Linares", "Paredes", "4267491", "AlLiPa@example.com"));
        // create owner 78
        ownerRepository.save(new Owner(310161583L, "Nashly", "Lopez", "Guerrero", "2603706", "NaLoGu@example.com"));
        // create owner 79
        ownerRepository.save(new Owner(605919683L, "Eduardo", "Gomez", "Restrepo", "6495981", "EdGoRe@example.com"));
        // create owner 80
        ownerRepository.save(new Owner(463325005L, "Fernanda", "Castillo", "Guerrero", "7491092", "FeCaGu@example.com"));
        // create owner 81
        ownerRepository.save(new Owner(269631169L, "Valentina", "Gomez", "Guerrero", "7542338", "VaGoGu@example.com"));
        // create owner 82
        ownerRepository.save(new Owner(859507885L, "Fernanda", "Jimenez", "Mendez", "4834142", "FeJiMe@example.com"));
        // create owner 83
        ownerRepository.save(new Owner(821776320L, "Paula", "Fernandez", "Navarro", "4576609", "PaFeNa@example.com"));
        // create owner 84
        ownerRepository.save(new Owner(265561323L, "Javier", "Martinez", "Parada", "4846325", "JaMaPa@example.com"));
        // create owner 85
        ownerRepository.save(new Owner(261740316L, "Jane", "Castillo", "Castillo", "6524985", "JaCaCa@example.com"));
        // create owner 86
        ownerRepository.save(new Owner(736308868L, "Lety", "Lopez", "Vergara", "1892702", "LeLoVe@example.com"));
        // create owner 87
        ownerRepository.save(new Owner(633532182L, "John", "Buitrago", "Poblete", "3931417", "JoBuPo@example.com"));
        // create owner 88
        ownerRepository.save(new Owner(505348574L, "Ana", "Guevara", "Bustos", "4461792", "AnGuBu@example.com"));
        // create owner 89
        ownerRepository.save(new Owner(519433567L, "Lina", "Cabrera", "Poblete", "9758363", "LiCaPo@example.com"));
        // create owner 90
        ownerRepository.save(new Owner(171713906L, "Ana", "Castillo", "Cruz", "5738941", "AnCaCr@example.com"));
        // create owner 91
        ownerRepository.save(new Owner(803775996L, "Alejandra", "Gonzalez", "Araya", "4202395", "AlGoAr@example.com"));
        // create owner 92
        ownerRepository.save(new Owner(322812909L, "Luis", "Ramirez", "Mendoza", "1993433", "LuRaMe@example.com"));
        // create owner 93
        ownerRepository.save(new Owner(999815923L, "Eduardo", "Garcia", "Rivas", "3187199", "EdGaRi@example.com"));
        // create owner 94
        ownerRepository.save(new Owner(883499951L, "Valentina", "Nuñez", "Pardo", "9829251", "VaNuPa@example.com"));
        // create owner 95
        ownerRepository.save(new Owner(322472122L, "Andres", "Sanchez", "Parra", "1147552", "AnSaPa@example.com"));
        // create owner 96
        ownerRepository.save(new Owner(119668984L, "Juliana", "Silva", "Miranda", "4185874", "JuSiMi@example.com"));
        // create owner 97
        ownerRepository.save(new Owner(225991741L, "Oswaldo", "Castro", "Fuentes", "3826947", "OsCaFu@example.com"));
        // create owner 98
        ownerRepository.save(new Owner(705030352L, "Pablo", "Alvarez", "Salas", "3762996", "PaAlSa@example.com"));
        // create owner 99
        ownerRepository.save(new Owner(235716052L, "Valentina", "Castillo", "Araya", "1514406", "VaCaAr@example.com"));
        // create owner 100
        ownerRepository.save(new Owner(646094641L, "Ana", "Ortega", "Paredes", "5902212", "AnOrPa@example.com"));
    }
    private void createDrugs(){
        try {
            InputStream file = getClass().getClassLoader().getResourceAsStream("MEDICAMENTOS_VETERINARIA.xlsx");
           // FileInputStream file = new FileInputStream(new File("/resources/MEDICAMENTOS_VETERINARIA.xlsx"));
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheet("MEDICAMENTOS BD FINAL");
            for(int rowIndex =1; rowIndex <= sheet.getLastRowNum(); rowIndex++){
                Row row = sheet.getRow(rowIndex);
                if(row != null){
                    Drug drug = new Drug();
                    drug.setName(row.getCell(0).getStringCellValue());
                    drug.setSellPrice((float) row.getCell(1).getNumericCellValue());
                    drug.setBuyPrice((float) row.getCell(2).getNumericCellValue());
                    drug.setItemsAvailable((int) row.getCell(3).getNumericCellValue());
                    drug.setItemsSell((int) row.getCell(4).getNumericCellValue());
                    drugRepository.save(drug);
                }
            }

            if(workbook != null){
                workbook.close();
            }
            file.close();
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
    private void createTreatments(){
        // Create and save treatment 1
        treatmentRepository.save(new Treatment(LocalDate.of(2023, 9, 20),  "Se le dió al felino el primer comprimido de FELIMAZOLE, revisión dentro de 12 horas."));
        // Create and save treatment 2
        treatmentRepository.save(new Treatment(LocalDate.of(2023, 9, 28), "Se administró Famciclovir para tratar la rinotraqueítis felina. Se realizará un seguimiento en 24 horas.") );
        // Create and save treatment 3
        treatmentRepository.save(new Treatment(LocalDate.of(2021, 5, 10), "Se aplicó PawPain Away al gato para aliviar el dolor en las patas. Revisión dentro de 12 horas para evaluar el alivio del dolor."));
        // Create and save treatment 4
        treatmentRepository.save(new Treatment(LocalDate.of(2022, 7, 25), "Se suministró WhiskerWellness al gato para mejorar su bienestar general y salud. Próxima revisión en 24 horas."));
        // Create and save treatment 5
        treatmentRepository.save(new Treatment(LocalDate.of(2022, 9, 1), "Se administró Purrfect Health para mantener la salud óptima del gato. Se evaluarán los resultados en 24 horas."));
        // Create and save treatment 6
        treatmentRepository.save(new Treatment(LocalDate.of(2021, 11, 8), "Se dio MeowMend al gato para ayudar en la recuperación de heridas o lesiones. Próxima revisión en 12 horas."));
        // Create and save treatment 7
        treatmentRepository.save(new Treatment(LocalDate.of(2020, 2, 12), "Se administró PawPrint Pain Relief para aliviar el dolor del gato. Revisión dentro de 12 horas para evaluar la eficacia."));
        // Create and save treatment 8
        treatmentRepository.save(new Treatment(LocalDate.of(2019, 4, 6), "Se administró FishOil Feline para promover la salud cardiovascular y del pelaje en el gato. Se evaluará su progreso en 24 horas."));
        // Create and save treatment 9
        treatmentRepository.save(new Treatment(LocalDate.of(2020, 6, 19), "Se administraron KittyCalm Drops al gato para reducir la ansiedad y el estrés. Próxima revisión en 12 horas."));
        // Create and save treatment 10
        treatmentRepository.save(new Treatment(LocalDate.of(2023, 8, 27), "Se aplicó WhiskerWonder Elixir al gato para mejorar su bienestar general y vitalidad. Revisión en 24 horas para evaluar su efectividad."));
    }
}
