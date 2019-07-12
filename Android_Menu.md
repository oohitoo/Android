#### 안드로이드 메뉴 관련 (메뉴 버튼)

> 메뉴 버튼을 클릭하면 드롭다운 메뉴 보이기
```java
    // 아이템 클릭시 변경 하게 하는곳 메소드
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemRed:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case  R.id.itemBlue:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.subRotate:
                // 버튼을 45도 돌리기
                button1.setRotation(45);
                return true;
            case R.id.subSize:
                // 현재 Size에 2배로 크게 만들기
                button1.setScaleX(2);
                return true;
        }
        return false;
    }
```

메뉴를 만드는 법은 총 2가지 방법이 있다.

   1. res -> `menu` 폴더생성 -> `menu1.xml`을 생성하여 추가 
```xml
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/itemRed"
        android:title="배경색(빨강)">
    </item>
    <item
        android:id="@+id/itemGreen"
        android:title="배경색(초록)">
    </item>
    <item
        android:id="@+id/itemBlue"
        android:title="배경색(파랑)">
    </item>
</menu>
```
   2. java(Activity 에서 사용)
```java
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(0,1,0, "배경색 (빨강)");
        menu.add(0,2,0, "배경색 (초록)");
        menu.add(0,3,0, "배경색 (파랑)");

        SubMenu subMenu = menu.addSubMenu("버튼 변경 >>");
        subMenu.add(0,4,0,"버튼 45도 회전");
        subMenu.add(0,5,0,"버튼 2배 확대");

        return true;
    }
```

> 버튼을 길게 눌러 메뉴 보이기

```java
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
                                                                                                     
        //xml로 만들어진 menu를 java파일로 가져오는곳이다.                                                          
        MenuInflater menuInflater = getMenuInflater();

        // 어떤 버튼을 클릭 했는지 확인 
        if(v == button1){
            menu.setHeaderTitle("배경색 변경");
            menu.setHeaderIcon(R.drawable.icon1);
            menuInflater.inflate(R.menu.menu1, menu);
        }
        if(v == button2){
            menuInflater.inflate(R.menu.menu2, menu);
        }
    }

    // 클릭했다면 Switch문을 통해 변경 한다.
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        super.onContextItemSelected(item);
        switch (item.getItemId()){
            case R.id.itemRed:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.itemBlue:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.subRotate:
                button2.setRotation(45);
                return true;
            case R.id.subSize:
                button1.setScaleX(2);
                return true;
        }
        return false;
    }
```

> 버튼 클릭하면 토스트 메세지를 생성한다. 위치는 랜덤

```java
    Toast toast = Toast.makeText(getApplicationContext(), "토스트 연습", Toast.LENGTH_LONG);
    Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
    int xOffset = (int) (Math.random() * display.getWidth());
    int yOffset = (int) (Math.random() * display.getHeight());

    //setGravity(TOP | LEFT , X좌표 , Y좌표)
    toast.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);
    toast.show();
```

> 다이얼 로그 뛰우기

   1. 다이얼 로그에 글
   
```java
final Button button1 = (Button)findViewById(R.id.button1);
button1.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
    final String[] versionArray = new String[]{"진저브레드", "허니콜" ,"아이스크림"};
    AlertDialog.Builder dig = new AlertDialog.Builder(Main6Activity.this);
    dig.setTitle("좋아하는 버전은?");
    dig.setIcon(R.drawable.ic_launcher);
    dig.setItems(versionArray, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            button1.setText(versionArray[i]);
        }
    });
    dig.setPositiveButton("닫기", null);
    dig.show();
}
});
```

   2. 다이얼 로그에 체크박스를 사용
   
```java
final Button button1 = (Button)findViewById(R.id.button1);
button1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final String[] versionArray = new String[]{"진저브레드", "허니콜" ,"아이스크림"};
        AlertDialog.Builder dig = new AlertDialog.Builder(Main6Activity.this);
        dig.setTitle("좋아하는 버전은?");
        dig.setIcon(R.drawable.ic_launcher);
        dig.setItems(versionArray, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                button1.setText(versionArray[i]);
            }
        });
        dig.setPositiveButton("닫기", null);
        dig.show();
    }
});
```

   3. 다이얼 로그에 라디오 버튼으로 선택하기
   
```java
final Button button1 = (Button)findViewById(R.id.button1);
button1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final String[] versionArray = new String[] {"진저브레드", "허니콤", "아이스크림"};
        final boolean[] checkArray = new boolean[] {true,false,false};
        AlertDialog.Builder dig = new AlertDialog.Builder(Main6Activity.this);
        dig.setTitle("좋아하는 버전은?");
        dig.setIcon(R.drawable.ic_launcher);
        dig.setMultiChoiceItems(versionArray, checkArray, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which, boolean b) {
                    button1.setText(versionArray[which]);
            }
        });
        dig.setPositiveButton("닫기", null);
        dig.show();
    }
});
```

> 버튼 클릭하여 다이얼로그 띄운 후 글 작성하기
```java
button1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // 다이얼 로그 뛰우기
            dialogView = (View) View.inflate(Main7Activity.this, R.layout.dialog1, null);
            AlertDialog.Builder dig = new AlertDialog.Builder(Main7Activity.this);
            
            // 메뉴바 에 뜨는 것 setting 하기
            dig.setTitle("사용자 정보 입력");
            dig.setIcon(R.drawable.ic_menu_allfriends);
            dig.setView(dialogView);
                                     
            //확인 버튼 클릭시
            dig.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    digEdtName = (EditText) dialogView.findViewById(R.id.digEdt1);
                    digEdtEmail = (EditText) dialogView.findViewById(R.id.digEdt2);

                    tvName.setText(digEdtName.getText().toString());
                    tvEmail.setText(digEdtEmail.getText().toString());
                }
            });

            //취소 버튼 클릭시
            dig.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast toast = new Toast(Main7Activity.this);

                    toastView = (View) View.inflate(Main7Activity.this, R.layout.toast1, null);
                    toastText = (TextView) toastView.findViewById(R.id.toastText1);
                    toastText.setText("취소했습니다.");
                    toast.setView(toastView);
                    toast.show();
                }
            });
            dig.show();
        }
    });
```

```xml
// 1. dialog1.xml (알트창에 보여주는 곳)
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:id="@+id/textView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="사용자 이름"
        android:textSize="20dp" />

    <EditText
        android:id="@+id/digEdt1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:ems="10"
        android:inputType="textPersonName"
        android:text="Name" />

    <TextView
        android:id="@+id/textView3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="이메일"
        android:textSize="20dp" />

    <EditText
        android:id="@+id/digEdt2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:ems="10"
        android:inputType="textPersonName" />
</LinearLayout>

// 2. toast1.xml (취소 버튼 클릭시 나오는 xml)
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:background="#ff0000"
    android:orientation="horizontal"
    android:gravity="center"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        app:srcCompat="@drawable/btn_star_big_on" />

    <TextView
        android:id="@+id/toastText1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:text="TextView"
        android:textSize="20dp" />

    <ImageView
        android:id="@+id/imageView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        app:srcCompat="@drawable/btn_star_big_on" />
</LinearLayout>
```