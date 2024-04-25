package com.example.Av1.service;

import com.example.Av1.model.ReleaseEntity;
import com.example.Av1.repository.NoticiaRepository;
import com.example.Av1.repository.ReleaseRepository;
import com.example.Av1.model.NoticiaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.UUID;

@Service
public class IbgeService {

    @Autowired
    private NoticiaRepository noticiaRepository;

    @Autowired
    private ReleaseRepository releaseRepository;

    public String obterNoticiasReleases() {
        String apiURL = "https://servicodados.ibge.gov.br/api/v3/noticias/";
        String dadosIbge = "";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiURL, String.class);

        dadosIbge = responseEntity.getBody();

        inserirNoticia();
        inserirRelease();

        return dadosIbge;
    }

    public String obterNoticias() {
        String apiURL = "https://servicodados.ibge.gov.br/api/v3/noticias/?tipo=noticia";
        String dadosIbge = "";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiURL, String.class);

        dadosIbge = responseEntity.getBody();

        return dadosIbge;
    }

    public String obterReleases() {
        String apiURL = "https://servicodados.ibge.gov.br/api/v3/noticias/?tipo=release";
        String dadosIbge = "";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiURL, String.class);

        dadosIbge = responseEntity.getBody();

        return dadosIbge;
    }

    private void inserirNoticia() {

        String noticias = obterNoticias();

        NoticiaEntity noticiaEntity = new NoticiaEntity();

        UUID uuid = UUID.randomUUID();
        noticiaEntity.setId(uuid.toString());
        noticiaEntity.setNoticia(noticias);

        noticiaRepository.save(noticiaEntity);
    }

    private void inserirRelease() {

        String releases = obterReleases();

        ReleaseEntity releaseEntity = new ReleaseEntity();

        UUID uuid = UUID.randomUUID();
        releaseEntity.setId(uuid.toString());
        releaseEntity.setRelease(releases);

        releaseRepository.save(releaseEntity);
    }

}

