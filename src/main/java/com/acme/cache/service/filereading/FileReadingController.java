package com.acme.cache.service.filereading;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static java.nio.charset.StandardCharsets.UTF_8;

@RestController
public class FileReadingController {

    @Value("classpath:/files/hello.txt")
    private Resource helloFile;

    @Value("classpath:/files/hellozip.zip")
    private Resource helloZipFile;

    @Autowired
    private ResourceLoader resourceLoader;

    @RequestMapping(value = "/filereading/resource", produces = MediaType.APPLICATION_JSON_VALUE)
    public String sendFileAsString() throws IOException {
        return StreamUtils.copyToString(helloFile.getInputStream(), UTF_8);
    }

    @RequestMapping(value = "/filereading/lazy")
    public String sendFileAsStringLazyLoad() throws IOException {
        return StreamUtils.copyToString(resourceLoader
                .getResource("classpath:/files/hello.txt")
                .getInputStream(), UTF_8);
    }

    @RequestMapping(value = "/filereading/zip")
    public String sendZippedFileAsString() throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(helloZipFile.getInputStream());
        zipInputStream.getNextEntry();
        return StreamUtils.copyToString(zipInputStream, UTF_8);
    }
}
