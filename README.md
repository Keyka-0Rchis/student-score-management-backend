# student-score-management-backend

## 概要

生徒の高校入試にあたっての進路指導で必要になるデータを登録し、整理して閲覧可能にするアプリケーションのバックエンドのプロジェクトです。
フロントエンドはこちらになります。（https://github.com/Keyka-0Rchis/student-score-management-frontend.git)

## 背景

私は前職で東京都の公立中学校の教員をしておりました。
生徒の情報は既存の校務支援システムに保管されていますが、進路に必要な情報を見やすく提示することはできません。
また、情報を三者面談などで保護者同席のもと確認したい際にも、レイアウトが確認するようになっていないため、
その都度、書面を作成する必要があり、時間のない中、教員の負担になっていました。
そのため、比較的簡単に情報を登録でき、書面の形で出力するアプリケーションを作ることにいたしました。
アプリケーションは、教員のPCにすでに入っているブラウザソフトをそのまま使用可能なため、Webアプリにすることにしました。

また、更なる経験と学習のため、転職を行うことを考えているため、このシステムを転職活動のポートフォリオとすることに決めました。

## フォルダ構成
```
src/main/java/works/keyka/
├── controller/
│ └── StudentController.java # 生徒情報の登録、編集を制御します。
├── service/
│ └── StudentService.java # 生徒登録、編集、一覧表示を行います。
├── mapper/
│ └── StudentMapper.java # 生徒情報のマッピングを行うためのインターフェース。
├── model/
│ └── ExamModel.java # 考査区分のモデル
│ └── ExamResultModel.java # 考査結果のモデル
│ └── RoleModel.java # 役職のモデル
│ └── StudentModel.java # 生徒のモデル
│ └── SubjectModel.java # 教科のモデル
│ └── UserModel.jave # 教員のモデル
├── .gitignore
└── README.md # このファイル
src/main/resource/works/keyka/
├── mapper/
│ └── StudentMapper.xml # 生徒情報のマッピングのSQL文
```

## 現状
- ER図を作成。
- ER図を用いてドメインモデルを定義。
- 生徒の登録、一覧表示、編集、論理削除機能を追加
