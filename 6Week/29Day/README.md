# MyBatis

SQL의 작성할 때 편하게 해주며 JDBC DataSource를 통해 Connection Pool을 자동으로 사용을 한다.

작성 방법은 [Cafe](https://github.com/seungwoo505/cafe)의 코드에도 적혀있지만

우선 dao 파일을 수정해야한다.

```

@Mapper
public interface MemberDao {
	
	public Member login(Member m) throws Exception;
	
	public void insertMember(Member m) throws Exception;
	
}

```

MyBatis를 사용하기 전과 사용 후의 코드를 보면 차이가 많이 난다.

일단 interface로 작성을 해야한다는 점이 가장 큰 특징이다.

그 다음 할 일은 SQL문을 작성하는 것이다.

보통 resources/mapper 폴더 안에 xml 파일을 만들어 사용한다.

```

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
  
<mapper namespace="com.shop.coffe.dao.MemberDao">

  <select id="login" resultType="Member" parameterType="Member" >
    select * 
    from member
    where email=#{email}
    and pw = #{pw}
  </select>
  
  <insert id="insertMember" parameterType="Member" >
    insert into 
    member(email, pw, nickname)
    values(#{email}, #{pw}, #{nickname})
  </insert>
  
</mapper>

```

이와같이 작성된다.

Dao에 작성해야할 부분을 xml로 이동했다고 보면된다.

```

mybatis.type-aliases-package=com.shop.coffe.dto
mybatis.mapper-locations=mapper/*.xml

```

그 후에 application.properties 파일에 수정을 위와같이해야한다.

mybatis.type-aliases-package은 return 타입이든 parameter 타입이든

자체 제작 타입으로 지정해야할 때 지정하기 쉽게 하기위해 경로를 잡아주는 것이다.

현제 우리는 member 타입을 가져야하므로 com.shop.coffe.dto으로 선택한 것이다.

mybatis.mapper-locations은 SQL 코드를 모아둔 곳을 지정하는 것이다.

아까 resources/mapper 안에 xml 파일을 만든다고 했었으므로 모든 xml파일을 지정해야하니

mapper/*.xml 로 설정을 한 것이다.

# Connection Pull

1. 서버가 시작될 때 DB Connection을 미리 생성하여 Pool에 저장한다.
2. 사용자가 Connection Pool에서 Connection을 제공
3. DB 작업이 끝나고 Connection을 닫으면, 실제로 닫는 것이 아니라 Pool로 반환
4. 다음 사용자가 요청하면 새로 불러오는 것이 아닌 Pool에서 반환된 Connection을 재사용
5. 사용자가 많아지면 더 많은 Connection Pool을 생성
6. 사용자가 적어질 경우 유후 Connection을 제거하여 리소스 절약