package org.edupro.web.service.impl;

import lombok.RequiredArgsConstructor;
import org.edupro.web.model.request.RuanganRequest;
import org.edupro.web.model.response.RuanganResponse;
import org.edupro.web.service.MasterRuanganService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MasterRuanganServiceImpl implements MasterRuanganService {
    private final RestTemplate restTemplate;
     private static List<RuanganResponse> DATA = Arrays.asList(
                new RuanganResponse(1,"R1", "Ruangan 1"),
                new RuanganResponse(2,"R2", "Ruangan 2"),
                new RuanganResponse(3,"R3", "Ruangan 3"),
                new RuanganResponse(4,"R4", "Ruangan 4"),
                new RuanganResponse(5,"R5", "Ruangan 5"),
                new RuanganResponse(6,"R6", "Ruangan 6"),
                new RuanganResponse(7,"R7", "Ruangan 7"),
                new RuanganResponse(8,"R8", "Ruangan 8"),
                new RuanganResponse(9,"R9", "Ruangan 9"),
                new RuanganResponse(10,"R10", "Ruangan 10"),
                new RuanganResponse(11,"R11", "Ruangan 11"),
                new RuanganResponse(12,"R12", "Ruangan 12"),
                new RuanganResponse(13,"R13", "Ruangan 13"),
                new RuanganResponse(14,"R14", "Ruangan 14"),
                new RuanganResponse(15,"R15", "Ruangan 15")
        );

     @Override
     public List<RuanganResponse> get() {
         return DATA;
    }

    @Override
    public Optional<RuanganResponse> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<RuanganResponse> save(RuanganRequest request) {
         if (request == null){
             return Optional.empty();
         }

         var data = convertResponse(request);
         DATA.add(data);
         return Optional.of(data);
    }

    @Override
    public Optional<RuanganResponse> update(RuanganRequest request, Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<RuanganResponse> delete(Integer id) {
        return Optional.empty();
    }

    private RuanganResponse convertResponse(RuanganRequest request){
         RuanganResponse result = new RuanganResponse();
        BeanUtils.copyProperties(request, result);
        return result;
    }

    private RuanganRequest convertRequest(RuanganResponse response){
         RuanganRequest result = new RuanganRequest();
         BeanUtils.copyProperties(response, result);
         return result;
    }
}
