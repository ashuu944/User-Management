package ziaat.usermanagement.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ziaat.usermanagement.Dto.ShehiaDto.GetShehiaDto;
import ziaat.usermanagement.Dto.ShehiaDto.InsertShehiaDto;
import ziaat.usermanagement.Dto.ShehiaDto.UpdateShehiaDto;
import ziaat.usermanagement.Model.District;
import ziaat.usermanagement.Model.Shehia;
import ziaat.usermanagement.Repository.DistrictRepository;
import ziaat.usermanagement.Repository.ShehiaRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShehiaService {
    @Autowired
    private ShehiaRepository repo;

    @Autowired
    private DistrictRepository reg_repo;

    public GetShehiaDto insertShehia(InsertShehiaDto req) {
        Optional<District> reg = reg_repo.findById(req.getDistId());
        ModelMapper modelMapper = new ModelMapper();
        ModelMapper modelMapperR = new ModelMapper();
        Shehia resp = modelMapper.map(req, Shehia.class);
        resp.setDistrict(reg.get());
        resp.setCreateAt(LocalDateTime.now());
        resp.setActive(true);
        Shehia ds = repo.save(resp);
        GetShehiaDto response = modelMapperR.map(ds, GetShehiaDto.class);
        response.setDistId(ds.getDistrict().getDistrictId());
        response.setDistName(ds.getDistrict().getDistrictName());

        return response ;

    }

    public List<GetShehiaDto> getAllShehia() {
        List<Shehia> rowlist = repo.findAll();
        ModelMapper modelMapper = new ModelMapper();
        List<GetShehiaDto> response = new ArrayList<>();
        for (Shehia row : rowlist) {
            GetShehiaDto resp = modelMapper.map(row, GetShehiaDto.class);
            resp.setDistId(row.getDistrict().getDistrictId());
            resp.setDistName(row.getDistrict().getDistrictName());
            response.add(resp);
        }
        return response;
    }

    public List<GetShehiaDto> getAllActiveShehia() {
        List<Shehia> rowlist = repo.findByIsActive(true);
        ModelMapper modelMapper = new ModelMapper();
        List<GetShehiaDto> response = new ArrayList<>();
        for (Shehia row : rowlist) {
            GetShehiaDto resp = modelMapper.map(row, GetShehiaDto.class);
            resp.setDistId(row.getDistrict().getDistrictId());
            resp.setDistName(row.getDistrict().getDistrictName());
            response.add(resp);
        }
        return response;
    }

    // For Select a specific record based on the given shehia id
    public GetShehiaDto getShehiaById(Long id) {

        Optional<Shehia> rowlist = repo.findById(id);
        ModelMapper modelMapper = new ModelMapper();

        if (rowlist.isPresent()) {
            Shehia row = rowlist.get();
            GetShehiaDto resp = modelMapper.map(row, GetShehiaDto.class);
            resp.setDistId(row.getDistrict().getDistrictId());
            resp.setDistName(row.getDistrict().getDistrictName());
            return resp;
        } else {
            return null;
        }

    }

    // For update data
    public GetShehiaDto updateShehia(UpdateShehiaDto req) {

        Optional<Shehia> rowlist = repo.findById(req.getShehiaId());
        Optional<District> reg =reg_repo.findById(req.getDistId());

        ModelMapper modelMapper = new ModelMapper();
        ModelMapper modelMapperR = new ModelMapper();

        if (rowlist.isPresent()) {
            Shehia row = rowlist.get();
            row.setCreateAt(LocalDateTime.now());
            row.setDistrict(reg.get());
            modelMapper.map(req, row);
            Shehia ds = repo.save(row);
            GetShehiaDto response = modelMapperR.map(ds, GetShehiaDto.class);
            response.setDistId(row.getDistrict().getDistrictId());
            response.setDistName(row.getDistrict().getDistrictName());
            return response;

        } else {
            return null;
        }

    }

    // For delete data
    public GetShehiaDto deleteShehia(Long id) {

        Optional<Shehia> rowlist = repo.findById(id);
        ModelMapper modelMapperR = new ModelMapper();

        if (rowlist.isPresent()) {
            Shehia row = rowlist.get();
            row.setCreateAt(LocalDateTime.now());
            row.setActive(false);
            Shehia response = repo.save(row);
            return modelMapperR.map(response, GetShehiaDto.class);

        } else {
            return null;
        }

    }


}
