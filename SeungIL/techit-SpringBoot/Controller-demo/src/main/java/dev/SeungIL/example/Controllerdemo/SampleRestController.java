package dev.SeungIL.example.Controllerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController // 이걸 Controller 어노테이션 대신사용하면 ResponseBody어노테이션 안써도됨.
@RequestMapping("/rest") // 클래스 자체에 할 수 있는데 url에 경로 지정한 것임.
public class SampleRestController {
    private static final Logger logger = LoggerFactory.getLogger(SampleRestController.class);

    @PostMapping(
            value = "/sample-multipart",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void sampleMultipartPost(
            @RequestParam("name")String name,
            @RequestParam("age")Integer age,
            @RequestParam("occupation")String occupation,
            @RequestParam(value = "file",required = false)MultipartFile multilpartFile
            ){
                logger.info("name" + name);
                logger.info("age" + age);
                logger.info("occupation" + occupation);
                logger.info("file original name:" + multilpartFile.getOriginalFilename());


    }
    @GetMapping("/sample-payload")
    public SamplePayload samplePayloadGet() {
        return new SamplePayload("SeungIL", 10, "Developer");
    }
    @PostMapping("/sample-payload")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void samplePayloadPost(@RequestBody SamplePayload samplePayload){
        logger.info(samplePayload.toString());
    }
    @GetMapping(
            value = "/sample-image",
            produces = MediaType.IMAGE_PNG_VALUE
    )
    public byte[] sampleImage() throws IOException{
        InputStream inputStream = getClass().getResourceAsStream("/static/img.png");


        return inputStream.readAllBytes();
    }
    // 이미지든 영상이든 byte를 돌려주는것임.
    // 만약 그게아니라 결과를 stream 해줘야 되면

}
