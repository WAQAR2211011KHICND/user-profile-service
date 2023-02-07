package com.xloop.resourceloop.candidateprofile.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.xloop.resourceloop.candidateprofile.model.CandidateCertificates;
import com.xloop.resourceloop.candidateprofile.repository.ICandidateCertificatesRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CertificatesService {

    @Value("${application.bucket.name}")
    private String bucketName;

    @Autowired
    private AmazonS3 s3Client;

    @Autowired
   private ICandidateCertificatesRepository certificatesRepo;

    public List<String> uploadFile(MultipartFile file) {
    //     String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
    // String bucketName = "your-bucket-name";
    // try {
    //     s3Client.putObject(bucketName, fileName, file.getInputStream(), new ObjectMetadata());
    //     return s3Client.getUrl(bucketName, fileName).toString();
    // } catch (IOException e) {
    //     e.printStackTrace();
    //     return null;
    // }
        File fileObj = convertMultiPartFileToFile(file);
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        s3Client.putObject(new PutObjectRequest(bucketName, fileName, fileObj));
        fileObj.delete();
        List<String> arr= new ArrayList<String>();
        arr.add(fileName);
        arr.add(s3Client.getUrl(bucketName, fileName).toString());
        return arr;
        

    }


    public byte[] downloadFile(String fileName) {
        S3Object s3Object = s3Client.getObject(bucketName, fileName);
        S3ObjectInputStream inputStream = s3Object.getObjectContent();
        try {
            byte[] content = IOUtils.toByteArray(inputStream);
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public String deleteFile(String fileName) {
        s3Client.deleteObject(bucketName, fileName);
        return fileName + " removed ...";
    }


    private File convertMultiPartFileToFile(MultipartFile file) {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            log.error("Error converting multipartFile to file", e);
        }
        return convertedFile;
    }

    public void deleteCertificate(Long id){
        certificatesRepo.deleteById(id);
    }
    public CandidateCertificates create(CandidateCertificates certificate){
        return certificatesRepo.save(certificate);
    }

    public List <CandidateCertificates> get_all_certificates(){
      return certificatesRepo.findAll();
    }
    public CandidateCertificates get_certificate_by_id(long id){
        return certificatesRepo.findById(id).orElse(null);
    }
    public List <CandidateCertificates> get_all_certificates_of_user(long id){
        return certificatesRepo.findAllByUserId(id);

    }
}