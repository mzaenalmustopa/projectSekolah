package org.edupro.web.service;

import org.edupro.web.model.request.KelasRequest;
import org.edupro.web.model.request.LevelRequest;
import org.edupro.web.model.response.KelasResponse;
import org.edupro.web.model.response.LevelResponse;

import java.util.List;
import java.util.Optional;

public interface MasterKelasService {
    List<KelasResponse> getAll();
    Optional<LevelResponse> getById(Integer id);
    Optional<KelasResponse> save(KelasRequest request);
    Optional<KelasResponse> update(KelasRequest request, Integer id);
    Optional<KelasResponse> delete(Integer id);


}
