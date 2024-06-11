package org.edupro.web.service;

import org.edupro.web.model.request.RuanganRequest;
import org.edupro.web.model.response.RuanganResponse;

import java.util.List;
import java.util.Optional;

public interface MasterRuanganService {
    List<RuanganResponse> get();
    Optional<RuanganResponse> getById(Integer id);
    Optional<RuanganResponse> save(RuanganRequest request);
    Optional<RuanganResponse> update(RuanganRequest request, Integer id);
    Optional<RuanganResponse> delete(Integer id);
}
