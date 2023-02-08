package com.xloop.resourceloop.candidateprofile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.xloop.resourceloop.candidateprofile.model.CandidateCertificates;
import com.xloop.resourceloop.candidateprofile.service.CertificatesService;

@CrossOrigin
@RestController
@RequestMapping("api/file")
public class CertificatesController {

    @Autowired
    private CertificatesService service;

    @PostMapping("/upload")
    public ResponseEntity<CandidateCertificates> uploadFile(@RequestParam(value = "file") MultipartFile file,
            @RequestParam(value = "filename") String name, @RequestParam(value = "user_id") Long userid,@RequestParam String category) {
        List<String> arr = service.uploadFile(file);
        CandidateCertificates cert = new CandidateCertificates(userid, name, arr.get(1), arr.get(0), category);

        return new ResponseEntity<>(service.create(cert), HttpStatus.OK);
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) {
        byte[] data = service.downloadFile(fileName);
        ByteArrayResource resource = new ByteArrayResource(data);
        return ResponseEntity
                .ok()

                .contentLength(data.length)
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<List<CandidateCertificates>> getAllCertifcatesByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(service.get_all_certificates_of_user(userId), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CandidateCertificates>> getAllCertificates() {
        return new ResponseEntity<>(service.get_all_certificates(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFile(@PathVariable Long id) {
        CandidateCertificates existedCert = service.get_certificate_by_id(id);
        if (existedCert == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            service.deleteFile(existedCert.getBucketFileName());
            service.deleteCertificate(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
}