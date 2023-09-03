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
                "555-1784", "pequint@example.com"));
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
        // create owner 17
        ownerRepository.save(new Owner(218180629L, "Enrrique", "Molina", "Guerrero", "609-1256", "EnMoGu@example.com"));
        // create owner 18
        ownerRepository.save(new Owner(154688087L, "Nathan", "Linares", "Campos", "251-2702", "NaLiCa@example.com"));
        // create owner 19
        ownerRepository.save(new Owner(507949223L, "Oswaldo", "Torres", "Araya", "257-6273", "OsToAr@example.com"));
        // create owner 20
        ownerRepository.save(new Owner(898966418L, "Circe", "Sanchez", "Navarro", "901-5053", "CiSaNa@example.com"));
        // create owner 21
        ownerRepository.save(new Owner(364979467L, "Sofia", "Ramirez", "Salas", "602-4050", "SoRaSa@example.com"));
        // create owner 22
        ownerRepository.save(new Owner(226689816L, "Juan", "Nuñez", "Salas", "803-6276", "JuNuSa@example.com"));
        // create owner 23
        ownerRepository.save(new Owner(135502469L, "Alejandra", "Vargas", "Campos", "491-8959", "AlVaCa@example.com"));
        // create owner 24
        ownerRepository.save(new Owner(803448104L, "Pablo", "Rodriguez", "Castrillon", "667-3802", "PaRoCa@example.com"));
        // create owner 25
        ownerRepository.save(new Owner(136314772L, "Sara", "Alvarez", "Campos", "228-9936", "SaAlCa@example.com"));
        // create owner 26
        ownerRepository.save(new Owner(644952283L, "Pablo", "Rojas", "Valencia", "688-2756", "PaRoVa@example.com"));
        // create owner 27
        ownerRepository.save(new Owner(311973152L, "María", "Alvarez", "Fuentes", "471-5765", "MaAlFu@example.com"));
        // create owner 28
        ownerRepository.save(new Owner(408974203L, "Luis", "Torres", "Navarro", "759-6405", "LuToNa@example.com"));
        // create owner 29
        ownerRepository.save(new Owner(427422007L, "Sebastian", "Garcia", "Zuñiga", "582-2974", "SeGaZu@example.com"));
        // create owner 30
        ownerRepository.save(new Owner(810334145L, "Valentina", "Gomez", "Araya", "707-8643", "VaGoAr@example.com"));
        // create owner 31
        ownerRepository.save(new Owner(114384811L, "Valentina", "Sanchez", "Pardo", "933-4327", "VaSaPa@example.com"));
        // create owner 32
        ownerRepository.save(new Owner(406744726L, "Paula", "Silva", "Araya", "188-3378", "PaSiAr@example.com"));
        // create owner 33
        ownerRepository.save(new Owner(764433451L, "Pablo", "Soto", "Cortes", "866-7849", "PaSoCo@example.com"));
        // create owner 34
        ownerRepository.save(new Owner(940894139L, "Juan", "Vargas", "Guerrero", "809-2072", "JuVaGu@example.com"));
        // create owner 35
        ownerRepository.save(new Owner(339900934L, "Pablo", "Martinez", "Cruz", "363-2584", "PaMaCr@example.com"));
        // create owner 36
        ownerRepository.save(new Owner(187857083L, "Nathalie", "Martinez", "Mendoza", "363-7774", "NaMaMe@example.com"));
        // create owner 37
        ownerRepository.save(new Owner(998722215L, "Sebastian", "Ruiz", "Torres", "264-2405", "SeRuTo@example.com"));
        // create owner 38
        ownerRepository.save(new Owner(928045170L, "Nashly", "Ramirez", "Restrepo", "127-4880", "NaRaRe@example.com"));
        // create owner 39
        ownerRepository.save(new Owner(672770409L, "Paula", "Vasquez", "Parada", "893-5646", "PaVaPa@example.com"));
        // create owner 40
        ownerRepository.save(new Owner(850414449L, "Oswaldo", "Castro", "Moya", "849-5060", "OsCaMo@example.com"));
        // create owner 41
        ownerRepository.save(new Owner(561689807L, "Alex", "Ramirez", "Pinto", "968-8731", "AlRaPi@example.com"));
        // create owner 42
        ownerRepository.save(new Owner(625689863L, "Kevin", "Diaz", "Leiva", "925-4654", "KeDiLe@example.com"));
        // create owner 43
        ownerRepository.save(new Owner(292985449L, "Sebastian", "Silva", "Bustos", "589-7413", "SeSiBu@example.com"));
        // create owner 44
        ownerRepository.save(new Owner(668355588L, "Valentina", "Gómez", "Castillo", "661-4110", "VaGóCa@example.com"));
        // create owner 45
        ownerRepository.save(new Owner(882389434L, "Pablo", "Vargas", "Moya", "879-4308", "PaVaMo@example.com"));
        // create owner 46
        ownerRepository.save(new Owner(492785202L, "Kevin", "Alvarez", "Rivas", "720-5880", "KeAlRi@example.com"));
        // create owner 47
        ownerRepository.save(new Owner(391412275L, "Nathan", "Guevara", "Poblete", "827-4749", "NaGuPo@example.com"));
        // create owner 48
        ownerRepository.save(new Owner(412964607L, "Alejandra", "Gomez", "Miranda", "991-7342", "AlGoMi@example.com"));
        // create owner 49
        ownerRepository.save(new Owner(973969923L, "Enrrique", "Ramirez", "Aguilar", "520-8322", "EnRaAg@example.com"));
        // create owner 50
        ownerRepository.save(new Owner(334694339L, "Pedro", "Castro", "Valencia", "698-7214", "PeCaVa@example.com"));
        // create owner 51
        ownerRepository.save(new Owner(240445914L, "Sebastian", "Rodriguez", "Cruz", "313-9689", "SeRoCr@example.com"));
        // create owner 52
        ownerRepository.save(new Owner(448367769L, "Sofia", "Hernandez", "Rivas", "358-3684", "SoHeRi@example.com"));
        // create owner 53
        ownerRepository.save(new Owner(419794478L, "Fernanda", "Diaz", "Valencia", "531-4490", "FeDiVa@example.com"));
        // create owner 54
        ownerRepository.save(new Owner(956230954L, "Lina", "Gomez", "Espinoza", "480-3634", "LiGoEs@example.com"));
        // create owner 55
        ownerRepository.save(new Owner(727941318L, "Kevin", "Fernandez", "Espinoza", "849-2795", "KeFeEs@example.com"));
        // create owner 56
        ownerRepository.save(new Owner(834743431L, "Paula", "Vargas", "Cortes", "828-4647", "PaVaCo@example.com"));
        // create owner 57
        ownerRepository.save(new Owner(565472040L, "Kevin", "Diaz", "Vasquez", "536-7961", "KeDiVa@example.com"));
        // create owner 58
        ownerRepository.save(new Owner(356360329L, "María", "Morales", "Orellana", "707-5250", "MaMoOr@example.com"));
        // create owner 59
        ownerRepository.save(new Owner(657103677L, "Alejandra", "Aguilar", "Salas", "651-9738", "AlAgSa@example.com"));
        // create owner 60
        ownerRepository.save(new Owner(172587760L, "Ana", "Perez", "Aguilar", "862-7310", "AnPeAg@example.com"));
        // create owner 61
        ownerRepository.save(new Owner(734139204L, "Fernanda", "Fernandez", "Aguilar", "813-5338", "FeFeAg@example.com"));
        // create owner 62
        ownerRepository.save(new Owner(618058540L, "Lina", "Castillo", "Cruz", "479-5488", "LiCaCr@example.com"));
        // create owner 63
        ownerRepository.save(new Owner(913632160L, "Alejandro", "Morales", "Parada", "324-6546", "AlMoPa@example.com"));
        // create owner 64
        ownerRepository.save(new Owner(571821265L, "Enrrique", "Aguilar", "Gil", "806-8666", "EnAgGi@example.com"));
        // create owner 65
        ownerRepository.save(new Owner(519741731L, "Circe", "Silva", "Sepulveda", "940-7141", "CiSiSe@example.com"));
        // create owner 66
        ownerRepository.save(new Owner(183664193L, "Sebastian", "Jimenez", "Restrepo", "333-4099", "SeJiRe@example.com"));
        // create owner 67
        ownerRepository.save(new Owner(150241586L, "Ana", "Diaz", "Peña", "302-4502", "AnDiPe@example.com"));
        // create owner 68
        ownerRepository.save(new Owner(107341754L, "Janeth", "Gómez", "Mendez", "599-3348", "JaGóMe@example.com"));
        // create owner 69
        ownerRepository.save(new Owner(124401630L, "Nashly", "Torres", "Galvis", "980-6393", "NaToGa@example.com"));
        // create owner 70
        ownerRepository.save(new Owner(254225324L, "Paula", "Fernandez", "Mendoza", "287-6712", "PaFeMe@example.com"));
        // create owner 71
        ownerRepository.save(new Owner(368520532L, "Enrrique", "Vargas", "Pinto", "909-6368", "EnVaPi@example.com"));
        // create owner 72
        ownerRepository.save(new Owner(247578146L, "Alejandra", "Gonzalez", "Galvis", "224-1805", "AlGoGa@example.com"));
        // create owner 73
        ownerRepository.save(new Owner(208248514L, "Oswaldo", "Torres", "Aguilar", "517-2804", "OsToAg@example.com"));
        // create owner 74
        ownerRepository.save(new Owner(225972823L, "Eduardo", "Alvarez", "Cortez", "787-5751", "EdAlCo@example.com"));
        // create owner 75
        ownerRepository.save(new Owner(956209430L, "Jane", "Romero", "Torres", "698-9248", "JaRoTo@example.com"));
        // create owner 76
        ownerRepository.save(new Owner(602091766L, "Sandra", "Fernandez", "Montoya", "749-9019", "SaFeMo@example.com"));
        // create owner 77
        ownerRepository.save(new Owner(249925995L, "Juan", "Soto", "Orellana", "865-2070", "JuSoOr@example.com"));
        // create owner 78
        ownerRepository.save(new Owner(574324010L, "Janeth", "Molina", "Cortez", "799-3247", "JaMoCo@example.com"));
        // create owner 79
        ownerRepository.save(new Owner(162005021L, "Alejandra", "Vasquez", "Castrillon", "998-1055", "AlVaCa@example.com"));
        // create owner 80
        ownerRepository.save(new Owner(713074792L, "John", "Buitrago", "Galvis", "441-4294", "JoBuGa@example.com"));
        // create owner 81
        ownerRepository.save(new Owner(613086392L, "Ana", "Martinez", "Cortez", "738-4168", "AnMaCo@example.com"));
        // create owner 82
        ownerRepository.save(new Owner(545890902L, "Janeth", "Linares", "Salas", "320-4645", "JaLiSa@example.com"));
        // create owner 83
        ownerRepository.save(new Owner(109064487L, "Alejandro", "Molina", "Chavez", "131-8647", "AlMoCh@example.com"));
        // create owner 84
        ownerRepository.save(new Owner(492212829L, "Valentina", "Vargas", "Orellana", "677-6177", "VaVaOr@example.com"));
        // create owner 85
        ownerRepository.save(new Owner(160777664L, "Sandra", "Castro", "Rivas", "455-9825", "SaCaRi@example.com"));
        // create owner 86
        ownerRepository.save(new Owner(638402799L, "Fernanda", "Flores", "Chaparro", "345-2099", "FeFlCh@example.com"));
        // create owner 87
        ownerRepository.save(new Owner(664491843L, "Ana", "Lopez", "Cruz", "664-6868", "AnLoCr@example.com"));
        // create owner 88
        ownerRepository.save(new Owner(294177134L, "Circe", "Silva", "Gil", "480-3675", "CiSiGi@example.com"));
        // create owner 89
        ownerRepository.save(new Owner(120817957L, "Jane", "Castro", "Galvis", "878-9156", "JaCaGa@example.com"));
        // create owner 90
        ownerRepository.save(new Owner(227255505L, "Fernanda", "Soto", "Fuentes", "310-3753", "FeSoFu@example.com"));
        // create owner 91
        ownerRepository.save(new Owner(304103075L, "Sebastian", "Alvarez", "Montoya", "993-3083", "SeAlMo@example.com"));
        // create owner 92
        ownerRepository.save(new Owner(482382451L, "Nashly", "Alvarez", "Zuñiga", "230-7934", "NaAlZu@example.com"));
        // create owner 93
        ownerRepository.save(new Owner(934048159L, "Pedro", "Gonzalez", "Restrepo", "994-7662", "PeGoRe@example.com"));
        // create owner 94
        ownerRepository.save(new Owner(287718486L, "Sofia", "Morales", "Chavez", "997-2356", "SoMoCh@example.com"));
        // create owner 95
        ownerRepository.save(new Owner(203358477L, "Janeth", "Nuñez", "Vasquez", "314-7069", "JaNuVa@example.com"));
        // create owner 96
        ownerRepository.save(new Owner(951448695L, "Alejandro", "Flores", "Salas", "569-2628", "AlFlSa@example.com"));
        // create owner 97
        ownerRepository.save(new Owner(326139298L, "Pablo", "Gómez", "Aguilar", "417-2209", "PaGóAg@example.com"));
        // create owner 98
        ownerRepository.save(new Owner(297243315L, "Alberto", "Aguilar", "Chaparro", "585-1148", "AlAgCh@example.com"));
        // create owner 99
        ownerRepository.save(new Owner(367586010L, "Alberto", "Castro", "Paredes", "229-8039", "AlCaPa@example.com"));
        // create owner 100
        ownerRepository.save(new Owner(143793847L, "Sandra", "Parada", "Salas", "120-1640", "SaPaSa@example.com"));
        //create cat 1
        petRepository.save(new Pet("Bonifacio", "Persa", new Date(), 4.0, "Lupus", "https://placekitten.com/g/200/300"));
        //create cat 2
        petRepository.save(new Pet("Mishu", "Persa", new Date(), 4.0, "Lupus", "https://placekitten.com/g/200/300"));
        //create cat 3
        


        Owner asociar = ownerRepository.findById(1L).get();
        for (Pet pet : petRepository.findAll()) {
            pet.setOwner(asociar);
            petRepository.save(pet);
        }
    }
}
