package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Client;

import java.util.Set;

public class ClientDTO {
    public Long id;
    public String firstName;
    public String lastName;
    public String email;

    public ClientDTO(Client client){
        this.id = client.getId();
        this.firstName= client.getFirstName();
        this.lastName = client.getLastName();
        this.email=client.getEmail();
    }
}