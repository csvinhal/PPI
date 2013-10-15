package Model;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class CriptografaSenha {
        
        private static final String FUNCAO_HASH = "MD5";

        private byte[] senhaCriptografada;

        /**
         * Método que recebe uma senha e a criptografa para armazenamento.
         * 
         * @param senhaOriginal
         * @throws NoSuchAlgorithmException
         * @throws UnsupportedEncodingException
         */
        public String gerarSenhaCriptografada(String senhaOriginal)
                        throws NoSuchAlgorithmException, UnsupportedEncodingException {
                
                senhaCriptografada = criptografarSenha(senhaOriginal);
                //Arrays.toString(senhaCriptografada);
                
                return formatarBase64(senhaCriptografada);
        }

        /**
         * Verifica se a senha digitada é idêntica a senha criptografada.
         * 
         * @param senhaDigitada
         * @return boolean
         * @throws NoSuchAlgorithmException
         * @throws UnsupportedEncodingException
         */
        public boolean isSenhaValida(String senhaDigitada , String senhaArmazenada)
                        throws NoSuchAlgorithmException, UnsupportedEncodingException {
                
                return senhaDigitada.equals(senhaArmazenada);
        }

        /**
         * Criptografa a senha passada como parâmetro e retorna o array de bytes
         * correspondente.
         * 
         * @param senha
         *            senha a ser criptografada
         * @return byte[] array de bytes correspondente à senha criptografada
         * @throws NoSuchAlgorithmException
         * @throws UnsupportedEncodingException
         */
        private byte[] criptografarSenha(String senha)
                        throws NoSuchAlgorithmException, UnsupportedEncodingException {
                
                MessageDigest messageDigest = MessageDigest.getInstance(FUNCAO_HASH);
                return messageDigest.digest(senha.getBytes("UTF-8"));
        }

        /**
         * Realiza a formatação do array de bytes para o padrão Base64.
         * 
         * @param senhaCriptografada
         * @return String - senha criptografada formatada em Base64
         */
        private String formatarBase64(byte[] senhaCriptografada) {
                return Base64.encode(senhaCriptografada);
        } 
}