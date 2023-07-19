package com.cafe.da.manha.Cafe.Controllers;

import com.cafe.da.manha.Cafe.DTO.RegistroComidaColaboradorDTO;
import com.cafe.da.manha.Cafe.Repository.ComidaColaboradorRepository;
import com.cafe.da.manha.Cafe.Service.ComidaColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ComidaColaboradorController {
    @Autowired
    ComidaColaboradorRepository Repository;

    @Autowired
    private ComidaColaboradorService servico;
/*
    //Break Point para cadastrar um registro
    @PostMapping("/Registrar")
    public @ResponseBody RegistroComidaColaboradorDTO cadastro(@RequestBody RegistroComidaColaboradorDTO registro ){
        return Repository.save(registro);
    }


    //Break Point para recuperar todos os registros
    @GetMapping("/ObterRegistros")
    public ResponseEntity<?> ObtemRegistros(){
        return new ResponseEntity<>(Repository.findAll(), HttpStatus.OK);
    }


    //Break Point para modificar um registro
    @PutMapping("/Modifica")
    public @ResponseBody RegistroComidaColaboradorDTO AtualizaRegistro(@RequestBody RegistroComidaColaboradorDTO registro){
       return Repository.save(registro);
    }


    //Break Point para buscar um registro por ID
    @GetMapping("/RecuperaRegistro/{id}")
    public Optional<RegistroComidaColaboradorDTO> RecuperaRegistroID(@PathVariable Long id){
        return Repository.findById(id);
    }
     */

    //Break Point para Deletar um registro
    @DeleteMapping("/Deletar/{id}")
    public void Deleta(@PathVariable Long id){
      Repository.deleteById(id);
    }

//-----------------------------------------------------------------------------------------------------------------------------------------------
    //Break Point para recuperar todos os registros NativeQuery
    @GetMapping("/ObterRegistros")
    public ResponseEntity<?> SelectGeral(){
        return servico.ObtemRegistoros();
    }

    //Break point para buscar um registro por ID NativeQuery
    @GetMapping("/RecuperaRegistro/{id}")
    public List<RegistroComidaColaboradorDTO> RecuperaRegistroID(@PathVariable Long id){
        return Repository.SelecionaPorID(id);
    }

    //Break Point para modificar um registro NativeQuery
    @PutMapping("/Modifica")
    public @ResponseBody ResponseEntity<?> AtualizaRegistro(@RequestBody RegistroComidaColaboradorDTO registro){
        return servico.modifica(registro);
    }

    //Break Point para cadastrar um registro NativeQuery
    @PostMapping("/Registrar")
    public @ResponseBody ResponseEntity<?> cadastro(@RequestBody RegistroComidaColaboradorDTO registro ){
        return servico.cadastrar(registro);
    }

    /*
    //Break Point para Deletar um registro NativeQuery
    @DeleteMapping("/Deletar/{id}")
    public void Deleta(@PathVariable Long id){
        Repository.DeletaRegistro(id);
    }
    obs: esse código está funcionando, com tudo, logo depois de efetuar o comando com "sucesso" o mesmo
    retorna um erro a qual não consegui achar uma explicaçã.
     */
}
