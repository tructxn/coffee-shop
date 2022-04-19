package common.exeption;

import common.api.ResponseBuilder;

public class NotFoundException extends ApiException {
    public NotFoundException() {
        super(ResponseBuilder.ResultCode.NOT_FOUND.getCode(), ResponseBuilder.ResultCode.NOT_FOUND.getDescription(), ResponseBuilder.ResultType.USER_ERROR.ordinal());
    }
}
