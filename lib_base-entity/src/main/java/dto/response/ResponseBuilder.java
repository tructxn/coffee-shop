package dto.response;

import exeption.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("responseBuilder")
public class ResponseBuilder {

    @Autowired
    public ResponseBuilder() {
    }

    public ResponseStatus buildSuccessResponse() {
        return ResponseStatus.builder().resultCode(ResultCode.SUCCESS.code)
                .resultMessage(ResultCode.SUCCESS.description)
                .resultType(ResultType.SUCCESS.ordinal())
                .build();
    }

    public ResponseStatus buildResponse(ApiException exception) {
        return ResponseStatus.builder().resultCode(ResultCode.UNKNOWN_ERROR.getCode())
                .resultMessage(exception.getMessage())
                .resultType(ResultType.UNKNOWN_ERROR.ordinal())
                .build();
    }

    public enum ResultType {
        SUCCESS,
        USER_ERROR,
        DB_ERROR,
        PARTNER_ERROR,
        UNKNOWN_ERROR;

        public static ResultType fromValue(int value) {
            for (ResultType resultType : ResultType.values()) {
                if (resultType.ordinal() == value) {
                    return resultType;
                }
            }

            return ResultType.UNKNOWN_ERROR;
        }
    }

    public enum ResultCode {
        SUCCESS(0, "SUCCESS"),
        NOT_FOUND(-2001, "Data not found"),
        DATABASE(1001, "A database error has occurred."),
        INTERNAL_ERROR(9001, "A database error has occurred."),
        UNKNOWN_ERROR(9999, "unknow error");
        private final int code;
        private final String description;

        ResultCode(int code, String description) {
            this.code = code;
            this.description = description;
        }

        public static ResultCode fromCode(int value) {
            for (ResultCode resultCode : ResultCode.values()) {
                if (resultCode.code == value) {
                    return resultCode;
                }
            }
            return ResultCode.UNKNOWN_ERROR;
        }

        public String getDescription() {
            return description;
        }

        public int getCode() {
            return code;
        }

        @Override
        public String toString() {
            return code + ": " + description;
        }
    }
}
