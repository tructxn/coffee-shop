package common.exeption;

import lombok.Getter;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-04-16T03:40:20.409Z")

@Getter
public class ApiException extends RuntimeException {
    private int code;
    private int resultType;
    public ApiException (int code, String msg, int resultType) {
        super(msg);
        this.resultType = resultType;
        this.code = code;
    }
}
