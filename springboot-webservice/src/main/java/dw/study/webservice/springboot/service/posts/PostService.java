package dw.study.webservice.springboot.service.posts;

import dw.study.webservice.springboot.domain.posts.Posts;
import dw.study.webservice.springboot.domain.posts.PostsRepository;
import dw.study.webservice.springboot.web.dto.PostUpdateRequestDto;
import dw.study.webservice.springboot.web.dto.PostsResponseDto;
import dw.study.webservice.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id: "+id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id: "+id));
        return new PostsResponseDto(entity);
    }
}
