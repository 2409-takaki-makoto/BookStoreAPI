package com.example.BookStore.application.exception.error;

import static com.example.BookStore.application.exception.error.ErrorType.*;

import lombok.Getter;

@Getter
public class ErrorObject {

	public static ErrorObject 予期せぬエラーが発生しました = new ErrorObject(SystemError, "9999", "予期せぬエラーが発生しました");
	public static ErrorObject 予期せぬエラーが発生しました_1 = new ErrorObject(SystemError, "9999", "予期せぬエラーが発生しました{1}");
	
	public static ErrorObject メールアドレスが重複しています = new ErrorObject(BusinessError, "0001", "メールアドレスが重複しています");
	public static ErrorObject ユーザー情報がみつかりません = new ErrorObject(BusinessError, "0002", "ユーザー情報が見つかりません");
	public static ErrorObject 日付の絞り込み条件では開始日は終了日より未来日を設定できません = new ErrorObject(BusinessError, "0003", "日付の絞り込み条件では開始日は終了日より未来日を設定できません");
	public static ErrorObject 書籍情報が見つかりません = new ErrorObject(BusinessError, "0004", "書籍情報が見つかりません");
	
	private String code;
	private String message;
	private ErrorType type;

	private ErrorObject(ErrorType type, String code, String messae) {
		this.message = messae;
		this.type = type;
		
		
		switch (type) {
		case SystemError: {
			this.code = "S" + code;
			break;
		}
		case BusinessError: {
			this.code = "E" + code;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + type);
		}
		
	}
	
	public String getMessage(String... embedded) {
		if (embedded == null || embedded.length == 0) {
			return getMessage();
		}
		
		StringBuilder builder = new StringBuilder();
		
		String[] messageParts = message.split("\\{\\d\\}");
		for (int i = 0; i < messageParts.length; i++) {
			builder.append(messageParts[i] + embedded[i]);
		}
		
		return builder.toString();
	}
	
	public String getMessage() {
		return this.message;
	}

}
