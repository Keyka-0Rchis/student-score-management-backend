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
📂 student-score-management-backend
├── 📁 src
│   ├── 📁 main
│   │   ├── 📁 java
│   │   │   └── 📁 works
│   │   │       └── 📁 keyka
│   │   │           ├── 📁 advice
│   │   │           │   └── GlobalExceptionHandler.java     # 共通例外ハンドリング
│   │   │           ├── 📁 common
│   │   │           │   └── 📁 exception
│   │   │           │       └── ErrorCode.java              # エラーコード定義
│   │   │           ├── 📁 controller
│   │   │           │   └── StudentController.java          # APIエンドポイント
│   │   │           ├── 📁 mapper
│   │   │           │   └── StudentMapper.java              # MyBatis Mapperインターフェース
│   │   │           ├── 📁 model                            # ドメインモデル（@Data）
│   │   │           │   ├── ExamModel.java
│   │   │           │   ├── ExamResultModel.java
│   │   │           │   ├── RoleModel.java
│   │   │           │   ├── StudentModel.java               
│   │   │           │   ├── SubjectModel.java
│   │   │           │   └── UserModel.java
│   │   │           ├── 📁 service
│   │   │           │   └── StudentService.java             # 業務ロジック層
│   │   │           └── StudentScoreManagementBackendApplication.java
│   │   └── 📁 resources
│   │       ├── 📁 static                                   # 静的リソース（未使用）
│   │       ├── 📁 templates                                # Thymeleafテンプレート（未使用）
│   │       └── 📁 works
│   │           └── 📁 keyka
│   │               └── 📁 mapper
│   │                   └── StudentMapper.xml               # MyBatis SQLマッピングファイル
│   │       ├── application-sample.properties               # 公開用サンプル設定
│   │       └── schema.sql                                  # テーブル定義
│   └── 📁 test
│       └── 📁 java
│           └── 📁 works
│               └── 📁 keyka
│                   └── 📁 service
│                       └── StudentServiceTest.java          # Service層の単体テスト

```

## 現状
- ER図を作成。
- ER図を用いてドメインモデルを定義。
- 生徒の登録、一覧表示、編集、論理削除機能を追加
- サービス層の単体テストの実装
