package org.edupro.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.edupro.web.model.request.GedungRequest;
import org.edupro.web.model.response.GedungResponse;
import org.edupro.web.model.response.Response;
import org.edupro.web.service.MasterGedungService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/master/gedung")
@RequiredArgsConstructor
public class MasterGedungController {

    private final MasterGedungService service;

    @GetMapping
    public ModelAndView index(){
        var view = new ModelAndView("pages/master/gedung/index");
        view.addObject("data", service.get());

        return view;
    }

    @GetMapping("/add")
    public ModelAndView addModal(){
        var view = new ModelAndView("pages/master/gedung/add");
        return view;
    }

    @PostMapping("/save")
    public ResponseEntity<Response> save(@RequestBody @Valid GedungRequest request){
        var result = service.save(request);
        return  getResponse(result);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id){
        return new ModelAndView("pages/master/gedung/edit");
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Response> update(@RequestBody @Valid GedungRequest request, @PathVariable("id") Integer id){
        var result = service.update(request, id);

        return  getResponse(result);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id){
        return new ModelAndView("pages/master/gedung/delete");
    }

    @PostMapping("/remove/{id}")
    public ResponseEntity<Response> remove(@PathVariable("id") Integer id){
        var result = service.delete(id);

        return getResponse(result);
    }

    @GetMapping("/data")
    public ResponseEntity<Response> getData(){
        List<GedungResponse> result = service.get();
        return ResponseEntity.ok().body(
                Response.builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Success")
                        .data(result)
                        .total(result.size())
                        .build()
        );
    }

    private ResponseEntity<Response> getResponse(Optional<GedungResponse> result){
        return result.isEmpty() ? ResponseEntity.badRequest().body(
                Response.builder()
                        .statusCode(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED.ordinal())
                        .message("Failed")
                        .data(null)
                        .total(0)
                        .build()
        ) : ResponseEntity.ok().body(
                Response.builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Success")
                        .data(result)
                        .total(1)
                        .build()
        );
    }
}
