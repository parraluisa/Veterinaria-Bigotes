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
                "5551234", "john.doe@example.com"));

        // Create owner 2
        ownerRepository.save(new Owner(
                234567890L, "Jane", "Smith", "Doe",
                "5555678", "jane.smith@example.com"));
        // Create owner 3
        ownerRepository.save(new Owner(
                345678901L, "Juan", "Perez", "Perez",
                "5551784", "jupe@gmail.com"));
        // Create owner 4
        ownerRepository.save(new Owner(
                456789012L, "Paula", "Niño", "Lopez",
                "5559837", "pau@gmail.com"));
        // Create owner 5
        ownerRepository.save(new Owner(
                567890123L, "Pedro", "Quintero", "Relcon",
                "5552784", "pequint@example.com"));
        // Create owner 6
        ownerRepository.save(new Owner(
                678901234L, "Pablo", "Andro", "Hulca",
                "5551344", "hulca@exaple.com"));
        // Create owner 7
        ownerRepository.save(new Owner(
                789012345L, "Nathalie", "Hurtado", "Rojas",
                "7872432", "nathur@example.com"));
        // Create owner 8
        ownerRepository.save(new Owner(
                890123456L, "Nashly", "Valto", "Torres",
                "4323555", "nash@example.com"));
        // Create owner 9
        ownerRepository.save(new Owner(
                901234567L, "Janeth", "Cantero", "Gil",
                "9855432", "cantja@example.com"));
        // Create owner 10
        ownerRepository.save(new Owner(
                987654321L, "Enrrique", "Maldonado", "Polo",
                "9873748", "enrri@example.com "));
        // Create owner 11
        ownerRepository.save(new Owner(
                876543210L, "Eduardo", "Cruz", "Bolivar",
                "8752333", "eduardo@example.com"));
        // Create owner 12
        ownerRepository.save(new Owner(
                765432109L, "María", "Morales", "Rivera",
                "3225800", "mam@gmail.com"));
        // Create owner 13
        ownerRepository.save(new Owner(
                654321098L, "Miguel", "Uribe", "Velez",
                "3238876", "migue@example.com"));
        // Create owner 14
        ownerRepository.save(new Owner(
                543210987L, "Raul", "Nivia", "Velez",
                "3238888", "rau@example.com"));
        // Create owner 15
        ownerRepository.save(new Owner(
                432109876L, "Nelson", "Jimenez", "Alteri",
                "3230374", "neljia@example.com"));
        // Create owner 16
        ownerRepository.save(new Owner(
                210987654L, "Jimena", "Alvarez", "Estrada",
                "3237483", "jimeal@example.com"));
        // Create owner 17
        // create owner 17
        ownerRepository.save(new Owner(339527439L, "Alberto", "Nuñez", "Navarro", "6464316", "AlNuNa@example.com"));
        // create owner 18
        ownerRepository
                .save(new Owner(389629107L, "Alejandra", "Alvarez", "Chaparro", "7634480", "AlAlCh@example.com"));
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
        ownerRepository
                .save(new Owner(560136473L, "Alejandro", "Gonzalez", "Ahumada", "6444285", "AlGoAh@example.com"));
        // create owner 31
        ownerRepository.save(new Owner(804999127L, "Nashly", "Silva", "Castillo", "4248438", "NaSiCa@example.com"));
        // create owner 32
        ownerRepository.save(new Owner(510972620L, "Jane", "Molina", "Lara", "7466902", "JaMoLa@example.com"));
        // create owner 33
        ownerRepository
                .save(new Owner(475470342L, "Enrrique", "Linares", "Castrillon", "7522873", "EnLiCa@example.com"));
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
        ownerRepository
                .save(new Owner(640537211L, "Sebastian", "Morales", "Restrepo", "7952017", "SeMoRe@example.com"));
        // create owner 42
        ownerRepository.save(new Owner(938522664L, "Fernanda", "Silva", "Paredes", "9301132", "FeSiPa@example.com"));
        // create owner 43
        ownerRepository.save(new Owner(258352672L, "Erick", "Fernandez", "Chaparro", "3983051", "ErFeCh@example.com"));
        // create owner 44
        ownerRepository.save(new Owner(146073939L, "Oswaldo", "Linares", "Montoya", "4691450", "OsLiMo@example.com"));
        // create owner 45
        ownerRepository
                .save(new Owner(883159347L, "Alberto", "Buitrago", "Guerrero", "9776421", "AlBuGu@example.com"));
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
        ownerRepository
                .save(new Owner(110619556L, "Sebastian", "Fernandez", "Mendoza", "2278777", "SeFeMe@example.com"));
        // create owner 54
        ownerRepository.save(new Owner(634672894L, "Camilo", "Rojas", "Chavez", "7865377", "CaRoCh@example.com"));
        // create owner 55
        ownerRepository.save(new Owner(975570482L, "Kevin", "Perez", "Torres", "8259213", "KePeTo@example.com"));
        // create owner 56
        ownerRepository
                .save(new Owner(547961919L, "Nathalie", "Castillo", "Aguilar", "3935301", "NaCaAg@example.com"));
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
        ownerRepository
                .save(new Owner(622637951L, "Oswaldo", "Rodriguez", "Chaparro", "6573517", "OsRoCh@example.com"));
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
        ownerRepository
                .save(new Owner(463325005L, "Fernanda", "Castillo", "Guerrero", "7491092", "FeCaGu@example.com"));
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

        petRepository
                .save(new Pet("Bonifacio", "Persa", new Date(), 4.0, "Lupus", "https://placekitten.com/g/200/300"));

        Owner asociar = ownerRepository.findById(1L).get();
        for (Pet pet : petRepository.findAll()) {
            pet.setOwner(asociar);
            petRepository.save(pet);
        }
    }
}
