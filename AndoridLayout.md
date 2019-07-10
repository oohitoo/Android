### 안드로이드 Layout

### IDE : Andriod Studio 

------------

#### 뷰의 영역 (그림의로 대체)
------------
![뷰의 영역 구문](https://twogrenade.tistory.com/26)
속성명 | 사용법
---| :---: |
layout_gravity(뷰가 모두 채워지지 않을때 사용) | 왼쪽 `android:layout_gravity = "left"`
 | 가운데 `android:layout_gravity = "center"`
 | 오른쪽 `android:layout_gravity = "right"`
gravity(내용물을 정렬함) | 왼쪽 `android:gravity = "left"`
 | 가운데 `android:gravity = "center"`
 | 오른쪽 `android:gravity = "right"`
 | 가로세로 가운데 `android:gravity = "center_horizontal | center_vertical"`

#### Layout 종류
------------
레이아웃 이름 | 설명
---| :---: |
`ConstraintLayout` | 기본 디폴트 레이아웃
`LinearLayout` | 가로,세로 한방향으로 뷰를 구현 
| 가로 방향 `android:orientation = "horizontal"`, 세로방향 `android:orientation = "vertical"`
`RelativeLayout` | 상대적 위치로 화면을 구현
`FrameLayout` | 상위에 있는 뷰 or 뷰그룹 (여러개 Layout을 하나의 Layout 구현)
`TableLayout` | Html의 표와 동일함. 사용하는 경우가 거의 없음

#### gravity 속성
속성 값 | 설명
---| :---: |
top / bottom / left / right | 객체를 위쪽, 아래쪽, 왼쪽, 오른쪽
center_vertical / center_horizontal | 객체를 수직 중앙, 수평 중앙
fill_vertical / fill_horizontal | 수직방향 여유 공간만큼 확대 후 채우기, 수평방향 여유공간만큼 확대 후 채우기
center | 수직방향 수평방향 중앙
fill | 수직방향 수평방향 여우 공간만큼 확대
clip_vertical | 공간이 남을때 남는부분 잘라내기
 | top, clip_vertical `아래쪽`에 남은공간 잘라내기
 | button, clip_vertical `위쪽`에 남은공간 잘라내기
 | center_vertical, clip_vertical `위쪽 아래쪽`에 남은공간 잘라내기
clip_horizontal | 공간이 남을때 남는부분 잘라내기
 | right, clip_horizontal `왼쪽`에 남은공간 잘라내기
 | left, clip_horizontal `오른쪽`에 남은공간 잘라내기
 | center_horizontal, clip_horizontal `왼쪽 오른쪽`에 남은공간 잘라내기


#### RelativeLayout 속성
속성 값 | 설명
---| :---: |
layout_alignParentTop