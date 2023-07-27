package com.Sung.jpa;

import com.Sung.jpa.entity.PostEntity;
import com.Sung.jpa.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.Iterator;
import java.util.Optional;

@Repository
public class PostDao {      //PostEntity 를 다루는 PostDao
    private static final Logger logger = LoggerFactory.getLogger(PostDao.class);
    private final PostRepository postRepository;
    public PostDao(
            @Autowired PostRepository postRepository
    ){
        this.postRepository = postRepository;
    }
    public void createPost(PostDto dto){
        PostEntity postEntity = new PostEntity();   // save에 들어가는 것은 Entity 이다. 그러므로 PostEntity 객체를 생성해준다.
        postEntity.setTitle(dto.getTitle());
        postEntity.setContent(dto.getContent());
        postEntity.setWriter(dto.getWriter());
        postEntity.setBoardEntity(null);
        this.postRepository.save(postEntity);          // save에 들어가는것은 postEntity이다.
    }
    public PostEntity readPost(int id){
        Optional<PostEntity> postEntity =this.postRepository.findById((long) id);       // 옵셔널(Board의 null 포인트에 대해서 대처하는 방법)로 결과가 돌아오게 된다. -> 옵셔널이란 null포인트 예외에 대해서 대처하는 방법중 하나이다.
        if(postEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);                // null 에서부터 도망치는 것이다.
        }
        return postEntity.get();                                        // ResponseStatusException 에 대한 결과를 return 값으로 받는다.
    }
    public Iterator<PostEntity> readPostAll(){          // Iterator로 응답형태를 바꿨다. Iterator이므로 postRepository의 findAll을 바로 return값으로 받아올 수 있다.
        return this.postRepository.findAll().iterator();        // 위에서 Exception에 대한 처리를 했기 때문에 여기서는 예외가 발생하지 않는다. (비어있을 수는 있다.)
    }
    public void updatePost(int id, PostDto dto){            // updatePost 는 create와 유사하게 해주면 된다.
        Optional<PostEntity> targetEntity = this.postRepository.findById(Long.valueOf(id));   // save에 들어가는 것은 Entity 이다. 그러므로 PostEntity 객체를 생성해준다.
        if(targetEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        PostEntity postEntity = targetEntity.get();
        postEntity.setTitle(dto.getTitle() == null ? postEntity.getTitle() : dto.getTitle());   // 삼항연산자를 사용해서 getTitle이 null이 참이면 postEntity 의 getTitle 을 넣는다.
        postEntity.setContent(dto.getContent() == null ? postEntity.getContent() : dto.getContent());
        postEntity.setWriter(dto.getWriter() == null ?  postEntity.getWriter() : dto.getWriter());
        this.postRepository.save(postEntity);          // save에 들어가는것은 postEntity이다.
    }
    public void deletePost(int id){
        // this.postRepository.deleteById((long) id);// save가 create와 update 양쪽에 통용이 되기 때문에 save만 사용해도 된다. 로 해도되고
        Optional<PostEntity> targetEntity = this.postRepository.findById((long) id);
        if (targetEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        this.postRepository.delete(targetEntity.get());

    }
}