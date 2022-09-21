package com.test.demo.api;

import lombok.SneakyThrows;
import com.test.demo.model.TestFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.test.demo.repository.TestFileRepository;

import java.util.UUID;

@RestController
public class TestApi {

    @Autowired
    TestFileRepository repository;

    @PostMapping
    @SneakyThrows
    public void saveFile(@RequestParam("file") MultipartFile file) {
        this.repository.saveAndFlush(new TestFile(file.getBytes()));
    }

    @GetMapping(path = "/{id}")
    public byte[] getFile(@PathVariable("id") UUID id) {
        return repository.findById(id).get().getFile();
    }

    @GetMapping
    @ResponseBody
    public String test() {
        return "TESTa";
    }


}
