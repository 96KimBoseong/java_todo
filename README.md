# java_todo

- [x]  생성 - 일정 작성
    - [x]  `할 일 제목`, `할 일 내용`, `담당자`, `비밀번호`, `작성일` 을 저장할 수 있습니다.
        - [x]  저장된 일정 정보를 반환 받아 확인할 수 있습니다.
- [x]  조회 - 선택한 일정 조회(상세 페이지)
    - [x]  선택한 일정의 정보를 조회할 수 있습니다.
    - [x]  반환 받은 일정 정보에는 `할 일 제목`,`할 일 내용`, `작성일`, `작성자 이름` 정보가 들어있습니다.
- [x]  조회 - 일정 목록 조회
    - [x]  등록된 일정 전체를 조회할 수 있습니다.
    - [x]  조회된 일정 목록은 `작성일` 기준 내림차순으로 정렬 되어있습니다.
- [x]  수정 - 선택한 일정 수정
    - [x]  선택한 일정의 `할 일 제목`, `할 일 내용`, `담당자`를 수정할 수 있습니다.
    - [x]  서버에 일정 수정을 요청할 때 `비밀번호`를 함께 전달합니다.
        - [x]  생성 시에, 입력한 비밀번호와 일치할 경우에만 수정할 수 있습니다.
    - [x]  수정된 일정의 정보를 반환 받아 확인할 수 있습니다.
- [x]  삭제 - 선택한 일정 삭제
    - [x]  서버에 일정 삭제를 요청할 때 `비밀번호`를 함께 전달합니다.
        - [x]  생성 시에, 입력한 비밀번호와 일치할 경우에만 수정할 수 있습니다.

---
### 택 구현 기능(요구사항)

