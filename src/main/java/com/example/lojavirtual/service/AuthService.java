package com.example.lojavirtual.service;

import com.example.lojavirtual.entity.CartEntity;
import com.example.lojavirtual.entity.builder.CartEntityBuilder;
import com.example.lojavirtual.entity.builder.UserEntityBuilder;
import com.example.lojavirtual.entity.UserEntity;
import com.example.lojavirtual.request.LoginRequest;
import com.example.lojavirtual.request.SignupRequest;
import com.example.lojavirtual.repository.UserRepository;
import com.example.lojavirtual.util.FunctionsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public Long login(LoginRequest user) {

        Optional<UserEntity> userFound = userRepository.findByEmailAndPass(user.getEmail(), user.getPass());

        if (userFound.isPresent()) {

            AuthSingleton authSingleton = AuthSingleton.getSingleton();
            authSingleton.registerAuth(userFound.get().getId());
            return userFound.get().getId();
        }

        return 0L;
    }

    public int signup(SignupRequest user) {

        // Verificar os dados para criar login

        //NOME
        if (user.getName().trim().equals("") && user.getName().trim().split(" ").length < 2) {
            return 1;
        }
        //CPF
        if (user.getCPF().length() != 11 && user.getCPF().equals(null)) {
            return 2;
        } else {

            int[] arry;
            arry = ConverterCPF(user.getCPF());

            int retorno = checkCPF(arry);

            if (retorno == 2){
                return 2;
            }
        }

        //EMAIL
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(user.getEmail());
        if(!matcher.find()) {
            return 3;
        }
        //SENHA
        if (user.getPass().length() < 6) {
            return 4;
        }

        if (userRepository.existsByCpf(user.getCPF())) {
            return 5;
        }

        if (!(user.getComercialaddress().equals("") ||user.getComercialaddress().contains("Rua") || user.getComercialaddress().contains("Avenida") || user.getComercialaddress().contains("Av.") || user.getComercialaddress().contains("Conjunto") || user.getComercialaddress().contains("Conj."))){
            return 6;
        }

        if (!(user.getResidencialaddress().equals("") || user.getResidencialaddress().contains("Rua") || user.getResidencialaddress().contains("Avenida") || user.getResidencialaddress().contains("Av.") || user.getResidencialaddress().contains("Conjunto") || user.getResidencialaddress().contains("Conj."))){
            return 7;
        }

        if (!(user.getComercialphone().length() == 11 || user.getComercialphone().equals(""))) {
            return 8;
        }

        if (!(user.getResidencialphone().length() == 11  || user.getResidencialphone().equals(""))) {
            return 9;
        }

        if (user.getCellphone().length() != 11) {
            return 10;
        }

        UserEntity userEntity =   UserEntityBuilder.builder()
                .withName(user.getName())
                .withPass(user.getPass())
                .withCPF(user.getCPF())
                .withEmail(user.getEmail())
                .withComercialAddress(user.getComercialaddress())
                .withResidencialAddress(user.getResidencialaddress())
                .withComercialPhone(user.getComercialphone())
                .withResidencialPhone(user.getResidencialphone())
                .withCellPhone(user.getCellphone())
                .withPermission(user.getPermission())
                .build();

        CartEntity cart = CartEntityBuilder.builder()
                .withUser(userEntity)
                .withRemoteIp(FunctionsUtils.getUserRemoteIpAddress())
                .build();

        userEntity.setCart(cart);

        userRepository.save(userEntity);

        return 0;
    }

    private int[] ConverterCPF(String cpf){
        int[] arry = new int[11];

        for(int i = 0; i < cpf.length(); i++){
            arry[i] = Integer.parseInt(String.valueOf(cpf.charAt(i)));
        }

        return arry;
    }

    private int checkCPF(int[] arry){
        int soma1 = (10*arry[0]) + (9*arry[1]) + (8*arry[2]) + (7*arry[3]) + (6*arry[4]) + (5*arry[5]) + (4*arry[6]) + (3*arry[7]) + (2*arry[8]) ;
        int soma2 = (11*arry[0]) + (10*arry[1]) + (9*arry[2]) + (8*arry[3]) + (7*arry[4]) + (6*arry[5]) + (5*arry[6]) + (4*arry[7]) + (3*arry[8]) + (2*arry[9]);
        int verificador1 = arry[9];
        int verificador2 = arry[10];


        if (soma1%11 == 0 || soma1%11 == 1){
            if(verificador1!=0){
                return 2;
            }
        }else if(verificador1 != 11-(soma1%11)){
            return 2;
        }

        if (soma2%11 == 0 || soma2%11 == 1){
            if(verificador2!=0){
                return 2;
            }
        }else if(verificador2 != 11-(soma2%11)){
            return 2;
        }
        return 0;
    }

}
