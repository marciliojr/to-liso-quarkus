package com.gestor.usuario;

import com.gestor.exceptions.NegocioException;
import com.gestor.util.MensagemErro;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Set;

@RequestScoped
public class UsuarioService {

    @Inject
    private UsuarioRepository repositorio;

    @Transactional
    public void insere(Usuario usuario) throws NoSuchAlgorithmException, UnsupportedEncodingException, NegocioException {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator ();

        Set<ConstraintViolation<Usuario>> constraintViolations =
                validator.validate( usuario);

        for (ConstraintViolation error: constraintViolations) {
            String msgError = error.getMessage();
            System.out.println (msgError);
        }

        boolean existeEmail = repositorio.existeUsuarioComEmail(usuario.getEmail());

        if(existeEmail){
            throw new NegocioException(MensagemErro.MENSAGEM_EMAIL_JA_CADASTRADO);
        }

        MessageDigest algorithm = null;
        algorithm = MessageDigest.getInstance("MD5");
        byte messageDigest[] = algorithm.digest(usuario.getSenha().getBytes("UTF-8"));
        usuario.setSenha(messageDigest.toString());

        repositorio.persist(usuario);
    }

}
