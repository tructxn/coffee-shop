package common.exeption;

import common.api.ResponseBuilder;

public class DatabaseException extends ApiException {
    public DatabaseException() {
        super(ResponseBuilder.ResultCode.DATABASE.getCode(), ResponseBuilder.ResultCode.DATABASE.getDescription(), ResponseBuilder.ResultType.DB_ERROR.ordinal());
    }
}
