# 숫자 세기 앱

## Layout

![](https://developer.android.com/static/images/viewgroup_2x.png?hl=ko)
그림 1. UI 레이아웃을 정의하는 뷰 계층 구조

* View와 ViewGroup 객체의 계층 구조를 사용하여 빌드
* View는 사용자가 보고 상호작용 할 수 있는 것을 그림
* ViewGroup은 View 및 기타 ViewGroup 객체의 레이아웃 구조를 정의하는 보이지 않는 컨테이너 

### LinearLayout
* width, height 설정 필수
* orientation으로 정렬 설정
* 자식 객체의 width나 height을 0dp로 설정하고 weight 통해 비율 설정 가능
### TextView
* text size, color, style 등을 설정할 수 있음
* text는 string.xml에서 설정한 후 사용하는 것을 권장
* id를 설정하여 text 값을 코드 내에서 바꿀 수 있음
### Button
* id를 설정하여 코드 내에서 이벤트 발생시 기능을 추가할 수 있음
* backgoundTint를 통해 버튼 색상 변겅 가능

## Android

### Activity
* 유저와 상호작용하는 진입점
* 라이플 사이클을 통해 관리
* 화면 전화이 됐을 시에도 데이터를 잘 가지고 있어야 함
### R 파일
* xml파일에서 id를 설정 시 R파일에 설정 됨
### findViewById
* id를 매개변수를 하여 View를 가져올 수 있음
### setOnClickListener
* 가져온 ID View 객체에 기능을 구현
### log
* 개발하는 도중 데이터, 기능 등을 확인하기 위해 자주 사용해야 함
