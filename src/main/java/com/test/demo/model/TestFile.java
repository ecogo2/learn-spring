package com.test.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "test_file")
@Getter
@Setter
public class TestFile {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Basic
    @Lob
    @Column(name = "file")
    private byte[] file;

    public TestFile(byte[] file) {
        this.name = "ime";
        this.file = file;
    }

    public TestFile() {

    }

    @PrePersist
    private void prePersist() {
        if(this.id == null)
            this.id = UUID.randomUUID();
    }

}
