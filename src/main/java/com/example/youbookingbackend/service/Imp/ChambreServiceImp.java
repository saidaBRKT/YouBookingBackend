package com.example.youbookingbackend.service.Imp;

import com.example.youbookingbackend.repository.dto.ChambreDto;
import com.example.youbookingbackend.repository.dto.ResponseDto;
import com.example.youbookingbackend.repository.dto.TransferDtoToEntity;
import com.example.youbookingbackend.repository.dto.TransferEntityToDto;
import com.example.youbookingbackend.entity.Chambre;
import com.example.youbookingbackend.entity.StatusChambre;
import com.example.youbookingbackend.repository.ChambreRespository;
import com.example.youbookingbackend.service.ChambreService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ChambreServiceImp implements ChambreService {
    @Autowired
    private ChambreRespository chambreRespository;

    @Override
    public ResponseDto addChambre(ChambreDto chambreDto) {
        Chambre chambre= TransferDtoToEntity.chamberDtoToChamber(chambreDto);
        if(chambre.getHotel()==null || chambre.getNbrLits()==0 || chambre.getNum()==0 || chambre.getPrix()==0){
         //   throw new IllegalStateException("Toutes les données sont obligatoires");
            return new ResponseDto("Bad request", "Toutes les données sont obligatoires");
        }
        else {
            Chambre chambre1 = chambreRespository.save(chambre);
            //return TransferEntityToDto.chamberToChamberDto(chambre1);
            return new ResponseDto("success","Added succefuly",TransferEntityToDto.chamberToChamberDto(chambre1));
        }
    }

    @Override
    public ResponseDto updateChambre(ChambreDto chambreDto) {
        Chambre chambre= TransferDtoToEntity.chamberDtoToChamber(chambreDto);
        Chambre chambre1=chambreRespository.findById(chambre.getId()).get();
        if (chambre1 == null){
            //throw new IllegalStateException("Chambre n'existe pas");
            return new ResponseDto("Bad request", "Chambre n'existe pas");
        }else {
            chambre1 = chambre;
            Chambre chambre2 = chambreRespository.save(chambre1);
          //  return TransferEntityToDto.chamberToChamberDto(chambre2);
            return new ResponseDto("success","Updateded succefuly",TransferEntityToDto.chamberToChamberDto(chambre2));

        }
    }

    @Override
    public List<ChambreDto> findAllChambre() {
        return chambreRespository.findAll().stream().map(chambre -> TransferEntityToDto.chamberToChamberDto(chambre))
                .collect(Collectors.toList());
    }

    @Override
    public List<ChambreDto> findAllChambreByStatus(StatusChambre statusChambre) {
        return chambreRespository.findAllByStatusChambre(statusChambre).stream().map(chambre -> TransferEntityToDto.chamberToChamberDto(chambre)).collect(Collectors.toList());
    }

    @Override
    public List<ChambreDto> findAllChambreHotel(Long idHotel) {
        return chambreRespository.findChambreByHotel(idHotel).stream().map(chambre -> TransferEntityToDto.chamberToChamberDto(chambre)).collect(Collectors.toList());
    }

    @Override
    public ResponseDto deleteChambre(int num) {
        Chambre chambre1=chambreRespository.getByNum(num);
        if(chambre1==null){
           // throw new IllegalStateException("Le chambre n'existe pas");
            return new ResponseDto("Bad request", "Chambre n'existe pas");
        }
        else {
            chambreRespository.deleteByNum(num);
            return new ResponseDto("success","deleted succefuly");
        }
    }


}
