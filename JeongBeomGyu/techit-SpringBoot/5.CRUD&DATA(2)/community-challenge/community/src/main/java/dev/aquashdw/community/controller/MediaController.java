package dev.aquashdw.community.controller;

import dev.aquashdw.community.model.MediaDescriptorDto;
import dev.aquashdw.community.service.MediaService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;

@RestController
@RequestMapping("media")
public class MediaController {
    private static final Logger logger = LoggerFactory.getLogger(MediaController.class);
    private final MediaService mediaService;

    public MediaController(@Autowired MediaService mediaService){
        this.mediaService = mediaService;
    }
    @PostMapping("upload")
    public ResponseEntity<MediaDescriptorDto> uploadMedia(
            @RequestParam("file")MultipartFile file){
        MediaDescriptorDto descriptorDto = this.mediaService.saveFile(file);        //mediaService의 saveFile 결과를 받아준다.
        return ResponseEntity
                .status(descriptorDto.getStatus())
                .body(descriptorDto);//ResponseEntity를 보낼 것인데 이때 ok가 아닌 status를 사용해서 IOException을 발생시키고 발생시킨것을 처리하는 것보다는 status로 처리한다. 그러기 위해서 MediaDsecriptDto에서 Integer 로 status를 넣어두었다. 이러면 status를 내부에서 사용할 수 있다.
    }       // -> 이렇게 하면 하나의 파일을 올리는 함수가 만들어진다.

    @PostMapping("upload-bulk")
    public ResponseEntity<Collection<MediaDescriptorDto>> uploadMediaBulk(
            @RequestParam("file") MultipartFile[] files  // 여러개의 파일을 동시에 올리는 것도 MultiPart Form 데이터로 진행하는 것이기는 하지만 이렇게 파라미터 이름을 동일하게 해서 여러개의 파일을 올려주게되면 SpringBoot에서 그것을 Array의 형식으로 가져올 수 있다.
    ){
        return ResponseEntity
                .status(HttpStatus.MULTI_STATUS)        // 한번에 여러개의 파일을 올리게 되니까 파일에 따라서 실제로 정상적으로 올라간것과 정상적으로 올라가지 않은 것이 두가지 경우가 있어서 Multi_STATUS로 놓고, 이렇게되면 클라이언트가 일일이 내용을 확을을 해서 정상적으로 파일들이 올라갔는지 확인을 해 달라는 의미가 된다.
                .body(this.mediaService.saveFileBulk(files));
    }

    @GetMapping("**")
    public ResponseEntity<byte[]> staticLikeEndpoint(
            HttpServletRequest request
    ){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);       //header 설정에다가 지금 보내고 있는 애들의 따라서 contentType을 설정을 해주려고 사용을 했던 부분이다.
        return new ResponseEntity<>(        //ResponseEntity를 새로 new를 통해서 만들고
                this.mediaService.getFileAsBytes(request.getRequestURI().split("media")[1]),    // 정적파일을 보내는 설정을 하지 않고 그냥 코드상에서 보내는 상황일 때
                headers,
                HttpStatus.OK
        );
    }
}
