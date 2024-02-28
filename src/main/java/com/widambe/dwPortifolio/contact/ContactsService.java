package com.widambe.dwPortifolio.contact;

import com.widambe.dwPortifolio.api.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsService {

    private final ContactsRepository contactsRepository;

    public ContactsService(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    public ApiResponse create_contact(Contacts contact_request){
        String responseMsg;
        contactsRepository.save(contact_request);

        responseMsg = "Your message was received successfully. We will get back to you in 24 hours.";
        return ApiResponse.builder().message(responseMsg).save(true).build();
    }

    public List<Contacts> getAll_contacts(){
        return contactsRepository.findAll();
    }
}
