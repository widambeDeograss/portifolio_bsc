package com.widambe.dwPortifolio.contact;


import com.widambe.dwPortifolio.api.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/contact_us")
public class ContactsController {

    private final ContactsService contactsService;

    public ContactsController(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> contact_us(
            @RequestBody Contacts contact_request
    ){
        return ResponseEntity.ok(contactsService.create_contact(contact_request));
    }

    @GetMapping
    public ResponseEntity<List<Contacts>> get_contacts(){
        return ResponseEntity.ok(contactsService.getAll_contacts());
    }

}
