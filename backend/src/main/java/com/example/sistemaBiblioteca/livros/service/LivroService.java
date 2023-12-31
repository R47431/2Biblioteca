package com.example.sistemaBiblioteca.livros.service;

import org.springframework.stereotype.Service;

import com.example.sistemaBiblioteca.model.LivroModelo;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class LivroService {


    Path currentPath = Paths.get(System.getProperty("user.dir"));
    //Path desiredPath = currentPath.getParent();
    String diretorio = currentPath.toString() + "/imagem";

    public String diretorioDaImagem(LivroModelo livroModelo) {
        String nomeImagem = livroModelo.getLivroId() + ".jpg";
        return diretorio + File.separator + nomeImagem;
    }

}