package user.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="usertable")
@Data
public class UserDTO {
	@Column(name="name", nullable = false, length = 30)
	private String name;
	
	@Id//primary key
	@Column(name="id", nullable = false, length = 30)
	private String id;
	
	@Column(name="pwd", nullable = false, length = 30)
	private String pwd;

}

/*
@EntityScan
어노테이션으로 엔티티 클래스를 스캔할 곳을 지정하는데 사용한다.
메인 어플리케이션 패키지 내에 엔티티 클래스가 없는 경우 어노테이션을 사용해서 패키지밖에 존재하는 
엔티티를 지정할 수 있다.
기본적으로 @EnableAutoConfiguration 어노테이션에 의해서 지정한 곳에서 엔티티를 스캔한다.

@EnableJpaRepositories
- JpaRepository에 대한 설정정보를 자동적으로 로딩하고 이 정보를 토대로 Repository 빈을 등록하는 역할을 한다

Optional 클래스란?
- Optional이란 'null일 수도 있는 객체'를 감싸는 일종의 Wrapper 클래스이다.

*/