- [ ]  [`HTTP 상태 코드(링크)`](https://developer.mozilla.org/ko/docs/Web/HTTP/Status)와 `에러 메시지`를 포함한 정보를 사용, 예외처리
    - 설명
        - 필요에 따라 사용자 정의 예외 클래스를 생성하여 예외 처리를 수행할 수 있습니다.
        - **`@ExceptionHandler`**를 활용하여 공통 예외 처리를 구현할 수도 있습니다.
        - 예외가 발생할 경우 적절한 HTTP 상태 코드와 함께 사용자에게 메시지를 전달하여 상황을 관리
    - 조건
        - [ ]  수정, 삭제 시 요청할 때 보내는 `비밀번호`가 일치하지 않을 때
        - [ ]  선택한 일정 정보가 이미 삭제되어 조회할 수 없을 때
        - [ ]  삭제하려는 일정 정보가 이미 삭제 상태일 때
- [ ]  `Swagger` 활용 / 파라미터 유효성 검사 / **`null 체크`** / **`특정 패턴`**에 대한 검증
    - 설명
        - Swagger
            - API 명세서를 직접 작성하는 대신 [**`Swagger(링크)`**](https://springdoc.org/#Introduction)를 활용하여 자동으로 생성할 수 있습니다.
            - 개발자는 코드와 함께 API 명세서를 업데이트하고 관리할 수 있어서 `개발 생산성`을 높일 수 있습니다.
            - Swagger UI를 통해 직관적인 인터페이스를 통해 API를 쉽게 이해하고 테스트할 수 있습니다.
        - 유효성 검사
            - 잘못된 입력이나 요청을 미리 방지할 수 있습니다.
            - 데이터의 `무결성을 보장`하고 애플리케이션의 예측 가능성을 높여줍니다.
            - Spring에서 제공하는 **`@Valid`** 어노테이션을 이용할 수 있습니다.
    - 조건
        - [ ]  Swagger
            - [ ]  Swagger UI를 통해 API 목록을 확인할 수 있다.
            - [ ]  Swagger UI를 통해 API 테스트를 할 수 있다.
        - [ ]  유효성 검사
            - [ ]  `할일 제목`은 최대 200자 이내로 제한, 필수값 처리
            - [ ]  `비밀번호`는 필수값 처리
            - [ ]  `담당자`는 이메일 형식을 갖도록 처리
             
---

### 3주차 요구사항

- [ ]  일정과 댓글의 연관 관계
    - [ ]  이전 주차에서 만든 일정에 댓글을 추가
    - [ ]  ERD에도 댓글 모델을 추가
    - [ ]  각 일정에 댓글을 작성할 수 있도록 관련 클래스를 추가하고 연관 관계를 설정
    - [ ]  매핑 관계를 설정 (1:1 or N:1 or N:M)
        
        
        | 댓글 필드 | 데이터 유형 |
        | --- | --- |
        | 아이디 (고유번호) | bigint |
        | 댓글 내용 | varchar |
        | 사용자 아이디 | varchar |
        | 일정 아이디 | bigint |
        | 작성일자 | timestamp |
- [ ]  댓글 등록
    - [ ]  댓글이 등록되었다면 client에게 반환합니다.
    - [ ]  선택한 일정이 DB에 저장되어 있어야 합니다.
    - [ ]  댓글을 식별하는 `고유번호`, `댓글 내용`, 댓글을 작성한 `사용자 아이디`, 댓글이 작성된 `일정 아이디`, `작성일자`를 저장할 수 있습니다.
    - [ ]  예외처리
        - [ ]  선택한 일정의 ID를 입력 받지 않은 경우
        - [ ]  댓글 내용이 비어 있는 경우
        - [ ]  일정이 DB에 저장되지 않은 경우
- [ ]  댓글 수정
    - [ ]  댓글이 수정되었다면 수정된 댓글을 반환합니다.
    - [ ]  `댓글 내용`만 수정 가능합니다.
    - [ ]  선택한 일정과 댓글이 DB에 저장되어 있어야 합니다.
    - [ ]  예외 처리
        - [ ]  선택한 일정이나 댓글의 ID를 입력 받지 않은 경우
        - [ ]  일정이나 댓글이 DB에 저장되지 않은 경우
        - [ ]  선택한 댓글의 사용자가 현재 사용자와 일치하지 않은 경우
- [ ]  댓글 삭제
    - [ ]  성공했다는 메시지와 상태 코드 반환하기
    - [ ]  선택한 일정과 댓글이 DB에 저장되어 있어야 합니다.
    - [ ]  예외 처리
        - [ ]  선택한 일정이나 댓글의 ID를 입력받지 않은 경우
        - [ ]  일정이나 댓글이 DB에 저장되지 않은 경우
        - [ ]  선택한 댓글의 사용자가 현재 사용자와 일치하지 않은 경우

---
- [ ]  JWT
    - [ ]  JWT를 이용한 인증/인가를 구현한다.
    - [ ]  위 CRUD 단계에서 인증/인가가 완료된 후에만 기능이 동작하도록 수정한다.
    - [ ]  조건
        - [ ]  Access Token 만료시간 60분
        - [ ]  Refresh Token 구현은 선택
    - [ ]  예외처리
        - [ ]  공통조건
            - [ ]  StatusCode : 400 / client에 반환
        - [ ]  토큰이 필요한 API 요청에서 토큰을 전달하지 않았거나 정상 토큰이 아닐 때
            - [ ]  에러 메세지 : “토큰이 유효하지 않습니다.”
        - [ ]  토큰이 있고, 유효한 토큰이지만 해당 사용자가 작성한 게시글/댓글이 아닐 때
            - [ ]  에러 메세지 : “작성자만 삭제/수정할 수 있습니다.”
        - [ ]  DB에 이미 존재하는 `username`으로 회원가입을 요청할 때
            - [ ]  에러 메세지 : “중복된 `username` 입니다.”
        - [ ]  로그인 시, 전달된 `username`과 `password` 중 맞지 않는 정보가 있을 때
            - [ ]  에러 메시지 : “회원을 찾을 수 없습니다.”
        - [ ]  StatusCode 나누기
            - [ ]  StatusCode를 다르게 정의하고 싶다면 참고하세요.
            - [ ]  [https://hongong.hanbit.co.kr/http-상태-코드-표-1xx-5xx-전체-요약-정리/](https://hongong.hanbit.co.kr/http-%EC%83%81%ED%83%9C-%EC%BD%94%EB%93%9C-%ED%91%9C-1xx-5xx-%EC%A0%84%EC%B2%B4-%EC%9A%94%EC%95%BD-%EC%A0%95%EB%A6%AC/)
- [ ]  회원가입
    - 사용자의 정보를 전달 받아 유저 정보를 저장한다.
        
        
        | 사용자 필드 | 데이터 유형 |
        | --- | --- |
        | 아이디 | bigint |
        | 별명 | varchar |
        | 사용자이름 (username) | varchar |
        | 비밀번호 (password) | varchar |
        | 권한 (일반, 어드민) | varchar |
        | 생성일 | timestamp |
    - [ ]  조건
        - [ ]  패스워드 암호화는 선택적으로 구현
        - [ ]  `username`은  `최소 4자 이상, 10자 이하이며 알파벳 소문자(a~z), 숫자(0~9)`로 구성
    - [ ]  `password`는  `최소 8자 이상, 15자 이하이며 알파벳 대소문자(a~z, A~Z), 숫자(0~9)`로 구성
    - [ ]  DB에 중복된 `username`이 없다면 회원을 저장하고 Client 로 성공했다는 메시지, 상태코드 반환
- [ ]  로그인
    - `username`, `password` 정보를 client로부터 전달받아 토큰을 반환한다.
    - DB에서 `username`을 사용하여 저장된 회원의 유무를 확인한다.
        - 저장된 회원이 있다면 `password` 를 비교하여 로그인 성공 유무를 체크한다
    - [ ]  조건
        - [ ]  패스워드 복호화는 선택적으로 구현 (위 회원가입의 암호화와 동일)
        - [ ]  로그인 성공 시 로그인에 성공한 유저의 정보와 JWT를 활용하여 토큰을 발급
        - [ ]  발급한 토큰을 `Header`에 추가하고 성공했다는 메시지 및 상태코드와 함께 client에 반환
