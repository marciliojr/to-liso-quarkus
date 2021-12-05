package com.gestor.usuario;

import com.gestor.exceptions.NegocioException;
import com.gestor.exceptions.NegocioExceptionDTO;
import com.gestor.util.MensagemErro;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Set;
import java.util.stream.Collectors;

@RequestScoped
public class UsuarioService {

    @Inject
    private UsuarioRepository repositorio;

    @Inject
    private Validator validador;

    @Transactional
    public void insere(Usuario usuario) throws NoSuchAlgorithmException, UnsupportedEncodingException, NegocioException {

        validarObjeto(usuario);

        if (repositorio.existeUsuarioComEmail(usuario.getEmail())) {
            throw new NegocioException(MensagemErro.MENSAGEM_EMAIL_JA_CADASTRADO);
        }
        criptografarSenhaUsuario(usuario);
        repositorio.persist(usuario);
    }

    private void validarObjeto(Usuario usuario) throws NegocioException {
        Set<String> validados = validador.validate(usuario).stream().map(ConstraintViolation::getMessage).collect(Collectors.toSet());

        NegocioExceptionDTO dto = new NegocioExceptionDTO();
        validados.forEach(valida ->{
            dto.addMensagem(valida);
        });

        if(dto.comMensagens()){
            throw new NegocioException(dto.toString());
        }
    }

    private void criptografarSenhaUsuario(Usuario usuario) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest algorithm = null;
        algorithm = MessageDigest.getInstance("MD5");
        byte messageDigest[] = algorithm.digest(usuario.getSenha().getBytes("UTF-8"));
        usuario.setSenha(messageDigest.toString());
    }

    public Usuario buscarPorEmail(String email) {
        return repositorio.buscarUsuarioPorEmail(email);
    }


}
