package com.bigotes.app.controller;

import com.bigotes.app.model.Owner;
import com.bigotes.app.model.Pet;
import com.bigotes.app.repository.OwnerRepository;
import com.bigotes.app.repository.PetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
@Transactional
public class DbController implements ApplicationRunner {
    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    PetRepository petRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Create owner 1
        ownerRepository.save(new Owner(
                123456789L, "John", "Doe", "Smith",
                "555-1234", "john.doe@example.com"));

        // Create owner 2
        ownerRepository.save(new Owner(
                234567890L, "Jane", "Smith", "Doe",
                "555-5678", "jane.smith@example.com"));
        // Create owner 3
        ownerRepository.save(new Owner(
                345678901L, "Juan", "Perez", "Perez",
                "555-1784", "jupe@gmail.com"));
        // Create owner 4
        ownerRepository.save(new Owner(
                456789012L, "Paula", "Niño", "Lopez",
                "555-9837", "pau@gmail.com"));
        // Create owner 5
        ownerRepository.save(new Owner(
                567890123L, "Pedro", "Quintero", "Relcon",
                "555-2784", "pequint@example.com"));
        // Create owner 6
        ownerRepository.save(new Owner(
                678901234L, "Pablo", "Andro", "Hulca",
                "555-1344", "hulca@exaple.com"));
        // Create owner 7
        ownerRepository.save(new Owner(
                789012345L, "Nathalie", "Hurtado", "Rojas",
                "787-2432", "nathur@example.com"));
        // Create owner 8
        ownerRepository.save(new Owner(
                890123456L, "Nashly", "Valto", "Torres",
                "432-3555", "nash@example.com"));
        // Create owner 9
        ownerRepository.save(new Owner(
                901234567L, "Janeth", "Cantero", "Gil",
                "985-5432", "cantja@example.com"));
        // Create owner 10
        ownerRepository.save(new Owner(
                987654321L, "Enrrique", "Maldonado", "Polo",
                "987-3748", "enrri@example.com "));
        // Create owner 11
        ownerRepository.save(new Owner(
                876543210L, "Eduardo", "Cruz", "Bolivar",
                "875-2333", "eduardo@example.com"));
        // Create owner 12
        ownerRepository.save(new Owner(
                765432109L, "María", "Morales", "Rivera",
                "322-5800", "mam@gmail.com"));
        // Create owner 13
        ownerRepository.save(new Owner(
                654321098L, "Miguel", "Uribe", "Velez",
                "323-8876", "migue@example.com"));
        // Create owner 14
        ownerRepository.save(new Owner(
                543210987L, "Raul", "Nivia", "Velez",
                "323-8888", "rau@example.com"));
        // Create owner 15
        ownerRepository.save(new Owner(
                432109876L, "Nelson", "Jimenez", "Alteri",
                "323-0374", "neljia@example.com"));
        // Create owner 16
        ownerRepository.save(new Owner(
                210987654L, "Jimena", "Alvarez", "Estrada",
                "323-7483", "jimeal@example.com"));
        // Create owner 17
        // create owner 17
        ownerRepository.save(new Owner(339527439L, "Alberto", "Nuñez", "Navarro", "646-4316", "AlNuNa@example.com"));
        // create owner 18
        ownerRepository
                .save(new Owner(389629107L, "Alejandra", "Alvarez", "Chaparro", "763-4480", "AlAlCh@example.com"));
        // create owner 19
        ownerRepository.save(new Owner(625390588L, "Paula", "Ortega", "Parra", "322-8670", "PaOrPa@example.com"));
        // create owner 20
        ownerRepository.save(new Owner(854299681L, "Luis", "Silva", "Bustos", "784-1868", "LuSiBu@example.com"));
        // create owner 21
        ownerRepository.save(new Owner(996211128L, "Alex", "Sanchez", "Galvis", "300-5175", "AlSaGa@example.com"));
        // create owner 22
        ownerRepository.save(new Owner(813299857L, "Sebastian", "Alvarez", "Parada", "510-6842", "SeAlPa@example.com"));
        // create owner 23
        ownerRepository.save(new Owner(542045102L, "Sara", "Castro", "Peña", "472-4792", "SaCaPe@example.com"));
        // create owner 24
        ownerRepository.save(new Owner(378517623L, "Sara", "Linares", "Fuentes", "907-3534", "SaLiFu@example.com"));
        // create owner 25
        ownerRepository.save(new Owner(420390569L, "Circe", "Castillo", "Salas", "163-9592", "CiCaSa@example.com"));
        // create owner 26
        ownerRepository.save(new Owner(936618990L, "Andres", "Castillo", "Restrepo", "124-3110", "AnCaRe@example.com"));
        // create owner 27
        ownerRepository.save(new Owner(455807491L, "Lety", "Rojas", "Chaparro", "401-8208", "LeRoCh@example.com"));
        // create owner 28
        ownerRepository.save(new Owner(321227151L, "Alex", "Romero", "Zuñiga", "129-9908", "AlRoZu@example.com"));
        // create owner 29
        ownerRepository.save(new Owner(892201172L, "Sara", "Parada", "Salas", "729-3452", "SaPaSa@example.com"));
        // create owner 30
        ownerRepository
                .save(new Owner(560136473L, "Alejandro", "Gonzalez", "Ahumada", "644-4285", "AlGoAh@example.com"));
        // create owner 31
        ownerRepository.save(new Owner(804999127L, "Nashly", "Silva", "Castillo", "424-8438", "NaSiCa@example.com"));
        // create owner 32
        ownerRepository.save(new Owner(510972620L, "Jane", "Molina", "Lara", "746-6902", "JaMoLa@example.com"));
        // create owner 33
        ownerRepository
                .save(new Owner(475470342L, "Enrrique", "Linares", "Castrillon", "752-2873", "EnLiCa@example.com"));
        // create owner 34
        ownerRepository.save(new Owner(580071667L, "Juan", "Castro", "Zuñiga", "264-6743", "JuCaZu@example.com"));
        // create owner 35
        ownerRepository.save(new Owner(257138356L, "Sofia", "Vasquez", "Restrepo", "872-8577", "SoVaRe@example.com"));
        // create owner 36
        ownerRepository.save(new Owner(966440715L, "Nashly", "Castro", "Peña", "794-3177", "NaCaPe@example.com"));
        // create owner 37
        ownerRepository.save(new Owner(124226767L, "Alberto", "Gómez", "Campos", "345-7259", "AlGóCa@example.com"));
        // create owner 38
        ownerRepository.save(new Owner(698247603L, "Alejandro", "Alvarez", "Mendez", "416-2734", "AlAlMe@example.com"));
        // create owner 39
        ownerRepository.save(new Owner(378490151L, "Alejandro", "Lopez", "Campos", "163-6449", "AlLoCa@example.com"));
        // create owner 40
        ownerRepository.save(new Owner(821559054L, "María", "Romero", "Ahumada", "437-4921", "MaRoAh@example.com"));
        // create owner 41
        ownerRepository
                .save(new Owner(640537211L, "Sebastian", "Morales", "Restrepo", "795-2017", "SeMoRe@example.com"));
        // create owner 42
        ownerRepository.save(new Owner(938522664L, "Fernanda", "Silva", "Paredes", "930-1132", "FeSiPa@example.com"));
        // create owner 43
        ownerRepository.save(new Owner(258352672L, "Erick", "Fernandez", "Chaparro", "398-3051", "ErFeCh@example.com"));
        // create owner 44
        ownerRepository.save(new Owner(146073939L, "Oswaldo", "Linares", "Montoya", "469-1450", "OsLiMo@example.com"));
        // create owner 45
        ownerRepository
                .save(new Owner(883159347L, "Alberto", "Buitrago", "Guerrero", "977-6421", "AlBuGu@example.com"));
        // create owner 46
        ownerRepository.save(new Owner(661240045L, "Camilo", "Aguilar", "Cortes", "466-1696", "CaAgCo@example.com"));
        // create owner 47
        ownerRepository.save(new Owner(517987000L, "Nathalie", "Silva", "Campos", "679-3730", "NaSiCam@example.com"));
        // create owner 48
        ownerRepository.save(new Owner(572035520L, "Janeth", "Cabrera", "Miranda", "330-5345", "JaCaMi@example.com"));
        // create owner 49
        ownerRepository.save(new Owner(167717438L, "Paula", "Hernandez", "Cortez", "109-8594", "PaHeCo@example.com"));
        // create owner 50
        ownerRepository.save(new Owner(511947917L, "Eduardo", "Castillo", "Cortez", "231-6386", "EdCaCo@example.com"));
        // create owner 51
        ownerRepository.save(new Owner(846422107L, "Sara", "Rodriguez", "Valencia", "998-1032", "SaRoVa@example.com"));
        // create owner 52
        ownerRepository.save(new Owner(210241221L, "Sara", "Castro", "Lara", "258-4197", "SaCaLa@example.com"));
        // create owner 53
        ownerRepository
                .save(new Owner(110619556L, "Sebastian", "Fernandez", "Mendoza", "227-8777", "SeFeMe@example.com"));
        // create owner 54
        ownerRepository.save(new Owner(634672894L, "Camilo", "Rojas", "Chavez", "786-5377", "CaRoCh@example.com"));
        // create owner 55
        ownerRepository.save(new Owner(975570482L, "Kevin", "Perez", "Torres", "825-9213", "KePeTo@example.com"));
        // create owner 56
        ownerRepository
                .save(new Owner(547961919L, "Nathalie", "Castillo", "Aguilar", "393-5301", "NaCaAg@example.com"));
        // create owner 57
        ownerRepository.save(new Owner(829169492L, "Oswaldo", "Hernandez", "Pinto", "481-9985", "OsHePi@example.com"));
        // create owner 58
        ownerRepository.save(new Owner(549243502L, "Nathalie", "Ramirez", "Campos", "938-8464", "NaRaCa@example.com"));
        // create owner 59
        ownerRepository.save(new Owner(196416649L, "Alejandra", "Silva", "Valencia", "982-2918", "AlSiVa@example.com"));
        // create owner 60
        ownerRepository.save(new Owner(567352636L, "Sebastian", "Gomez", "Restrepo", "460-2777", "SeGoRe@example.com"));
        // create owner 61
        ownerRepository.save(new Owner(798173831L, "Pablo", "Rodriguez", "Parada", "757-9155", "PaRoPa@example.com"));
        // create owner 62
        ownerRepository.save(new Owner(655985260L, "John", "Romero", "Peña", "739-1355", "JoRoPe@example.com"));
        // create owner 63
        ownerRepository.save(new Owner(455935310L, "Luis", "Linares", "Chavez", "902-5652", "LuLiCh@example.com"));
        // create owner 64
        ownerRepository.save(new Owner(657949991L, "Alberto", "Ruiz", "Ahumada", "756-9365", "AlRuAh@example.com"));
        // create owner 65
        ownerRepository.save(new Owner(984312956L, "Oswaldo", "Ramirez", "Lara", "337-2955", "OsRaLa@example.com"));
        // create owner 66
        ownerRepository.save(new Owner(539264339L, "Sandra", "Rojas", "Sepulveda", "749-9509", "SaRoSe@example.com"));
        // create owner 67
        ownerRepository.save(new Owner(677979915L, "Circe", "Linares", "Torres", "574-4770", "CiLiTo@example.com"));
        // create owner 68
        ownerRepository
                .save(new Owner(622637951L, "Oswaldo", "Rodriguez", "Chaparro", "657-3517", "OsRoCh@example.com"));
        // create owner 69
        ownerRepository.save(new Owner(136989434L, "Pedro", "Vargas", "Chavez", "930-1463", "PeVaCh@example.com"));
        // create owner 70
        ownerRepository.save(new Owner(890223436L, "Nathalie", "Castro", "Paredes", "641-2083", "NaCaPa@example.com"));
        // create owner 71
        ownerRepository.save(new Owner(149819435L, "Lety", "Parada", "Valencia", "938-6544", "LePaVa@example.com"));
        // create owner 72
        ownerRepository.save(new Owner(283639477L, "Luis", "Torres", "Aguilar", "640-8054", "LuToAg@example.com"));
        // create owner 73
        ownerRepository.save(new Owner(198897671L, "María", "Ramirez", "Sepulveda", "968-9679", "MaRaSe@example.com"));
        // create owner 74
        ownerRepository.save(new Owner(316420753L, "Pedro", "Castillo", "Cortes", "300-8839", "PeCaCo@example.com"));
        // create owner 75
        ownerRepository.save(new Owner(407918405L, "Javier", "Aguilar", "Lara", "888-3505", "JaAgLa@example.com"));
        // create owner 76
        ownerRepository.save(new Owner(587267274L, "Andres", "Perez", "Chavez", "464-4344", "AnPeCh@example.com"));
        // create owner 77
        ownerRepository.save(new Owner(441949057L, "Alberto", "Linares", "Paredes", "426-7491", "AlLiPa@example.com"));
        // create owner 78
        ownerRepository.save(new Owner(310161583L, "Nashly", "Lopez", "Guerrero", "260-3706", "NaLoGu@example.com"));
        // create owner 79
        ownerRepository.save(new Owner(605919683L, "Eduardo", "Gomez", "Restrepo", "649-5981", "EdGoRe@example.com"));
        // create owner 80
        ownerRepository
                .save(new Owner(463325005L, "Fernanda", "Castillo", "Guerrero", "749-1092", "FeCaGu@example.com"));
        // create owner 81
        ownerRepository.save(new Owner(269631169L, "Valentina", "Gomez", "Guerrero", "754-2338", "VaGoGu@example.com"));
        // create owner 82
        ownerRepository.save(new Owner(859507885L, "Fernanda", "Jimenez", "Mendez", "483-4142", "FeJiMe@example.com"));
        // create owner 83
        ownerRepository.save(new Owner(821776320L, "Paula", "Fernandez", "Navarro", "457-6609", "PaFeNa@example.com"));
        // create owner 84
        ownerRepository.save(new Owner(265561323L, "Javier", "Martinez", "Parada", "484-6325", "JaMaPa@example.com"));
        // create owner 85
        ownerRepository.save(new Owner(261740316L, "Jane", "Castillo", "Castillo", "652-4985", "JaCaCa@example.com"));
        // create owner 86
        ownerRepository.save(new Owner(736308868L, "Lety", "Lopez", "Vergara", "189-2702", "LeLoVe@example.com"));
        // create owner 87
        ownerRepository.save(new Owner(633532182L, "John", "Buitrago", "Poblete", "393-1417", "JoBuPo@example.com"));
        // create owner 88
        ownerRepository.save(new Owner(505348574L, "Ana", "Guevara", "Bustos", "446-1792", "AnGuBu@example.com"));
        // create owner 89
        ownerRepository.save(new Owner(519433567L, "Lina", "Cabrera", "Poblete", "975-8363", "LiCaPo@example.com"));
        // create owner 90
        ownerRepository.save(new Owner(171713906L, "Ana", "Castillo", "Cruz", "573-8941", "AnCaCr@example.com"));
        // create owner 91
        ownerRepository.save(new Owner(803775996L, "Alejandra", "Gonzalez", "Araya", "420-2395", "AlGoAr@example.com"));
        // create owner 92
        ownerRepository.save(new Owner(322812909L, "Luis", "Ramirez", "Mendoza", "199-3433", "LuRaMe@example.com"));
        // create owner 93
        ownerRepository.save(new Owner(999815923L, "Eduardo", "Garcia", "Rivas", "318-7199", "EdGaRi@example.com"));
        // create owner 94
        ownerRepository.save(new Owner(883499951L, "Valentina", "Nuñez", "Pardo", "982-9251", "VaNuPa@example.com"));
        // create owner 95
        ownerRepository.save(new Owner(322472122L, "Andres", "Sanchez", "Parra", "114-7552", "AnSaPa@example.com"));
        // create owner 96
        ownerRepository.save(new Owner(119668984L, "Juliana", "Silva", "Miranda", "418-5874", "JuSiMi@example.com"));
        // create owner 97
        ownerRepository.save(new Owner(225991741L, "Oswaldo", "Castro", "Fuentes", "382-6947", "OsCaFu@example.com"));
        // create owner 98
        ownerRepository.save(new Owner(705030352L, "Pablo", "Alvarez", "Salas", "376-2996", "PaAlSa@example.com"));
        // create owner 99
        ownerRepository.save(new Owner(235716052L, "Valentina", "Castillo", "Araya", "151-4406", "VaCaAr@example.com"));
        // create owner 100
        ownerRepository.save(new Owner(646094641L, "Ana", "Ortega", "Paredes", "590-2212", "AnOrPa@example.com"));

        petRepository
                .save(new Pet("Bonifacio", "Persa", new Date(), 4.0, "Lupus", "https://placekitten.com/g/200/300"));

        Owner asociar = ownerRepository.findById(1L).get();
        for (Pet pet : petRepository.findAll()) {
            pet.setOwner(asociar);
            petRepository.save(pet);
        }
    }
}
