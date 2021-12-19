package dw.study.webservice.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
//DB Layer 접근자 (Dao)
//Jpa에서는 Repository로 부르고, 인터페이스로 생성함
//JpaRepository<entity class, pk> 상속 시 기본적인 crud 메소드 자동 생성
// @Repository 추가할필요 없음
// Entity class와 기본 entity repository는 함께 위치해야함
