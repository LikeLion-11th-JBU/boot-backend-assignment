package dev.aquashdw.community.service;

import dev.aquashdw.community.model.MediaDescriptorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

public class LocalMediaService implements MediaService{
    private static final Logger logger = LoggerFactory.getLogger(MediaService.class);
    private final String basePath = "./media";
    @Override
    public MediaDescriptorDto saveFile(MultipartFile file) {
        return this.saveToDir(file);
    }

    @Override
    public Collection<MediaDescriptorDto> saveFileBulk(MultipartFile[] files) {
        Collection<MediaDescriptorDto> resultList = new ArrayList<>();
        for(MultipartFile file: files){
            resultList.add(this.saveFile(file));
        }
        return resultList;
    }

    @Override
    public byte[] getFileAsBytes(String resourcePath) {
        try {
            return Files.readAllBytes(Path.of(basePath, resourcePath));      //endpoint에 media가 붙은 것인데, 상황에 따라서 media가 안붙고 다른 것이 들어갈 수도 있으니까 media와 상관없이 요청한 파일명만 전달하면 안쪽에서 어떠한 경로로 그 파일을 찾아야 될지를 검증을 하기 위해서 readAllByte를 사용하였다.
        } catch (IOException e) {  //이때 IOException이 발생하기 때문에 catch로 처리해준다.
            logger.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    private MediaDescriptorDto saveToDir(MultipartFile file){
        MediaDescriptorDto descriptorDto = new MediaDescriptorDto();
        descriptorDto.setStatus(200);
        descriptorDto.setOriginalName(file.getOriginalFilename());
        try{
            LocalDateTime now = LocalDateTime.now();
            String targetDir = Path.of(
                    basePath,
                    now.format(DateTimeFormatter.BASIC_ISO_DATE)).toString();
            String newFileName = now.format(DateTimeFormatter.ofPattern("HHMMSS"))
                    + "_"
                    + file.getOriginalFilename();
            File dirNow = new File(targetDir);
            if(!dirNow.exists()) dirNow.mkdir();
            file.transferTo(Path.of(
                    targetDir,
                    newFileName
            ));
            descriptorDto.setResourcePath(Path.of(
                    targetDir,
                    newFileName).toString().substring(1)
            );
            return descriptorDto;
        }catch (IOException e){
            logger.error(e.getMessage());
            descriptorDto.setMessage("failed");
            descriptorDto.setStatus(500);
            return descriptorDto;

        }
    }
}
