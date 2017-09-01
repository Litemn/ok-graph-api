package ru.litemn.ok.graph.objects;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Nullable;

/**
 * Api response
 */
public class ApiResponse {

    @SerializedName("error_code")
    private String errorCode;
    @SerializedName("error_msg")
    private String errorMsg;
    @SerializedName("error_data")
    private String errorData;
    @SerializedName("error_field")
    private String errorField;

    @Nullable
    public String getErrorCode() {
        return errorCode;
    }

    @Nullable
    public String getErrorMsg() {
        return errorMsg;
    }

    @Nullable
    public String getErrorData() {
        return errorData;
    }

    @Nullable
    public String getErrorField() {
        return errorField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApiResponse)) return false;
        ApiResponse that = (ApiResponse) o;
        return Objects.equal(errorCode, that.errorCode) &&
                Objects.equal(errorMsg, that.errorMsg) &&
                Objects.equal(errorData, that.errorData) &&
                Objects.equal(errorField, that.errorField);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(errorCode, errorMsg, errorData, errorField);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("errorCode", errorCode)
                .add("errorMsg", errorMsg)
                .add("errorData", errorData)
                .add("errorField", errorField)
                .toString();
    }
}
