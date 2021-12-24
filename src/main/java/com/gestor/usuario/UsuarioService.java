package com.gestor.usuario;

import com.gestor.exceptions.NegocioException;
import com.gestor.exceptions.NegocioExceptionDTO;
import com.gestor.usuario.dto.UsuarioAutenticadoDTO;
import com.gestor.usuario.dto.UsuarioDTO;
import com.gestor.usuario.dto.UsuarioRespostaDTO;
import com.gestor.util.ConstanteUtil;
import com.gestor.util.CriptografiaUtil;
import com.gestor.util.MensagemErro;
import org.jboss.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Validator;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;

import static com.gestor.util.ConstanteUtil.ACAO_INSERIR;
import static com.gestor.util.ConstanteUtil.ACAO_SUCESSO;

@RequestScoped
public class UsuarioService {

    @Inject
    private UsuarioRepository repositorio;

    @Inject
    private Validator validador;

    private static final Logger LOG = Logger.getLogger(UsuarioService.class);

    @Transactional
    public void insere(UsuarioDTO usuario) throws NoSuchAlgorithmException, UnsupportedEncodingException, NegocioException {
        LOG.info(ACAO_INSERIR + ": Usuario: " + usuario.toString());
        validarObjeto(usuario);

        if (repositorio.existeUsuarioComEmail(usuario.getEmail())) {
            throw new NegocioException(MensagemErro.MENSAGEM_EMAIL_JA_CADASTRADO);
        }

        String senhaCriptografada = CriptografiaUtil.criptografarSenhaUsuario(usuario.getSenha());

        Usuario usuarioBase = new Usuario(usuario.getEmail(), usuario.getNick(), senhaCriptografada);

        repositorio.persist(usuarioBase);
        LOG.info(ACAO_SUCESSO + ": Usuario: " + usuario.toString());
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
            LOG.error("Erro: " + negocioExceptionDTO.toString());
            throw new NegocioException(negocioExceptionDTO.toString());
        }
    }


    public UsuarioRespostaDTO login(UsuarioAutenticadoDTO usuario) throws UnsupportedEncodingException, NoSuchAlgorithmException, NegocioException {

            String senha = usuario.getSenha();
            usuario.setSenha(CriptografiaUtil.criptografarSenhaUsuario(usuario.getSenha()));

        UsuarioRespostaDTO login = repositorio.login(usuario);

        if(login == null){
            throw new NegocioException(MensagemErro.MENSAGEM_USUARIO_NAO_ENCONTRADO);
        }

        return login;
    }


}
