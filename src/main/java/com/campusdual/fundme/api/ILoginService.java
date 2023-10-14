package com.campusdual.fundme.api;

public interface ILoginService {

    boolean authenticate(String username, String password);

}