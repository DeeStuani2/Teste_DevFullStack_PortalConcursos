package com.example.demo.controller;

import com.example.demo.model.Aprovado;
import com.example.demo.repo.AprovadoRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/aprovados")
@CrossOrigin(origins = "*")
public class AprovadoController {

    private final AprovadoRepository repo;

    // valor padrão caso falte no application.properties
    @Value("${app.upload-dir:uploads}")
    private String uploadDir;

    public AprovadoController(AprovadoRepository repo) {
        this.repo = repo;
    }

    // cria aprovado e salva imagem no disco
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Aprovado criar(
            @RequestPart("nome") String nome,
            @RequestPart("email") String email,
            @RequestPart("telefone") String telefone,
            @RequestPart("concursos") String concursos,
            @RequestPart(value = "imagem", required = false) MultipartFile imagem
    ) throws IOException {

        String imagemPath = null;

        if (imagem != null && !imagem.isEmpty()) {
            Path uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();
            Files.createDirectories(uploadPath);

            String ext = "";
            String original = imagem.getOriginalFilename();
            if (original != null && original.contains(".")) {
                ext = original.substring(original.lastIndexOf("."));
            }

            String filename = UUID.randomUUID() + ext;
            Path destino = uploadPath.resolve(filename);

            Files.copy(imagem.getInputStream(), destino, StandardCopyOption.REPLACE_EXISTING);

            // SALVA ABSOLUTO 
            imagemPath = destino.toString();
        }

        return repo.save(new Aprovado(nome, email, telefone, concursos, imagemPath));
    }

    // lista todos
    @GetMapping
    public List<Aprovado> listar() {
        return repo.findAll();
    }

    // retorna a imagem do aprovado
    @GetMapping("/{id}/imagem")
    public ResponseEntity<byte[]> imagem(@PathVariable Long id) throws IOException {
        Aprovado aprovado = repo.findById(id).orElse(null);

        if (aprovado == null || aprovado.getImagemPath() == null || aprovado.getImagemPath().isBlank()) {
            return ResponseEntity.notFound().build();
        }

        Path path = Paths.get(aprovado.getImagemPath());

        // Resolver Relatividade no UploadDir
        if (!path.isAbsolute()) {
            path = Paths.get(uploadDir).toAbsolutePath().normalize().resolve(path).normalize();
        }

        if (!Files.exists(path)) {
            return ResponseEntity.notFound().build();
        }

        String contentType = Files.probeContentType(path);
        if (contentType == null) contentType = "application/octet-stream";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body(Files.readAllBytes(path));
    }
}
