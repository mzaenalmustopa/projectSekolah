package org.edupro.web.service.impl;

import lombok.RequiredArgsConstructor;
import org.edupro.web.model.request.GedungRequest;
import org.edupro.web.model.response.GedungResponse;
import org.edupro.web.service.MasterGedungService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MasterGedungServiceImpl implements MasterGedungService {
    private final RestTemplate restTemplate;

    private static List<GedungResponse> DATA = Arrays.asList(
            new GedungResponse(1,"G1","Gedung Satu"),
            new GedungResponse(2,"G2","Gedung Dua"),
            new GedungResponse(3,"G3","Gedung Tiga"),
            new GedungResponse(4,"G4","Gedung Empat"),
            new GedungResponse(5,"G5","Gedung Lima"),
            new GedungResponse(6,"G6","Gedung Genam"),
            new GedungResponse(7,"G7","Gedung Tujuh"),
            new GedungResponse(8,"G8","Gedung Delapan"),
            new GedungResponse(9,"G9","Gedung Sembilan"),
            new GedungResponse(10,"G10","Gedung Sepuluh"),
            new GedungResponse(11,"G11","Gedung Sebelas"),
            new GedungResponse(12,"G12","Gedung DuaBelas"),
            new GedungResponse(13,"G13","Gedung TigaBelas"),
            new GedungResponse(14,"G14","Gedung EmpatBelas"),
            new GedungResponse(15,"G15","Gedung LimaBelas")
    );
    @Override
    public List<GedungResponse> get() {
        return DATA;
    }

    @Override
    public Optional<GedungResponse> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<GedungResponse> save(GedungRequest request) {
        return Optional.empty();
    }

    @Override
    public Optional<GedungResponse> update(GedungRequest request, Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<GedungResponse> delete(Integer id) {
        return Optional.empty();
    }
}
