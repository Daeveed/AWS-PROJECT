package com.amazonaws.models.nosql;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

import java.util.List;
import java.util.Map;
import java.util.Set;

@DynamoDBTable(tableName = "awsdistributedprojec-mobilehub-155970210-my_data")

public class MyDataDO {
    private String _dataName;
    private String _userId;
    private String _dataDetails;

    @DynamoDBHashKey(attributeName = "dataName")
    @DynamoDBAttribute(attributeName = "dataName")
    public String getDataName() {
        return _dataName;
    }

    public void setDataName(final String _dataName) {
        this._dataName = _dataName;
    }
    @DynamoDBAttribute(attributeName = "UserId")
    public String getUserId() {
        return _userId;
    }

    public void setUserId(final String _userId) {
        this._userId = _userId;
    }
    @DynamoDBAttribute(attributeName = "dataDetails")
    public String getDataDetails() {
        return _dataDetails;
    }

    public void setDataDetails(final String _dataDetails) {
        this._dataDetails = _dataDetails;
    }

}
