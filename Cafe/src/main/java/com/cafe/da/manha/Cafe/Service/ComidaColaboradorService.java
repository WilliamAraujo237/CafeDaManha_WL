package com.cafe.da.manha.Cafe.Service;

import com.cafe.da.manha.Cafe.DTO.RegistroComidaColaboradorDTO;
import com.cafe.da.manha.Cafe.Repository.ComidaColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ComidaColaboradorService {
    @Autowired
    private ComidaColaboradorRepository repository;

    //Regra para registrar um novo usuário e comida na lista
    public ResponseEntity<?> cadastrar(RegistroComidaColaboradorDTO registro){
        if (registro.getNome().equals("")){
            String Mensagem = "O campo nome, não pode estar vazio";
            return new ResponseEntity<>(Mensagem, HttpStatus.BAD_REQUEST);
        } else if (registro.getCpf() <11 ) {
            String Mensagem = "O cpf não pode ter menos de 11 digitos";
            return new ResponseEntity<>(Mensagem,HttpStatus.BAD_REQUEST);
        } else if (registro.getComida().equals("")) {
            String Mensagem = "O campo Comida não pode estar vazio";
            return new ResponseEntity<>(Mensagem,HttpStatus.BAD_REQUEST);
        }else if (repository.existsByNome(registro.getNome())) {
            String mensagem = "O nome informado já existe no banco de dados";
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (repository.existsByCpf(registro.getCpf())) {
            String mensagem = "O CPF informado já existe no banco de dados";
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (repository.existsByComida(registro.getComida())) {
            String mensagem = "A comida informada já existe no banco de dados";
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(repository.InsertRegistro(registro.getNome(),registro.getCpf(),registro.getComida()),HttpStatus.OK);
        }
    }

    //Regra para modificar um registro da tabela registro_comida_colaboradordto
    public ResponseEntity<?> modifica(RegistroComidaColaboradorDTO registro){
        if (registro.getNome().equals("")){
            String Mensagem = "O campo nome, não pode estar vazio";
            return new ResponseEntity<>(Mensagem, HttpStatus.BAD_REQUEST);
        } else if (registro.getCpf() <11 ) {
            String Mensagem = "O cpf não pode ter menos de 11 digitos";
            return new ResponseEntity<>(Mensagem,HttpStatus.BAD_REQUEST);
        } else if (registro.getComida().equals("")) {
            String Mensagem = "O campo Comida não pode estar vazio";
            return new ResponseEntity<>(Mensagem,HttpStatus.BAD_REQUEST);
        }else if (repository.existsByNome(registro.getNome())) {
            String Mensagem = "O nome informado já existe no banco de dados";
            return new ResponseEntity<>(Mensagem, HttpStatus.BAD_REQUEST);
        } else if (repository.existsByCpf(registro.getCpf())) {
            String Mensagem = "O CPF informado já existe no banco de dados";
            return new ResponseEntity<>(Mensagem, HttpStatus.BAD_REQUEST);
        } else if (repository.existsByComida(registro.getComida())) {
            String Mensagem = "A comida informada já existe no banco de dados";
            return new ResponseEntity<>(Mensagem, HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(repository.UpdateGeral(registro.getNome(),registro.getCpf(),registro.getComida(),registro.getId()),HttpStatus.OK);
        }
    }

    //Regra para obter todos os registros
    public ResponseEntity<?> ObtemRegistoros(){
        return new ResponseEntity<>(repository.SelectGeral(),HttpStatus.OK);
    }

    //Regra para Deletar um registro da tabela registro_comida_colaboradordto
    public ResponseEntity<?> DeletaRegistro(RegistroComidaColaboradorDTO registro){
        if (registro.getId() == null){
            String Mensagem = "O campo ID não pode estar vazio";
            return new ResponseEntity<>(Mensagem,HttpStatus.BAD_REQUEST);
        } else if (registro.getId() < 1) {
            String Mensagem = "O campo ID não pode ser menosr que 1";
            return new ResponseEntity<>(Mensagem,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(repository.DeletaRegistro(registro.getId()),HttpStatus.OK);
    }
}
