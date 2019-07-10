### 안드로이드 Codes

### IDE : Andriod Studio 

------------

> 계산기를 만들어보자 (간단한 계산기)
```java
    // 전역변수로 먼저 선언을 하자
    Button add, mul, div, sub, divs; // 더하기 , 곱하기 , 나누기 , 빼기 , 나머지
    EditText e1, e2;
    TextView textResult;

    // onCreate 메소드 안에서 나머지 구현하자

     //더하기
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (e1.getText().toString().isEmpty() || e2.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "오류가 발생하였습니다.", Toast.LENGTH_LONG).show();
                } else {
                    String num1 = e1.getText().toString();
                    String num2 = e2.getText().toString();

                    double result = Double.parseDouble(num1) + Double.parseDouble(num2);
                    textResult.setText("계산결과 : " + result + "");
                    Toast.makeText(getApplicationContext(), "계산결과 : " + result, Toast.LENGTH_LONG).show();
                }
            }
        };

     // 뺴기
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (e1.getText().toString().isEmpty() || e2.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "오류가 발생하였습니다.", Toast.LENGTH_LONG).show();
                } else {
                    String num1 = e1.getText().toString();
                    String num2 = e2.getText().toString();

                    double result = Double.parseDouble(num1) - Double.parseDouble(num2);
                    textResult.setText("계산결과 : "+ result + "");
                    Toast.makeText(getApplicationContext(), "계산결과 : " + result, Toast.LENGTH_LONG).show();
                }
            }
        });

      // 곱하기
            mul.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(e1.getText().toString().isEmpty() || e2.getText().toString().isEmpty()){
                        Toast.makeText(getApplicationContext(), "오류가 발생하였습니다.", Toast.LENGTH_LONG).show();
                    }else{
                        String num1 = e1.getText().toString();
                        String num2 = e2.getText().toString();

                        double result = Double.parseDouble(num1) * Double.parseDouble(num2);
                        textResult.setText("계산결과 : "+result+"");
                        Toast.makeText(getApplicationContext(), "계산결과 : "+ result, Toast.LENGTH_LONG).show();
                    }
                }
            });

    // 나누기
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(e1.getText().toString().isEmpty() || e2.getText().toString().isEmpty() || e1.getText().toString().equals("0") || e2.getText().toString().equals("0")){
                    Toast.makeText(getApplicationContext(), "오류가 발생하였습니다.", Toast.LENGTH_LONG).show();
                }else{
                    String num1 = e1.getText().toString();
                    String num2 = e2.getText().toString();

                    double result = (Double.parseDouble(num1) % Double.parseDouble(num2) *100) / 100.0;
                    textResult.setText("계산결과 : "+result+"");
                    Toast.makeText(getApplicationContext(), "계산결과 : "+ result, Toast.LENGTH_LONG).show();
                }
            }
        });

   //나머지
        divs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(e1.getText().toString().isEmpty() || e2.getText().toString().isEmpty() || e1.getText().toString().equals("0") || e2.getText().toString().equals("0")){
                    Toast.makeText(getApplicationContext(), "오류가 발생하였습니다.", Toast.LENGTH_LONG).show();
                }else{
                    String num1 = e1.getText().toString();
                    String num2 = e2.getText().toString();

                    double result = Double.parseDouble(num1) / Double.parseDouble(num2);
                    textResult.setText("계산결과 : "+result+"");
                    Toast.makeText(getApplicationContext(), "계산결과 : "+ result, Toast.LENGTH_LONG).show();
                }
            }
        });
```

> 버튼을 클릭하는 계산기 V2(생각 해야하는 계산기)
```java
    //버튼 배열을 만들어서 저장하자
    int BtnArray[] = {R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2,
                       R.id.BtnNum3,R.id.BtnNum4, R.id.BtnNum5,
                       R.id.BtnNum6, R.id.BtnNum7,R.id.BtnNum8,
                       R.id.BtnNum9};
    Button Btn[] = new Button[10];

    // 만든 버튼을 for문을 이용하여 생성하자
    for (int i = 0; i < BtnArray.length; i++) {
            Btn[i] = (Button) findViewById(BtnArray[i]);
    }
    
    // 만든 버튼을 클릭할때마다 setText 해야한다.
    for (int j = 0; j<Btn.length; j++) {
        final int a = j;
        Btn[j].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (Edit1.isFocused() == true) {
                    Edit1.append(Btn[a].getText().toString());
                } else if (Edit2.isFocused() == true) {
                    Edit2.append(Btn[a].getText().toString());
                }else {
                    Toast.makeText(getApplicationContext(), "숫자가 부족함", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    // 이제 사칙연산을 할수 있도록 하자
    // 더하기 (하나만 예시를 들었다 금방 할 수 있을거라고 생각한다.)
    BtnAdd.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String n1 = Edit1.getText().toString();
            String n2 = Edit2.getText().toString();
            if(n1.equals("") || n2.equals("")){
                Toast.makeText(getApplicationContext(), "숫자가 부족함", Toast.LENGTH_LONG).show();
            }else {
                int result = Integer.parseInt(n1) + Integer.parseInt(n2);
                TextResult.setText("게산 결과 : " + result);
            }
        }
    });

```
