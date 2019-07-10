### 안드로이드 

다국어 지원함으로 사용은 아래와 같이 한다.

`프로젝트 경로\app\src\main\res\` 아래 `values-국가코드(2자리)` 로 폴더를 생성한다.
만든 폴더 안에 `strings.xml` 동일한 파일명으로 생성한다.

`res/values/strings.xml` 파일에 다국어 버전 아래와 같이 만들어준다.
```xml
<resources>
    <string name ="multi_caption">My Application</string>
    <string name ="multi_buttoncation">Press Me</string>
    .... 이하생략 ...
</resources>
```

작성 하는 java 코드로 가서 `R.string.이름` 으로 설정한다.
R.layout.작성레이아웃 으로 가서 text를 `@string/설정한 name을 입력`
