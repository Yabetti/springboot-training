package system.anotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/** ISBN13用のバリデーションクラス */
public class ISBN13Validator implements ConstraintValidator<ISBN13, String> {

    /** 初期化 */
    public void initialize(ISBN13 constraintAnnotation) {
    }

    /** 入力チェック */
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        value = value.replaceAll("-", "");

        return isISBN13Valid(value);
    }

    /** 入力されたISBN13コードが正しいかどうかチェックデジットを用いてチェックするメソッド */
    private boolean isISBN13Valid(String isbn) {
        if (isbn.length() != 13) {
            return false;
        }

        int check = 0;

        try {
            for (int i = 0; i < 12; i += 2) {
                check += Integer.parseInt(isbn.substring(i, i + 1));
            }

            for (int i = 1; i < 12; i += 2) {
                check += Integer.parseInt(isbn.substring(i, i + 1)) * 3;
            }

            check += Integer.parseInt(isbn.substring(12));

        } catch (NumberFormatException e) {
            return false;
        }

        return check % 10 == 0;
    }

}
