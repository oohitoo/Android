### 안드로이드 Layout

### IDE : Andriod Studio 

------------

#### 뷰의 영역 (그림의로 대체)
![뷰의 영역 구문](http://mooc.phinf.nhnnext.org/20180124_264/1516784342945mAiMu_JPEG/2.jpg?type=w760)<br>

속성명 | 사용법
---| :---: |
layout_gravity(뷰가 모두 채워지지 않을때 사용) | 왼쪽 `android:layout_gravity = "left"`<br>가운데 `android:layout_gravity = "center"`<br>오른쪽 `android:layout_gravity = "right"`
gravity(내용물을 정렬함) | 왼쪽 `android:gravity = "left"`<br>가운데 `android:gravity = "center"`<br>오른쪽 `android:gravity = "right"`<br>가로세로 가운데`android:gravity = "center_horizontal | center_vertical"`

#### Layout 종류
------------
레이아웃 이름 | 설명
---| :---: |
`ConstraintLayout` | 기본 디폴트 레이아웃
`LinearLayout` | 가로,세로 한방향으로 뷰를 구현 
`LinearLayout` | 가로 방향 `android:orientation = "horizontal"`<br> 세로방향 `android:orientation = "vertical"`
`RelativeLayout` | 상대적 위치로 화면을 구현
`FrameLayout` | 상위에 있는 뷰 or 뷰그룹 (여러개 Layout을 하나의 Layout 구현)
`TableLayout` | Html의 표와 동일함. 사용하는 경우가 거의 없음

#### gravity 속성
------------
속성 값 | 설명
---| :---: |
top / bottom / left / right | 객체를 위쪽, 아래쪽, 왼쪽, 오른쪽
center_vertical / center_horizontal | 객체를 수직 중앙, 수평 중앙
fill_vertical / fill_horizontal | 수직방향 여유 공간만큼 확대 후 채우기<br>수평방향 여유공간만큼 확대 후 채우기
center | 수직방향 수평방향 중앙
fill | 수직방향 수평방향 여우 공간만큼 확대
clip_vertical | 공간이 남을때 남는부분 잘라내기 <br> top, clip_vertical `아래쪽`에 남은공간 잘라내기<br>button, clip_vertical `위쪽`에 남은공간 잘라내기<br>center_vertical, clip_vertical `위쪽 아래쪽`에 남은공간 잘라내기
clip_horizontal | 공간이 남을때 남는부분 잘라내기 <br>right, clip_horizontal `왼쪽`에 남은공간 잘라내기<br>left, clip_horizontal `오른쪽`에 남은공간 잘라내기<br> center_horizontal, clip_horizontal `왼쪽 오른쪽`에 남은공간 잘라내기

#### RelativeLayout 속성
------------
속성 값 | 설명
---| :---: |
layout_alignParentTop | 부모 컨테이너의 위쪽과 뷰의 왼쪽 맞춤
layout_alignParentBottom | 부모 컨테이너의 아래쪽과 뷰의 아래쪽 맞춤
layout_alignParentLeft | 부모 컨테이너의 왼쪽끝과 뷰의 왼쪽 끝 맞춤
layout_alignParentRight | 부모 컨테이너의 오른쪽 끝과 뷰의 오른쪽 끝 맞춤
layout_centerHorizontal | 부모 컨테이너의 수평 방향 중앙
layout_centerVertical | 부모 컨테이너의 수직 방향 중앙
layout_centerInParent | 부모 컨테이너의 수평과 수직 방향 중앙

#### 텍스트 뷰의 속성
속성 값 | 설명
---| :---: |
textColor | #88FF0022 (#FF~88(투명도)0F(R)1F(G)2F(B))

#### 캘린더뷰
firstDayOfWeek : 제일 왼쪽의 첫 요일 (디폴트 1 : 일요일이 시작, 2: 월요일이 시작)
minDate : 달력에 표시할 최소 날짜
maxDate : 달력에 표시할 최대 날짜
focusedMonthDateColor : 현재 선택된 달의 배경 색상
selectedWeekBackgroundColor : 선택된 주의 배경 색상
unfocusedMonthDateColor : 선택되지 않은 달의 배경 색상
showWeekNumber : 왼쪽에 "1주차, 2주차, 3주차... "를 보여줄 것인가를 지정 (디폴트는 true)
weekNumberColor : "주(週)"차의 색상을 지정
weekSeparatorLineColor : 주 사이의 구분선. 디폴트는 투명한 색
selectedDateVerticalBar  : 선택한 날짜 양쪽에 보일 수직바에 대한 드로블

