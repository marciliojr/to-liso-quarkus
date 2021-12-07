package com.gestor.usuario;

import com.gestor.exceptions.NegocioException;
import com.gestor.exceptions.NegocioExceptionDTO;
import com.gestor.usuario.dto.UsuarioDTO;
import com.gestor.util.MensagemErro;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Validator;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;

@RequestScoped
public class UsuarioService {

    @Inject
    private UsuarioRepository repositorio;

    @Inject
    private Validator validador;

    @Transactional
    public void insere(UsuarioDTO usuario) throws NoSuchAlgorithmException, UnsupportedEncodingException, NegocioException {

        validarObjeto(usuario);

        if (repositorio.existeUsuarioComEmail(usuario.getEmail())) {
            throw new NegocioException(MensagemErro.MENSAGEM_EMAIL_JA_CADASTRADO);
        }
        criptografarSenhaUsuario(usuario);

        Usuario usuarioBase = new Usuario(usuario.getEmail(), usuario.getNick(), usuario.getSenha());

        repositorio.persist(usuarioBase);
    }

    private void validarObjeto(UsuarioDTO usuario) throws NegocioException {

        NegocioExceptionDTO negocioExceptionDTO = new NegocioExceptionDTO();
        validador.validate(usuario).forEach(usuarioValidado -> {
            String propriedade = usuarioValidado.getPropertyPath().toString();
            String mensagem = usuarioValidado.getMessage();
            String mensagemFormatada = MessageFormat.format("Campo {0} {1} ", propriedade, mensagem);
            negocioExceptionDTO.addMensagem(mensagemFormatada);
        });

        if (negocioExceptionDTO.comMensagens()) {
            throw new NegocioException(negocioExceptionDTO.toString());
        }
    }

    private void criptografarSenhaUsuario(UsuarioDTO usuario) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest algorithm = null;
        algorithm = MessageDigest.getInstance("MD5");
        byte messageDigest[] = algorithm.digest(usuario.getSenha().getBytes("UTF-8"));
        usuario.setSenha(messageDigest.toString());
    }

    public Usuario buscarPorEmail(String email) {
        return repositorio.buscarUsuarioPorEmail(email);
    }


}
