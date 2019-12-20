package com.example.demo.controller;

import com.example.demo.Provider.GithubProvider;
import com.example.demo.dto.AccessTokenDTO;
import com.example.demo.dto.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubprovider;
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_id("6b9bc66c1a2b035d1736");
        accessTokenDTO.setClient_secret("d96356994684ca8f49007f865b0c0cbc6ebed18f");
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        String accessToken = githubprovider.getAccessToken(accessTokenDTO);
        GithubUser user = githubprovider.gethubuser(accessToken);
        System.out.println(user.getName());
        return "Index";
    }
}
