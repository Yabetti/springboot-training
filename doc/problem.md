## 課題

仕様書(書籍管理システムについて)と技術要素解説を参照して、下記該当箇所のプログラムを穴埋めし、仕様書通りに動作するように記述してください。

### [1] 書籍登録の実装
ヘッダーメニューの「書籍登録」より書籍登録画面に遷移し、画面上に入力した書籍情報をデータベースに登録できるようにしなさい。また、登録した書籍情報を一覧画面より確認できるようにしなさい。

本課題は下記の手順で実装する。

1. (1)のJavaプログラムを記述しなさい。(``BookController.java``)
   @@@return regist ⇒ return redirect: /regist に変更
   
1. (9)のJavaプログラムを記述しなさい。(``BookService.java``)
1. (13)と(18)のJavaプログラムを記述しなさい。(``BookRepository.java``)

### [2] 書籍詳細の実装
一覧画面の書籍タイトルリンクを押下すると、書籍詳細画面に遷移し該当の書籍情報が表示されるようにしなさい。

本課題は下記の手順で実装する。

1. (2)のJavaプログラムを記述しなさい。(``BookController.java``)
1. (8)のJavaプログラムを記述しなさい。(``BookService.java``)
1. (12)と(17)のJavaプログラムを記述しなさい。(``BookRepository.java``)

### [3] 書籍編集の実装
一覧画面の編集リンクを押下すると、書籍編集画面に遷移し該当の書籍情報を編集できるようにし、データベースのデータが更新されるようにしなさい。また、一覧画面より詳細画面に遷移し情報が更新されることを確認しなさい。

本課題は下記の手順で実装する。

1. (22)に必要なHTMLタグを記述し画面を完成させなさい。(``edit.html``)  
書籍登録画面(``regist.html``)を参考にしなさい。
1. (3)と(4)のJavaプログラムを記述しなさい。(``BookController.java``)
1. (10)のJavaプログラムを記述しなさい。(``BookService.java``)
1. (14)と(19)のJavaプログラムを記述しなさい。(``BookRepository.java``)

### [4] 書籍削除の実装
一覧画面の削除リンクを押下すると、該当の書籍データが削除されるようにしなさい。

本課題は下記の手順で実装する。

1. (5)と(6)のJavaプログラムを記述しなさい。(``BookController.java``)
1. (11)のJavaプログラムを記述しなさい。(``BookService.java``)
1. (15)と(20)のJavaプログラムを記述しなさい。(``BookRepository.java``)

### [5] 書籍タイトル検索の実装
一覧画面よりキーワードを入力し、検索ボタンを押下すると検索結果が一覧表に表示されるようにしなさい。

本課題は下記の手順で実装する。

1. (7)のJavaプログラムを記述しなさい。(``BookController.java``)
1. (12)のJavaプログラムを記述しなさい。(``BookService.java``)
1. (16)と(21)のJavaプログラムを記述しなさい。(``BookRepository.java``)

以上
