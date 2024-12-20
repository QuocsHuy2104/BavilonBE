package com.pearus.bavilonbe.controller;

import com.nimbusds.jose.JOSEException;
import com.pearus.bavilonbe.dto.request.AuthenticationRequest;
import com.pearus.bavilonbe.dto.request.IntrospectRequest;
import com.pearus.bavilonbe.dto.request.LogoutRequest;
import com.pearus.bavilonbe.dto.request.RefreshTokenRequest;
import com.pearus.bavilonbe.dto.response.AuthenticationResponse;
import com.pearus.bavilonbe.dto.response.IntrospectResponse;
import com.pearus.bavilonbe.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        var result = authenticationService.authenticate(request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/verity")
    public ResponseEntity<IntrospectResponse> verityToken(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
        var result = authenticationService.introspect(request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logoutUser(@RequestBody LogoutRequest request) throws ParseException, JOSEException {
        authenticationService.logout(request);
        return new ResponseEntity<>("Logged out successfully", HttpStatus.OK);
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody RefreshTokenRequest request)
            throws ParseException, JOSEException {
        var result = authenticationService.refreshToken(request);
        return ResponseEntity.ok().body(result);
    }
}
