package com.example.youbookingbackend.rest;

import com.example.youbookingbackend.repository.dto.ChambreDto;
import com.example.youbookingbackend.repository.dto.ResponseDto;
import com.example.youbookingbackend.entity.StatusChambre;
import com.example.youbookingbackend.service.ChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/chambres")
@CrossOrigin("http://localhost:60435/")
public class ChambreController {
    @Autowired
    private ChambreService chambreService;

    @PostMapping("/add_Chambre")
    public ResponseDto addChambre(@RequestBody ChambreDto chambreDto){
       // Chambre chambre= TransferDtoToEntity.chamberDtoToChamber(chambreDto);
        return chambreService.addChambre(chambreDto);
    }

    @PutMapping("/update_chambre")
    public ResponseDto updateChambre(@RequestBody ChambreDto chambreDto){
       // Chambre chambre= TransferDtoToEntity.chamberDtoToChamber(chambreDto);
        return chambreService.updateChambre(chambreDto);
    }

    @GetMapping("/AllChambre")
    public List<ChambreDto> getAllChambres(){
        return chambreService.findAllChambre();
    }

    @GetMapping("/AllChambreDisponible")
    public List<ChambreDto> getAllChambresDispo(){
        return chambreService.findAllChambreByStatus(StatusChambre.Disponible);
    }

    @GetMapping("/AllChambreIndisponible")
    public List<ChambreDto> getAllChambresIndispo(){
        return chambreService.findAllChambreByStatus(StatusChambre.Indisponible);
    }
    @GetMapping("/AllChambreHotel/{idHotel}")
    public List<ChambreDto> getAllChambrehotel(@PathVariable Long idHotel){
        return chambreService.findAllChambreByStatus(StatusChambre.Indisponible);
    }

    @DeleteMapping("/delete/num/{num}")
    public ResponseDto deleteChamber(@PathVariable int num){
        return chambreService.deleteChambre(num);
    }

    @PostMapping("/ReserverChambre/id/{id}")
    public ResponseDto reserverChambre(@PathVariable Long id){

        return null;
    }




}
